package com.example.networkllassigmentll;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.net.ConnectException;
import java.util.EventListener;

public class showitem {

    @FXML
    private Button confirm;

    @FXML
    private TextField productid;

    @FXML
    private Label incoorect;
    // MainControl
    private MainControl MyMain;
    // MainControl
    //Mine Start
    Stage myStage;
    //Mine End
    @FXML
    void showitem(ActionEvent event)
    {
        try
        {


            String ID = this.productid.getText();
            if (!ID.isEmpty()) {
                try {
                    Integer.parseInt(ID);
                    this.incoorect.setVisible(false);
                    String Url = this.MyMain.getUrl();
                    String method = this.MyMain.getMethod();

                    if (Url.contains("http://127.0.0.1:80/NWIIASSII"))
                        Url += "//showitem.php";

                    else if (Url.contains("http://localhost:8080/hello/responseServlet")) {
                        this.MyMain.addParameter("showitem", "yes");
                        this.MyMain.addParameter("editnumitem", "No");
                        this.MyMain.addParameter("showall", "No");
                        this.MyMain.addParameter("Withdraw", "No");
                        this.MyMain.addParameter("inseritem", "No");
                       // Url += "//responseServlet";
                    }

                    this.MyMain.setUrl(Url);
                    this.MyMain.addParameter("ID", ID);
                    if (method.equalsIgnoreCase("get")) {

                        this.MyMain.sendData_GET();

                    } //   if (method.equalsIgnoreCase("get"))

                    else if (method.equalsIgnoreCase("post")) {
                        this.MyMain.sendData_POST();

                    }//    else if (method.equalsIgnoreCase("post"))
                    String read = this.MyMain.getRead();
                   // String item=read.split("=>")[1];
                    //this.MyMain.addPrice(item);
                    if (read.contains("Product Not Found"))
                    {
                        this.incoorect.setVisible(true);
                        this.incoorect.setText("This Product was not Found please try again");
                        this.MyMain.getConvert2().setVisible(false);
                    }//if

                    else {

                        this.MyMain.geta2().setText("ID                                price(USD)                                type                                amount\n" + read);
                        this.myStage.close();
                        this.MyMain.getConvert2().setVisible(true);
                    }//else

                    this.MyMain.setRead("");
                    this.MyMain.getmethod();
                    this.MyMain.setDataStr("");
                }//try
                catch (NumberFormatException Ex) {
                    this.incoorect.setText("Only Digits Accepted");
                    this.incoorect.setVisible(true);
                }
            }//if(!ID.isEmpty())

            else {
                this.incoorect.setText("You need to enter ID of product");
                this.incoorect.setVisible(true);
            }
        }//try
        catch (ConnectException Ex)
        {
            this.incoorect.setVisible(true);
            this.incoorect.setText("The Server is Off");
        }
        catch (FileNotFoundException Ex)
        {
            this.incoorect.setVisible(true);
            this.incoorect.setText("Error 404 Not Found File");
        }
    }
    @FXML
    void Cancel(ActionEvent event)
    {
        this.myStage.close();

    }
    public void getMainContorl(MainControl M)
    {
        this.MyMain=M;
    }

    public void setMyStage(Stage myStage)
    {
        this.myStage = myStage;
    }
}
