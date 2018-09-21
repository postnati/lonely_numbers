package com.bluemedora;

/*
 * Write a method that takes in an integer array, the integer array is composed of repeating values and zero or more
 * non-repeating values.  Return an array/list of all non repeated values.
 *
 * Your program’s Main method can contain the inputs and call to the method you create to solve the problem.
 * There is no need to worry about user input. The goal is to solve the algorithm in a method and NOT to worry about
 * creating a good user experience.
 *
 * Test Inputs and Expected Outputs
 * ex: [ 2, 3, 7, 3, 2, 3, 10 ] would return [7, 10]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        runLonelyNumbersUsingCollection();
        runLonelyNumbersUsingArrays();
    }

    private static void runLonelyNumbersUsingCollection() {
        // ---------------------------------------------------------------
        // Base Test: [ 2, 3, 7, 3, 2, 3, 10 ] would return [7, 10]
        // ---------------------------------------------------------------
        ArrayList<Integer> baseInput = new ArrayList<>(Arrays.asList(2, 3, 7, 3, 2, 3, 10));
        ArrayList baseOutput = lonelyNumbersUsingCollections(baseInput);

        if(baseOutput.size() == 2 && baseOutput.contains(7) && baseOutput.contains(10)) {
            System.out.println("SUCCESS - BaseOutput: " + baseOutput);
        } else {
            System.out.println("FAILURE - BaseOutput Expected [7, 10] but was " + baseOutput);
        }

        // ---------------------------------------------------------------
        // All Duplicates Test: [ 1, 2, 3, 3, 2, 1] would return []
        // ---------------------------------------------------------------
        ArrayList<Integer> allDuplicatesInput = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 2, 1));
        ArrayList allDuplicatesOutput = lonelyNumbersUsingCollections(allDuplicatesInput);

        if(allDuplicatesOutput.size() == 0) {
            System.out.println("SUCCESS - All Duplicates: " + allDuplicatesOutput);
        } else {
            System.out.println("FAILURE - All Duplicates Expected [] but was " + allDuplicatesOutput);
        }

        // ---------------------------------------------------------------
        // Unique Test: [ -1, 2, -3, 3, -2, 1 ] would return [-1, 2, -3, 3, -2, 1]
        // ---------------------------------------------------------------
        ArrayList<Integer> uniqueInput = new ArrayList<>(Arrays.asList(-1, 2, -3, 3, -2, 1));
        ArrayList uniqueOutput = lonelyNumbersUsingCollections(uniqueInput);

        if(uniqueOutput.size() == 6 &&
                uniqueOutput.contains(-1) && uniqueOutput.contains(-2) && uniqueOutput.contains(-3) &&
                uniqueOutput.contains(1) && uniqueOutput.contains(2) && uniqueOutput.contains(3)
        ) {
            System.out.println("SUCCESS - UniqueOutput: " + uniqueOutput);
        } else {
            System.out.println("FAILURE - UniqueOutput Expected [-1, 2, -3, 3, -2, 1] but was " + uniqueOutput);
        }

        // ---------------------------------------------------------------
        // Empty Test: [] would return []
        // ---------------------------------------------------------------
        ArrayList<Integer> emptyInput = new ArrayList<>(Collections.emptyList());
        ArrayList emptyOutput = lonelyNumbersUsingCollections(emptyInput);

        if(emptyOutput.size() == 0) {
            System.out.println("SUCCESS - emptyOutput: " + emptyOutput);
        } else {
            System.out.println("FAILURE - emptyOutput Expected [] but was " + emptyOutput);
        }

        // ---------------------------------------------------------------
        // Null Test: [] would return []
        // ---------------------------------------------------------------
        ArrayList nullOutput = lonelyNumbersUsingCollections(null);

        if(nullOutput.size() == 0) {
            System.out.println("SUCCESS - nullOutput: " + nullOutput);
        } else {
            System.out.println("FAILURE - nullOutput Expected [] but was " + nullOutput);
        }
    }


    private static void runLonelyNumbersUsingArrays() {
        // ---------------------------------------------------------------
        // Base Test: [ 2, 3, 7, 3, 2, 3, 10 ] would return [7, 10]
        // ---------------------------------------------------------------
        int[] baseInput = new int[]{2, 3, 7, 3, 2, 3, 10};
        int[] baseOutput = lonelyNumbersUsingArrays(baseInput);

        System.out.println("BaseOutput: " + Arrays.toString(baseOutput));

        // ---------------------------------------------------------------
        // All Duplicates Test: [ 1, 2, 3, 3, 2, 1] would return []
        // ---------------------------------------------------------------
        int[] allDuplicatesInput = new int[]{1, 2, 3, 3, 2, 1};
        int[]  allDuplicatesOutput = lonelyNumbersUsingArrays(allDuplicatesInput);

        System.out.println("All Duplicates: " + Arrays.toString(allDuplicatesOutput));

        // ---------------------------------------------------------------
        // Unique Test: [ -1, 2, -3, 3, -2, 1 ] would return [-1, 2, -3, 3, -2, 1]
        // ---------------------------------------------------------------
        int[] uniqueInput = new int[]{-1, 2, -3, 3, -2, 1};
        int[] uniqueOutput = lonelyNumbersUsingArrays(uniqueInput);

        System.out.println("UniqueOutput: " + Arrays.toString(uniqueOutput));

        // ---------------------------------------------------------------
        // Empty Test: [] would return []
        // ---------------------------------------------------------------
        int[] emptyInput = new int[0];
        int[] emptyOutput = lonelyNumbersUsingArrays(emptyInput);

        System.out.println("emptyOutput: " + Arrays.toString(emptyOutput));

        // ---------------------------------------------------------------
        // Null Test: [] would return []
        // ---------------------------------------------------------------
        int[] nullOutput = lonelyNumbersUsingArrays(null);

        System.out.println("nullOutput: " + Arrays.toString(nullOutput));
    }

    /*
     * lonelyNumbers method using Java collections
     */
    private static ArrayList lonelyNumbersUsingCollections(ArrayList<Integer> input) {
        ArrayList<Integer> output = new ArrayList<>();

        if(input == null || input.isEmpty()) {
            return output;
        }

        HashMap<Integer, Integer> trackingMap = new HashMap<>();

        // For loop using old style counting
        for(int index = 0; index < input.size(); index++) {
            Integer key = input.get(index);
            if(trackingMap.containsKey(key)) {
                trackingMap.put(key, trackingMap.get(key) + 1);
            } else {
                trackingMap.put(key, 1);
            }
        }

        // For loop using iteration style. keySet returns an array of all the keys in the map
        for (Integer key: trackingMap.keySet()) {
            if(trackingMap.get(key) == 1) {
                output.add(key);
            }
        }

        return output;
    }

    /*
     * lonelyNumbers method using Java Arrays
     */
    private static int[] lonelyNumbersUsingArrays(int[] input) {
        int[] output = new int[0];
        int[] rejected = new int[0];

        if(input == null || input.length == 0) {
            return output;
        }

        // For loop using old style counting
        for(int index = 0; index < input.length; index++) {
            int key = input[index];

            if(!intArrayContains(output, key) && !intArrayContains(rejected, key)) {
                output = addIntValueToArray(output, key);
            } else if(intArrayContains(output, key)) {
                output = removeIntValueFromArray(output, key);
                rejected = addIntValueToArray(rejected, key);
            }
        }

        return output;
    }

    private static boolean intArrayContains(int[] array, int value) {
        boolean isFound = false;
        for(int index = 0; index < array.length; index++) {
            if(array[index] == value) {
                isFound = true;
            }
        }

        return isFound;
    }

    private static int[] addIntValueToArray(int[] array, int newValue) {
        int[] newArray = new int[array.length + 1];
        int index;

        for(index = 0; index < array.length; index++) {
            newArray[index] = array[index];
        }

        newArray[index] = newValue;

        return newArray;
    }

    private static int[] removeIntValueFromArray(int[] array, int value) {
        int foundCount = 0;

        for(int index = 0; index < array.length; index++) {
            if(array[index] == value) {
                foundCount = foundCount + 1;
            }
        }

        int[] newArray = new int[array.length - foundCount];
        int offset = 0;

        for(int index = 0; index < array.length; index++) {
            if(array[index] == value) {
                offset = offset + 1;
            } else {
                newArray[index-offset] = array[index];
            }
        }

        return newArray;
    }
}
