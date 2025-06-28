package org.stackprograms;

import java.util.ArrayList;

public class CustomStack {

    private ArrayList<Integer> stack = new ArrayList<>();
    private int top = -1;

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public void push(int num) {
        stack.add(num);
        top++;
    }

    public int pop(){
        if(isEmpty()) {
            return -1;
        }
        int value = stack.remove(top);
        top--;
        return value;
    }

    public int peek(){
        return stack.get(top);
    }

    public void print(){
        System.out.println(stack);
    }

    public static void main(String[] args) {

        CustomStack stack = new CustomStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.print();
        System.out.println(stack.peek());
        stack.print();
        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.pop());
        stack.print();
    }
}
