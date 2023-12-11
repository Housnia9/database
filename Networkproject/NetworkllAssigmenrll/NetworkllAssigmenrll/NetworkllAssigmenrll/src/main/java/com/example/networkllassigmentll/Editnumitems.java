package com.example.networkllassigmentll;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.net.ConnectException;

public class Editnumitems
{
    //TextField Start
    @FXML
    private TextField productid;
    @FXML
    private TextField numitem;
    //TextField End

    //Label Start
    @FXML
    private Label incorrect;
    //Label End

    //MainControl
    MainControl MyMain;
    //MainControl
    //Mine Start
    Stage myStage;
    //Mine End

    @FXML
    void editnumitem(ActionEvent event)
    {
        try {

            String ID = this.productid.getText();
            String amount = this.numitem.getText();
            if (!ID.isEmpty() && !amount.isEmpty()) {

                if (!this.String_is_number(ID) || !this.String_is_number(amount)) {
                    this.incorrect.setText("only Digit accepted in these field");
                    this.incorrect.setVisible(true);
                } else if (!this.String_is_number(ID)) {
                    this.incorrect.setText("ID should be Digit only ");
                    this.incorrect.setVisible(true);
                } else if (!this.String_is_number(amount)) {
                    this.incorrect.setText("Number of items should be Digit only ");
                    this.incorrect.setVisible(true);
                } else {
                    int num = Integer.parseInt(amount);
                    if (num < 0) {
                        incorrect.setVisible(true);
                        incorrect.setText("amount of product is positive number");
                        return;
                    }

                    String Url = this.MyMain.getUrl();
                    String method = this.MyMain.getMethod();

                    if (Url.contains("http://127.0.0.1:80/NWIIASSII"))
                        Url += "//editnumitem.php";
                    else if (Url.contains("http://localhost:8080/hello/responseServer")) {
                        this.MyMain.addParameter("showitem", "No");
                        this.MyMain.addParameter("editnumitem", "yes");
                        this.MyMain.addParameter("showall", "No");
                        this.MyMain.addParameter("Withdraw", "No");
                        this.MyMain.addParameter("inseritem", "No");
                       // Url += "//responseServlet";
                    }

                    this.MyMain.setUrl(Url);
                    this.MyMain.addParameter("ID", ID);
                    this.MyMain.addParameter("amount", amount);
                    this.incorrect.setVisible(false);
                    if (method.equalsIgnoreCase("get")) {
                        this.MyMain.sendData_GET();

                    }
                    //   if (method.equalsIgnoreCase("get"))
                    else if (method.equalsIgnoreCase("post")) {
                        this.MyMain.sendData_POST();
                    }//else if(method.equalsIgnoreCase("post"))

                    String read = this.MyMain.getRead();
                    if(read.contains("Product Not Found"))
                    {
                        this.incorrect.setText("This Product was not Found please try again");
                        this.incorrect.setVisible(true);
                    }
                    else
                    {
                        this.MyMain.geta2().setText(read);
                        this.myStage.close();
                    }//else
                    this.MyMain.setRead("");
                    this.MyMain.getmethod();
                    this.MyMain.setDataStr("");
                    this.MyMain.getConvert2().setVisible(false);
                }//else

            }//if(!ID.isEmpty()&&!amount.isEmpty())


            else {
                this.incorrect.setText("You need to fill this Information");
                this.incorrect.setVisible(true);
            }
        }//try
              catch (ConnectException Ex)
        {
            this.incorrect.setVisible(true);
            this.incorrect.setText("The Server is Off");
        }
        catch (FileNotFoundException Ex)
        {
            this.incorrect.setVisible(true);
            this.incorrect.setText("Error 404 Not Found File");
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
    private boolean String_is_number(String Number)
    {
        if(Number!=null)
        {
            boolean b;
            try
            {
                Integer.parseInt(Number);
                b=true;
            }
            catch (NumberFormatException Ex)
            {
                b=false;
            }
            return b;
        }
        else
        throw new NullPointerException("The String is null");
    }
    public void setMyStage(Stage stage)
    {
        this.myStage=stage;
    }

}
