package org.recursionprograms;

import java.util.ArrayList;
import java.util.List;

public class FindKnightPath {

//    int count = 0;
    int N = 5;

    FindKnightPath(int N){
        this.N = N;
    }

    int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
    int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};
    boolean solutionFound = false;

    public boolean isSafe(int x, int y, boolean[][] visited) {
        return (x >= 0 && x < N) && (y >= 0 && y < N) && !visited[x][y];
    }

    public void findKnightPaths(boolean[][] visited, List<String> path, int x, int y, int moveCount) {

//        System.out.println(count++);

        if(solutionFound){
            return;
        }

        if(moveCount == N*N) {
            System.out.println(path);
            System.out.println(path.size());
            solutionFound = true;
            return;
        }

        for (int i = 0; i < dx.length; i++) {

            if(solutionFound){
                return;
            }

            int nx = x + dx[i];
            int ny = y + dy[i];

            if(isSafe(nx, ny, visited)) {
                visited[nx][ny] = true;
                path.add("("+nx+", "+ny+")");
//                System.out.println(path);
                findKnightPaths(visited, path, nx, ny, moveCount+1);

                visited[nx][ny] = false;
                path.remove(path.size() - 1);
            }
        }
    }



    public static void main(String[] args) {
        int N = 5;
        FindKnightPath obj = new FindKnightPath(N);
        List<String> path = new ArrayList<>();

        boolean[][] visited = new boolean[N][N];

//        path.add("(0, 0)");c
        int startX = 0, startY = 0;
        visited[startX][startY] = true;
        path.add("(" + startX + ", " + startY + ")");
        System.out.println("Attempting path: " + "(" + startX + ", " + startY + ")");
        obj.findKnightPaths(visited, path, startX, startY, 1);
        System.out.println(path);
    }
}
