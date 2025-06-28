package org.queueprograms;

import java.util.Stack;

public class CustomQueueUsingArray {

    static class Queue {
        static int[] arr;
        static int size;

        static int front = -1;
        static int rear = -1;

        Queue(int size) {
            this.size = size;
            arr = new int[size];
        }

        public static boolean isEmpty() {
            return rear == -1;
        }

        public static void add(int data) {
            if(rear == size-1) {
                System.out.println("queue is full");
                return;
            }
            if(front == -1) {
                front++;
            }
            rear++;
            arr[rear] = data;
        }

        public static int remove() {
            if(isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }
            int data = arr[front];

            for (int i = 0; i < arr.length-1; i++) {
                arr[i] = arr[i+1];
            }
            rear--;
            return data;
        }

        public static int peek() {
            if(isEmpty()) {
                System.out.println("Empty qeueue");
                return -1;
            }
            return arr[front];
        }

        public static void printQueue(){
            System.out.print("[");
            for (int i = front ; i <= rear; i++) {
                if (i == rear) {
                    System.out.print(arr[i]);
                }else {
                    System.out.print(arr[i]+", ");
                }
            }
            System.out.println("]");
        }

    }

    static class CircularQueue {
        static int[] arr;
        static int size;

        static int front = -1;
        static int rear = -1;

        CircularQueue(int size) {
            this.size = size;
            arr = new int[size];
        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static boolean isFull() {
            return (rear+1) % size == front;
        }

        public static void add(int data) {
            if(isFull()) {
                System.out.println("Queue is Full");
                return;
            }
            if(front == -1) {
                front++;
            }
            rear = (rear+1) % size ;
            arr[rear] = data;
        }

        public static int remove() {
           if(isEmpty()) {
               System.out.println("Queue is Empty");
               return -1;
           }
           int data = arr[front];

           // Special case for single element
           if(rear == front) {
               rear = front = -1;
           }else {
               front = (front+1)% size;
           }

           return data;
        }


        public static int peek() {
            if(isEmpty()) {
                System.out.println("Empty qeueue");
                return -1;
            }
            return arr[front];
        }

        public static void printQueue(){
            System.out.print("[");
            for (int i = 0 ; i < size; i++) {
                if (i == size-1) {
                    System.out.print(arr[i]);
                }else {
                    System.out.print(arr[i]+", ");
                }
            }
            System.out.println("]");
        }

    }

    static class QueueUsing2Stacks {

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        public void add(int data) {

            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            s1.push(data);

            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }

        }

        public int remove(){
            if(s1.isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            return s1.pop();
        }

        public int peek() {
            if(s1.isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            return s1.peek();
        }

        public void printQueue(){
            System.out.println(s1);
        }

    }

    public static void main(String[] args) {
        QueueUsing2Stacks q = new QueueUsing2Stacks();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);


        q.printQueue();
        System.out.println(q.remove());
        q.printQueue();
        System.out.println(q.remove());
        q.printQueue();
        System.out.println(q.peek());
        q.printQueue();
//        q.add(4);
//        q.printQueue();
//        q.add(5);
//        q.printQueue();
//        q.remove();
//        q.printQueue();
//        q.add(6);
//        q.printQueue();

    }
}
