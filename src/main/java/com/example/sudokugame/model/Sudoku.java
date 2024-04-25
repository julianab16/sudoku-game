package com.example.sudokugame.model;


public class Sudoku {
    private int sudoku[][];

    private int sudokuSolved[][];


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

    public void setSudokuSolved(int[][] sudokuSolved) {
        this.sudokuSolved = sudokuSolved;
    }

    public boolean comprobarSudoku() {
        for (int i = 0; i <9; i++) {
            for (int j = 0; j <9; j++) {
                int aux = sudoku[i][j];
                sudoku[i][j] = 0;
                if (!verifityFile(i, aux) || !verifityColum(j, aux) || !validarCuadrante(i, j, aux)) {
                    sudoku[i][j]=aux;
                    return false;
                }
                sudoku[i][j]=aux;
            }
        }
        return true;
    }
    public boolean solveSudoku(){
        for (int i=0; i< 9; i++){
            for (int j=0; j< 9; j++){
                if(sudoku[i][j]==0){
                    for (int k=0; k<=9; k++){
                        if(verifityFile(i,k)&&verifityColum(j,k)&&validarCuadrante(i,j,k)){
                            sudoku[i][j]=k;
                            if(solveSudoku()) return true;
                            sudoku[i][j]=0;
                        }
                    }return false;
                }
            }
        }return true;
    }

    public boolean validarCuadrante(int i, int j, int k){
        int posI = subCuadranteActual(i);
        int posJ = subCuadranteActual(j);

        for (int l=posI-3; l<posI;l++){
            for(int m = posJ-3; m < posJ; m++){
                if (sudoku[l][m]==k){
                    return false;
                }
            }
        }
        return true;
    }
    public int subCuadranteActual(int pos){
        if(pos<=2) return 3;
        else if(pos<=5)return 6;
        else return 9;
    }

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

}

