package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.example.AdditionalOperations.*;

public class TestAdditionalOperations {
    @Test(groups = {"positive"})
    public static void TestFactorial() {
        //arange
        final int n = 3;
        int expectedResult = 6;
        int actualResult;
        //act
        actualResult = Factorial(n);
        //assert
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test(groups = {"positive"})
    public static void TestMatrixElementsSum() throws Exception {
        //arange
        final int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int expectedResult = 45;
        int actualResult;
        //act
        actualResult = MatrixElementsSum(matrix);
        //assert
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test(groups = {"positive"})
    public static void TestDeleteDuplicates() throws Exception {
        //arange
        // final int[] arr = {};
        // int[] expectedResult = {};
        final int[] arr = {1, 3, 1, 8, 5, 3, 8};
        int[] expectedResult = {1, 3, 5, 8};
        int[] actualResult;
        //act
        actualResult = DeleteDuplicates(arr);
        //assert
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test(groups = {"positive"})
    public static void TestArrayMaxElement() throws Exception {
        //arange
        final int[] arr = {4, 8, 53, 2, 12, 8, 7, 4, 67, 32};
        // int expectedResult = 53;
        int expectedResult = 67;
        int actualResult;
        //act
        actualResult = ArrayMaxElement(arr);
        //assert
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test(groups = {"negative"}, expectedExceptions = {AdditionalOperations.NullArrayException.class})
    public static void TestArrayMaxElementException() throws Exception {
        //arange
        final int[] arr = {};
        int[] expectedResult = {};
        int actualResult;
        //act
        actualResult = ArrayMaxElement(arr);
    }
    @Test(groups = {"negative"}, expectedExceptions = {AdditionalOperations.NullArrayException.class})
    public static void TestDeleteDuplicatesException() throws Exception {
        //arange
        final int[] arr = {};
        int[] expectedResult = {};
        int[] actualResult;
        //act
        actualResult = DeleteDuplicates(arr);
    }
    @Test(groups = {"negative"}, expectedExceptions = {AdditionalOperations.NullMatrixException.class})
    public static void TestMatrixElementsSumException() throws Exception {
        //arange
        final int[][] matrix = {};
        int expectedResult = 0;
        int actualResult;
        //act
        actualResult = MatrixElementsSum(matrix);
    }
}
