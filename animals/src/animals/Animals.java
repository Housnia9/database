/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animals;

/**
 *
 * @author 97056
 */
import java.util.Objects;
 import javafx.application.Application;
 import javafx.event.ActionEvent;
import javafx.fxml.FXML;
 import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JButton;

/**
 *
 * @author oth
 */
public class Animals extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //CostomerInformation.fxml
        
      
    }

/* private void admin(ActionEvent event) throws Exception {
     if(event.getSource()==b2){
          
       Parent m = FXMLLoader.load(getClass().getResource("add_emp.fxml"));
        
        Scene ms = new Scene(m);
        Stage m3;
        m3=(Stage)((Node)event.getSource()).getScene().getWindow();
        m3.setScene(ms);
         m3.show();
    }
 }*/
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
