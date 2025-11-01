package FileManage;


public class BitShiftDemo {
    public static void main(String[] args) {
        final String RESET = "\u001B[0m";
        final String GREEN = "\u001B[32m"; 
        final String BLUE = "\u001B[34m";
        final String YELLOW = "\u001B[33m";
        final String CYAN = "\u001B[36m";

        int a = 8;
        int b = -8;

        System.out.println(CYAN + "Positive number (a = 8)" + RESET);
        printShift(a, GREEN, YELLOW, RESET);

        System.out.println();
        System.out.println(CYAN + "Negative number (b = -8)" + RESET);
        printShift(b, BLUE, YELLOW, RESET);
    }

    private static void printShift(int num, String color, String opColor, String reset) {
        System.out.println("Original: " + color + toFormattedBinary(num) + reset);
        System.out.println(opColor + ">> 2 (arithmetic): →→ " + reset + color + toFormattedBinary(num >> 2) + reset + " = " + (num >> 2));
        System.out.println(opColor + ">>> 2 (logical): →→ " + reset + color + toFormattedBinary(num >>> 2) + reset + " = " + (num >>> 2));
    }

    private static String toFormattedBinary(int n) {
        String bin = Integer.toBinaryString(n);
        bin = String.format("%32s", bin).replace(' ', '0');
        StringBuilder formatted = new StringBuilder();

        for (int i = 0; i < bin.length(); i++) {
            formatted.append(bin.charAt(i));
            if ((i + 1) % 4 == 0 && i != bin.length() - 1) {
                formatted.append(' ');
            }
        }
        return formatted.toString();
    }
}


