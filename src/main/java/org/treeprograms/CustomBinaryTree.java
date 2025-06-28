package org.treeprograms;

import java.util.LinkedList;
import java.util.Queue;

public class CustomBinaryTree {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        int idx = -1;
        public Node buildBinaryTree(int[] nodes){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildBinaryTree(nodes);
            newNode.right = buildBinaryTree(nodes);

            return newNode;
        }

        public void preOrderTraversal(Node root) {
            if(root == null) {
                System.out.print(-1 + " ");
                return;
            }
            System.out.print(root.data + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }

        public void postOrderTraversal(Node root) {
            if(root == null) {
                System.out.print(-1 + " ");
                return;
            }
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data + " ");
        }

        public void inOrderTraversal(Node root) {
            if(root == null) {
                System.out.print(-1 + " ");
                return;
            }
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }

        public void levelOrderTraversal(Node root) {
            Queue<Node>  q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()) {
                Node currNode = q.remove();
//                System.out.println(currNode.data);
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else {
                    System.out.print(currNode.data + " ");
                    if(currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
        }

        public int countNodes(Node root) {

            if(root == null){
                return 0;
            }

            int leftCount = countNodes(root.left);
            int rightCount = countNodes(root.right);
            int totalCount = leftCount + rightCount + 1;

            return totalCount;
        }

        public int sumOfNodes(Node root){
            if( root == null) {
                return 0;
            }
            int leftSum = sumOfNodes(root.left);
            int rightSum = sumOfNodes(root.right);

            return leftSum + rightSum + root.data;
        }

        public int heightOfTree(Node root){
            if( root == null) {
                return 0;
            }
            int leftHeight = heightOfTree(root.left);
            int rightHeight = heightOfTree(root.right);

            return Math.max(leftHeight, rightHeight) + 1;
        }

        public int diameter(Node root){
            if(root == null) {
                return  0;
            }

            int leftd = diameter(root.left);
            int rightd = diameter(root.right);
            int dia3 = heightOfTree(root.left) + heightOfTree(root.right) + 1;
            System.out.println("Diameters at root: " + root.data + " are " + leftd + " " + rightd + " " + dia3);

            return Math.max(leftd, Math.max(rightd, dia3));
        }

        static class TreeInfo{
            int ht;
            int dia;
            TreeInfo(int ht, int dia){
                this.ht = ht;
                this.dia = dia;
            }
        }

        public TreeInfo diameterWithOnTimeComplexity(Node root) {

            if(root == null) {
                return new TreeInfo(0, 0);
            }

            TreeInfo left = diameterWithOnTimeComplexity(root.left);
            TreeInfo right = diameterWithOnTimeComplexity(root.right);

            int height = Math.max(left.ht, right.ht) + 1;
            int d1 = left.dia;
            int d2 = right.dia;
            int d3 = left.ht + right.ht + 1;
            int diameter = Math.max(d1, Math.max(d2, d3));

            TreeInfo myInfo = new TreeInfo(height, diameter);

            return myInfo;
        }

    }

    public static void main(String[] args) {

        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree bt = new BinaryTree();
        Node root = bt.buildBinaryTree(nodes);
//        System.out.println(root.data);
//        bt.preOrderTraversal(root);
//        System.out.println();
//        bt.postOrderTraversal(root);
//        System.out.println();
//        bt.inOrderTraversal(root);
//        bt.levelOrderTraversal(root);
//        System.out.println(bt.countNodes(root));
//        System.out.println(bt.sumOfNodes(root));
//        System.out.println(bt.heightOfTree(root));
//        System.out.println(bt.diameter(root));
        BinaryTree.TreeInfo ti = bt.diameterWithOnTimeComplexity(root);
        System.out.println(ti.ht + " " + ti.dia);
    }
}
