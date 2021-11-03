package com.javidasgarov.encoder.util;


public class StringUtil {
    public static String replaceNonUnicode(String content) {
        var stringBuilder = new StringBuilder();
        for (char c : content.toCharArray()) {
            if (Character.UnicodeBlock.of(c) != Character.UnicodeBlock.BASIC_LATIN) {
                stringBuilder.append(toUnicode(c));
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    private static String toUnicode(char ch) {
        String unicode = String.format("\\u%04x", (int) ch);
        return unicode.substring(0, 2) + unicode.substring(2).toUpperCase();
    }
}
