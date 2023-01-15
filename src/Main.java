import java.util.Scanner;

public class Main {

    public static void main(String[] arguments) throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String exp = scn.nextLine();
        String newExp = exp.replaceAll(" ", "");
        System.out.println(calc(newExp));
    }

    public static int calc(String input) throws Exception {


        char[] chars = new char[10];


        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        int actionIndex = -1;
        int count = 0;

        for (int i = 0; i < input.length(); i++) {

            chars[i] = input.charAt(i);
            if (chars[i] == '+' || chars[i] == '-' || chars[i] == '*' || chars[i] == '/')   {
                count += 1;
            }
            if (count >= 2) throw new Exception("Должно быть два операнда"); {
            }
        }


        for (int i = 0; i < actions.length; i++) {
            if (input.contains(actions[i])) {
                actionIndex = i;
                break;
            }
        }

        if (actionIndex == -1) throw new Exception("Неподдерживаемая математическая операция");{
           // System.out.println("Некорректное выражение, можно использовать только + - / *");

        }

        String[] data = input.split(regexActions[actionIndex]);

        int a = 0, b=0;


        if (data[0].matches("(?i)1|2|3|4|5|6|7|8|9|10") && data[1].matches("(?i)1|2|3|4|5|6|7|8|9|10")) {

            a = Integer.parseInt(data[0]);
            b = Integer.parseInt(data[1]);
        }
        else  throw new Exception("Значения должны быть в диапазоне 1..10");{
        }


        int result = switch (actions[actionIndex]) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> a / b;
        };
        return result;
    }
}

