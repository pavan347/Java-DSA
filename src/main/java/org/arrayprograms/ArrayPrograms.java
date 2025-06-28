package org.arrayprograms;

import java.lang.reflect.Array;
import java.util.*;

public class ArrayPrograms {

    public static void printArr(Object[] arr) {
        for(Object obj: arr) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    public static void printIntArr(int[] arr) {
        for(int i: arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void copyArray(int[] arr) {
        int[] newArr = new int[arr.length];

        printIntArr(newArr);

        // Using For Loop for copying
//        int i = 0;
//        for(int ele: arr){
//            newArr[i] = ele;
//            i++;
//        }

        // Using Clone method
//        newArr = arr.clone();


        newArr = Arrays.copyOf(arr, arr.length);
        printIntArr(newArr);
    }

    public void findFrequencyOfEachElement(int[] arr){

        int max = arr[0];
        for(int ele: arr) {
            max = Math.max(max, ele);
        }
        System.out.println(max);

        int frequency[] = new int[max+1];

        for(int ele: arr) {
            frequency[ele]++;
        }

        for(int ele: arr) {
            System.out.println("Ele: " + ele + " Count: " + frequency[ele]);
        }
    }

    public void findFrequencyOfEachElementPr(int[] arr) {

        boolean[] visited = new boolean[arr.length];
        int count;
        for (int i = 0; i < arr.length; i++) {
            count = 1;
//            System.out.println(i + " " + visited[i]);
            if(!visited[i]){
                for (int j = i+1; j < arr.length; j++) {
                    if(arr[i] == arr[j]) {
                        count++;
//                        System.out.print(j + " " );
                        visited[j] = true;
                    }
                }
                System.out.println(arr[i] + " " + count );
            }
//            System.out.println();
        }

    }

    public void leftRotateElements(int[] arr, int numofTimes) {

        printIntArr(arr);

        int length = arr.length;
        for(int n = 1; n <= numofTimes; n++) {
            int lastEle = arr[length-1];
            for(int i = length - 1; i > 0 ; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = lastEle;
        }

        printIntArr(arr);

    }

    public void leftRotateElementsPr(int[] arr, int numofTimes) {
        System.out.println(Arrays.toString(arr));
        while(numofTimes > 0) {
            int first = arr[0];
            for (int i = 1; i < arr.length; i++) {
                arr[i-1] = arr[i];
            }
            arr[arr.length-1] = first;
            numofTimes--;
        }

        System.out.println(Arrays.toString(arr));
    }

    public void printDuplicates(int[] arr){
        boolean visited[] = new boolean[arr.length];

        for(int i = 0 ; i < arr.length; i++) {
            int count = 1;
            if(!visited[i]) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] == arr[j]) {
                        count++;
                        visited[j] = false;
                    }
                }
            }
            if(count > 1) {
                System.out.println("Ele: " + arr[i] + " Count: " + count);
            }

        }
    }

    public void sortElementsInAssendingOrDescending(int[] arr) {
        // Ascending order
//        printIntArr(arr);
//        Arrays.sort(arr);
//        printIntArr(arr);

        // Descending order
        Integer[] intergerArray = new Integer[arr.length];
        int i = 0;
        for(int ele : arr) {
            intergerArray[i] = ele;
            i++;
        }
        printArr(intergerArray);
        Arrays.sort(intergerArray, Collections.reverseOrder());
        printArr(intergerArray);

    }

    public void removeDuplicates(int[] arr) {

        printIntArr(arr);

        boolean visited[] = new boolean[100000];
        ArrayList<Integer> arrList = new ArrayList();
        for(int i = 0 ; i < arr.length ; i++) {
            if(!visited[arr[i]]) {
                arrList.add(arr[i]);
            }
            visited[arr[i]] = true;
        }

        System.out.println(arrList);
    }

    public void secondlargest(int[] arr) {
        int length = arr.length;
        int largest = Math.max(arr[0], arr[1]);
        int secondLargest = Math.min(arr[0], arr[1]);

        for(int i = 2 ; i < length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }

        System.out.println("Largest: " + largest);
        System.out.println("Second Largest: " + secondLargest);
    }

    public void replaceALlNumbersByTheirRank(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        printIntArr(arr);
        printIntArr(newArr);

        for (int i = 0; i < arr.length; i++) {
            int temp = map.get(newArr[i]);
            System.out.println(temp);
            newArr[i] = temp;
        }

        printIntArr(newArr);
    }

    public int findEquilibriumIndex(int[] arr) {

        int sum = 0;
        int leftSum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            sum-=arr[i];

            if(leftSum == sum) {
                return i;
            }
            leftSum += arr[i];
        }

        return -1;

    }

    public void leftRotateArray(int[] arr, int t) {
        printIntArr(arr);
        for (int i = 0; i < t; i++) {
            int num = arr[0];
            for (int j = 0; j < arr.length-1; j++) {
                arr[j] = arr[j+1];
            }
            arr[arr.length-1] = num;
//            printIntArr(arr);
        }
        printIntArr(arr);

    }

    public void sortThe012Array(int[] arr) {

        printIntArr(arr);
        int length = arr.length;

        int i = 0;
        int j = length-1;
        int idx = 0;
        while(  idx <= j) {

            if(arr[idx] == 0) {
                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
                i++;
                idx++;
            }else if(arr[idx] == 1) {
                idx++;
            }else {
                int temp = arr[j];
                arr[j] = arr[idx];
                arr[idx] = temp;
                j--;
            }

            System.out.println(idx);
            printIntArr(arr);
        }

        printIntArr(arr);

    }

    public void findKthMaxAndMinElement(int[] arr, int k) {

        printIntArr(arr);
        Arrays.sort(arr);
        printIntArr(arr);
        System.out.println("Maximum " +arr[arr.length - k]);
        System.out.println("Minumum " + arr[k-1]);

    }

    public void moveAllNegativeElementsToOneSide(int[] arr) {

        printIntArr(arr);
        int idx = 0;
        int negTrac = 0;
        while(idx< arr.length){
            if(arr[idx] < 0) {
                int temp = arr[idx];
                arr[idx] = arr[negTrac];
                arr[negTrac] = temp;
                negTrac++;
            }
            idx++;
        }
        printIntArr(arr);
    }

    public void findUnionAndIntersectionOfTwoArrays(int[] arr1, int[] arr2){

        Set<Integer> union = new HashSet<Integer>();
        List<Integer> intersection = new ArrayList<>();

        for (int i = 0; i < arr1.length; i++) {
            if(union.contains(arr1[i])){
                intersection.add(arr1[i]);
            }
            union.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            if(union.contains(arr2[i])){
                intersection.add(arr2[i]);
            }
            union.add(arr2[i]);
        }

        System.out.println(union);
        System.out.println(intersection);


    }

    public void findLargestSumContiguousArray(int[] arr) {
        // [1, -2, 3, 4, -1, 2, 1, -5, 4]
        int start = -1;
        int end = -1;
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                    sum+=arr[j];
                if(largest < sum) {
                    start = i;
                    end = j;
                    largest = sum;
                }
                System.out.println(arr[i]+"(" +i +")"+ "---" + arr[j] +"(" +j +")" + " " + sum);
            }
        }

        System.out.println(start + "-----" + end  + "  ==> " + largest);

    }

    public void minimizeTheMaximumDifferenceBetweenHeights(int[] arr) {

        Arrays.sort(arr);

        int min = arr[0];
        int max = arr[arr.length-1];

        int diff1 = (max+3) - (min+3);
        int diff2 = (max-3) - (min-3);
        int diff3 = (max-3) - (min+3);
        int diff4 = (max+3) - (min-3);

        System.out.println(diff1 + " " + diff2 + " " + diff3 + " " + diff4);

        System.out.println(Math.min(diff1, Math.min(diff2, Math.min(diff3, diff4))));

    }

    public void findTwoSum(int[] arr, int target) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if(list.contains(target-arr[i])){
                System.out.println(list.indexOf(target-arr[i]) + " " + i);
                return;
            }else{
                list.add(arr[i]);
            }
        }

    }

    public void groupAnargams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            int[] freq = new int[26];
            for(char ch: str.toCharArray()) {
                freq[ch - 'a']++;
            }
            String key = Arrays.toString(freq);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);

        }

        System.out.println(map.values());
    }

    public void findElementsGreaterThanKFrequency(int[] arr, int k)     {

//        Map<Integer, Integer> map = new HashMap<>();
//
//        for(int ele: arr) {
//            if(!map.containsKey(ele)) {
//                map.put(ele, 1);
//            }else {
//                map.put(ele, map.get(ele)+1);
//            }
//        }
//
//        System.out.println(map);
//
//        for(int ele: map.keySet()) {
//            if(map.get(ele) >= k) {
//                System.out.println(ele);
//            }
//        }


        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            System.out.println(arr[i-1] + " " + arr[i] + " " + count);
            if(arr[i] == arr[i-1]){
                count++;
                if(i == arr.length-1){
                    if(count >= k) {
                        System.out.println(arr[i-1]);
                    }
                }
            }else {
                if( count >= k) {
                    System.out.println(arr[i-1]);
                }
                count = 1;
            }

        }

    }

    public void productOfArrayExceptSelf(int[] arr) {

        int[] newArr = new int[arr.length];

        int product = 1;
        int zeroCount = 0;
        for(int ele: arr){
            if(ele != 0){
                product *= ele;
            }else{
                zeroCount++;
            }
        }

        if(zeroCount > 1) {
            System.out.println(Arrays.toString(newArr));
        }

        for (int i = 0; i < arr.length; i++) {
            if(zeroCount == 1){
                if(arr[i] == 0){
                    newArr[i] = product;
                }
            }else{
                newArr[i] = product/arr[i];
            }
        }

        System.out.println(Arrays.toString(newArr));
    }

    public boolean isValidSubGrid(char[][] sudoku, int row, int col) {

        boolean[] seen = new boolean[9];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("("+(i+row)+" "+(j+col+")"));
                char current = sudoku[row+i][col+j];
                int index = current -'1';
                if(current != '.'){
                    if(seen[index]){
                        return false;
                    }
                    seen[index] = true;
                }
            }
            System.out.println();
        }

        System.out.println();
        return true;

    }

    public boolean isValidSudoko(char[][] sudoko){

        boolean[] rowFreq = new boolean[9];
        boolean[] colFreq = new boolean[9];

        // for checking row and column
        for (int i = 0; i < sudoko.length; i++) {
            for (int j = 0; j < sudoko.length; j++) {
//                System.out.print(sudoko[i][j] + ", ");
                int idxi = sudoko[i][j] - '1';
                int idxj = sudoko[j][i] - '1';
                if(sudoko[i][j] != '.'){
                    if(rowFreq[idxi]){
                        return false;
                    }
                    rowFreq[idxi] = true;
                }
                if(sudoko[j][i] != '.'){
                    if(colFreq[idxj]){
                        return false;
                    }
                    colFreq[idxj] = true;
                }
            }
//            System.out.println(Arrays.toString(rowFreq));
//            System.out.println(Arrays.toString(colFreq));

            Arrays.fill(rowFreq, false);
            Arrays.fill(colFreq, false);
//            System.out.println();
        }

        // for checking the 3 * 3 matrix
        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                if(!isValidSubGrid(sudoko, i, j)){
                    return false;
                }
            }
        }

        return true;
    }

    public int findLengthOfLongestConsecutiveSequenceOfElements(int[] arr){

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int len = 1;
        int maxLength = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]- arr[i-1] == 1) {
                len++;
//                maxLength = Math.max(len, maxLength);
            }else if(arr[i] == arr[i-1]){

            }else{
                len = 1;
            }
            System.out.println(len + " " + maxLength);
            maxLength = Math.max(len, maxLength);
        }
        return maxLength;
    }

    // Two Pointers
    public boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length()-1;



        while(i < j) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(j);
            if(c1 != c2){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public void findTwoSumTwoPointer(int[] arr, int target) {
        // 4, 5, 6
        int i = 0;
        int j = arr.length-1;

        while(i < j) {
            int sum = arr[i]+arr[j];
            if(sum == target){
                System.out.println(i + " "  +j);
                return;
            }else if(sum < target) {
                i++;
            }else {
                j--;
            }
        }

    }

    public void findThreeSum(int[] arr){
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            int left = i+1;
            int right = arr.length-1;
            while(left < right){
                int sum = arr[i] + arr[left] + arr[right];
                if(sum == 0){
                    System.out.println(i + " "  + left + " " + right);
                    left++;
                    right--;
                }else if(sum > 0) {
                    right--;
                }else{
                    left++;
                }
            }
        }
    }

    public void findContainerWithMostWater(int[] heights){

        // Done in leetcode and do it again when you visit this function.

    }

    public static void main(String[] args) {
        ArrayPrograms ap = new ArrayPrograms();
        Integer intObjArr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int intfreqArr[] = {1, 2, 3, 4, 3, 2, 4, 5, 6, 7, 4, 5,9, 8, 10};
        int[] intArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String stringArr[] = {"pavan", "kumar", "aravind", "eswar", "garapati"};
//        ArrayPrograms.printIntArr(intArr);
//        ArrayPrograms.printArr(stringArr);
//        ap.copyArray(intArr);
//        ap.findFrequencyOfEachElement(intfreqArr);
//        ap.findFrequencyOfEachElementPr(intfreqArr);
//        ap.leftRotateElements(intArr, 10);
//        ap.printDuplicates(intfreqArr);
//        ap.sortElementsInAssendingOrDescending(intfreqArr);
//        ap.removeDuplicates(intfreqArr);
//        ap.secondlargest(intArr);
        int array[] =  {1,2,3,4,5,1,3,2,4};
//        ap.replaceALlNumbersByTheirRank(array);
//        int index = ap.findEquilibriumIndex(array);
//        System.out.println(index);
//        ap.leftRotateArray(intArr, 2);
//        ap.leftRotateElementsPr(intArr, 2);
        int[] arr012 = {2,0,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,0};
//        ap.sortThe012Array(arr012);
//        ap.findKthMaxAndMinElement(intArr, 2);
        int[] negArr = {2,-1,45,-3,-6,5,-6,7,-8};
//        ap.moveAllNegativeElementsToOneSide(negArr);
        int[] arr1 = {3, 4, 5, 6, 7};
        int[] arr2 = {2, 4, 6, 7, 8, 9, 0};
//        ap.findUnionAndIntersectionOfTwoArrays(arr1, arr2);
        int[] conArr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        ap.findLargestSumContiguousArray(conArr);
        int[] heightsArr = {1, 5, 15, 10};
//        ap.minimizeTheMaximumDifferenceBetweenHeights(heightsArr);
        int[] twoSumArr = {2, 7, 11, 15};
        int target = 9;
//        System.out.println(Arrays.toString(twoSumArr));
//        ap.findTwoSum(twoSumArr, target);
        String[] strs = {"act","hat"};
//        ap.groupAnargams(strs);
//        ap.findElementsGreaterThanKFrequency(conArr, 2);
        int[] productArr = {-1,0,1,2,3};
//        ap.productOfArrayExceptSelf(productArr);
        char[][] sudoku = {
                {'5','3','.','.','7','.','.','.','8'}, // ← Duplicate '5' in the same row
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','.','.','.','.','3'}, // ← Duplicate '6' in same column (column index 4)
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
//        System.out.println(ap.isValidSudoko(sudoku));
        int[] nums = {0,3,2,5,4,6,1,1};
        System.out.println(ap.findLengthOfLongestConsecutiveSequenceOfElements(nums));
//        System.out.println(ap.isPalindrome("a"));
//        ap.findTwoSum(twoSumArr, target);
//        ap.findTwoSumTwoPointer(twoSumArr, target);
//        int[]  threeSumArr = {-1,0,1,2,-1,-4};
//        ap.findThreeSum(threeSumArr);
//        String str = Arrays.toString(intArr);
//        System.out.println(str);
    }
}
