/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campusplacement;

import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class quizController implements Initializable {

    @FXML
    private Button next;
    @FXML
    private Button submit;
    @FXML
    private RadioButton rb1;
    @FXML
    private RadioButton rb3;
    @FXML
    private RadioButton rb2;
    @FXML
    private RadioButton rb4;
    @FXML
    private TextField qtext;
    @FXML
    private TextField qno;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String con = "jdbc:mysql://localhost:3306/campus";
            String username = "root";
            String Pass = "";
            java.sql.Connection conn = DriverManager.getConnection(con,username,Pass);
            PreparedStatement st = conn.prepareStatement("select * from studentpending");
            ResultSet res = st.executeQuery();
            while(res.next())
            {
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            }
    }    

    @FXML
    private void handleNextAction(ActionEvent event) {
    }

    @FXML
    private void handleSubmitAction(ActionEvent event) {
    }
    
}
