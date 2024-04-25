package com.example.sudokugame.model;


public class Sudoku {
    private int sudoku[][];


    public Sudoku() {
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
        return sudoku;
    }

    public void setSudoku(int[][] sudoku) {
        this.sudoku = sudoku;
    }

    public boolean sudokuSolved(){
        for (int i=0; i< 9; i++){
            for (int j=0; j< 9; j++){
                if(sudoku[i][j]==0){
                    for (int k=0; k<=9; k++){
                        if(verityRow(i,k)&&verityColum(j,k)&&verifyQuadrant(i,j,k)){
                            sudoku[i][j]=k;
                            if(sudokuSolved()) return true;
                            sudoku[i][j]=0;
                        }
                    }return false;
                }
            }
        }return true;
    }

    public boolean verifyQuadrant(int i, int j, int k){
        int posI = SubQuadrantCurrent(i);
        int posJ = SubQuadrantCurrent(j);

        for (int l=posI-3; l<posI;l++){
            for(int m = posJ-3; m < posJ; m++){
                if (sudoku[l][m]==k){
                    return false;
                }
            }
        }
        return true;
    }
    public int SubQuadrantCurrent(int pos){
        if(pos<=2) return 3;
        else if(pos<=5)return 6;
        else return 9;
    }

    public boolean verityRow(int i, int v) {
        for (int j = 0; j < 9; j++) {
            if (sudoku[i][j] == v) {
                return false;
            }
        }
        return true;
    }

    public boolean verityColum(int j, int v) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][j] == v) {
                return false;
            }
        }
        return true;
    }

}

