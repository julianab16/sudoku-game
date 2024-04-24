package com.example.sudokugame.controller;

import com.example.sudokugame.model.Sudoku;
import com.example.sudokugame.view.alert.AlertBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;


public class GameController {
    @FXML
    private GridPane GridPane;
    Sudoku sudoku = new Sudoku();

    public void  initialize() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                TextField textfield = new TextField();
                textFieldSize(textfield);
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
                        Integer in = Integer.parseInt(event.getText());
                        if (String.valueOf(event.getText().charAt(0)).equals(" ")){
                            event.consume();
                        }

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
        int n = 0;
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
                if (textField.getText().isEmpty()) {
                    n++;
                }
            }
        }
        if (n>0) {
            n++;
            String title = "Alerta";
            String header = "Error";
            String content = "Sudoku incompleto";
            new AlertBox().showMessage(title, header, content);
        }
    }

    private void verifityEmptyNumber(TextField textfield, int n){
        if (n !=0 ){
            textfield.setEditable(false);
        }
        else {textfield.clear();}
    }

    @FXML
    void onHandleButtonSolved(ActionEvent event) {
        /*
        for (int i = 0; i < GridPane.getChildren().size(); i++) {
            if (GridPane.getChildren().get(i) instanceof TextField) {
                TextField textField = (TextField) GridPane.getChildren().get(i);
                textField.setText(String.valueOf(sudoku.getSudokuSolved()));
            }
        }
         */
    }

    public TextField textFieldSize(TextField txt){
        txt.setMaxWidth(50);
        txt.setMaxHeight(45);
        txt.setFont(new Font("Verdana",20));
        txt.setAlignment(Pos.CENTER);
        txt.setStyle("-fx-backgroud-color: pink");
        return txt;
    }
}
