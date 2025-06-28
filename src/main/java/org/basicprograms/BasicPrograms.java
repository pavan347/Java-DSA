package org.basicprograms;

import java.util.*;

public class BasicPrograms {

    public int factorial(int num) {
        if(num <= 1) {
            return 1;
        }

        return num * factorial(num - 1);
    }

    public String reverseString(String str) {

        int length = str.length();

        if(length == 1) {
            return str;
        }

        return str.charAt(length - 1 ) + reverseString(str.substring(0, length-1));
    }

    public String reverStringPr(String str) {

        if(str.length() <= 1){
            return str;
        }

        return str.charAt(str.length()-1) + reverseString(str.substring(0, str.length()-1));
    }



    public static void main(String[] args) {
        BasicPrograms bp = new BasicPrograms();
        int num = 5 ;
        String str = "pavan";
        char a = 'a';
        char b = 'b';
//        System.out.println(bp.factorial(num));
//        System.out.println(bp.reverseString(str));
//        int asciiValueOfA = a;
//        int asciiValueOfB = b;
//        System.out.println("ASCII Value of A: " + asciiValueOfA);
//        System.out.println("ASCII Value of B: " + asciiValueOfB);


//        Stack<String> stack = new Stack<>();
//        stack.add("p");
//        stack.push("a");
//        System.out.println(stack.size());
//        System.out.println(stack);
//        stack.remove(1);
//        System.out.println(stack);

//        Queue<String> queue = new ArrayDeque<>();
//        queue.add("p");
//        queue.add("a");
//        queue.add("v");
//        queue.add("a");
//        queue.add("n");
//        System.out.println(queue);
//        queue.remove();
//        System.out.println(queue);
//        System.out.println(queue.poll());
//        System.out.println(queue);

        System.out.println(bp.reverStringPr("pavan"));
        int min = 3;
        int max = 7;
        System.out.println(Math.floor(Math.random() * (max-min+1)) + min);
    }
}
