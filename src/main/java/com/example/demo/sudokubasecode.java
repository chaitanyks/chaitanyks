package com.example.demo;

public class sudokubasecode {

    public static void printf(int [][] grid){
        int i=0,j=0;
        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                System.out.print(grid[i][j]);
                System.out.print(" ");
            }
        }
    }

    public boolean isCheck(int [][] grid, int i,int j){
        int val = grid[i][j];
        //row
        for (int ii = 0; ii < 9; ii++) {
            if (grid[ii][j] == val && ii != i) {
                return false;
            }
        }
        //column
        for (int ii = 0; ii < 9; ii++) {
            if (grid[i][ii] == val && ii != j) {
                return false;
            }
        }

        int indexi, indexj;

        if (i >= 0 && i < 3) {
            indexi = 0;
        } else if (i >= 3 && i < 6) {
            indexi = 3;
        } else {
            indexi = 6;
        }
        //col
        if (j >= 0 && j < 3) {
            indexj = 0;
        } else if (j >= 3 && j < 6) {
            indexj = 3;
        } else {
            indexj = 6;
        }

        for (int x = indexi; x < indexi + 3; x++) {
            for (int y = indexj; y < indexj + 3; y++) {
                if (grid[x][y] == val && x != i && y != j) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean solve(int [][] grid,int i,int j){
        if (i == 8 && j == 8) {
            boolean ans = true;
            for (int ti = 0; ti < 9; ti++) {
                for (int tj = 0; tj < 9; tj++) {
                    ans = ans & isCheck(grid, ti, tj);
                }
            }
            return ans;
        }

        for (int ti = 0; ti < 9; ti++) {
            for (int tj = 0; tj < 9; tj++) {
                if (grid[ti][tj] == 0) {
                    for (int v = 1; v <= 9; v++) {
                        grid[ti][tj] = v;
                        if (isCheck(grid,ti,tj)&&solve(grid, ti, tj)) {
                            return true;
                        }
                        grid[ti][tj] = 0;
                    }
                    return false;
                }
            }
        }

        return false;
    }

    public int[][] run(int [][] gridinput){


            int [][] grid = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}};

            int[][] grid1 = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}};

            if (solve(gridinput, 0, 0)) {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        System.out.print(gridinput[i][j]);
                        System.out.print(" ");
                    }
                    System.out.println();
                }
            } else {
                System.out.print("Not Possible");
            }
            return gridinput;
        }

    }
