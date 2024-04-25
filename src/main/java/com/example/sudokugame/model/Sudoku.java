package com.example.sudokugame.model;

/** Authors:
 Juliana Melissa Bolaños Araujo-2372224
 Ivan David Ausecha Salamanca-2328223
 Laura Stefania Salazar Blanco-2327896
 Emails:
 juliana.araujo@correounivalle.edu.co
 ivan.ausecha@correounivalle.edu.co
 laura.blanco@coreounivalle.edu.co
 */
public class Sudoku {
    private int sudoku[][]; /** Array to store the Sudoku puzzle */



    public Sudoku() {
        /** Initialize the Sudoku puzzle with pre-defined values */
        this.sudoku = new int[][]{
                {1, 0, 6, 8, 0, 0, 0, 9, 4},
                {0, 2, 0, 0, 6, 0, 7, 0, 0},
                {7, 0, 0, 4, 0, 2, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0},
                {6, 4, 0, 0, 2, 8, 3, 5, 0},
                {0, 9, 0, 5, 0, 1, 0, 0, 2},
                {4, 0, 2, 6, 0, 3, 0, 0, 5},
                {0, 0, 0, 0, 1, 0, 0, 0, 3},
                {8, 0, 9, 0, 0, 0, 1, 2, 0}
        };
    }


    public int[][] getSudoku() {
        return sudoku; /** Get the Sudoku puzzle */
    }

    public void setSudoku(int[][] sudoku) {
        this.sudoku = sudoku; /** Set the Sudoku puzzle */
    }

    public boolean sudokuSolved(){
        /** Recursive method to solve the Sudoku puzzle */
        for (int i=0; i< 9; i++){
            for (int j=0; j< 9; j++){
                if(sudoku[i][j]==0){
                    for (int k=0; k<=9; k++){
                        if(verityRow(i,k)&&verityColum(j,k)&&verifyQuadrant(i,j,k)){
                            sudoku[i][j]=k;
                            if(sudokuSolved()) return true;
                            sudoku[i][j]=0;
                        }
                    }return false; /** No valid number found for this cell */
                }
            }
        }return true; /** No valid number found for this cell */
    }

    public boolean verifyQuadrant(int i, int j, int k){
        /** Check if number k is valid in the 3x3 quadrant containing cell (i, j) */
        int posI = SubQuadrantCurrent(i);
        int posJ = SubQuadrantCurrent(j);

        for (int l=posI-3; l<posI;l++){
            for(int m = posJ-3; m < posJ; m++){
                if (sudoku[l][m]==k){
                    return false; /** Number k already exists in the quadrant */
                }
            }
        }
        return true; /** Number k is valid in the quadrant */
    }
    public int SubQuadrantCurrent(int pos){
        /** Determine the starting position of the 3x3 quadrant based on row or column index */
        if(pos<=2) return 3;
        else if(pos<=5)return 6;
        else return 9;
    }

    public boolean verityRow(int i, int v) {
        /** Check if number v is valid in the row i */
        for (int j = 0; j < 9; j++) {
            if (sudoku[i][j] == v) {
                return false; /** Number v already exists in the row */
            }
        }
        return true; /** Number v is valid in the row */
    }

    public boolean verityColum(int j, int v) {
        /** Check if number v is valid in the column j */
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][j] == v) {
                return false; /** Number v already exists in the column */
            }
        }
        return true; /** Number v is valid in the column */
    }

}

