package com.example.networkllassigmentll;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.net.ConnectException;

public class withdraw
{
    //TextField Start
    @FXML
    private TextField productid;
    @FXML
    private TextField numofwithdrawals;
    //TextField End

    //Label Start
    @FXML
    private Label incorrect;
    //Label End

    //My MAIN Control Start
   MainControl MyMain;
    //My MAIN Control End
    //Mine
    Stage myStage;
    //Mine
    @FXML
    void withdraw(ActionEvent event)
    {
    try
    {

        String ID = this.productid.getText();
        String withdraw = this.numofwithdrawals.getText();
        if (!ID.isEmpty() && !withdraw.isEmpty()) {

            if (!this.String_is_number(ID) && !this.String_is_number(withdraw)) {
                this.incorrect.setText("only Digit accepted in these field");
                this.incorrect.setVisible(true);
            } else if (!this.String_is_number(ID)) {
                this.incorrect.setText("ID should be Digit only ");
                this.incorrect.setVisible(true);
            } else if (!this.String_is_number(withdraw)) {
                this.incorrect.setText("Number of withdrawals should be Digit only ");
                this.incorrect.setVisible(true);
            } else {
                int num = Integer.parseInt(withdraw);
                if (num < 0) {
                    this.incorrect.setVisible(true);
                    this.incorrect.setText("The number of withdrawals   is positive number");
                    return;
                }

                String Url = this.MyMain.getUrl();
                String method = this.MyMain.getMethod();
                if (Url.contains("http://127.0.0.1:80/NWIIASSII"))
                    Url += "//withdraw.php"; //withdraw
                else if (Url.contains("http://localhost:8080/responseServer"))
                {
                    this.MyMain.addParameter("showitem", "No");
                    this.MyMain.addParameter("editnumitem", "No");
                    this.MyMain.addParameter("showall", "No");
                    this.MyMain.addParameter("Withdraw", "yes");
                    this.MyMain.addParameter("inseritem", "No");
                   // Url += "//responseServlet";
                }
                this.MyMain.setUrl(Url);
                this.MyMain.addParameter("ID", ID);
                this.MyMain.addParameter("withdraw", withdraw);
                this.incorrect.setVisible(false);
                if (method.equalsIgnoreCase("get")) {
                    this.MyMain.sendData_GET();

                }
                //   if (method.equalsIgnoreCase("get"))
                else if (method.equalsIgnoreCase("post")) {
                    this.MyMain.sendData_POST();
                }//else if(method.equalsIgnoreCase("post"))

                String read = this.MyMain.getRead();
                if(!read.contains("Success")) {
                    if (read.contains("Product Not Found")) {
                        this.incorrect.setText("This Product was not Found please try again");
                        this.incorrect.setVisible(true);
                    }
                    else
                    {
                        this.incorrect.setText(read);
                        this.incorrect.setVisible(true);
                    }//else
                }//if  if(!read.contains("Success"))
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
    }
    catch (ConnectException Ex)
    {
        this.incorrect.setText("The Server is Off");
        this.incorrect.setVisible(true);
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
    public void getMainContorl(MainControl M)
    {
        this.MyMain=M;
    }
    public void setMyStage(Stage myStage)
    {
        this.myStage = myStage;
    }
}
