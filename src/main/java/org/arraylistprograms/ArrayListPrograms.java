package org.arraylistprograms;

import java.util.*;

public class ArrayListPrograms {

    public void removeDuplicates(ArrayList<Integer> arr) {

        ArrayList<Integer> modifieArr = new ArrayList<>();

        for(Integer ele : arr) {
            if(!modifieArr.contains(ele)) {
                modifieArr.add(ele);
            }
        }

        System.out.println(modifieArr);

    }

    public void reverseArrayList(ArrayList<Integer> arr) {

        System.out.println(arr);

        int i = 0;
        int j = arr.size()-1;
        while (i < j) {
            int temp = arr.get(i);
            arr.set(i,arr.get(j));
            arr.set(j, temp);
            i++;
            j--;
        }

        System.out.println(arr);
    }

    public void countFrequencies(ArrayList<Integer> arr) {
        HashMap<String, Integer>  map = new HashMap<>();
        for (Integer ele: arr) {
//            if(map.containsKey(ele+"")) {
//                map.put(ele+"", map.get(ele+"") + 1);
//            }else {
//                map.put(ele+"" ,1);
//            }
            map.putIfAbsent(ele+"", 0);
            map.put(ele+"", map.get(ele+"") +1);
        }

        System.out.println(map);
    }

    public void findAllPairsWithGivenSum(ArrayList<Integer> arr, int target) {

//        for (int i = 0; i < arr.size(); i++) {
//            for (int j = i+1; j < arr.size(); j++) {
//                if(arr.get(i)+ arr.get(j) == sum){
//                    System.out.println("( " + arr.get(i) + ", " + arr.get(j) + " )");
//                }
//            }
//        }

//        This will print only the unique pairs with efficient time & space complexity
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;
            if (seen.contains(complement)) {
                System.out.println("(" + complement + ", " + num + ")");
            }
            seen.add(num);
        }


//        It gives all the elements like (2, 8) and (8, 2) and (5, 5)
//        for (int num : arr) {
//            int complement = target - num;
//            if (arr.contains(complement)) {
//                System.out.println("(" + complement + ", " + num + ")");
//            }
//        }

    }

    public void moveAllZeroesToEnd(ArrayList<Integer> list){

        System.out.println(list);
        int i = 0;
        int j = list.size()-1;

        while(i < j) {
            if(list.get(i) == 0) {
                if(list.get(j) != 0) {
                    int temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                    j--;
                    continue;
                }else {
                    j--;
                    continue;
                }
            }else {
                i++;
            }
        }

        System.out.println(list);

    }

    public static void main(String[] args) {
        ArrayListPrograms alp = new ArrayListPrograms();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(3);
        arr.add(3);
        arr.add(0);
        arr.add(7);
        arr.add(0);
        arr.add(0);
        arr.add(0);
//        alp.removeDuplicates(arr);
//        alp.reverseArrayList(arr);
        alp.countFrequencies(arr);
//        alp.findAllPairsWithGivenSum(arr, 10);
//        alp.moveAllZeroesToEnd(arr);
    }
}
