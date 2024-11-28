import javax.swing.JOptionPane;
public class MATHoperations {
    public static void main(String[] args){
        String strNum1, strNum2;

        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ","Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, "Please input the first number: ","Input the first number", JOptionPane.INFORMATION_MESSAGE);

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        double sum = num1 + num2;
        double difference = Math.abs(num1 - num2);
        double quotient = num1 / num2;

        JOptionPane.showMessageDialog(null, sum, "The sum of two double numbers",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, difference, "The difference of two double numbers",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, quotient, "The quotient of two double numbers",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
    
}
