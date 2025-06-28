package org.recursionprograms;

public class BackTracking {

    public void findKnightPath(int[][] board) {
        findKnightPathHelper(board, 0, 0);
    }

    public boolean isSafe(int[][] board, int x, int y) {
        int rowLength = board.length;
        int colLength = board[0].length;

//       (x+2, y+1); (x+2, y-1); (x-2, y-1); (x-2, y+1);
//        (x-1, y+2); (x-1, y-2); (x+1, y+2); (x+1, y-2);
        if(x+2 >7 || x-2 < 0 || y+2 > 7 || y-2 < 0|| x+1>7 || x-1<0 || y+1 > 7 || y-1 < 0 ) {
            return false;
        }
        if(board[x][y] == -1) {
            return false;
        }
        return  true;
    }

    public void findKnightPathHelper(int[][] board, int x, int y) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(isSafe(board, i, j)){
                    findKnightPathHelper(board, i, j);
                }
            }
        }

    }


    public void findPermutations(String str, String prem) {
        if(str.isEmpty()) {
            System.out.println(prem);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            String newStr = str.substring(0,i) + str.substring(i+1);
//            System.out.println(currChar + " " + newStr);
            findPermutations(newStr, prem+currChar);
        }
    }

    public void findPermutationsPr(String str, String prem) {
        if(str.isEmpty()){
            System.out.println(prem);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            String newString = str.substring(0, i) + str.substring(i+1);
            findPermutations(newString, prem+currChar);
        }
    }

    public static void main(String[] args) {

        BackTracking bt = new BackTracking();
//        int[][] chess = new int[8][8];
//        bt.findKnightPath(chess);
        bt.findPermutationsPr("abc", "");

    }
}
