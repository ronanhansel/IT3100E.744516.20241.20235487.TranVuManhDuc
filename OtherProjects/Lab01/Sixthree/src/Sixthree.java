import java.util.Scanner;

public class Sixthree {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        int n = keyboard.nextInt();
        StringBuilder sb = new StringBuilder();
      
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                sb.append(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                sb.append("*");
            }
            sb.append("\n"); 
        }

        System.out.print(sb.toString());
    }
}
