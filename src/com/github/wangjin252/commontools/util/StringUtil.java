package com.github.wangjin252.commontools.util;

public class StringUtil {


    public static String snakeToCamel(String snake) {
        StringBuilder stringBuilder = new StringBuilder();


        String[] strings = snake.split("_");
        for (String string : strings) {
            char[] chars = string.toCharArray();
            // 移位 首字母大写
            chars[0] -= 32;
            stringBuilder.append(String.valueOf(chars));
        }

        return stringBuilder.toString();

    }
}
