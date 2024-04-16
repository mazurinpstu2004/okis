package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.example.Sort.*;

public class TestSort {
    @Test(groups = {"positive"})
    public static void TestBubbleSort() throws Exception {
        //arange
        final int[] ARR = {82, 42, 12, 6, 65, 31, 9, 25, 11, 93};
        int[] expectedResult = {6, 9, 11, 12, 25, 31, 42, 65, 82, 93};
        int[] actualResult;
        //act
        bubbleSort(ARR);
        actualResult = ARR;
        //assert
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test(groups = {"positive"})
    public static void testShakerSort() throws Exception {
        //arange
        final int[] ARR = {18, 91, 47, 98, 58, 59, 21, 1, 55, 96};
        int[] expectedResult = {1, 18, 21, 47, 55, 58, 59, 91, 96, 98};
        // int[] expectedResult = {1, 18, 21, 47, 55, 58, 59, 91, 96, 98, 0};
        int[] actualResult;
        //act
        shakerSort(ARR);
        actualResult = ARR;
        //assert
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test(groups = {"positive"})
    public static void testInsertionSort() throws Exception {
        //arange
        final int[] ARR = {19, 95, 48, 52, 34, 40, 46, 1, 84, 56};
        int[] expectedResult = {1, 19, 34, 40, 46, 48, 52, 56, 84, 95};
        // int[] expectedResult = {1, 19, 40, 34, 46, 48, 52, 56, 84, 95};
        int[] actualResult;
        //act
        insertionSort(ARR);
        actualResult = ARR;
        //assert
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test(groups = {"positive"})
    public static void testShellSort() throws Exception {
        //arange
        final int[] ARR = {94, 46, 99, 75, 28, 96, 3, 13, 33, 4};
        int[] expectedResult = {3, 4, 13, 28, 33, 46, 75, 94, 96, 99};
        int[] actualResult;
        //act
        shellSort(ARR);
        actualResult = ARR;
        //assert
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test(groups = {"negative"}, expectedExceptions = {Sort.NullArrayException.class})
    public static void testSortException() throws Exception {
        //arange
        final int[] ARR = {};
        //act
        shakerSort(ARR); // Можно использовать любую сортировку
    }
}
