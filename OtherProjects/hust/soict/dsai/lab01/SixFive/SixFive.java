import javax.swing.JOptionPane;
import java.util.Arrays;

public class Sixfive {
    public static void main(String[] args) {
        int numElements = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of elements in the array:"));

        double[] array = new double[numElements];
        double sum = 0;

        for (int i = 0; i < numElements; i++) {
            double element = Double.parseDouble(JOptionPane.showInputDialog("Enter element " + (i + 1) + ":"));
            array[i] = element;
            sum += element;
        }

        Arrays.sort(array);

        StringBuilder sortedArrayString = new StringBuilder("Sorted Array:\n");
        for (double value : array) {
            sortedArrayString.append(value).append(" ");
        }

        double average = sum / numElements;
        String resultMessage = sortedArrayString.toString() + "\nSum: " + sum + "\nAverage: " + average;

        JOptionPane.showMessageDialog(null, resultMessage);
    }
}
