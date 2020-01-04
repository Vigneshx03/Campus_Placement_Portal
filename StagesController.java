/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campusplacement;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import java.sql.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;



public class StagesController implements Initializable {
    public String roll,nam,teststat,gdstat,pistat,fstat;
    public String namee="Smita Aaher";
    @FXML private Label disname;
    
    @FXML private Label rollNo;
    
    @FXML private Label testStatus;
    
    @FXML private Label gdStatus;
    
    @FXML private Label piStatus;

    @FXML private Label finalStatus;

    @FXML public Button test;
    
    @FXML private Button gd;
    
    @FXML private Button pi;
    
    @FXML
    void handlethis(ActionEvent ae)
    {
        
    }
    
    @FXML
    void display()
    {
        rollNo.setText(String.valueOf(roll));
        disname.setText(String.valueOf(nam));
        testStatus.setText(String.valueOf(teststat));
        gdStatus.setText(String.valueOf(gdstat));
        piStatus.setText(String.valueOf(pistat));
        finalStatus.setText(String.valueOf(fstat));
        if(teststat.equals("attempted"))
        {
            test.setDisable(true);
        }
        if(gdstat.equals("attempted"))
        {
            gd.setDisable(true);
        }
        if(pistat.equals("attempted"))
        {
            pi.setDisable(true);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    try{
            Class.forName("com.mysql.jdbc.Driver");
            String con = "jdbc:mysql://localhost:3306/campus";
            String username = "root";
            String Pass = "";
            java.sql.Connection conn = DriverManager.getConnection(con,username,Pass);
            PreparedStatement st = conn.prepareStatement("select * from hiring_stages where name=?");
            st.setString(1, namee);
            ResultSet res = st.executeQuery();
            while(res.next())
            {
                roll = res.getString(1);
                nam = res.getString(2);
                teststat = res.getString(3);
                gdstat = res.getString(4);
                pistat = res.getString(5);
                fstat = res.getString(6);
            }
            display();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            }
    }    
    
}
