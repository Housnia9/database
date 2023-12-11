package com.example.networkllassigmentll;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.EventListener;
import java.util.Objects;

public class HelloController {
    //Variables Start
    //Button Start
    @FXML
    private Button log_in;
     @FXML
    private Button log_in1;
    
    //Button End
    //passwordfield start
    @FXML
    private PasswordField password;
    //passwordfield End

    //Textfield Start
    @FXML
    private TextField ID;
    //Textfield End

    //Label Start
    @FXML
    private Label suc;
    //Label End

    // String Start
    private String dataStr = "";
    private String urlStr = "http://localhost:80/NWIIASSII/login.php";
    private String contentStr = "application/x-www-form-urlencoded";
    // String End

    //boolean Start
    boolean b;
    //boolean End
    //For Server Start
    URLConnection myConn;
    BufferedReader in;
   OutputStream out;
    URL myURL;
    HttpURLConnection urlCon;
    String[] recive;
    // For Server End

    //Mysatge
    Stage mystage;
    //Mystage
    //Variables End

    //Method Start
    @FXML
    void Log_in(ActionEvent event) throws IOException,ParseException
    {
        try
        {
       if (ID.getText().isEmpty() || password.getText().isEmpty())
       {
            this.suc.setText("You need to fill all information");
            this.suc.setVisible(true);
        }
       else
       {

                Integer.parseInt(ID.getText());
                this.sendData_POST();
                if (b)
                {
                    // this.suc.setVisible(false);
                    Stage stage = new Stage();
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Main.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 1035, 752);
                    stage.setTitle("Employee Page");
                    scene.getStylesheets().add(Objects.requireNonNull(this.getClass().getResource("CSS/Main.css")).toExternalForm());
                    stage.setScene(scene);
                    stage.show();
                    stage.setResizable(false);
                    MainControl load = fxmlLoader.getController();
                    load.getLogin(this);
                    load.getloginstage(stage);
                    load.setLastseen(recive[1] + " " + recive[2]);
                    mystage.close();
                } else {
                    this.suc.setText("Incorrect ID or password please try again");
                    this.suc.setVisible(true);
                }
            } //try

        } //else
        catch (NumberFormatException EX)
        {
            this.suc.setText("Employee ID need to be digits only");
            this.suc.setVisible(true);
        }
        catch (ConnectException Ex)
        {
            this.suc.setText("Server is Off");
            this.suc.setVisible(true);
        }
        catch (FileNotFoundException Ex)
        {
            this.suc.setText("Error 404 Not Found File");
            this.suc.setVisible(true);
        }


    }//Log in


    private void addParameter(String ps, String vs)
    {
        if (ps == null || vs == null || ps.length() == 0 || vs.length() == 0)
        {
            return;
        }
        if (dataStr.length() > 0) {
            dataStr += "&";
        }
       try
        {

            dataStr += ps + "=" + URLEncoder.encode(vs, "ASCII");
       }
        catch (UnsupportedEncodingException e)
       {
            System.out.println(e.toString());
        }
    }

    void sendData_POST()  throws ConnectException,FileNotFoundException
    {


        String ID = this.ID.getText().trim();
        String password = this.password.getText().trim();
        addParameter("ID", ID);
        addParameter("password", password);
        try {
            this.myURL = new URL(this.urlStr);
            this.myConn = this.myURL.openConnection();
            this.urlCon=(HttpURLConnection)myConn;
            this.urlCon.setRequestMethod("POST");
            this.urlCon.setAllowUserInteraction(true);
            this.urlCon.setRequestProperty("Content-Type", contentStr);

            this.urlCon.setDoOutput(true);
            this.out = new BufferedOutputStream(urlCon.getOutputStream());
            this.out.write(this.dataStr.getBytes());
            out.flush();
            out.close();

            this.in=new BufferedReader(new InputStreamReader(this.urlCon.getInputStream()));
            String server = "";
            if ((server = in.readLine()) != null)
            {
                if (server.contains("true"))
                {
                    this.b = true;
                    this.recive = server.split(" ");
                } //if(server.contains("true"))
                else if (server.contains("false"))
                    this.b = false;
            }//if
        }//try
     catch (Exception Ex)
     {
         System.out.println(Ex.toString());
         Ex.printStackTrace();
     }

    }

    public String get_ID() {
        return this.ID.getText();
    }

    public void getmystage(Stage stage)
    {
        this.mystage = stage;
    }
    //Method End

@FXML
    void studenty(ActionEvent event) throws IOException,ParseException
    {FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("student.fxml"));
                   
    Scene scene = new Scene(fxmlLoader.load(), 1035, 752);
     Stage stage = new Stage();
                    stage.setTitle("Student page");
                    scene.getStylesheets().add(Objects.requireNonNull(this.getClass().getResource("CSS/Main.css")).toExternalForm());
                    stage.setScene(scene);
                    stage.show();
                    stage.setResizable(false);
                    MainControl load = fxmlLoader.getController();


}}