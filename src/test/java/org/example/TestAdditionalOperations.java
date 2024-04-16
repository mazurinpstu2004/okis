package org.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.example.AdditionalOperations.*;

public class TestAdditionalOperations {
    @Test(groups = {"positive"})
    public static void testFactorial() {
        //arange
        final int N = 3;
        int expectedResult = 6;
        int actualResult;
        //act
        actualResult = factorial(N);
        //assert
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test(groups = {"positive"})
    public static void testMatrixElementsSum() throws Exception {
        //arange
        final int[][] MATRIX = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int expectedResult = 45;
        int actualResult;
        //act
        actualResult = matrixElementsSum(MATRIX);
        //assert
        Assert.assertEquals(actualResult, expectedResult);
    }
    @DataProvider(name = "arrays")
    public Object[][] testArrays() {
        int[] arr1 = {1, 1, 1, 1, 1, 1};
        int[] expectedResult1 = {1};
        int[] arr2 = {3, 5, 8, 3, 3, 8, 9, 5, 5, 1};
        int[] expectedResult2 = {1, 3, 5, 8, 9};
        int[] arr3 = {1, 7, 12, 13, 17, 18};
        int[] expectedResult3 = {1, 7, 12, 13, 17, 18};
        return new Object[][] {
                {arr1, expectedResult1}, {arr2, expectedResult2}, {arr3, expectedResult3}
        };
    }
    @Test(groups = {"positive"}, dataProvider = "arrays")
    public static void testDeleteDuplicates(int[] arr, int[] expectedResult) throws Exception {
        //arange
        // final int[] ARR = {};
        // int[] expectedResult = {};
        int[] actualResult;
        //act
        actualResult = deleteDuplicates(arr);
        //assert
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test(groups = {"positive"})
    public static void testArrayMaxElement() throws Exception {
        //arange
        final int[] ARR = {4, 8, 53, 2, 12, 8, 7, 4, 67, 32};
        // int expectedResult = 53;
        int expectedResult = 67;
        int actualResult;
        //act
        actualResult = arrayMaxElement(ARR);
        //assert
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test(groups = {"negative"}, expectedExceptions = {AdditionalOperations.NullArrayException.class})
    public static void testArrayMaxElementException() throws Exception {
        //arange
        final int[] ARR = {};
        //act
        arrayMaxElement(ARR);
    }
    @Test(groups = {"negative"}, expectedExceptions = {AdditionalOperations.NullArrayException.class})
    public static void testDeleteDuplicatesException() throws Exception {
        //arange
        final int[] ARR = {};
        //act
        deleteDuplicates(ARR);
    }
    @Test(groups = {"negative"}, expectedExceptions = {AdditionalOperations.NullMatrixException.class})
    public static void testMatrixElementsSumException() throws Exception {
        //arange
        final int[][] MATRIX = {};
        //act
        matrixElementsSum(MATRIX);
    }
}
