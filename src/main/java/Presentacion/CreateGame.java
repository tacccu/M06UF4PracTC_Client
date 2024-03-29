package Presentacion;

import Entities.Lookups;
import Logica.Alerts.Alerts;
import Logica.Interfaces.IPartida;
import Logica.Interfaces.ISessionManager;
import Main.WindowsManager;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.naming.NamingException;

public class CreateGame implements Initializable {

    public enum dificultades {
        ALTA, BAJA, MEDIA
    };

    @FXML
    private Button cancelButton;

    @FXML
    private Button createButton;

    @FXML
    private ChoiceBox<String> dificultChoiceBox;

    @FXML
    private TextField newGameInputText;

    @FXML
    private Label newGameLabel;

    @FXML
    private ImageView imageLogo;

    @FXML
    private ChoiceBox<String> numberOfPlayersChoiceBox;

    @FXML
    private Label playersLabel;

    @FXML
    private Label selectDificultLabel;

    //Gestor de ventanas
    WindowsManager manager = WindowsManager.getInstance();

    public static IPartida partida;

    ISessionManager sessionManager;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Dificultades
        inicializarDificultades();
        inicializarImagenes();
        try {
            partida = Lookups.partidaEJBRemoteLookup();
            sessionManager = Lookups.sessionManagerEJBRemoteLookup();

        } catch (NamingException ex) {
            Logger.getLogger(CreateGame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void inicializarDificultades() {
        for (dificultades dificultad : dificultades.values()) {
            dificultChoiceBox.getItems().add(dificultad.toString());
        }
    }

    void inicializarImagenes() {
        Image logo = new Image("/images/Trivial.png");
        imageLogo.setImage(logo);
    }

    @FXML
    void startGame(ActionEvent event) throws NamingException {

        try {
            //Llamar a EJB
            partida.crearPartida(newGameInputText.getText(), LoginController.token, dificultChoiceBox.getValue());

            manager.startGame(createButton);
        } catch (NullPointerException e) {
            throw e;
        } catch (Exception e) {
            partida = Lookups.partidaEJBRemoteLookup();
            Alerts.Warning(e.getMessage());
        } finally {
            newGameInputText.requestFocus();
            dificultChoiceBox.requestFocus();
        }

    }

    @FXML
    void cancelButton(ActionEvent event) {

        //Implementar funcion para cambiar de ventana
        manager.mainMenu(cancelButton);

    }

}
