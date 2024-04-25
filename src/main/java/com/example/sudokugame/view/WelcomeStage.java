package com.example.sudokugame.view;

import com.example.sudokugame.controller.WelcomeController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
/** Authors:
 Juliana Melissa Bolaños Araujo
 Ivan David Ausecha Salamanca-2328223
 Laura Stefania Salazar Blanco-2327896
 Emails:

 ivan.ausecha@correounivale.edu.co
 laura.blanco@correounivalle.edu.co */
public class WelcomeStage extends Stage {
    /** Variable to keep track of the controller for the welcome screen.*/
    private WelcomeController welcomeController;
    /** The constructor method */
    public WelcomeStage () throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/com/example/sudokugame/welcome.fxml"));
        Parent root = loader.load();
        welcomeController = loader.getController();
        setTitle("Juego Sudoku - Bienvenido");
        Scene scene = new Scene(root);
        getIcons().add(
                new Image(
                        String.valueOf(getClass().getResource("/com/example/sudokugame/images/flaticon.png"))));
        setScene(scene);
        setResizable(false);
        show();
    }

    public WelcomeController getWelcomeController(){
        return welcomeController;
    }

    public static WelcomeStage getInstance() throws IOException{
        return WelcomeStageHolder.INSTANCE = new WelcomeStage();
    }

    private static class WelcomeStageHolder {
        private static WelcomeStage INSTANCE;
    }

    public static void deleteInstance() {
        WelcomeStageHolder.INSTANCE.close();
        WelcomeStageHolder.INSTANCE = null;
    }
}
