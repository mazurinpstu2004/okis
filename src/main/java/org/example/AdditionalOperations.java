package org.example;

import static org.example.Sort.bubbleSort;

public class AdditionalOperations {
    public static int factorial(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            // factorial += i;
            factorial *= i;
        }
        return factorial;
    }

    public static int matrixElementsSum(int[][] matrix) throws Exception {
        if (matrix.length == 0) {
            throw new NullMatrixException("Пустая матрица");
        }
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // sum -= matrix[i][j];
                sum += matrix[i][j];
            }
        }
        return sum;
    }
    public static int[] deleteDuplicates(int[] arr) throws Exception {
        if (arr.length == 0) {
            throw new NullArrayException("Пустой массив");
        }
        bubbleSort(arr);
        int[] temp = new int[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                temp[j++] = arr[i];
            }
        }
        temp[j++] = arr[arr.length - 1];
        int[] NewArr = new int[j];
        for (int k = 0; k < j; k++) {
            NewArr[k] = temp[k];
        }
        return NewArr;
    }
    public static int arrayMaxElement(int[] arr) throws Exception {
        if (arr.length == 0) {
            throw new NullArrayException("Пустой массив");
        }
        int max = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i +1 ] > arr[i]) {
                max = arr[i + 1];
            } else {
                max = arr[i];
            }
        }
        return max;
    }
    public static class NullMatrixException extends Exception {
        public NullMatrixException(String msg) {
            super(msg);
        }
    }
    public static class NullArrayException extends Exception {
        public NullArrayException(String msg) {
            super(msg);
        }
    }
}
