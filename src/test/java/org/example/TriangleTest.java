package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {



    // TESTING VALID INPUTS FOR INTEGER CONSTRUCTOR
    @Test
    @DisplayName("checks if numeric values for Equilateral triangle identifies correct")
    void checkNumericInputForEquilateral() {
        Triangle t = new Triangle(9,9,9);
        assertEquals("" + 9 + ", " + 9 + ", " + 9 + ", This is a Equilateral triangle", t.toString());
    }

    @Test
    @DisplayName("checks if values for Isosceles triangle identifies correct")
    void checkNumericInputForIsosceles() {
        Triangle t = new Triangle(9,9,8);
        assertEquals("" + 9 + ", " + 9 + ", " + 8 + ", This is a Isosceles triangle", t.toString());
    }

    @Test
    @DisplayName("checks if values for Scalene triangle identifies correct")
    void checkNumericInputForScalene() {
        Triangle t = new Triangle(9,7,8);
        assertEquals("" + 9 + ", " + 7 + ", " + 8 + ", This is a Scalene triangle", t.toString());
    }



    // TESTING VALID INPUTS FOR STRING ARRAY CONSTRUCTOR
    @Test
    @DisplayName("check if string array inputs are correctly parsed for Equilateral triangle")
    void checkStringArrayInputForEquilateral() {
        String[] validInputs = {"9", "9", "9"};
        Triangle t = new Triangle(validInputs);
        assertEquals("" + 9 + ", " + 9 + ", " + 9 + ", This is a Equilateral triangle", t.toString());
    }

    @Test
    @DisplayName("check if string array inputs are correctly parsed for Isosceles triangle")
    void checkStringArrayInputForIsosceles() {
        String[] validInputs = {"9", "9", "8"};
        Triangle t = new Triangle(validInputs);
        assertEquals("" + 9 + ", " + 9 + ", " + 8 + ", This is a Isosceles triangle", t.toString());
    }

    @Test
    @DisplayName("check if string array inputs are correctly parsed for Scalene triangle")
    void checkStringArrayInputForScalene() {
        String[] validInputs = {"9", "7", "8"};
        Triangle t = new Triangle(validInputs);
        assertEquals("" + 9 + ", " + 7 + ", " + 8 + ", This is a Scalene triangle", t.toString());
    }

    // TESTING INVALID INPUTS FOR STRING ARRAY CONSTRUCTOR

    @Test
    @DisplayName("check if incorrect string array inputs set current_type to null")
    void checkInvalidStringArrayInput() {
        String[] invalidInputs = {"a", "9", "8"};
        Triangle t = new Triangle(invalidInputs);
        assertNull(t.getCurrent_type(), "Expected current_type to be null for invalid string inputs");

    }


    @Test
    @DisplayName("check if the string array has too many elements")
    void checkIfTooManyValues() {
        String[] invalidInputs = {"4", "9", "8", "5"};
        Triangle t = new Triangle(invalidInputs);
        assertNull(t.getCurrent_type(), "Expected current_type to be null for too many string inputs");
    }

    @Test
    @DisplayName("check if the string array has too few elements")
    void checkIfTooFewValues() {
        String[] invalidInputs = {"4", "9"};
        Triangle t = new Triangle(invalidInputs);
        assertNull(t.getCurrent_type(), "Expected current_type to be null for too few string inputs");
    }

    @Test
    @DisplayName("check if the string array values is invalid triangle")
    void checkInvalidTriangleArrayConstructor() {
        String[] invalidInputs = {"1", "2", "3"};
        Triangle t = new Triangle(invalidInputs);
        assertNull(t.getCurrent_type(), "Expected current_type to be null for too few string inputs");
    }



    // BOUNDARY TESTING INPUTS FOR STRING ARRAY CONSTRUCTOR

    @Test
    @DisplayName("check if input values are 0")
    void checkIfArrayInputValueIsZero() {
        String[] invalidInputs = {"0", "0", "0"};
        Triangle t = new Triangle(invalidInputs);
        assertEquals("" + 0 + ", " + 0 + ", " + 0 + ", This is not a triangle", t.toString());

    }

    @Test
    @DisplayName("check if String array input values are negative numbers")
    void checkNegativeIntArrayInputValue() {
        String[] invalidInputs = {"-1", "10", "5"};
        Triangle t = new Triangle(invalidInputs);
        assertEquals("" + -1 + ", " + 10 + ", " + 5 + ", This is not a triangle", t.toString());

    }

    // TESTING IF INTEGER CONSTRUCTOR VALUES ARE INVALID TRIANGLE

    @Test
    @DisplayName("Integer constructor sets current_type to null for sides that do not form a triangle")
    void testIntegerConstructorInvalidTriangle() {
        Triangle t = new Triangle(1, 2, 3);
        assertNull(t.getCurrent_type(), "Current type should be null for sides that do not form a triangle");
    }



    // BOUNDARY TESTING INPUTS FOR INTEGER CONSTRUCTOR
    @Test
    @DisplayName("check if input values are 0")
    void checkIfIntegerInputValueIsZero() {
        Triangle t = new Triangle(0,0,0);
        assertEquals("" + 0 + ", " + 0 + ", " + 0 + ", This is not a triangle", t.toString());

    }

    @Test
    @DisplayName("check if integer input is > 0 ")
    void checkNegativeIntegerInputValue() {
        Triangle t = new Triangle(-10,-50,-40);
        assertEquals("" + -10 + ", " + -50 + ", " + -40 + ", This is not a triangle", t.toString());

    }

// TESTING SCANNER INPUT, SCALENE TRIANGLE
    @Test
    void testGetUserInputScalene() {
        String inputData = "3,4,5\n";
        ByteArrayInputStream testIn = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(testIn);

        Triangle t = new Triangle();
        t.getUserInput();

        assertEquals(Triangle.TYPE.SCALENE, t.getCurrent_type(), "Triangle should be SCALENE for sides 3, 4, 5");

        System.setIn(System.in);
    }

    // TESTING SCANNER INPUT, ISOSCELES TRIANGLE
    @Test
    void testGetUserInputIsoceles() {
        String inputData = "4,3,3\n";
        ByteArrayInputStream testIn = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(testIn);

        Triangle t = new Triangle();
        t.getUserInput();

        assertEquals(Triangle.TYPE.ISOSCELES, t.getCurrent_type(), "Triangle should be ISOSCELES for sides 4, 3, 3");

        System.setIn(System.in);
    }

    // TESTING SCANNER INPUT, EQUILATERAL TRIANGLE

    @Test
    void testGetUserInputEquilateral() {
        String inputData = "3,3,3\n";
        ByteArrayInputStream testIn = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(testIn);

        Triangle t = new Triangle();
        t.getUserInput();

        assertEquals(Triangle.TYPE.EQUILATERAL, t.getCurrent_type(), "Triangle should be EQUILATERAL for sides 3, 3, 3");

        System.setIn(System.in);
    }


    // TESTING SCANNER INPUT WITH NUMBERFORMATEXCEPTION (INVALID NUMBER FORMAT)
    @Test
    @DisplayName("Testing scanner input for NumberFormatException")
    void testGetUserInputWithNumberFormatException() {

        String invalidInputData = "a,4,5\n";
        ByteArrayInputStream testIn = new ByteArrayInputStream(invalidInputData.getBytes());
        System.setIn(testIn);

        Triangle t = new Triangle();
        t.getUserInput();

        assertNull(t.getCurrent_type(), "Current type should be null due to NumberFormatException");

        System.setIn(System.in);
    }


    // TESTING SCANNER INPUT WITH TOO MANY INPUT VALUES
    @Test
    @DisplayName("Testing scanner input when too many input values")
    void testGetUserInputWithIncorrectInputAmount() {

        String invalidInputData = "5,4,5,4\n";
        ByteArrayInputStream testIn = new ByteArrayInputStream(invalidInputData.getBytes());
        System.setIn(testIn);

        Triangle t = new Triangle();
        t.getUserInput();

        assertNull(t.getCurrent_type(),  "Current type should be null due to incorrect amount of input values");

        System.setIn(System.in);
    }


    // TESTING SCANNER INPUT WITH INVALID FORMAT
    @Test
    @DisplayName("Testing scanner input with invalid format")
    void testGetUserInputWithInvalidFormat() {
        String invalidInputData = "3,3;4\n"; // Ogiltigt format med semikolon
        ByteArrayInputStream testIn = new ByteArrayInputStream(invalidInputData.getBytes());
        System.setIn(testIn);

        Triangle t = new Triangle();
        t.getUserInput();

        assertNull(t.getCurrent_type(), "Current type should be null due to invalid format");

        System.setIn(System.in);
    }

    // TESTING SCANNER INPUT WITH TOO FEW INPUT VALUES
    @Test
    @DisplayName("Testing scanner input with too few values")
    void testGetUserInputWithInsufficientValues() {
        String invalidInputData = "3,4\n"; //
        ByteArrayInputStream testIn = new ByteArrayInputStream(invalidInputData.getBytes());
        System.setIn(testIn);

        Triangle t = new Triangle();
        t.getUserInput();

        assertNull(t.getCurrent_type(), "Current type should be null due to too few values");

        System.setIn(System.in);
    }


    // TESTING VALID VALUES FOR setCurrent_type

    @Test
    @DisplayName("setCurrent_type correctly identifies an equilateral triangle")
    void testSetCurrentTypeEquilateral() {
        Triangle t = new Triangle();
        t.setCurrent_type(10, 10, 10);
        assertEquals(Triangle.TYPE.EQUILATERAL, t.getCurrent_type(), "Should be an equilateral triangle");
    }

    @Test
    @DisplayName("setCurrent_type correctly identifies an isosceles triangle")
    void testSetCurrentTypeIsosceles() {
        Triangle t = new Triangle();
        t.setCurrent_type(10, 10, 8);
        assertEquals(Triangle.TYPE.ISOSCELES, t.getCurrent_type(), "Should be an isosceles triangle");
    }

    @Test
    @DisplayName("setCurrent_type correctly identifies a scalene triangle")
    void testSetCurrentTypeScalene() {
        Triangle t = new Triangle();
        t.setCurrent_type(10, 8, 6);
        assertEquals(Triangle.TYPE.SCALENE, t.getCurrent_type(), "Should be a scalene triangle");
    }


    // Testing invalid values for setCurrent_type, should be null
    @Test
    @DisplayName("setCurrent_type sets current_type to null for invalid triangle")
    void testSetCurrentTypeInvalid() {
        Triangle t = new Triangle();
        t.setCurrent_type(1, 2, 3);
        assertNull(t.getCurrent_type(), "Should be null for an invalid triangle");
    }


    // TESTING toString method

    @Test
    @DisplayName("toString returns correct string for an equilateral triangle")
    void testToStringEquilateral() {
        Triangle t = new Triangle(10, 10, 10);
        String expected = "10, 10, 10, This is a Equilateral triangle";
        assertEquals(expected, t.toString(), "toString should describe an equilateral triangle");
    }

    @Test
    @DisplayName("toString returns correct string for an isosceles triangle")
    void testToStringIsosceles() {
        Triangle t = new Triangle(10, 10, 8);
        String expected = "10, 10, 8, This is a Isosceles triangle";
        assertEquals(expected, t.toString(), "toString should describe an isosceles triangle");
    }

    @Test
    @DisplayName("toString returns correct string for a scalene triangle")
    void testToStringScalene() {
        Triangle t = new Triangle(10, 8, 6);
        String expected = "10, 8, 6, This is a Scalene triangle";
        assertEquals(expected, t.toString(), "toString should describe a scalene triangle");
    }


    @Test
    @DisplayName("toString returns correct string for an invalid triangle")
    void testToStringInvalid() {
        Triangle t = new Triangle(1, 2, 3);
        String expected = "1, 2, 3, This is not a triangle";
        assertEquals(expected, t.toString(), "toString should indicate this is not a triangle");
    }

}