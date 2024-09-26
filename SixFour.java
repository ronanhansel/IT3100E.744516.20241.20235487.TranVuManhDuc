// Exercise 6.4
import javax.swing.JOptionPane;
public class SixFour {
    public static void main(String[] args) {
        String monthInput = JOptionPane.showInputDialog("Enter the month (full name, abbreviation, or number):");
        String yearInput = JOptionPane.showInputDialog("Enter the year (non-negative number):");

        int month = -1;
        int year = -1;

        switch (monthInput.toLowerCase()) {
            case "january":
            case "jan.":
            case "jan":
            case "1":
            month = 1;
            break;
            case "february":
            case "feb.":
            case "feb":
            case "2":
            month = 2;
            break;
            case "march":
            case "mar.":
            case "mar":
            case "3":
            month = 3;
            break;
            case "april":
            case "apr.":
            case "apr":
            case "4":
            month = 4;
            break;
            case "may":
            case "5":
            month = 5;
            break;
            case "june":
            case "jun.":
            case "jun":
            case "6":
            month = 6;
            break;
            case "july":
            case "jul.":
            case "jul":
            case "7":
            month = 7;
            break;
            case "august":
            case "aug.":
            case "aug":
            case "8":
            month = 8;
            break;
            case "september":
            case "sep.":
            case "sep":
            case "9":
            month = 9;
            break;
            case "october":
            case "oct.":
            case "oct":
            case "10":
            month = 10;
            break;
            case "november":
            case "nov.":
            case "nov":
            case "11":
            month = 11;
            break;
            case "december":
            case "dec.":
            case "dec":
            case "12":
            month = 12;
            break;
            default:
            JOptionPane.showMessageDialog(null, "Invalid month input.");
            System.exit(1);
        }

        try {
            year = Integer.parseInt(yearInput);
            if (year < 0) {
            throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid year input.");
            System.exit(1);
        }

        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        int daysInMonth;
        switch (month) {
            case 4: case 6: case 9: case 11:
            daysInMonth = 30;
            break;
            case 2:
            daysInMonth = isLeapYear ? 29 : 28;
            break;
            default:
            daysInMonth = 31;
        }

        JOptionPane.showMessageDialog(null, "Year: " + year + "\nMonth: " + month + "\nDays: " + daysInMonth);
        System.exit(0);
    }
}