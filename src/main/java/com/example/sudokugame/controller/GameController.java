package com.example.sudokugame.controller;

import com.example.sudokugame.model.Sudoku;
import com.example.sudokugame.view.GameStage;
import com.example.sudokugame.view.WelcomeStage;
import com.example.sudokugame.view.alert.AlertBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;

/** Authors:
 Juliana Melissa Bolaños Araujo-2372224
 Ivan David Ausecha Salamanca-2328223
 Laura Stefania Salazar Blanco-2327896
 Emails:
 juliana.araujo@correounivalle.edu.co
 ivan.ausecha@correounivalle.edu.co
 laura.blanco@coreounivalle.edu.co
 */

public class GameController {
    @FXML
    private GridPane GridPane; /** The layout container for the Sudoku grid */
    Sudoku sudoku = new Sudoku(); /** Create a Sudoku object */
    private int [][] sudokuPlayer = new int[9][9]; /** Array to store player's input*/

    public void  initialize() {
        /** Create TextFields for each cell in the Sudoku grid */
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                TextField txt = new TextField();
                textFieldStyle(txt); /** Apply styling to the text field */
                txt.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.DOTTED, CornerRadii.EMPTY, new BorderWidths(1))));
                txt.setText(String.valueOf(sudoku.getSudoku()[i][j])); /** Set initial value */
                verityEmptyNumber(txt, sudoku.getSudoku()[i][j]); /** Verify if the cell is empty */
                GridPane.add(txt,j,i); /** Add the TextField to the GridPane */
                onKeyTextField(txt, i, j); /** Listen for key presses */
            }
        }
    }

    private void onKeyTextField(TextField txt, int i, int j) {
        txt.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                    try {
                        Integer in = Integer.parseInt(event.getText()); /** Parse input as an integer */

                    } catch (NumberFormatException excep) {
                        /** Show an error message if input is not a valid number */
                        String title = "Alerta";
                        String header = "Error";
                        String content = "Solo se puedes ingresar numeros";
                        new AlertBox().showMessage(title, header, content);
                    }
                sudoku.sudokuSolved(); /** Check Sudoku solution */
                if (Integer.parseInt(event.getText()) != sudoku.getSudoku()[i][j]){
                    /** Show an error message if input doesn't match the solution */
                        String title = "Alerta";
                        String header = "Error";
                        String content = "Numero Equivocado";
                        new AlertBox().showMessage(title, header, content);
                }
                else {
                    sudokuPlayer[i][j] = Integer.parseInt(event.getText()); /** Store player's input */
                }

            }
        });
    }

    @FXML
    void onHandleButtonConfirm(ActionEvent event){
        if(veritySodukos()){
            /** Show victory message if player's solution matches Sudoku solution */
            String title = "Victoria";
            String header = "Lo lograste :)";
            String content = "¡Felicidades! Haz resuelto el sudoku";
            new AlertBox().showMessageInformation(title, header, content);
        }
        else {
            /** Show defeat message if solution is incorrect or incomplete */
            String title = "Perdiste";
            String header = "Mmmmm :(";
            String content = "Lo siento, tu solucion es erroneo o esta incompleta";
            new AlertBox().showMessage(title, header, content);

        }
    }

    private boolean veritySodukos(){
        /** Check if player's solution matches Sudoku solution */
        sudoku.sudokuSolved();
        boolean n = false;
        int m=0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku.getSudoku()[i][j] == sudokuPlayer[i][j]) {
                    m++;
                }
            }
        }
        if (m==48){
            n = true;
        }
        else{
            n = false;
        }
        return n;
    }

    @FXML
    void onHandleButtonSolved(ActionEvent event) {
        sudoku.sudokuSolved(); /** Get the complete sudoku solution */
        for (int i = 0; i < GridPane.getChildren().size(); i++) {
            if (GridPane.getChildren().get(i) instanceof TextField) {
                TextField textField = (TextField) GridPane.getChildren().get(i);
                textField.deselect(); /** Deselect any selected text field */
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                TextField txt = new TextField();
                textFieldStyle(txt); /** Style the new text field */
                txt.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.DOTTED, CornerRadii.EMPTY, new BorderWidths(1))));
                txt.setText(String.valueOf(sudoku.getSudoku()[i][j])); /** Show the solution in the text field */
                if (txt.getLength() > 0) {
                    txt.setEditable(false); /** Make the text field not editable if it already contains a value */
                    txt.setBackground(new Background(new BackgroundFill(Color.rgb(240, 240, 240), null, null)));
                } else {
                    txt.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), null, null)));
                }
                GridPane.add(txt,j,i); /** Add the new text field to the GridPane */
            }
        }
    }

    private void verityEmptyNumber(TextField txt, int n){
        /** Verify whether a cell is empty or contains a pre-filled number */
        if (n !=0 ){
            txt.setEditable(false);
            txt.setBackground(new Background(new BackgroundFill(Color.rgb(240, 240, 240), null, null)));
        }
        else {
            txt.clear();
            txt.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), null, null)));
        }
    }

    public TextField textFieldStyle(TextField txt) {
        /** Set style for the TextField */
        txt.setMaxWidth(50);
        txt.setMaxHeight(45);
        txt.setFont(new Font("Verdana", 20));
        txt.setAlignment(Pos.CENTER);
        txt.setStyle("-fx-backgroud-color: pink");
        return txt;
    }
    public void onHandleButtonBackToPlay(ActionEvent actionEvent) throws IOException {
        /** Return to the welcome stage to play again */
        GameStage.deleteInstance();
        WelcomeStage.getInstance();
    }
}
