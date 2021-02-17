package com.company;

import java.io.*;
import java.util.Arrays;

public class Main
{
    static public double average(int[] arr, int left, int right) {
        double sum = 0;
        for (int i = left; i <= right; ++i) {
            sum += arr[i];
        }
        return sum / (right - left + 1);
    }

    static public void sort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }

        if (left + 1 == right) {
            if (arr[left] > arr[right]) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
            return;
        }
        double av = average(arr, left, right);
        int size = right - left + 1;

        int tmp[] = new int[size];
        int i1 = 0;
        int i2 = size - 1;

        for (int i = left; i <= right; ++i) {
            if (arr[i] < av) {
                tmp[i1] = arr[i];
                ++i1;
            } else {
                tmp[i2] = arr[i];
                --i2;
            }
        }

        for (int i = left; i <= right; ++i) {
            arr[i] = tmp[i - left];
        }

        sort(arr, left, left + i2);
        sort(arr, left + i1, right);
    }

    public static void main(String[] args) {

//        int size = 5;
//        int arr[] = {17, 1, 96, 4, 58};
        int size = 10;
        int arr[] = {17, 1, 96, 4, 58, 2, 100, 9999, 9998, 18};
        sort(arr, 0, size - 1);
        System.out.println(Arrays.toString(arr));
    }
}
