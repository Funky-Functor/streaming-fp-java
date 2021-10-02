package com.funkyfunctor.stream.java;

import lombok.experimental.UtilityClass;
import lombok.val;

@UtilityClass
public class JavaExamples {

    public static void main(String[] args) {
        runTestForGivenValue("23");
        runTestForGivenValue("");
        runTestForGivenValue("2");
        runTestForGivenValue("a");
        runTestForGivenValue("2a");
        runTestForGivenValue("2a3");
    }

    private static void runTestForGivenValue(String value) {
        val result = MapAndFlatmapExercise.letterCombinations(value);
        System.out.println("The result for '" + value + "' is '" + result+ "'");
    }
}
