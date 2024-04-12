package org.example;

public class Sort {
    public static void BubbleSort(int[] arr) throws NullArrayException {
        if (arr.length == 0) {
            throw new NullArrayException("Пустой массив");
        }
        int i;
        for (i = 0; i < arr.length; i++) {
            // for (int j = i - 1; j < arr.length; j++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    public static void ShakerSort(int[] arr) throws NullArrayException {
        if (arr.length == 0) {
            throw new NullArrayException("Пустой массив");
        }
        int i;
        int temp;
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            for ( i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            right--;
            for (i = right; i > left; i--) {
                if (arr[i] < arr[i - 1]) {
                    temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                }
            }
            left++;
        }
    }
    public static void InsertionSort(int[] arr) throws NullArrayException {
        if (arr.length == 0) {
            throw new NullArrayException("Пустой массив");
        }
        int i;
        int j;
        for (i = 1; i < arr.length; i++) {
            int swap = arr[i];
            for (j = i; j > 0 && swap < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = swap;
        }
    }
    public static void ShellSort(int[] arr) throws NullArrayException {
        if (arr.length == 0) {
            throw new NullArrayException("Пустой массив");
        }
        int i;
        for (int gap = arr.length/2; gap > 0; gap /= 2) {
            for (i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j;
                // for (j = i + 1; j >= gap && arr[j - gap] > temp; j -= gap) {
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }
    public static class NullArrayException extends Exception {
        public NullArrayException(String msg) {
            super(msg);
        }
    }
}
