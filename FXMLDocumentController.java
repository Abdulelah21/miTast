/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermtest;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author gg
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private TextField textUsername;
    @FXML
    private TextField texPassword;
    @FXML
    private Label labTrue;
    @FXML
    private Label labFlase;

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TOD
    }

    @FXML
    private void saveInFile(ActionEvent event) throws IOException {
        User file = new User();

        boolean check = file.cheackUser(textUsername.getText());
        
        labTrue.setText("");
        labFlase.setText("");
        
        if (check) {
            
            labTrue.setText("");
            labFlase.setText("ERROR WE CAN'T FIND THE USER NAME -__-");
        } else if  (check == false) {
            System.out.println(check);
            labTrue.setText("Thank you for regester :D ");
            labFlase.setText("");
            file.addUser(textUsername.getText(),texPassword.getText());
        }

    }

}
