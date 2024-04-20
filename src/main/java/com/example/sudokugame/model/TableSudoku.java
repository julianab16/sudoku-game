package com.example.sudokugame.model;

import javafx.scene.control.TextField;

public class TableSudoku {
    private TextField[][] listaTextfileds;

    public TableSudoku() {
        this.listaTextfileds = new TextField[9][9];
    }

    public TextField[][] getListaTextfileds() {
        return listaTextfileds;
    }
    public void setListaTextfileds(TextField[][] listaTextfileds) {
        this.listaTextfileds = listaTextfileds;
    }

}
