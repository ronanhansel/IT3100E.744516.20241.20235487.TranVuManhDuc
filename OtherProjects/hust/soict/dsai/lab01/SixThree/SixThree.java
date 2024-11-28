// Exercise 6.3
import javax.swing.JOptionPane;
public class SixThree {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Enter the height of the triangle:");
        int n = Integer.parseInt(input);

        StringBuilder triangle = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n - i; j++) {
                triangle.append("\t");
            }
            for (int k = 0; k < 2 * i - 1; k++) {
                triangle.append("*");
            }
            triangle.append("\n");
        }

        JOptionPane.showMessageDialog(null, triangle.toString());
        System.exit(0);
    }
}