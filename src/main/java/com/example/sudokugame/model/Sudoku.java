package com.example.sudokugame.model;


public class Sudoku {
    private int sudoku[][];

    private int sudokuSolved[][];


    public Sudoku() {
        this.sudoku = new int[][]{
                {8, 0, 6, 8, 0, 0, 0, 9, 4},
                {0, 2, 0, 0, 6, 0, 7, 0, 0},
                {7, 0, 0, 4, 0, 2, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0},
                {6, 4, 0, 0, 2, 8, 3, 5, 0},
                {0, 9, 0, 5, 0, 1, 0, 0, 2},
                {4, 0, 2, 6, 0, 3, 0, 0, 5},
                {0, 0, 0, 0, 1, 0, 0, 0, 3},
                {8, 0, 9, 0, 0, 0, 1, 2, 0}
        };

        this.sudokuSolved = new int[][]{
                {1, 5, 6, 8, 3, 7, 2, 9, 4},
                {9, 2, 4, 1, 6, 5, 7, 3, 8},
                {7, 8, 3, 4, 9, 2, 5, 6, 1},
                {2, 7, 5, 3, 4, 6, 8, 1, 9},
                {6, 4, 1, 9, 2, 8, 3, 5, 7},
                {3, 9, 8, 5, 7, 1, 6, 4, 2},
                {4, 1, 2, 6, 8, 3, 9, 7, 5},
                {5, 6, 7, 0, 1, 9, 4, 8, 3},
                {8, 3, 9, 7, 5, 4, 1, 2, 6}
        };
    }


    public int[][] getSudoku() {
        return sudoku;
    }

    public int[][] getSudokuSolved() {
        return sudokuSolved;
    }

    public void setSudoku(int[][] sudoku) {
        this.sudoku = sudoku;
    }

/*
    public boolean verifityFile(int i, int v) {
        for (int j = 0; j < 9; j++) {
            if (sudoku[i][j] == v) {
                return false;
            }
        }
        return true;
    }

    public boolean verifityColum(int j, int v) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][j] == v) {
                return false;
            }
        }
        return true;
    }

    public boolean SudokuSolved() {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                if (sudoku[i][j] == 0) {
                    for (int valor = 1; valor <= 9; valor++) {
                        if (verifityFile(i, valor) && verifityColum(j, valor)) {
                            sudoku[i][j] = valor;
                            if (SudokuSolved()) {
                                return true;
                            }
                            sudoku[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

 */

}

