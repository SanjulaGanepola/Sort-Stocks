package stocksort;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Zhaojingyu, Vasily, Sanjula
 */
public class Sorts {

    public static Comparable[] selectionSort(Comparable[] list) {
        for (int i = 0; i < list.length; i++) {
            int minIndex = i;
            for (int j = i; j < list.length; j++) {
                if (list[j].compareTo(list[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            Comparable temp = list[i];
            list[i] = list[minIndex];
            list[minIndex] = temp;
        }
        return list;
    }

    public static Integer[] insertionSort(Integer[] list) {
        for (int i = 1; i < list.length; i++) {
            for (int j = i; j > 0; j--) {
                if (list[j] < list[j - 1]) {
                    int temp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = temp;
                }
            }
        }
        return list;
    }

    /**
     * Using a bubble sort algorithm, sort a comparable array.
     *
     * @param list The array to sort.
     * @return The sorted array.
     */
    public static Comparable[] bubbleSort(Comparable[] list) {
        //Track whether swaps were made
        boolean swap;
        //Temporary variable used when swapping elements
        Comparable temp;
        do {
            //No swap was made
            swap = false;
            //Loop through the array
            for (int i = 0; i < list.length-1; i++) {
                //Compare the element and the element above it
                    if (list[i].compareTo(list[i + 1]) > 0) {
                        //Swap the two elements
                        temp = list[i];
                        list[i] = list[i + 1];
                        list[i + 1] = temp;
                        //Swap was made
                        swap = true;
                    }
            }
        } while (swap);
        //Sorted array
        return list;
    }
}
