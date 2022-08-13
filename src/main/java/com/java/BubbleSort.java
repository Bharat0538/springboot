package com.java;

import java.util.Arrays;

public class BubbleSort {

   // int[] a = {36,19,29,12,5};

    public static void main(String[] args) {
        int[] a = {36,19,29,12,5};
        Arrays.stream(a).forEach(i->System.out.print(i+" "));
        System.out.println();
        bubbleSort(a);
        Arrays.stream(a).forEach(i->System.out.print(i+" "));


        String[] arr = {"bharat","ravi","jagdish","nirmal","puja","mannu"};
        bubbleSortForString(arr);
        System.out.println();
        Arrays.stream(arr).forEach(i->System.out.print(i+" "));

    }
    //Given List for round 1 :  36,19,29,12,5
    //Round-1
    //36,19,29,12,5
    //19,36,29,12,5
    //19,29,36,12,5
    //19,29,12,36,5
    //19,29,12,5,36
    //Given List for round 2 :  19,29,12,5,36
    //19,29,12,5,36
    //19,29,12,5,36
    //19,12,29,5,36
    //19,12,5,29,36
    //Given List for round 3 : 19,12,5,29,36
    //19,12,5,29,36
    //12,19,5,29,36
    //12,5,19,29,36
    //Given List for round 4 : 12,5,19,29,36
    //12,5,19,29,36
    //5,12,19,29,36

    public static void bubbleSort(int[] a){
        int temp;
        for (int i = 0 ; i < a.length ; i++ ){
            int flag = 0;
            for (int j = 0 ; j < a.length-1-i ;j++){
                if (a[j]>a[j+1]){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag =1;
                }
            }
            if (flag==0){
                break;
            }
        }
    }


    public static void bubbleSortForString(String[] a){
        String temp;
        for (int i = 0 ; i < a.length ; i++ ){
            int flag = 0;
            for (int j = 0 ; j < a.length-1-i ;j++){
                if (a[j].compareTo(a[j+1])>0){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag =1;
                }
            }
            if (flag==0){
                break;
            }
        }
    }
}

