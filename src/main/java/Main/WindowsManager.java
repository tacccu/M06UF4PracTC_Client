/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author carlo
 */
public class WindowsManager {

    private static WindowsManager manager;

    public static WindowsManager getInstance() {
        if (manager == null) {
            manager = new WindowsManager();
        }

        return manager;
    }

    public void hallOfFame(Button backButton) {
        try {
            Stage oldWindow = (Stage) backButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));

            Parent root = loader.load();
            Stage stage = new Stage();
            stage.getIcons().add(new Image("/images/Trivial.png"));
            stage.setTitle("[Trivial] Hall Of Fame");
            stage.setScene(new Scene(root, 600, 400));
            stage.setResizable(false);
            oldWindow.close();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void returnToMain(Button backButton) {
        try {
            Stage oldWindow = (Stage) backButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pantallaMain.fxml"));

            Parent root = loader.load();
            Stage stage = new Stage();
            stage.getIcons().add(new Image("/images/Trivial.png"));
            stage.setTitle("[Trivial] Menú Principal");
            stage.setScene(new Scene(root, 600, 400));
            oldWindow.close();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void login() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.getIcons().add(new Image("/images/Trivial.png"));
            stage.setTitle("[Trivial] Login");
            stage.setScene(new Scene(root, 600, 400));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void disconnect(Button discon) {
        try {
            Stage oldWindow = (Stage) discon.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.getIcons().add(new Image("/images/Trivial.png"));
            stage.setTitle("[Trivial] Login");
            stage.setScene(new Scene(root, 600, 400));
            stage.setResizable(false);
            oldWindow.close();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createNewGame(Button createGame) throws Exception {
        try {
            Stage oldWindow = (Stage) createGame.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.getIcons().add(new Image("/images/Trivial.png"));
            stage.setTitle("[Trivial] New Game");
            stage.setScene(new Scene(root, 600, 400));
            oldWindow.close();
            stage.show();
        } catch (Exception e) {
            throw e;
        }
    }

    public void startGame(Button createButton) throws Exception {
        try {
            Stage oldWindow = (Stage) createButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("inGame.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("[Trivial] Juego");
            stage.getIcons().add(new Image("/images/Trivial.png"));
            stage.setScene(new Scene(root, 1163, 824));
            stage.setResizable(false);
            oldWindow.close();
            stage.show();
        } catch (Exception e) {
            throw e;
        }

    }

    public void mainMenu(Button cancelButton) {
        try {
            Stage oldWindow = (Stage) cancelButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pantallaMain.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("[Trivial] Main");
            stage.getIcons().add(new Image("/images/Trivial.png"));
            stage.setScene(new Scene(root, 600, 400));
            oldWindow.close();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
