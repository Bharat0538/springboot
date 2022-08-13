package com.java;

import java.util.Arrays;

public class SelectionSort {

    //38,52,9,18,6,62,13

    public static void main(String[] args) {
        int[] a = {38,52,9,18,6,62,13};
        selectSortInteger(a);
        Arrays.stream(a).forEach(p->System.out.print(p+" "));

        String[] arr = {"bharat","ravi","jagdish","nirmal","puja","mannu"};
        selectSortString(arr);
        System.out.println();
        Arrays.stream(arr).forEach(i->System.out.print(i+" "));
    }


    //38,52,9,18,6,62,13   checks for index 1
    //6,52,9,18,38,62,13   checks for index 2
    //6,9,52,18,38,62,13   checks for index 3
    //6,9,13,18,38,62,52    checks for index 4
    //6,9,13,18,38,62,52    checks for index 5
    //6,9,13,18,38,62,52   checks for index 6
    //6,9,13,18,38,52,52   checks for index 7
    public static void selectSortInteger(int[] a){
        for (int i=0; i<a.length;i++ ){
            int min; int temp = 0;
            min=i;
            for (int j = i+1 ; j<a.length;j++){
                if (a[j]<a[min]){
                    min = j;
                }
            }
            temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

    public static void selectSortString(String[] a){
        for (int i=0; i<a.length;i++ ){
            int min; String temp="";
            min=i;
            for (int j = i+1 ; j<a.length;j++){
                if (a[j].compareTo(a[min])<0){
                    min = j;
                }
            }
            temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }
}
