package org.stackprograms;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class StackPrograms {

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

    public void pushElementAtTheBottom(Stack<Integer> st, int data) {

        if(st.isEmpty()){
            st.push(data);
            return;
        }
        int oldData = st.pop();
        pushElementAtTheBottom(st, data);
        st.push(oldData);
    }

    public void reverseStack(Stack<Integer> stack) {

        if(stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        reverseStack(stack);
        pushElementAtTheBottom(stack, top);
//        stack.push(top);
    }

    public int evaluateReversePolishNotation(String[] arr) {
        Stack<String> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            String currStr = arr[i];
            if(currStr.equals("+")) {
                int value1 = Integer.parseInt(st.pop());
                int value2 = Integer.parseInt(st.pop());
                int result = value2 + value1;
                st.push(result+"");
            }else if(currStr.equals("-")) {
                int value1 = Integer.parseInt(st.pop());
                int value2 = Integer.parseInt(st.pop());
                int result = value2 - value1;
                st.push(result+"");
            }else if(currStr.equals("*")) {
                int value1 = Integer.parseInt(st.pop());
                int value2 = Integer.parseInt(st.pop());
                int result = value2 * value1;
                st.push(result+"");
            }else if(currStr.equals("/")) {
                int value1 = Integer.parseInt(st.pop());
                int value2 = Integer.parseInt(st.pop());
                int result = value2 / value1;
                st.push(result+"");
            }else {
                st.push(currStr);
            }
        }

        return Integer.parseInt(st.pop());
    }

    ArrayList<String> validPren = new ArrayList<>();
    public void generateParenthesis(int n, int len, String str) {

        if(str.length() == len && isValidParanthesis(str)) {
            validPren.add(str);
            return;
        }

        if(n == 0) {
            return;
        }
        generateParenthesis(n-1, len, str+"(");
        generateParenthesis(n-1, len, str+")");

    }

    public void dailyTemperatures(int[] arr) {

        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] > arr[i]) {
                    result[i] = j-i ;
                    break;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(result[i] + " ");
        }

    }

    public void carFleet(int target, int[] position, int[] speed) {

        for (int i = 0; i < position.length; i++) {
            
            while(position[i] <= target) {
                position[i] *= speed[i];
            }
        }
        
    }

    public int largestRectangleArea(int[] heights) {
        int area = 0;
        for(int i = 0; i < heights.length; i++) {

            int minHeight = heights[i];
            for(int j = i; j < heights.length; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                area = Math.max(area, minHeight * (j-i+1));
                // System.out.print(minHeight+ " "  + area + " --- ");
                // System.out.print(heights[j] + " ");
            }
            // System.out.println();
        }

        return area;
    }

    public static void main(String[] args) {
        StackPrograms sp = new StackPrograms();
//        String str = "()(())";
//        System.out.println(sp.isValidParanthesis(str));

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
//        stack.push(5);
//        System.out.println(stack);
//        sp.pushElementAtTheBottom(stack, 5);
//        System.out.println(stack);
//        stack.push(6);
//        System.out.println(stack);
//        System.out.println(stack);
//        sp.reverseStack(stack);
//        System.out.println(stack);
//        String[] exprArr = {"1","2","+","3","*","4","-"};
//        System.out.println(sp.evaluateReversePolishNotation(exprArr));
        int n = 3;
//        sp.generateParenthesis(n*2, n*2, "");
//        System.out.println(sp.validPren);
        int[] temp = { 30,38,30,36,35,40,28 };
//        sp.dailyTemperatures(temp);
        int[] heights = {1, 3, 7};
        System.out.println(sp.largestRectangleArea(heights));

//        String str = "pavan";
//        String str1 = "garapatipavan";
//        System.out.println(str1.indexOf(str));

        String s = "(a+b)=c";
//        String result = s.replaceAll("[(){}]","");
//        System.out.println("Expression without brackets : "+result);
    }
}
