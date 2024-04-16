package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringOperations {
    public static  String alternatingSymbols(String str1, String str2)  {
        int len = str1.length();
        String str = "";
        for (int i = 0; i < len; i++) {
            str += str1.charAt(i);
            str += str2.charAt(i);
        }
        return str;
    }

    public static String stringCompression(String str) {
        String res = "";
        Pattern p = Pattern.compile("(.)\\1{0,}");
        Matcher m = p.matcher(str);
        while (m.find()) {
            res += m.group(1);
            int length = m.group().length();
            // if (length >= 1)
            if (length > 1)
                res += length;
        }
        return res;
    }

    public static int digitsInString(String str) throws NullStringException {
        if (str == "") {
            throw new NullStringException("Пустая строка");
        }
        int sch = 0;
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            // if (Character.isLetter(ch[i])) {
            if (Character.isDigit(ch[i])) {
                sch++;
            }
        }
        return sch;
    }

    public static int multiplicationDigitsInString(String str) throws NullStringException {
        if (str == "") {
            throw new NullStringException("Пустая строка");
        }
        int mult = 1;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                mult *= ((int) (ch) - 48);
            }
        }
        return mult;
    }
    public static class NullStringException extends Exception {
        public NullStringException(String msg) {
            super(msg);
        }
    }
}


