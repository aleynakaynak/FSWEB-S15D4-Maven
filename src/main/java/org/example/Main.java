package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static boolean checkForPalindrome(String input) {
        if (input == null) {
            return false;
        }

        Deque<Character> characters = new ArrayDeque<>();
        StringBuilder normalized = new StringBuilder();
        for (char character : input.toCharArray()) {
            if (Character.isLetterOrDigit(character)) {
                char lowerCaseCharacter = Character.toLowerCase(character);
                normalized.append(lowerCaseCharacter);
                characters.push(lowerCaseCharacter);
            }
        }

        for (int index = 0; index < normalized.length(); index++) {
            if (normalized.charAt(index) != characters.pop()) {
                return false;
            }
        }
        return true;
    }

    public static String convertDecimalToBinary(int number) {
        if (number == 0) {
            return "0";
        }

        long value = Math.abs((long) number);
        Deque<Integer> bits = new ArrayDeque<>();
        while (value > 0) {
            bits.push((int) (value % 2));
            value /= 2;
        }

        StringBuilder binary = new StringBuilder();
        if (number < 0) {
            binary.append('-');
        }
        while (!bits.isEmpty()) {
            binary.append(bits.pop());
        }
        return binary.toString();
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

}