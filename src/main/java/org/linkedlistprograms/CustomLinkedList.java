package org.linkedlistprograms;

import jdk.jfr.consumer.RecordedEvent;

public class CustomLinkedList {

    Node head = null;

    class Node{
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            next = null;
        }
    }

    public void addFirst(String data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(String data) {
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            return;
        }
        Node tempNode = head;
        while(tempNode.next!=null) {
            tempNode= tempNode.next;
        }
        tempNode.next = newNode;
    }

    public String removeFirrst(){
        if(head == null) {
            System.out.println("No elements to remove");
            return "";
        }
        String data = head.data;
        head = head.next;
        return data;
    }

    public String removeLast(){
        if(head == null) {
            System.out.println("No elements to remove");
            return "";
        }

        String data;
        Node tempNode = head;
        if(tempNode.next == null) {
            removeFirrst();
        }
        while(tempNode.next.next!=null){
            tempNode = tempNode.next;
        }
        data = tempNode.next.data;
        tempNode.next = null;
        return data;
    }

    public int size(){
        int size = 0;

        Node tempNode = head;
        while (tempNode!=null) {
            tempNode = tempNode.next;
            size++;
        }

        return size;
    }

    public void print() {
        Node tempNode = head;
        while(tempNode!= null) {
            System.out.print(tempNode.data + " --> ");
            tempNode = tempNode.next;
        }
        System.out.println("NULL");
    }

    public void reverse() {

        if(head == null || head.next ==null) {
            return;
        }
        Node prev = null;
        Node curr = head;

        while(curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        System.out.println();
    }

    public Node recursiveReverse(Node head) {

        if(head == null || head.next == null) {
            return head;
        }

        Node reversed = recursiveReverse(head.next);
        head.next.next = head;
        head.next = null;
        return reversed;
    }

    public void printList(Node head) {
        Node tempNode = head;
        while(tempNode!= null) {
            System.out.print(tempNode.data + " --> ");
            tempNode = tempNode.next;
        }
        System.out.println("NULL");
    }

    public String findNthNodeFromLast(int n) {
        int fromFirst = size() - n + 1;

        int count = 0;
        Node tempNode = head;
        while(tempNode != null) {
            count++;
            if(count == fromFirst){

                return tempNode.data;
            }
            tempNode = tempNode.next;
        }

        return "";
    }

    public void deleteNthNodeFromLast(int n) {
        int fromFirst = size() - n ;

        if(fromFirst == 0) {
            head = head.next;
            return;
        }

        int count = 1;
        Node tempNode = head;
        while(tempNode != null) {
            if(count == fromFirst){
                tempNode.next = tempNode.next.next;
                return;
            }
            count++;
            tempNode = tempNode.next;
        }

    }


    public static void main(String[] args) {

        CustomLinkedList ll = new CustomLinkedList();
        ll.addFirst("1");
        ll.addLast("2");
        ll.addLast("3");
//        System.out.println(ll.size());
        ll.addLast("4");
        ll.addLast("5");
        ll.print();
//        System.out.println(ll.size());
//        System.out.println(ll.removeFirrst());
//        ll.print();
//        System.out.println(ll.removeLast());
//        ll.print();
//        ll.reverse();
//        ll.print();
//        ll.head = ll.recursiveReverse(ll.head);
//        ll.print();
//        System.out.println(ll.findNthNodeFromLast(2));
        ll.deleteNthNodeFromLast(5);
        ll.print();
    }
}
