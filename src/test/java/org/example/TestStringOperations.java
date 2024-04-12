package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.example.StringOperations.*;

public class TestStringOperations {
    @Test(groups = {"positive"})
    public static void TestAlternatingSymbols() throws Exception {
        //arange
        final String str1 = "hlool";
        final String str2 = "elwrd";
        //act
        String exceptionResult = "helloworld";
        // String exceptionResult = "hello world";
        String actualResult = AlternatingSymbols(str1, str2);
        //assert
        Assert.assertEquals(actualResult, exceptionResult);
    }
    @Test(groups = {"positive"})
    public static void TestStringCompression() throws Exception  {
        //arange
        final String str = "heeellloooowooorrldddd";
        String exceptionResult = "he3l3o4wo3r2ld4";
        //act
        String actualResult = StringCompression(str);
        //assert
        Assert.assertEquals(actualResult, exceptionResult);
    }
    @Test(groups = {"positive"})
    public static void TestDigitsInString() throws Exception  {
        //arange
        final String str = "*123  321re987_7";
        int exceptionResult = 10;
        //act
        int actualResult = DigitsInString(str);
        //assert
        Assert.assertEquals(actualResult, exceptionResult);
    }
    @Test(groups = {"positive"})
    public static void TestMultiplicationDigitsInString() throws Exception  {
        //arange
        //final String str = "";
        //int exceptionResult = 0;
        final String str = "Qw3rty 7yu1o pio2";
        int exceptionResult = 42;
        //act
        int actualResult = MultiplicationDigitsInString(str);
        //assert
        Assert.assertEquals(actualResult, exceptionResult);
    }
    @Test(groups = {"negative"}, expectedExceptions = {NullStringException.class})
    public static void TestDigitsInStringException() throws NullStringException {
        //arange
        final String str = "";
        //act
        int exceptionResult = 0;
        int actualResult = DigitsInString(str);
    }
}
