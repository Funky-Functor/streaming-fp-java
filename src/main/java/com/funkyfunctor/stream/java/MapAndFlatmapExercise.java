package com.funkyfunctor.stream.java;


import io.vavr.Tuple;
import io.vavr.collection.HashMap;
import io.vavr.collection.List;
import io.vavr.collection.Map;
import lombok.experimental.UtilityClass;
import lombok.val;

/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */
@UtilityClass
public class MapAndFlatmapExercise {

    public static Map<Character, List<String>> digitsToLettersMap = HashMap.ofEntries(
            Tuple.of('2', List.of("a", "b", "c")),
            Tuple.of('3', List.of("d", "e", "f")),
            Tuple.of('4', List.of("g", "h", "i")),
            Tuple.of('5', List.of("j", "k", "l")),
            Tuple.of('6', List.of("m", "n", "o")),
            Tuple.of('7', List.of("p", "q", "r", "s")),
            Tuple.of('8', List.of("t", "u", "v")),
            Tuple.of('9', List.of("w", "x", "y", "z"))
    );

    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return List.empty();
        } else {
            val digitsAsList = stringToCharactersList(digits);

            return letterCombinations(digitsAsList);
        }
    }

    public static List<String> letterCombinations(List<Character> digits) {
        if (digits.isEmpty()) {
            return List.of("");
        } else {
            val head = digits.head();
            val tail = digits.tail();

            val headResult = getCharacterForDigit(head);
            if (tail.isEmpty()) {
                return headResult;
            } else {
                return headResult.flatMap((c) -> letterCombinations(tail).map((str) -> c + str));
            }
        }
    }

    private static List<Character> stringToCharactersList(String digits) {
        val charArray = digits.toCharArray();

        return List.ofAll(charArray);
    }

    private static List<String> getCharacterForDigit(Character digit) {
        return digitsToLettersMap.getOrElse(digit, List.of(""));
    }
}
