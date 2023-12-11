package com.example.networkllassigmentll;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.net.ConnectException;

public class insertitem
{
    private int count=1;
    //TextField Start
    @FXML
    private TextField amount;

    @FXML
    private TextField productid;

    @FXML
    private TextField price;
 @FXML
   private TextField name;

    @FXML
    private TextField grade;

    @FXML
    private TextField city;
    @FXML
    private TextField type;
    //TextField End
    //Label Start
    @FXML
    private Label idl;
    @FXML
    private Label tl;

    @FXML
    private Label al;

    @FXML
    private Label pl;
    @FXML
    private Label Status;

    //Label End
    //MainControl Start
    MainControl MyMain;
    //MainControl End
    //MyStage
    Stage myStage;
    //MyStage
    //Method Start
    @FXML
    void Insertitem(ActionEvent event)
    {try {


          //  String ID = this.productid.getText();
            String grade = this.grade.getText();
            String name = this.name.getText();
            String city = this.city.getText();
            if ( !city.isEmpty() && !grade.isEmpty() & !name.isEmpty()) {
                if (this.String_is_number(grade)) {
                    int A = Integer.parseInt(grade);
                   
                    if (A < 0 ) {
                        if (A < 0) {
                            this.al.setVisible(true);
                            this.al.setText("must be positive");
                        } else
                            this.al.setVisible(false);
                      
                      
                        return;

                    }
                    this.setLabels();
                    String Url = this.MyMain.getUrl();
                    String method = this.MyMain.getMethod();

                    if (Url.contains("http://127.0.0.1:80/NWIIASSII"))
                        Url += "//insertitem.php";
                    else if (Url.contains("http://localhost:8080/hello/responseServlet")) {
                        this.MyMain.addParameter("showitem", "No");
                        this.MyMain.addParameter("editnumitem", "No");
                        this.MyMain.addParameter("showall", "No");
                        this.MyMain.addParameter("Withdraw", "No");
                        this.MyMain.addParameter("inseritem", "yes");
                       // Url += "//responseServlet";
                    }

else if (Url.contains("http://localhost:8080/hello/showall.jsp")) {
                        this.MyMain.addParameter("showitem", "No");
                        this.MyMain.addParameter("editnumitem", "No");
                        this.MyMain.addParameter("showall", "No");
                        this.MyMain.addParameter("Withdraw", "No");
                        this.MyMain.addParameter("inseritem", "yes");
                       // Url += "//responseServlet";
                    }

                    this.MyMain.setUrl(Url);
                    this.MyMain.addParameter("name", name);
                    this.MyMain.addParameter("city", city);
                    this.MyMain.addParameter("grade", String.valueOf(grade));

                    if (method.equalsIgnoreCase("get")) {
                        this.MyMain.sendData_GET();

                    }
                    //   if (method.equalsIgnoreCase("get"))
                    else if (method.equalsIgnoreCase("post")) {
                        this.MyMain.sendData_POST();
                    }//else if(method.equalsIgnoreCase("post"))
                    String read = this.MyMain.getRead();
                    if (read.contains("Done")) {
                        this.Status.setText("item" + this.count + " added successfully");
                        this.count++;
                        this.Status.setVisible(true);
                    } else if (read.contains("Duplicate")) {
                        this.Status.setText("This product is existed");
                        this.Status.setVisible(true);
                    }
                    this.MyMain.setRead("");
                    this.MyMain.getmethod();
                    this.MyMain.setDataStr("");
                    this.MyMain.getConvert2().setVisible(false);
                    this.setTextFields();

                }// if(this.String_is_number(ID)&&this.String_is_number(amount)&&this.String_is_number(price))

                else {
                    this.Status.setVisible(false);
                   

                   
                    if (!this.String_is_number(grade)) {
                        this.pl.setText("Only Digit accepted");
                        this.pl.setVisible(true);
                    } else
                        this.pl.setVisible(false);
                }//else


            }//if(!ID.isEmpty()&&!amount.isEmpty()&&!price.isEmpty()&!type.isEmpty())


            else {
                this.Status.setVisible(false);
              
                if (city.isEmpty()) {
                    this.al.setVisible(true);
                    this.al.setText("Required");
                } else
                    this.al.setVisible(false);

                if (grade.isEmpty()) {
                    this.pl.setVisible(true);
                    this.pl.setText("Required");
                } else
                    this.pl.setVisible(false);

                if (name.isEmpty()) {
                    this.tl.setVisible(true);
                    this.tl.setText("Required");
                } else
                    this.tl.setVisible(false);

            }//else
        }//try
        catch (ConnectException Ex)
        {
            this.Status.setVisible(true);
            this.Status.setText("The Server is Off");
        }
        catch (FileNotFoundException Ex)
        {
            this.Status.setVisible(true);
            this.Status.setText("Error 404 Not Found File");
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

    private void setLabels()
    {

        this.idl.setText("");
        this.idl.setVisible(false);
        this.pl.setText("");
        this.pl.setVisible(false);
        this.al.setText("");
        this.al.setVisible(false);
        this.tl.setText("");
        this.tl.setVisible(false);
    }
    private void setTextFields()
    {
        this.productid.setText("");
        this.price.setText("");
        this.amount.setText("");
        this.type.setText("");
    }
    public void getMainContorl(MainControl M)
    {
        this.MyMain=M;
    }
    public void setMyStage(Stage myStage)
    {
        this.myStage = myStage;
    }


    //Method End
}
