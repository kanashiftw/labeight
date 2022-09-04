package com.company;

import java.util.Arrays;

public class Main {
    public static void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }
    public static int linearSearch(int arr[], int elementToSearch) {

        for (int index = 0; index < arr.length; index++) {
            if(arr[index] == elementToSearch) {
                return index;
            }
        }
        return -1;
    }
    public static int interpolationSearch(int[] data, int item) {

        int highEnd = (data.length - 1);
        int lowEnd = 0;

        while (item >= data[lowEnd] && item <= data[highEnd] && lowEnd <= highEnd) {

            int probe = lowEnd + (highEnd - lowEnd) * (item - data[lowEnd]) / (data[highEnd] - data[lowEnd]);

            if (highEnd == lowEnd) {
                if (data[lowEnd] == item) {
                    return lowEnd;
                } else {
                    return -1;
                }
            }

            if (data[probe] == item) {
                return probe;
            }

            if (data[probe] < item) {
                lowEnd = probe + 1;
            } else {
                highEnd = probe - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
	// write your code here
        int[] array1 = new int[100];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = ((int)(Math.random() * 31));
        }
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < array1.length; i++) {
                if (array1[i] < array1[i - 1]) {
                    swap(array1, i, i-1);
                    needIteration = true;
                }
            }
        }
        System.out.println(Arrays.toString(array1));
        int index = Arrays.binarySearch(array1, 2) + 1;
        System.out.println(index);
        System.out.println(linearSearch(array1, 3));
        System.out.println(interpolationSearch(array1, 3));
    }
}
