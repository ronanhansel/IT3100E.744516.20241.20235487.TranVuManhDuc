import javax.swing.JOptionPane;

public class Findingroots {
    public static void main(String[] args) {
        String selection = getSelection();

        switch (selection) {
            case "1":
                solveFirstDegreeEquation();
                break;
            case "2":
                solveFirstDegreeSystem();
                break;
            case "3":
                solveSecondDegreeEquation();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid selection", "Error", JOptionPane.ERROR_MESSAGE);
        }

        System.exit(0);
    }

    private static String getSelection() {
        String selection;
        while (true) {
            selection = JOptionPane.showInputDialog(null,
                "1. First-degree equation\n2. System of first-degree equations\n3. Second-degree equation",
                "Select the programme",
                JOptionPane.INFORMATION_MESSAGE);
            if (selection != null && (selection.equals("1") || selection.equals("2") || selection.equals("3"))) {
                return selection;
            }
            JOptionPane.showMessageDialog(null, "Invalid selection. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void solveFirstDegreeEquation() {
        double a = getNonZeroDoubleInput("Please enter the first number (a):");
        double b = getDoubleInput("Please enter the second number (b):");
        double solution = -b / a;
        JOptionPane.showMessageDialog(null, "The solution is: " + solution, "Solution", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void solveFirstDegreeSystem() {
        double[] coefficients = new double[6];
        for (int i = 0; i < coefficients.length; i++) {
            coefficients[i] = getDoubleInput("Please enter number " + (i + 1) + ":");
        }

        double a1 = coefficients[0], b1 = coefficients[1], c1 = coefficients[2];
        double a2 = coefficients[3], b2 = coefficients[4], c2 = coefficients[5];
        double determinant = a1 * b2 - a2 * b1;

        if (determinant == 0) {
            if (a1 * c2 == a2 * c1 && b1 * c2 == b2 * c1) {
                JOptionPane.showMessageDialog(null, "The system has infinitely many solutions.", "Infinitely Many Solutions", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "The system has no solution.", "No Solution", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            double x = (c1 * b2 - c2 * b1) / determinant;
            double y = (a1 * c2 - a2 * c1) / determinant;
            JOptionPane.showMessageDialog(null, "The solution is: x = " + x + ", y = " + y, "Solution", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void solveSecondDegreeEquation() {
        double a = getNonZeroDoubleInput("Please enter the first number (a):");
        double b = getDoubleInput("Please enter the second number (b):");
        double c = getDoubleInput("Please enter the third number (c):");
        double delta = b * b - 4 * a * c;

        if (delta < 0) {
            JOptionPane.showMessageDialog(null, "The equation has no real roots.", "No Real Roots", JOptionPane.INFORMATION_MESSAGE);
        } else if (delta == 0) {
            double root = -b / (2 * a);
            JOptionPane.showMessageDialog(null, "The equation has one real root: " + root, "One Real Root", JOptionPane.INFORMATION_MESSAGE);
        } else {
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            JOptionPane.showMessageDialog(null, "The equation has two real roots: " + root1 + " and " + root2, "Two Real Roots", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static double getDoubleInput(String message) {
        String input;
        while (true) {
            input = JOptionPane.showInputDialog(null, message, "Input", JOptionPane.INFORMATION_MESSAGE);
            if (input == null) return Double.NaN; // Handle cancel
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static double getNonZeroDoubleInput(String message) {
        double value;
        while (true) {
            value = getDoubleInput(message);
            if (value != 0) return value;
            JOptionPane.showMessageDialog(null, "The number cannot be zero. Please re-enter.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }
}
