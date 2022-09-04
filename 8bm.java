package com.company;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String source = "abcde";
        String template = "cd";
        System.out.println("Вхождение подстроки в строку в:" + getFirstEntry(source, template));
    }

    public static HashMap<Character, Integer> makeOffsetTable(String pattern) {
        HashMap<Character, Integer> offsetTable = new HashMap<Character, Integer>();
        for (int i = 0; i <= 255; i++) {
            offsetTable.put((char) i, pattern.length());
        }
        for (int i = 0; i < pattern.length() - 1; i++) {
            offsetTable.put(pattern.charAt(i), pattern.length() - i - 1);
        }
        return offsetTable;
    }

    public static int getFirstEntry(String s, String p) {
        HashMap<Character, Integer> offsetTable = makeOffsetTable(p);
        if (s.length() < p.length()) {
            return -1;
        }

        int i = p.length() - 1;
        int j = i;
        int k = i;

        while (j >= 0 && i <= s.length() - 1) {
            j = p.length() - 1;
            k = i;
            while (j >= 0 && s.charAt(k) == p.charAt(j)) {
                k--;
                j--;
            }
            i += offsetTable.get(s.charAt(i));
        }
        if (k >= s.length() - p.length()) {
            return -1;
        } else {
            return k + 1;
        }
    }
}
