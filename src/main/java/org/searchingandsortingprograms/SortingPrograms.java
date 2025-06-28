package org.searchingandsortingprograms;

public class SortingPrograms {

    public void printArr(int arr[]) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

    public void bubbleSort(int[] arr) {

        printArr(arr);

        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        printArr(arr);
    }

    public void selectionSort(int[] arr){
        printArr(arr);

        int n = arr.length;
        int smallest;
        for (int i = 0; i < n-1; i++) {
            smallest = i;
            for (int j = i+1; j < n; j++) {
                if(arr[j] < arr[smallest]) {
                    smallest = j;
                }
            }
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }

        printArr(arr);

    }

    public void insertionSort(int[] arr) {
        printArr(arr);

        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while(j>=0 && current > arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = current;
        }

        printArr(arr);
    }

    public void bubbleSortPrac(int[] arr) {
        int n = arr.length;

        printArr(arr);

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        printArr(arr);
    }

    public void selectionSortPr(int[] arr) {

        printArr(arr);
        int n = arr.length;


        for (int i = 0; i < n; i++) {
            int smallest = i;
            for (int j = i+1; j < n; j++) {
                if(arr[j] < arr[smallest]) {
                    smallest = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }

        printArr(arr);
        
    }
    
    public void insertionSortPr(int[] arr) {

        printArr(arr);
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int current = arr[i];
            int j = i -1;
            while(j >= 0 && current < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = current;
        }

        printArr(arr);

    }

    public static void main(String[] args) {
        SortingPrograms sp = new SortingPrograms();
        int arr[] = {7, 8, 2, 5, 4,5,6,3,4,2,8,7,9,3,2,1,5,4,6,8,7,9, 3, 1};
        sp.bubbleSort(arr);
        sp.selectionSort(arr);
        sp.insertionSort(arr);
        sp.bubbleSortPrac(arr);
        sp.selectionSortPr(arr);
        sp.insertionSortPr(arr);
    }
}
