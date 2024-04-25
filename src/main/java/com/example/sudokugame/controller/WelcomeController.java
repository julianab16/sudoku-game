package com.example.sudokugame.controller;

import com.example.sudokugame.view.GameStage;
import com.example.sudokugame.view.WelcomeStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

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
public class WelcomeController {
    @FXML
    void buttonStart(ActionEvent event) throws IOException {
        /** When the "Start" button is clicked initialize the GameController for the game */
        GameStage.getInstance().getGameController().initialize();
        /** Close the WelcomeStage */
        WelcomeStage.deleteInstance();
    }
}
