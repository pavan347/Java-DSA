package org.recursionprograms;

import java.util.*;

public class RecursionPrograms {

    public void printFrom1To5(int num) {

        if(num > 5) {
            return;
        }

        System.out.println(num);

        printFrom1To5(num+1);
    }

    public void printFrom5To1(int num) {

        if(num < 1) {
            return;
        }

        System.out.println(num);

        printFrom5To1(num-1);
    }

    public int sumOfNaturalNumbers(int sum, int n) {
        if(n < 1) {
            return sum;
        }

        return sumOfNaturalNumbers(n+sum, --n);
    }

    public int factorialOfANumber(int num) {
        if(num <= 1) {
            return 1;
        }

        return num * factorialOfANumber(num-1);
    }

    public void printFibonnacciSeries(int n, int f1, int f2) {

        if(n <= 2){
            return;
        }

//        System.out.println(f1);
//        System.out.println(f2);
        int f3 = f1+f2;
        System.out.println(f3);
        f1 = f2;
        f2 = f3;
        printFibonnacciSeries(n-1, f1, f2);
    }

    public void prinXPowerN(int x, int n, int value) {
        if(n == 0) {
            System.out.println(value);
            return;
        }

//        System.out.println(x + " " + n + " " +value);

        prinXPowerN(x, n-1, x*value);
    }

    public int printXPowerN(int x, int n) {

        if( n == 1) {
            return x;
        }

        return x * printXPowerN(x, n-1);
    }

    public int printXPowerNStackHeightLonN(int x, int n) {
        if(n == 0) {
            return 1;
        }
        if(x == 0) {
            return 0;
        }

        if(n % 2 == 0) {
            return printXPowerNStackHeightLonN(x, n/2) * printXPowerNStackHeightLonN(x, n/2);
        }else {
            return printXPowerNStackHeightLonN(x, n/2) * printXPowerNStackHeightLonN(x, n/2) * x;
        }
    }

    public String findReverse(String str) {

        if(str.length() <= 1) {
            return str;
        }

        return str.charAt(str.length()-1) + findReverse(str.substring(0, str.length()-1));
    }

    public void towerOfHannoi(int n, String src, String helper, String dest) {

        if(n == 1) {
            System.out.println("Transfer disk " + n + " from " + src  + " to " + dest);
            return;
        }

        towerOfHannoi(n-1, src, dest, helper);
        System.out.println("Transfer disk " + n + " from " + src  + " to " + dest);
        towerOfHannoi(n-1, helper, src, dest);

    }

    private static int first = -1;
    private static int last = -1;
    public void findFirstAndLastOccurance(String str, int idx, char element) {

//        System.out.println(str.indexOf(element) + " " +str.lastIndexOf(element));
        if(idx == str.length()) {
            System.out.println(first + " " + last);
            return;
        }

        char currentChar = str.charAt(idx);

        if(currentChar == element) {
            if(first == -1) {
                first = idx;
            }else {
                last = idx;
            }
        }

        findFirstAndLastOccurance(str, idx+1, element);

    }

    public boolean checkIfSorted(int[] arr, int idx) {

        if(idx == arr.length-1) {
            return true;
        }

        if(arr[idx] < arr[idx+1]) {
            return checkIfSorted(arr, idx+1);
        }else {
            return false;
        }

    }

    public String moveAllXCharToEnd(String str, int idx, int count) {

        if(idx == str.length()-1 - count) {
            return str;
        }

        //zjxhjxxhsk
        char currentChar = str.charAt(idx);
        if(currentChar == 'x') {
            System.out.println(idx + " " + count +" " + " " + str + "   " + str.substring(0, idx) + "   " + str.substring(idx+1, str.length()));
            return moveAllXCharToEnd(str.substring(0, idx) + str.substring(idx+1) + 'x', idx, count+1);
        }else {
            return moveAllXCharToEnd(str, idx+1, count);
        }

    }

    public String removeDuplicates(String str, int idx, Set<Character> set, String newString) {

        if(idx == str.length()) {
            return newString;
        }

        char currenctChar = str.charAt(idx);
        if(!set.contains(currenctChar)) {
            set.add(currenctChar);
            return removeDuplicates(str, idx+1, set, newString+currenctChar);
        }else {
            return removeDuplicates(str, idx+1, set, newString);
        }
    }

    public void subSequences(String str, int idx, String newString) {

        if (idx == str.length()) {
            System.out.println(newString);
            return;
        }

        char currentChar = str.charAt(idx);
        subSequences(str, idx+1, newString+currentChar);
        subSequences(str, idx+1, newString);
    }

    public void printUniqueCombinations(String str, int idx, String newString, Set<String> set) {
        if (idx == str.length()) {
            if(!set.contains(newString)) {
                set.add(newString);
                System.out.println(newString);
                return;
            }else{
                return;
            }
        }

        char currentChar = str.charAt(idx);

        printUniqueCombinations(str, idx+1, newString+currentChar, set);
        printUniqueCombinations(str, idx+1, newString, set);
    }

    private static String[] keypad = {".", "abc", "def", "ghi", "jkl","mno","pqrs","tu","vwx", "yz"};

    public void printKeypadcombinations(String str, int idx, String combinaiton) {

        if(str.length() == idx) {
            System.out.println(combinaiton);
            return;
        }

        char currenctChar = str.charAt(idx);
        String mapping = keypad[currenctChar - '0'];

        for (int i = 0; i < mapping.length(); i++) {
            printKeypadcombinations(str, idx+1, combinaiton+mapping.charAt(i));
        }

    }

    public boolean primeNumber(int num, int i) {

        if(num <= 1) {
            return false;
        }

        if(num % 2 == 0) {
            return false;
        }

        if(i*i > num ) {
            return true;
        }

        if(i == num) {
            return true;
        }
        if(num % i == 0) {
            return false;
        }

        return primeNumber(num, i+1);
    }

    public int findLargestElementInAnArray(int[] arr, int idx, int largest) {

        if(idx == arr.length) {
            return largest;
        }

        if(arr[idx] > largest) {
            largest = arr[idx];
        }
        return findLargestElementInAnArray(arr, idx+1, largest);
    }

    public int reversingANumber(int num, int rev) {

        if(num == 0) {
            return rev;
        }
//        rev = rev*10 + num%10;
//        num = num/10;
        return reversingANumber(num/10, rev*10+num%10);

    }

    public int findGCDorHCF(int a, int b) {
        if(b == 0){
            return a;
        }

        return findGCDorHCF(b, a%b);
    }

    public int findLCM(int a, int b) {

        int hcf = findGCDorHCF(a, b);
        int lcm =  a * b / (hcf);

        return lcm;

    }

    public void printALlPermutations(String str) {

        System.out.print(str + " ");

    }

    public int findFNthTerm(int n, int counter) {

        if( n == 1) {
            return 1;
        }

        int sum = 1;
        int temp = n;
       while(temp > 0 ) {
           System.out.println(counter);
           sum*= counter;
           counter--;
           temp--;
       }
        System.out.println(counter + " "  + n + " "  + sum);

        return sum + findFNthTerm(n-1, counter);

    }

    public int findFNthTermPr(int n, int counter) {

        int currTerm = 1;

        if(n ==1){
            return currTerm;
        }

        int temp = n;
        while(temp > 0) {
            System.out.println(counter);
            currTerm *= counter;
            temp--;
            counter--;
        }
        System.out.println(currTerm + " " + counter);
        return currTerm + findFNthTermPr(n-1, counter);

    }

    public void findSumOfAllSubsets(ArrayList<Integer> arrList, ArrayList<Integer> sumsList, int index, int sum) {

        if(arrList.size() == index) {
            sumsList.add(sum);
            return;
        }

        findSumOfAllSubsets(arrList, sumsList, index+1, sum+arrList.get(index));

        findSumOfAllSubsets(arrList, sumsList, index+1, sum);

    }

    public void findSubsets(ArrayList<Integer> arrList, Set<ArrayList<Integer>> subLists, int index, ArrayList<Integer> subList) {

        if(arrList.size() == index) {
            ArrayList<Integer> copy = new ArrayList<>(subList);
            Collections.sort(copy);
            subLists.add(copy);
            return;
        }


        findSubsets(arrList, subLists, index+1, new ArrayList<>(subList));
        subList.add(arrList.get(index));
        findSubsets(arrList, subLists, index+1, new ArrayList<>(subList));
    }

    public int findLastNonZeroDigit(int num) {
        int fact = factorialOfANumber(num);

        while( fact%10 == 0) {
            fact /= 10;
        }

        return fact%10;
    }

    ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();

    public void printPascalTriangle(int num) {

        while(num > 0){
            ArrayList<Integer> list = triangle.get(triangle.size()-1);
            ArrayList<Integer> newList = new ArrayList<>();
            newList.add(1);
            for (int i = 0; i < list.size()-1; i++) {
                newList.add(list.get(i) + list.get(i+1));
            }
            newList.add(1);
//            System.out.println(newList);
            triangle.add(newList);
            num--;
        }
    }

    public void printPascalTrianglePr(int num) {
        while(num > 0) {
            ArrayList<Integer> list = triangle.get(triangle.size()-1);
            ArrayList<Integer> newList = new ArrayList<>();
            newList.add(1);
            for (int i = 0; i < list.size()-1; i++) {
                newList.add(list.get(i)+list.get(i+1));
            }
            newList.add(1);
            triangle.add(newList);
            num--;
        }
    }

    public ArrayList<Integer> getRow(int rowindex) {

        ArrayList<Integer> currList = new ArrayList<>();

        currList.add(1);
        if(rowindex == 0) {
            return currList;
        }

        ArrayList<Integer> prev = getRow( rowindex-1);
        System.out.println(prev);
        for (int i = 0; i < prev.size()-1; i++) {
            currList.add(prev.get(i) + prev.get(i+1));
        }
        currList.add(1);

        return currList;
    }

    public boolean isValidParanthesis(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
                continue;
            }
            if(stack.isEmpty()) return false;
            char check = stack.pop();
            switch (ch) {
                case ')':
                    if (check != '(') return false;
                    break;
                case ']':
                    if (check != '[') return false;
                    break;
                case '}':
                    if (check != '{') return false;
                default:
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public void generateValidParenthesis(String str, int len, int n) {

        if(str.length() == len && isValidParanthesis(str)) {
            System.out.println(str);
            return;
        }

        if(n == 0 ) {
            return;
        }

        generateValidParenthesis(str+'(', len, n-1);
        generateValidParenthesis(str+')', len, n-1);

    }

    public boolean isAllPrefixesValid(String str) {
        for (int i =1; i < str.length(); i++) {
//            System.out.println(str.substring(0, i));
            if(!isValidBinary(str.substring(0, i))){
                return false;
            }
        }

        return true;
    }

    public boolean isValidBinary(String str) {
        int onecount = 0;
        int zerocount = 0;
        for(char ch: str.toCharArray()) {
            if(ch == '1'){
                onecount++;
            }else{
                zerocount++;
            }
        }

        return onecount >= zerocount;
    }

    public void printNBitBinaryNumbers(String str, int len, int n) {

        if(str.length() == len && isAllPrefixesValid(str)){
            System.out.println(str);
            return;
        }
        if(n==0) {
            return;
        }
        printNBitBinaryNumbers(str+'1', len, n-1);
        printNBitBinaryNumbers(str+'0', len, n-1);
    }

    public void findAllSubSequencesForArrayList(ArrayList<Integer> list, int idx, ArrayList<Integer> newList) {

        if(list.size() == idx) {
            System.out.println(newList);
            return;
        }

//        ArrayList<Integer> nList = new ArrayList<>();
//        nList.addAll(newList);
//        nList.add(list.get(idx));

        findAllSubSequencesForArrayList(list, idx+1, new ArrayList<>(newList));
        newList.add(list.get(idx));
        findAllSubSequencesForArrayList(list, idx+1, new ArrayList<>(newList));

    }

    public static void main(String[] args) {
        RecursionPrograms rp = new RecursionPrograms();
//        rp.printFrom1To5(1);
//        rp.printFrom5To1(5);
//        int sum = rp.sumOfNaturalNumbers(0, 5);
//        System.out.println(sum);
//        System.out.println(rp.factorialOfANumber(3));
//        rp.printFibonnacciSeries(10, 0, 1);
//        rp.prinXPowerN(2, 4, 1);
//        System.out.println(rp.printXPowerN(2, 4));
//        System.out.println(rp.printXPowerNStackHeightLonN(3, 4));
//        System.out.println(rp.findReverse("gaian"));
//        rp.towerOfHannoi(3, "S", "H", "D");
//        System.out.println("afhjahlahahj".indexOf('a'));
//        System.out.println("afhjahlahahj".lastIndexOf('a'));
//        rp.findFirstAndLastOccurance("ahhdhfhlafsdj", 0, 'a');
//        int[] arr = {1, 4, 3, 4, 5, 6, 7};
//        System.out.println(rp.checkIfSorted(arr, 0));
        String str = "aaabbb";
//        System.out.println(rp.moveAllXCharToEnd(str, 0, 0));
        Set<String> set = new HashSet<>();
//        System.out.println(rp.removeDuplicates(str, 0, set, ""));
//        rp.subSequences(str, 0, "");
//        rp.printUniqueCombinations(str, 0, "", set);
//        rp.printKeypadcombinations("4", 0, "");
//        System.out.println(rp.primeNumber(31, 2));
        int[] arr = {2,3,4,5754,6,7,8};
//        System.out.println(rp.findLargestElementInAnArray(arr, 0, -1));
//        System.out.println(rp.reversingANumber(3456, 0));
//        System.out.println(rp.findGCDorHCF(3, 5));
//        System.out.println(rp.findLCM(3, 5));
        int n = 3;
//        System.out.println(n*(n+1)/2);
//        System.out.println(rp.findFNthTerm(n, n*(n+1)/2));
//        System.out.println(rp.findFNthTermPr(n, n*(n+1)/2));
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(1);
        arrList.add(2);
        arrList.add(1);
//        arrList.add(1);
        ArrayList<Integer> sumsList = new ArrayList<>();
//        rp.findSumOfAllSubsets(arrList, sumsList, 0, 0);
//        System.out.println(sumsList);
//        System.out.println(rp.findLastNonZeroDigit(9));
        ArrayList<Integer> newList = new ArrayList<>();
        newList.add(1);
//        System.out.println(newList);
//        rp.triangle.add(newList);
//        rp.printPascalTrianglePr(4);
//        System.out.println(rp.triangle);
//        System.out.println(rp.triangle.get(rp.triangle.size()-1));
//        System.out.println(rp.getRow(5));
//        rp.generateValidParenthesis("", n*2, n*2);
//        rp.printNBitBinaryNumbers("", 4, 4);
//        rp.findAllSubSequencesForArrayList(arrList, 0, newList);
        Set<ArrayList<Integer>> subLists = new HashSet<>();
//        rp.findSubsets(arrList, subLists, 0, new ArrayList<>());
//        List<ArrayList<Integer>> sortableList = new ArrayList<>(subLists);
//
//        // Step 2: Sort the ArrayList using a Comparator based on sublist size
//        sortableList.sort(Comparator.comparingInt(ArrayList::size));
//        System.out.println(subLists);
//        System.out.println(sortableList);
    }
}
