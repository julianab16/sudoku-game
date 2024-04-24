package com.example.sudokugame.controller;

import com.example.sudokugame.model.Sudoku;
import com.example.sudokugame.view.alert.AlertBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;


public class GameController {
    @FXML
    private GridPane GridPane;
    Sudoku sudoku = new Sudoku();

    public void  initialize() {
        GridPane.setHgap(0);
        GridPane.setVgap(0);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                TextField textfield = new TextField();
                textFieldSize(textfield);
                textfield.setStyle("-fx-backgroud-color: pink");
                textfield.setText(String.valueOf(sudoku.getSudoku()[i][j]));
                verifityEmptyNumber(textfield, sudoku.getSudoku()[i][j]);
                GridPane.add(textfield,j,i);
                onKeyTextField(textfield, i, j);
            }
        }

    }

    private void onKeyTextField(TextField textfield, int i, int j) {
        textfield.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                    try {
                        Integer in = Integer.parseInt(event.getText().toLowerCase());

                    } catch (NumberFormatException excep) {
                        String title = "Alerta";
                        String header = "Error";
                        String content = "Solo se puedes ingresar numeros";
                        new AlertBox().showMessage(title, header, content);
                    }
            }
        });
    }

    @FXML
    void onHandleButtonConfirm(ActionEvent event) {
        for (int i = 0; i < GridPane.getChildren().size(); i++) {
            if (GridPane.getChildren().get(i) instanceof TextField) {
                TextField textField = (TextField) GridPane.getChildren().get(i);
                if (textField.getText().length() > 1) {
                    textField.clear();
                    String title = "Alerta";
                    String header = "Error";
                    String content = "Solo se puede ingresa UN numero";
                    new AlertBox().showMessage(title, header, content);
                }
            }
        }
    }

    private void verifityEmptyNumber(TextField textfield, int n){
        if (n !=0 ){
            textfield.setEditable(false);
        }
        else {textfield.clear();}
    }

    public TextField textFieldSize(TextField txt){
        txt.setMaxWidth(50);
        txt.setMaxHeight(45);
        txt.setFont(new Font("System",20));
        return txt;
    }
}
