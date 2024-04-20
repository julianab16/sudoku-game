package com.example.sudokugame.model;

import java.util.ArrayList;

public class Sudoku {
    private int sudoku[][];

    public Sudoku(){
        this.sudoku = new int[][]{
            {0, 0, 6, 8, 0, 0, 0, 9, 4},
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

    public boolean verifityFile(int i, int v){
        for (int j = 0; j<9; j++) {
            if (sudoku[i][j] == v) {
                return false;
            }
        }
        return true;
    }
    public boolean verifityColum(int j, int v){
        for (int i = 0; i<9; i++) {
            if (sudoku[i][j] == v) {
                return false;
            }
        }
        return true;
    }
}
