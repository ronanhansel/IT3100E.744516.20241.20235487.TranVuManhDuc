// Exercise 2.2.6: TwoTwoSix.java
import javax.swing.JOptionPane;
public class TwoTwoSix {
    public static void main(String[] args) {
        String selection;

        boolean validInput = false;
        while (!validInput) {
            selection = JOptionPane.showInputDialog(null,
            "1. First-degree equation\n2. System of first-degree equations\n3. Second-degree equation",
            "Select the programme",
            JOptionPane.INFORMATION_MESSAGE);

            switch(selection) {
            case "1":
                // First-degree equation
                String a = "";
                boolean validInputA = false;
                while (!validInputA) {
                    a = JOptionPane.showInputDialog(null,
                        "Please enter the first number (a): ",
                        "Input the first number",
                        JOptionPane.INFORMATION_MESSAGE);
                    if (a.equals("0")) {
                        JOptionPane.showMessageDialog(null,
                        "The second number cannot be zero. Please re-enter.",
                        "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    } else {
                    validInputA = true;
                    }
                }
                String b = JOptionPane.showInputDialog(null,
                "Please enter the second number (b): ",
                "Input the second number",
                JOptionPane.INFORMATION_MESSAGE);
                firstDegreeSolver(a, b);
                break;
            case "2":
                // System of first-degree equations
                String a1 = JOptionPane.showInputDialog(null,
                        "Please enter the first number (a1): ",
                        "Input the first number",
                        JOptionPane.INFORMATION_MESSAGE);
                String b1 = JOptionPane.showInputDialog(null,
                        "Please enter the second number (b1): ",
                        "Input the second number",
                        JOptionPane.INFORMATION_MESSAGE);
                String c1 = JOptionPane.showInputDialog(null,
                        "Please enter the third number (c1): ",
                        "Input the third number",
                        JOptionPane.INFORMATION_MESSAGE);
                String a2 = JOptionPane.showInputDialog(null,
                        "Please enter the fourth number (a2): ",
                        "Input the fourth number",
                        JOptionPane.INFORMATION_MESSAGE);
                String b2 = JOptionPane.showInputDialog(null,
                        "Please enter the fifth number (b2): ",
                        "Input the fifth number",
                        JOptionPane.INFORMATION_MESSAGE);
                String c2 = JOptionPane.showInputDialog(null,
                        "Please enter the sixth number (c2): ",
                        "Input the sixth number",
                        JOptionPane.INFORMATION_MESSAGE);
                firstDegreeSystemSolver(a1, b1, c1, a2, b2, c2);
                break;
            case "3":
                // Second-degree equation
                String a3 = JOptionPane.showInputDialog(null,
                        "Please enter the first number (a): ",
                        "Input the first number",
                        JOptionPane.INFORMATION_MESSAGE);
                String b3 = JOptionPane.showInputDialog(null,
                        "Please enter the second number (b): ",
                        "Input the second number",
                        JOptionPane.INFORMATION_MESSAGE);
                String c3 = JOptionPane.showInputDialog(null,
                        "Please enter the third number (c): ",
                        "Input the third number",
                        JOptionPane.INFORMATION_MESSAGE);
                secondDegreeSolver(a3, b3, c3);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid selection",
                    "Invalid selection", JOptionPane.INFORMATION_MESSAGE);
                    continue;
            }
            validInput = true;
        }

        System.exit(0);
    }

    private static void firstDegreeSolver(String a, String b) {
        double numA = Double.parseDouble(a);
        double numB = Double.parseDouble(b);
        JOptionPane.showMessageDialog(null, "The solution is: " + -numB / numA,
            "Solution", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void firstDegreeSystemSolver(String a1, String b1, String c1, String a2, String b2, String c2) {
        double numA1 = Double.parseDouble(a1);
        double numB1 = Double.parseDouble(b1);
        double numC1 = Double.parseDouble(c1);
        double numA2 = Double.parseDouble(a2);
        double numB2 = Double.parseDouble(b2);
        double numC2 = Double.parseDouble(c2);
        double determinant = numA1 * numB2 - numA2 * numB1;

        if (determinant == 0) {
            if (numA1 * numC2 == numA2 * numC1 && numB1 * numC2 == numB2 * numC1) {
            JOptionPane.showMessageDialog(null, "The system has infinitely many solutions.",
                "Infinitely Many Solutions", JOptionPane.INFORMATION_MESSAGE);
            } else {
            JOptionPane.showMessageDialog(null, "The system has no solution.",
                "No Solution", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            double determinantX = numC1 * numB2 - numC2 * numB1;
            double determinantY = numA1 * numC2 - numA2 * numC1;
            double x = determinantX / determinant;
            double y = determinantY / determinant;
            JOptionPane.showMessageDialog(null, "The solution is: x = " + x + ", y = " + y,
            "Solution", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void secondDegreeSolver(String a, String b, String c) {
        double numA = Double.parseDouble(a);
        double numB = Double.parseDouble(b);
        double numC = Double.parseDouble(c);
        double delta = numB * numB - 4 * numA * numC;

        if (delta < 0) {
            JOptionPane.showMessageDialog(null, "The equation has no real roots.",
                "No Real Roots", JOptionPane.INFORMATION_MESSAGE);
        } else if (delta == 0) {
            double root = -numB / (2 * numA);
            JOptionPane.showMessageDialog(null, "The equation has one real root: " + root,
                "One Real Root", JOptionPane.INFORMATION_MESSAGE);
        } else {
            double root1 = (-numB + Math.sqrt(delta)) / (2 * numA);
            double root2 = (-numB - Math.sqrt(delta)) / (2 * numA);
            JOptionPane.showMessageDialog(null, "The equation has two real roots: " + root1 + " and " + root2,
                "Two Real Roots", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}