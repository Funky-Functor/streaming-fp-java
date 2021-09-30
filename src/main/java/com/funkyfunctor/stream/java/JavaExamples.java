package com.funkyfunctor.stream.java;

import io.vavr.Tuple;
import io.vavr.collection.HashMap;
import io.vavr.collection.HashSet;
import io.vavr.collection.List;
import io.vavr.collection.Set;
import io.vavr.control.Option;
import lombok.experimental.UtilityClass;
import lombok.val;

@UtilityClass
public class JavaExamples {

    public static void main(String[] args) {
        //map
        //Takes a value of type A and returns a value of a type B
        //Take an Integer i and return the next integer (i +1)

        //Option
        final Option<Integer> myOption = Option.of(1);
        final Option<Integer> myEmptyOption = Option.of(null);

        final Option<Integer> myOptionPlusOne = myOption.map((i) -> i + 1);
        System.out.println("Value for myOptionPlusOne is " + myOptionPlusOne);

        final Option<Integer> myEmptyOptionPlusOne = myEmptyOption.map((i) -> i + 1);
        System.out.println("Value for myEmptyOptionPlusOne is " + myEmptyOptionPlusOne);

        final Option<Integer> plusOneAgain = myOption.flatMap((i) -> Option.of(i + 1));
        System.out.println("Value for plusOneAgain is " + plusOneAgain);

        final Option<Integer> finalOptionResult = myEmptyOption
                .flatMap(JavaExamples::plusOne)
                .flatMap(JavaExamples::timesTwo)
                .flatMap((i) -> divideBy(i, 4));
        System.out.println("Value for finalOptionResult is " + finalOptionResult);

        //List
        final List<Integer> myList = List.of(1, 2, 3);

        final List<Integer> myListPlusOne = myList.map((i) -> i + 1);
        System.out.println("Value for myListPlusOne is " + myListPlusOne);

        final List<Integer> plusOneMinusOne = myList.flatMap((i) -> List.of(i - 1, i + 1));
        System.out.println("Value for plusOneMinusOne is " + plusOneMinusOne);

        //Sets
        final Set<Integer> mySet = HashSet.of(4, 5, 6);
        final Set<Integer> mySetPlusOne = mySet.map((i) -> i + 1);
        System.out.println("Value for mySetPlusOne is " + mySetPlusOne);

        final Set<Integer> mySetPlusOneMinusOne = mySet.flatMap((i) -> HashSet.of(i - 1, i + 1));
        System.out.println("Value for mySetPlusOneMinusOne is " + mySetPlusOneMinusOne);

        //Tuples
        final var myTuple = Tuple.of("John", "Doe", 39);
        System.out.println("My user name is " + myTuple._1 + " " + myTuple._2);

        //Map
        val tuple1 = Tuple.of(1, "John Doe");
        val tuple2 = Tuple.of(2, "Jane Doe");
        val tuple3 = Tuple.of(3, "Funky Functor");

        val myMap = HashMap.ofEntries(
                tuple1,
                tuple2,
                tuple3
        );
        final var valueFor1 = myMap.get(3);
        System.out.println("The user for id 3 is " + valueFor1);

        final var valueForMinus1 = myMap.get(-1);
        System.out.println("The user for id -1 is " + valueForMinus1);
    }

    public static Option<Integer> plusOne(Integer i) {
        return Option.of(i + 1);
    }

    public static Option<Integer> timesTwo(Integer i) {
        return Option.of(i * 2);
    }

    public static Option<Integer> divideBy(Integer i, Integer j) {
        if ((j == null) || (j == 0))
            return Option.none();
        else return Option.of(i / j);
    }
}
