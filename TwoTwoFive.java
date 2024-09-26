// Example 5: TwoTwoFive.java
import javax.swing.JOptionPane;
public class TwoTwoFive {
    public static void main(String[] args) {
        String strNum1;
        String strNum2 = "";
        String strNotification = "You've just entered: ";
        String result;

        strNum1 = JOptionPane.showInputDialog(null,
        "Please enter the first number: ",
        "Input the first number",
        JOptionPane.INFORMATION_MESSAGE);

        double num1 = Double.parseDouble(strNum1);

        boolean validInput = false;
        while (!validInput) {
            strNum2 = JOptionPane.showInputDialog(null,
            "Please enter the second number: ",
            "Input the second number",
            JOptionPane.INFORMATION_MESSAGE);

            double num2 = Double.parseDouble(strNum2);

            if (num2 == 0) {
            JOptionPane.showMessageDialog(null,
            "The second number cannot be zero. Please re-enter.",
            "Invalid Input", JOptionPane.ERROR_MESSAGE);
            } else {
            validInput = true;
            }
        }

        double num2 = Double.parseDouble(strNum2);

        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        double quotient = num1 / num2;

        strNotification += strNum1 + " and " + strNum2;

        JOptionPane.showMessageDialog(null, strNotification,
        "Show two numbers", JOptionPane.INFORMATION_MESSAGE);

        result = "Sum: " + sum + "\n" + "Difference: " + difference + "\n" + "Product: " + product + "\n" + "Quotient: " + quotient;

        JOptionPane.showMessageDialog(null, result,
        "Result", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}