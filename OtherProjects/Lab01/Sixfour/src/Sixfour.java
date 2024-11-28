import javax.swing.JOptionPane;

public class Sixfour {
    public static void main(String[] args) {
        String monthInput = JOptionPane.showInputDialog("Enter the month (full name, abbreviation, or number):");
        String yearInput = JOptionPane.showInputDialog("Enter the year (non-negative number):");

        int month = getMonth(monthInput);
        if (month == -1) {
            JOptionPane.showMessageDialog(null, "Invalid month input.");
            System.exit(1);
        }

        int year = getYear(yearInput);
        if (year == -1) {
            JOptionPane.showMessageDialog(null, "Invalid year input.");
            System.exit(1);
        }

        int daysInMonth = getDaysInMonth(month, year);
        JOptionPane.showMessageDialog(null, "Year: " + year + "\nMonth: " + month + "\nDays: " + daysInMonth);
        System.exit(0);
    }

    private static int getMonth(String monthInput) {
        String[] months = {
            "january", "jan.", "jan", "1",
            "february", "feb.", "feb", "2",
            "march", "mar.", "mar", "3",
            "april", "apr.", "apr", "4",
            "may", "5",
            "june", "jun.", "jun", "6",
            "july", "jul.", "jul", "7",
            "august", "aug.", "aug", "8",
            "september", "sep.", "sep", "9",
            "october", "oct.", "oct", "10",
            "november", "nov.", "nov", "11",
            "december", "dec.", "dec", "12"
        };

        for (int i = 0; i < months.length; i++) {
            if (months[i].equals(monthInput.toLowerCase())) {
                return (i / 4) + 1; 
            }
        }
        return -1; 
    }

    private static int getYear(String yearInput) {
        try {
            int year = Integer.parseInt(yearInput);
            if (year < 0) {
                throw new NumberFormatException();
            }
            return year;
        } catch (NumberFormatException e) {
            return -1; 
        }
    }

    private static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return (isLeapYear(year) ? 29 : 28);
            default:
                return 31;
        }
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
