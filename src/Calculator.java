import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));

    }

    public static String calc(String input) {
        String[] parts;
        String a, b, sign;
        String result = "";
        parts = input.split(" ");
        if (parts.length != 3)
            throw new ArrayIndexOutOfBoundsException("Ошибка: формат ввода должен соотвествовать шаблону \"a + b\"");
        a = parts[0];
        sign = parts[1];
        b = parts[2];
        try {
            switch (sign) {
                case "+":
                    if (checkerInt(a) && checkerInt(b)) {
                        if ((Integer.parseInt(a) >= 0 && Integer.parseInt(a) <= 10)
                                && (Integer.parseInt(b) >= 0 && Integer.parseInt(b) <= 10)) ;
                        int temp = Integer.parseInt(a) + Integer.parseInt(b);
                        result = String.valueOf(temp);
                    } else if ((getPosition(a) > 0 && getPosition(a) <= 10)
                            && (getPosition(b) > 0 && getPosition(b) <= 10)) {
                        int temp = getPosition(a) + getPosition(b);
                        result = toRoman(temp);
                    }
                    break;
                case "-":
                    if (checkerInt(a) && checkerInt(b)) {
                        if ((Integer.parseInt(a) >= 0 && Integer.parseInt(a) <= 10)
                                && (Integer.parseInt(b) >= 0 && Integer.parseInt(b) <= 10)) ;
                        int temp = Integer.parseInt(a) - Integer.parseInt(b);
                        result = String.valueOf(temp);
                    } else if ((getPosition(a) > 0 && getPosition(a) <= 10)
                            && (getPosition(b) > 0 && getPosition(b) <= 10)) {
                        int temp = getPosition(a) - getPosition(b);
                        result = toRoman(temp);
                    }
                    break;
                case "*":
                    if (checkerInt(a) && checkerInt(b)) {
                        if ((Integer.parseInt(a) >= 0 && Integer.parseInt(a) <= 10)
                                && (Integer.parseInt(b) >= 0 && Integer.parseInt(b) <= 10)) ;
                        int temp = Integer.parseInt(a) * Integer.parseInt(b);
                        result = String.valueOf(temp);
                    } else if ((getPosition(a) > 0 && getPosition(a) <= 10)
                            && (getPosition(b) > 0 && getPosition(b) <= 10)) {
                        int temp = getPosition(a) * getPosition(b);
                        result = toRoman(temp);
                    }
                    break;
                case "/":
                    try {
                        if (checkerInt(a) && checkerInt(b)) {
                            if ((Integer.parseInt(a) >= 0 && Integer.parseInt(a) <= 10)
                                    && (Integer.parseInt(b) >= 0 && Integer.parseInt(b) <= 10)) ;
                            int temp = Integer.parseInt(a) / Integer.parseInt(b);
                            result = String.valueOf(temp);
                        } else if ((getPosition(a) > 0 && getPosition(a) <= 10)
                                && (getPosition(b) > 0 && getPosition(b) <= 10)) {
                            int temp = getPosition(a) / getPosition(b);
                            result = toRoman(temp);
                        }
                        break;

                    } catch (ArithmeticException ex) {
                        System.out.println(ex.getMessage());
                        System.out.println("Ошибка: деление на 0");
                        break;
                    }
                default:
                    throw new InputMismatchException("Ошибка: Неподдерживаемая операция");


            }
        } catch (NumberFormatException exception) {
            System.out.println(exception.getMessage());
            System.out.println("Ошибка: Числа должны находиться в одной системе, либо введенные числа не целые");
        }

        return result;
    }

    public static boolean checkerInt(String str) {
        List<String> numberList = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        return numberList.contains(str);

    }

    public static String toRoman(int index) {
        String output = "";
        List<String> romanList = Arrays.asList(" ", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII",
                "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII",
                "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV",
                "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX",
                "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI",
                "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII",
                "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C");
        try {
            if (index != 0 && index < 101) {
                output = romanList.get(index);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Ошибка: отрицательное число в римской системе!");
        }

        return output;
    }

    public static int getPosition(String str) {
        List<String> romanList = Arrays.asList(" ", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII",
                "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII",
                "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV",
                "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX",
                "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI",
                "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII",
                "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C");
        int index = 0;
        try {
            if (romanList.contains(str)) {
                index = romanList.indexOf(str);
            } else throw new InputMismatchException();
        } catch (
                InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");
        }
        return index;

    }
}
