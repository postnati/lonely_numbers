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
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
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
        ArrayList<Integer> emptyInput = new ArrayList<>(Arrays.asList());
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

    /*
     * lonelyNumbers method using Java collections
     */
    public static ArrayList lonelyNumbersUsingCollections(ArrayList<Integer> input) {
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
}
