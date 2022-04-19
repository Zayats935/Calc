import java.util.Scanner;




public class Main {
    enum Roman{
        I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10),
        XI(11), XII(12), XIII(13), XIV(14), XV(15), XVI(16), XVII(17), XVIII (18), XIX(19), XX(20),
        XXI(21), XXII(22), XXIII(23), XXIV(24), XXV(25), XXVI(26), XXVII(27), XXVIII (28), XXIX(29), XXX(30),
        XXXI(31), XXXII(32), XXXIII(33), XXXIV(34), XXXV(35), XXXVI(36), XXXVII(37), XXXVIII(38), XXXIX(39), XL(40),
        XLI(41), XLII(42), XLIII(43), XLIV(44), XLV(45), XLVI(46), XLVII(47), XLVIII(48), XLIX(49), L(50),
        LI(51), LII(52), LIII(53), LIV(54), LV(55), LVI(56), LVII(57), LVIII(58), LIX(59), LX(60),
        LXI(61), LXII(62), LXIII(63), LXIV(64), LXV(65), LXVI(66), LXVII(67), LXVIII(68), LXIX(69), LXX(70),
        LXXI(71), LXXII(72), LXXIII(73), LXXIV(74), LXXV(75), LXXVI(76), LXXVII(77), LXXVIII(78), LXXIX(79), LXXX(80),
        LXXXI(81), LXXXII(82), LXXXIII(83), LXXXIV(84), LXXXV(85), LXXXVI(86), LXXXVII(87), LXXXVIII(88), LXXXIX(89), XC(90),
        XCI(91), XCII(92), XCIII(93), XCIV(94), XCV(95), XCVI(96), XCVII(97), XCVIII(98), XCIX(99), C(100);
        private final int integer;

        Roman findByNumber(int number){
            Roman[] Romans = Roman.values();
            return Romans[number-1];
        }        
        Roman(int integer) {
            this.integer = integer;
        }
    }

    public static void main (String[] args){
        String input;
        String firstNumber = "", secondNumber = "", operand = "", result = "";
        boolean firstNumberFull = false, secondNumberFull = false;
        System.out.println("Введите выражение:");
        Roman usableRoman = Roman.I;
        Scanner s = new Scanner(System.in);
        input = s.nextLine();
        String[] splitString = input.split(" ");
        for (int i =0; i<splitString.length; i++){
            String a = splitString[i];
            switch (a){
                default:
                    if (!firstNumberFull)
                    {
                        firstNumber = splitString[i];
                        firstNumberFull = true;
                        continue;
                    }
                    if (firstNumberFull && !secondNumberFull)
                    {
                        secondNumber = splitString[i];
                        secondNumberFull = true;
                        continue;
                    }
                    if (firstNumberFull&&secondNumberFull)
                    {
                        throw new RuntimeException("Больше двух чисел");
                    }
                    break;

                case "+","-","/","*":
                    if (operand == "")
                    {
                        operand = splitString[i];
                    }
                    else
                    {
                        throw new RuntimeException("Больше одного операнда");
                    }
                    break;
            }
        }
        if (firstNumber == "" || secondNumber == "" || firstNumber == "0" || secondNumber == "0" || operand == "")
        {
            throw new RuntimeException("Строка не является математической операцией");
        }
        if ((firstNumber.contains("X") || firstNumber.contains("V") || firstNumber.contains("I")) && (secondNumber.contains("X") || secondNumber.contains("V") || secondNumber.contains("I")))
        {
             switch (operand) {
                    case "+":
                        result = usableRoman.findByNumber(Roman.valueOf(firstNumber).integer + Roman.valueOf(secondNumber).integer).toString();
                        break;
                    case "/":
                        result = usableRoman.findByNumber(Roman.valueOf(firstNumber).integer / Roman.valueOf(secondNumber).integer).toString();
                        break;
                    case "*":
                        result = usableRoman.findByNumber(Roman.valueOf(firstNumber).integer * Roman.valueOf(secondNumber).integer).toString();
                        break;
                    case "-":
                        if (Roman.valueOf(firstNumber).integer>Roman.valueOf(secondNumber).integer)
                        {
                            result = usableRoman.findByNumber(Roman.valueOf(firstNumber).integer - Roman.valueOf(secondNumber).integer).toString();
                        }
                        else {
                            throw new RuntimeException("В римских числах нет отрицательных");
                        }
                        break;
                }
                 
        } else if ((!firstNumber.contains("X") && !firstNumber.contains("V") && !firstNumber.contains("I")) && (!secondNumber.contains("X") && !secondNumber.contains("V") && !secondNumber.contains("I"))) {
            switch (operand)
            {
                case "+":
                    result = Integer.toString(Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber));
                    break;
                case "-":
                    result = Integer.toString(Integer.parseInt(firstNumber) - Integer.parseInt(secondNumber));
                    break;
                case "*":
                    result = Integer.toString(Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber));
                    break;
                case "/":
                    result = Integer.toString(Integer.parseInt(firstNumber) / Integer.parseInt(secondNumber));
                    break;
            }
        } else {
            throw new RuntimeException("Используются одновременно разные системы счисления");
        }
        System.out.println(result);
    }
}