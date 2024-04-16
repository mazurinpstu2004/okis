package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.example.StringOperations.*;

public class TestStringOperations {
    @Test(groups = {"positive"})
    public static void testAlternatingSymbols() throws Exception {
        //arange
        final String STR1 = "hlool";
        final String STR2 = "elwrd";
        String exceptionResult = "helloworld";
        //act
        // String exceptionResult = "hello world";
        String actualResult = alternatingSymbols(STR1, STR2);
        //assert
        Assert.assertEquals(actualResult, exceptionResult);
    }
    @Test(groups = {"positive"})
    public static void testStringCompression() throws Exception  {
        //arange
        final String STR = "heeellloooowooorrldddd";
        String exceptionResult = "he3l3o4wo3r2ld4";
        //act
        String actualResult = stringCompression(STR);
        //assert
        Assert.assertEquals(actualResult, exceptionResult);
    }
    @Test(groups = {"positive"})
    public static void testDigitsInString() throws Exception  {
        //arange
        final String STR = "*123  321re987_7";
        int exceptionResult = 10;
        //act
        int actualResult = digitsInString(STR);
        //assert
        Assert.assertEquals(actualResult, exceptionResult);
    }
    @Test(groups = {"positive"})
    public static void testMultiplicationDigitsInString() throws Exception  {
        //arange
        //final String STR = "";
        //int exceptionResult = 0;
        final String STR = "Qw3rty 7yu1o pio2";
        int exceptionResult = 42;
        //act
        int actualResult = multiplicationDigitsInString(STR);
        //assert
        Assert.assertEquals(actualResult, exceptionResult);
    }
    @Test(groups = {"negative"}, expectedExceptions = {NullStringException.class})
    public static void testDigitsInStringException() throws NullStringException {
        //arange
        final String STR = "";
        //act
        digitsInString(STR);
    }
}
