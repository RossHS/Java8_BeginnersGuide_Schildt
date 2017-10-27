package Ch14_LambdaExpressions_MethodReferences;

/**
 * Created by Ross on 26.10.2017.
 */

interface StringFunc {
    String func(String str);
}

public class LambdaArgumentDemo {
    static String changeStr(StringFunc sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Лямбда-выражения расширяют Java";
        String outStr;
        System.out.println("Входная строка " + inStr);

        StringFunc reverse = (str) -> {
            String result = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }
            return result;
        };

        outStr = changeStr(reverse, inStr);
        System.out.println("Обращенная строка " + outStr);
        //внедряем ламбда выражение непосредственно в метод
        outStr = changeStr((str) -> str.replace(' ', '-'), inStr);
        System.out.println("Cтрока с замененными пробелами: " + outStr);

        //Внедряем блочное лямбда выражение непосредственно в вызов метода
        //так лучше не делать
        outStr = changeStr((str) -> {
            String result = "";
            char ch;
            for (int i = 0; i < str.length(); i++) {
                ch = str.charAt(i);
                if (Character.isUpperCase(ch))
                    result += Character.toLowerCase(ch);
                else
                    result += Character.toUpperCase(ch);
            }
            return result;
        }, inStr);

        System.out.println("Строка с обращенным регистром букв: " + outStr);

        StringFunc remove = (str) -> {
            String newStr = "";
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != ' ') newStr += str.charAt(i);
            }
            return newStr;
        };

        outStr = changeStr(remove,inStr);
        System.out.println("Строка без пробелов: " + outStr);
    }
}
