package org.stringprograms;

import java.util.Arrays;

public class StringPrograms {

    public boolean isAnargam(String str1, String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }

//        char[] str1Arr = str1.toCharArray();
//        char[] str2Arr = str2.toCharArray();
//
//        Arrays.sort(str1Arr);
//        Arrays.sort(str2Arr);
//
////        for(int i = 0 ; i < str1.length(); i++) {
////            if (str1Arr[0] != str2Arr[0]) {
////                return false;
////            }
////        }
//        return Arrays.equals(str1Arr, str2Arr);

        int[] freq = new int[256];

        for(int i = 0 ; i < str1.length(); i++) {
            freq[str1.charAt(i)]++;
            freq[str2.charAt(i)]--;
        }

        for(int ele: freq) {
            if(ele != 0) {
                return false;
            }
        }

        return true;
    }

    public void countTotalNoOfChars(String str) {
//        System.out.println(str.length());

        // For calculating no of punctuation marks
        int count = 0;
        for(char c : str.toCharArray()) {
            if((c+"").equals("'")) {
                count++;
            }
        }
        System.out.println("Number of punctuation marks: " + count);
    }

    public void divideStringIntoNParts(String str, int n) {

        if(str.length()%n != 0) {
            System.out.println("The String can't be divided");
            return;
        }

        while(str.length() > n) {
            System.out.println(str.substring(0,n));
            str = str.substring(n);
        }
    }

    public void divideStringIntoNPartsPr(String str, int n) {

        if(str.length()%n != 0) {
            System.out.println("The String can't be divided");
            return;
        }

        System.out.println(str.length()/n);
        int temp = str.length()/n;
        int i = 0;
        while(i < str.length()) {
            System.out.println(str.substring(i, i+temp));
            i += temp;
        }

    }

    public void findSubStringsOfAString(String str) {
        int n = str.length();
        int len = (n *( n+1)/2);
        String[] subsetsArr = new String[len];

        int temp = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                    subsetsArr[temp] = str.substring(i, j+1);
                    System.out.println(str.substring(i, j+1));
                    temp++;
            }
        }

        for(String ele: subsetsArr){
            System.out.print(ele + " ");
        }
    }

    public void findSubSetsOfAStringPr(String str, int idx, String newString) {

        if(idx >= str.length()){
            System.out.println(idx + " " + newString);
            return;
        }

        findSubSetsOfAStringPr(str, idx+1, newString+str.charAt(idx));
        findSubSetsOfAStringPr(str, idx+1, newString);
    }

    public void lowerToUperandViseVerse(String str) {

//        char[] charArr = str.toCharArray();
        StringBuffer modifiedStr = new StringBuffer("");

        for (int i = 0; i < str.length(); i++) {
               if(Character.isLowerCase(str.charAt(i))) {
                   modifiedStr.append(Character.toUpperCase(str.charAt(i)));
               }else {
                   modifiedStr.append(Character.toLowerCase(str.charAt(i)));
               }
        }

        System.out.println(modifiedStr);
    }

    public void isRotation(String str1, String str2) {

        String fullStr = str1 + str1;
        for(int i = 0 ; i < fullStr.length()/2; i++) {
//            System.out.println(fullStr.substring(i, i+str1.length()));
            if(str2.equals(fullStr.substring(i, i+str1.length())) ){
                System.out.println("Yes");
                return;
            }
        }

        System.out.println("No");

    }

    public void isRotationPr(String str1, String str2) {
        if(str1.length() != str2.length()){
            System.out.println(false);
            return;
        }
        String str = str1 + str1;
        System.out.println(str1 + " " + str2 + " " + str);

        if(str.contains(str2)){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }

    public void findMaximumAndMinumumOccuringChar(String str){

        int[] freq = new int[256];

        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }

        char minChar = ' ';
        char maxChar = ' ';
        int min = str.length();
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
//            System.out.println("Char: " + str.charAt(i) + " Count: " + freq[str.charAt(i)]);
            if(max < freq[str.charAt(i)]) {
                max = freq[str.charAt(i)];
                maxChar = str.charAt(i);
            }
            if(min > freq[str.charAt(i)]) {
                min = freq[str.charAt(i)];
                minChar = str.charAt(i);
            }
        }

        System.out.println("Max Char: " + maxChar + " Count: " + max);
        System.out.println("Min Char: " + minChar + " Count: " + min);
    }

    public void findDuplicateWords(String str) {

        String[] wordsArr = str.split(" ");

        boolean[] visited = new boolean[wordsArr.length];
        // pavan kumar pavan good
        int count;
        for (int i = 0; i < wordsArr.length; i++) {
            if(!visited[i]) {
            count = 0;
                for (int j = i + 1 ; j < wordsArr.length; j++) {
                    if (wordsArr[i].equals(wordsArr[j])) {
                        count++;
                        visited[j] = true;
                    }

                }
                    if(count > 1) {
                        System.out.println(wordsArr[i] + " " + count);
                    }
            }
        }

//        System.out.println("No of times for loop runed: " + count);

    }

    public void findMostRepeatedWord(String str) {

        String[] wordsArr = str.split(" ");

        int[] visited = new int[wordsArr.length];
        // pavan kumar pavan good
        int count;
        String mostRepeatedStr = "";
        int maxCount = 0;
        for (int i = 0; i < wordsArr.length; i++) {
                count = 1;
                for (int j = i + 1 ; j < wordsArr.length; j++) {
                    if (wordsArr[i].equals(wordsArr[j])) {
                        count++;
                    }

                }
                visited[i] = count;
                if(count > maxCount) {
                    maxCount = count;
                    mostRepeatedStr = wordsArr[i];
                }

        }

//        for (int i = 0; i < visited.length; i++) {
//            System.out.println("Word: " + wordsArr[i] + " Count: "+ visited[i]);
//        }


        System.out.println("Most repeated word: " + mostRepeatedStr);

    }

    public void swapTwoStringWithoutUsingAnotherVariable(String str1, String str2) {

        System.out.println(str1 + " " + str2);

        str1 = str1 + str2;
        str2 = str1.substring(0,(str1.length() - str2.length()));
        str1 = str1.substring(str2.length());

        System.out.println(str1 + " " + str2);

    }

    public boolean isPallendrome(String str) {
        return new StringBuffer(str).reverse().toString().toLowerCase().equals(str.toLowerCase());
    }

    public void largestAndSmallestpalindromicWord(String str) {

        String[] words = str.split(" ");
        String largestWord = "";
        String smallestWord = "";
        int smallest = str.length();
        int largest = 0;
        for(String ele: words) {
            if(isPallendrome(ele)) {
                System.out.println(ele);
                if(ele.length() > largest) {
                    largest = ele.length();
                    largestWord = ele;
                }
                if(ele.length() < smallest) {
                    smallest = ele.length();
                    smallestWord = ele;
                }
            }
        }

        System.out.println("Largest Word: " + largestWord + ", len: " + largest);
        System.out.println("Smallest Word: "+ smallestWord + ", len: " + smallest);

    }

    public static void main(String[] args) {
        StringPrograms sp = new StringPrograms();
        String str = "Wowyouownkayak";
//        sp.countTotalNoOfChars(str);
        String str1 = "abcde";
        String str2 = "cdeab";
//        if(sp.isAnargam(str1, str2)) {
//            System.out.println(str1 + " and " + str2 + " are anargams");
//        }else {
//            System.out.println(str1 + " and " + str2 + " are not anargams");
//        }
//        sp.divideStringIntoNPartsPr(str, 2);
//        sp.findSubStringsOfAString(str1);
//        sp.findSubSetsOfAStringPr(str1, 0, "");
//        sp.lowerToUperandViseVerse(str);
        sp.isRotationPr(str1, str2);
        sp.isRotationPr("ababa", "babaa");
//        sp.findMaximumAndMinumumOccuringChar(str);
//        sp.findDuplicateWords("big black bug bit a big black dog on his big black nose");
//        sp.findMostRepeatedWord("big black bug bit a big black dog on his big black nose");
//        sp.swapTwoStringWithoutUsingAnotherVariable(str1, str2);
//        sp.largestAndSmallestpalindromicWord(str);
    }
}
