package com.example.networkllassigmentll;

import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

//import com.google.gson.Gson;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
import javafx.util.Duration;
import org.json.JSONException;
import org.json.JSONObject;
//import com.google.gson.JsonParser;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class MainControl  implements Initializable
{

   // Buttons
    private Button showall;
    private Button avarage;
    private Button product;
    private Button higest;
    @FXML
    private Button convert2;
    @FXML
    private Button convert;
    //Hyperlink End
    //textarea
     @FXML
     private TextArea a1;
     @FXML
     private TextArea a2;
    //textarea


    //anchor
     @FXML
     private AnchorPane A2;
    @FXML
    private AnchorPane A1;
    //anchor

    //Label
    @FXML
    private Label date;
    @FXML
    private Label time;

    @FXML
    private Label url;
    @FXML
    private Label lastenter;
    @FXML
    private Label L1;

    @FXML
    private Label L2;
    //Label

    //MenuButton
    @FXML
    private MenuButton servermethod;
    //MenuButton

    //MenuItem Start
    @FXML
    private MenuItem get1;
    @FXML
    private MenuItem post1;
    @FXML
    private MenuItem get2;
    private MenuItem postj;
    private MenuItem getj;
    @FXML
    private MenuItem post2;
    @FXML
    private TextField namet;
    //MenuItem End
   //String
    private String Url="http://localhost/NWIIASSII",method="GET";
    private  String dataStr="";
    private String contentStr = "application/x-www-form-urlencoded";
    private  String []recive;
  private   String read ;
  private  String from,to,currency,result;
    //String

    //For Server Start
    URLConnection myConn;
    BufferedReader in;
    BufferedOutputStream out;
    URL myURL;
    HttpURLConnection urlCon;
    // For Server End

    //HelloControl
    HelloController login;
    String EID;
    Stage stage;
    //HelloControl
    //Bollean Start
    private boolean USD_convert1;
    private boolean USD_convert2;
    //Bollean End
     ///ArrayList Start
    ArrayList<String>Prices=new ArrayList<String>();
    //ArrayList End
    //Variable End
    @FXML
    private AnchorPane mainanchor;
    @FXML
    private Button searchhh;
    @FXML
    private Button loggg;
    @FXML
    private MenuItem get21;
    @FXML
    private MenuItem post21;
    @FXML
    private Button showproduct;
    @FXML
    private Button edititems;
    @FXML
    private Button withdraw;


    //Method Start
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        this.USD_convert1=false;
        this.USD_convert2=false;
        read = new String();
       this.getDate();
       this.getmethod();
       this.Scale();


    }


    @FXML
    void moveanchor(ActionEvent event) throws IOException  {
        if(event.getSource()==this.showall)
        {
            this.A1.setVisible(true);
            this.A2.setVisible(false);
            this.convert2.setVisible(false);
            this.ShowAll();
            this.a2.setText("");
            this.convert.setText("Convert to EUR");


        }
        else if(event.getSource()==this.product)
        {this.A1.setVisible(true);
            this.A2.setVisible(false);
            this.convert2.setVisible(false);
            this.numberr();
            this.a2.setText("");
            this.convert.setText("Convert to EUR");
           
        }

 else if(event.getSource()==this.higest)
        {
             this.A1.setVisible(true);
            this.A2.setVisible(false);
            this.convert2.setVisible(false);
            this.hiehestgrrades();
            this.a2.setText("");
            this.convert.setText("Convert to EUR");

        }
        
else if(event.getSource()==this.avarage)
        {
             this.A1.setVisible(true);
            this.A2.setVisible(false);
            this.convert2.setVisible(false);
            this.avarageeee();
            this.a2.setText("");
            this.convert.setText("Convert to EUR");

        }
        else if(event.getSource()==this.searchhh)
        {
             this.A1.setVisible(true);
            this.A2.setVisible(false);
            this.convert2.setVisible(false);
this.search();
            this.a2.setText("");
            this.convert.setText("Convert to EUR");

        }
       
        
        
       
    }

    @FXML
    void selectservermethod(ActionEvent event)
    {
        if(event.getSource()==this.get1)
        {
            this.servermethod.setText(this.get1.getText());

        }
       else if(event.getSource()==this.post1)
        {
            this.servermethod.setText(this.post1.getText());
        }
        else if(event.getSource()==this.get2)
        {
            this.servermethod.setText(this.get2.getText());

        }
        else if(event.getSource()==this.post2)
        {
            this.servermethod.setText(this.post2.getText());
        }
        
         else if(event.getSource()==this.postj)
        {
            this.servermethod.setText(this.postj.getText());
        }
         else if(event.getSource()==this.getj)
        {
            this.servermethod.setText(this.getj.getText());
        }
        this.getmethod();
    }
    void showlastseen(ActionEvent event)
    {
            this.lastenter.setVisible(true);
    }
    void Logout(ActionEvent event) throws IOException {
        this.stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 842, 574);
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        scene.getStylesheets().add(Objects.requireNonNull(this.getClass().getResource("CSS/login.css")).toExternalForm());
        stage.show();
        stage.setResizable(false);
        HelloController load=fxmlLoader.getController();
        load.getmystage(stage);

        this.addParameter("ID",this.EID);
        this.Url="http://127.0.0.1:80/NWIIASSII/lastseen.php";
        this.sendData_GET();


    }
    @FXML
    void showproduct(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("showitem.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 554, 205);
        Stage showitemstage=new Stage();
        showitemstage.setTitle("Show Product");
        showitemstage.setResizable(false);
        showitemstage.setScene(scene);
        showitemstage.show();
        showitem S=fxmlLoader.getController();
        S.getMainContorl(this);
        S.setMyStage(showitemstage);

    }
    @FXML
    void editnumitem(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("editnumitems.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 554, 205);
        Stage edititemstage=new Stage();
        edititemstage.setTitle("Edit number of product");
        edititemstage.setScene(scene);
        edititemstage.show();
        edititemstage.setResizable(false);
        Editnumitems S=fxmlLoader.getController();
        S.getMainContorl(this);
        S.setMyStage(edititemstage);
    }
    @FXML
    void withdraw(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("withdraw.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 554, 205);
        Stage withdraw=new Stage();
        withdraw.setTitle("Edit number of product");
        withdraw.setScene(scene);
        withdraw.show();
        withdraw.setResizable(false);
        withdraw S=fxmlLoader.getController();
        S.getMainContorl(this);
        S.setMyStage(withdraw);
    }

    void insertitem(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("insertitem.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 695, 557);
        Stage insertitem=new Stage();
        insertitem.setTitle("Add Student");
        insertitem.setScene(scene);
        insertitem.show();
        insertitem.setResizable(false);
        insertitem S=fxmlLoader.getController();
        S.getMainContorl(this);
        S.setMyStage(insertitem);
    }
    
    
    
    @FXML
    void convert2(ActionEvent event)throws JSONException
    {
        try
        {

            String space="                                ";
            String Text = this.a2.getText();
            String[] S1 = Text.split("\n");
            if (S1[0].contains("USD"))
            {
                this.USD_convert1 = true;
                this.from = "USD";
                this.to = "EUR";
                Text = S1[0].replaceAll("USD", "EUR")+"\n";
            }
            else if (S1[0].contains("EUR"))
            {
                this.USD_convert1 = false;
                this.from = "EUR";
                this.to = "USD";
                Text = S1[0].replaceAll("EUR", "USD")+"\n";

            }

            for (int i = 1; i < S1.length; i++)
            {
                S1[i]=S1[i].replaceAll(space,"=>");
                if(S1[i].contains(" "))
                    S1[i].replaceAll(" ","");
                String[]temp=S1[i].split("=>");
                this.currency=temp[1];
                this.API_Currency();
                temp[1]=temp[1].replaceAll(this.currency,this.result);
                Text+=temp[0]+space+temp[1]+space+temp[2]+space+temp[3];
                Text+="\n";
            }
            this.a2.setText(Text);


        }//try
        catch (IOException Ex)
        {
            this.a2.setText("Can't read");
        }
        catch (InterruptedException Ex )
        {
            this.a2.setText("Error Connection");
        }
    }
    @FXML
    void convert(ActionEvent event)throws JSONException
    {
        try
        {

             String space="                                ";
            String Text = this.a1.getText();
            String[] S1 = Text.split("\n");
            if (S1[0].contains("USD"))
            {
                this.USD_convert1 = true;
                this.from = "USD";
                this.to = "EUR";
                this.a1.setText(S1[0]+"\n");
                Text = S1[0].replaceAll("USD", "EUR")+"\n";
            }
            else if (S1[0].contains("EUR"))
            {
                this.USD_convert1 = false;
                this.from = "EUR";
                this.to = "USD";
                Text = S1[0].replaceAll("EUR", "USD")+"\n";

            }


                S1[1]=S1[1].replaceAll(space,"=>");
                if(S1[1].contains(" "))
                    S1[1].replaceAll(" ","");
                String[]temp=S1[1].split("=>");
                this.currency=temp[1];
                this.API_Currency();
                temp[1]=temp[1].replaceAll(this.currency,this.result);
              Text+=temp[0]+space+temp[1]+space+temp[2]+space+temp[3];
              Text+="\n";

            this.a1.setText(Text);


        }//try
        catch (IOException Ex)
        {
            this.a1.setText("Can't read");
        }
        catch (InterruptedException Ex )
        {
            this.a1.setText("Error Connection");
        }


    }

     void  getmethod()
    {
        String[]temp=this.servermethod.getText().split("=>");
        try
        {
            this.method = temp[0];
            this.Url = temp[1];
            this.url.setVisible(false);
        }
        catch (IndexOutOfBoundsException Ex)
        {
            this.url.setText("unexpected server you select");
            this.url.setVisible(true);
        }

    }
    private void getDate()
    {
        DateTimeFormatter dtfDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime nowDate = LocalDateTime.now();
        date.setText("Date:"+dtfDate.format(nowDate));
        time.setText("Time:"+nowDate.getHour()+":"+nowDate.getMinute()+":"+nowDate.getSecond());
    }

    public void getLogin(HelloController c)
    {
            this.login=c;
            this.EID=login.get_ID();
    }
    public void getloginstage(Stage stage1 )
    {
        this.stage=stage1;
    }
    public void setLastseen(String LL) throws ParseException
    {


            SimpleDateFormat dtfDate = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");

            Date LS = dtfDate.parse( LL.replaceAll("-","/"));
            this.lastenter.setText("LastSeen:"+LS.toString());

    }
     void addParameter(String ps, String vs)
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
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }

    void sendData_POST() throws ConnectException, FileNotFoundException
    {

        try
        {
            this.myURL = new URL(this.Url);

            this.myConn = myURL.openConnection();
            this.myConn.setDoOutput(true);
            this.myConn.setDoInput(true);

            this.myConn.setRequestProperty("Content-Type", contentStr);
            this.myConn.setUseCaches(false);
            this.urlCon = (HttpURLConnection) myConn;
            this.urlCon.setRequestMethod("POST");
            this.myConn.connect();
            this.out = new BufferedOutputStream(urlCon.getOutputStream());
            this.out.write(this.dataStr.getBytes());
            this.out.flush();
            this.out.close();
            this.in=new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
            String date=new String();

            while ((date=in.readLine())!=null)
            {
                read+=date;

            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    void sendData_GET() throws ConnectException,FileNotFoundException
    {
        try
        {


            this.myURL = new URL(this.Url+"?"+this.dataStr);

            this.myConn = this.myURL.openConnection();
            this.urlCon=(HttpURLConnection)this.myConn;
            this.in = new BufferedReader(new InputStreamReader(myConn.getInputStream()));
            String date=new String();
            while ((date=in.readLine())!=null)
            {
                read+=date;

            }


        } //try
        catch (Exception e)
        {
            System.out.println(e.toString());
        }

    }

    public TextArea geta2 ()
    {
        return this.a2;
    }
    private void ShowAll()
    {

        try
        {


            if (Url.contains("http://127.0.0.1:80/NWIIASSII"))
                this.Url += "//showall.php";
            else if (Url.contains("http://localhost:8080/hello/responseServlet")) {
             addParameter("showitem", "No");
             addParameter("editnumitem", "No");
             addParameter("showall", "yes");
               addParameter("Withdraw", "No");
              addParameter("inseritem", "No");
                 addParameter("higest", "No"); 
                addParameter("avarage", "No"); 
                 addParameter("product", "No"); 
             
               // Url += "/responseServlet";
            }
          else if (Url.contains("http://localhost:8080/hello/showall.jsp")) {
          
           addParameter("showitem", "No");
             addParameter("editnumitem", "No");
             addParameter("showall", "yes");
               addParameter("Withdraw", "No");
              addParameter("inseritem", "No");
                 addParameter("higest", "No"); 
                addParameter("avarage", "No"); 
                 addParameter("product", "No"); 
          
          
          }
            this.Prices=new ArrayList<String>();

            read += "studentid" + "                          " + "name" + "                              " + "city" + "                              " + "grade" + "\n";
            if (this.method.equalsIgnoreCase("POST")) {
                this.sendData_POST();
            } else if (this.method.equalsIgnoreCase("GET")) {
                this.sendData_GET();
            }
            a1.setText(this.read.replaceAll("Success", "").replaceAll("enter", "\n"));
            this.setRead("");
            this.setDataStr("");
            this.getmethod();
        }
        catch (ConnectException Ex)
        {
            this.a1.setText("The Server is Off");
        }
        catch (FileNotFoundException Ex)
        {
            this.a1.setText("Error 404 Not Found File");
        }

    }
    public String getUrl()
    {
        return this.Url;
    }

    public String getMethod()
    {
        return this.method;
    }
    public String getRead()
    {
        return  this.read;
    }
    public void setRead(String seted)
    {
      this.read=seted;
    }
    public void setUrl(String url)
    {
     this.Url=url;
    }

    public void setDataStr(String dataStr)
    {
        this.dataStr = dataStr;

    }

    public Button getConvert2()
    {
        return convert2;
    }

    private void API_Currency() throws IOException, InterruptedException, JSONException {

        this.addParameter("to",this.to);
        this.addParameter("from",this.from);
        this.addParameter("amount",this.currency);
        DateTimeFormatter dtfDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime nowDate = LocalDateTime.now();
        this.addParameter("date",dtfDate.format(nowDate));
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.apilayer.com/fixer/convert?"+this.dataStr))
                .header("apikey", "iiX5nNTnykk9ZaOFD0c5bD83vYwdIAlu")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject jsonObject =new JSONObject(response.body());
        System.out.println(response.body());
        this.result=jsonObject.getString("result");
        this.setDataStr("");
        if(this.USD_convert1)
            this.convert.setText("Convert to USD");
        else
            this.convert.setText("Convert to EUR");

        if(this.USD_convert2)
            this.convert2.setText("Convert to USD");
        else
            this.convert2.setText("Convert to EUR");
    }
    public  void addPrice(String item)
    {

        this.Prices.add(item);
    }
    private void  Scale()
    {
        ScaleTransition scale=new ScaleTransition();
        scale.setNode(this.L1);
        scale.setDuration(Duration.millis(1000));
        scale.setCycleCount(TranslateTransition.INDEFINITE);
        scale.setInterpolator(Interpolator.LINEAR);
        scale.setByX(-0.1);
        scale.setByY(-0.1);
        scale.setAutoReverse(true);
        scale.play();

        ScaleTransition scale2=new ScaleTransition();
        scale2.setNode(this.L2);
        scale2.setDuration(Duration.millis(1000));
        scale2.setCycleCount(TranslateTransition.INDEFINITE);
        scale2.setInterpolator(Interpolator.LINEAR);
        scale2.setByX(0.1);
        scale2.setByY(0.1);
        scale2.setAutoReverse(true);
        scale2.play();
    }
    //Method End
private void hiehestgrrades()
    {

       try {
    if (Url.contains("http://127.0.0.1:80/NWIIASSII"))
        Url += "//highgrades.php";
    else if (Url.contains("http://localhost:8080/hello/responseServlet")) {
        addParameter("showitem", "No");
        addParameter("editnumitem", "No");
        addParameter("higest", "yes");
        addParameter("Withdraw", "No");
         addParameter("inseritem", "No");
           addParameter("showall", "No");
         addParameter("product", "No");
        
             addParameter("avarage", "No");
    }
    else if (Url.contains("http://localhost:8080/hello/showall.jsp")) {
        addParameter("showitem", "No");
        addParameter("editnumitem", "No");
        addParameter("higest", "yes");
        addParameter("Withdraw", "No");
         addParameter("inseritem", "No");
           addParameter("showall", "No");
             addParameter("product", "No");
        
             addParameter("avarage", "No");
    }

    this.Prices = new ArrayList<String>();
    read += "studentid" + "                          " + "name" + "                              " + "city" + "                              " + "grade" + "\n";

    if (this.method.equalsIgnoreCase("POST")) {
        sendData_POST();
    } else if (this.method.equalsIgnoreCase("GET")) {
        sendData_GET();
    }

    // Sort the data based on the grade in descending order
    List<String> sortedData = Arrays.asList(this.read.split("\n"));
    sortedData = sortedData.subList(1, sortedData.size()); // Remove the header line
    Collections.sort(sortedData, new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            int grade1 = Integer.parseInt(s1.trim().split("\\s+")[3]); // Assuming grade is the 4th column
            int grade2 = Integer.parseInt(s2.trim().split("\\s+")[3]);
            return Integer.compare(grade2, grade1); // Sort in descending order
        }
    });

    // Show the top 3 highest grades
    StringBuilder topThreeGrades = new StringBuilder("Top 3 Highest Grades:\n");
    for (int i = 0; i < Math.min(3, sortedData.size()); i++) {
        topThreeGrades.append(sortedData.get(i)).append("\n");
    }

    // Display the result in the GUI
    a1.setText(topThreeGrades.toString());

    setRead("");
    setDataStr("");
    getmethod();
} catch (ConnectException Ex) {
    a1.setText("The Server is Off");
} catch (FileNotFoundException Ex) {
    a1.setText("Error 404 Not Found File");
}
    }
    private void avarageeee()
    {
try {
    if (Url.contains("http://127.0.0.1:80/NWIIASSII"))
        Url += "//avarageeh.php"; // Corrected forward slash here
    else if (Url.contains("http://localhost:8080/hello/responseServlet")) {
        addParameter("showitem", "No");
        addParameter("editnumitem", "No");
        addParameter("avarage", "yes");
        addParameter("Withdraw", "No");
        addParameter("inseritem", "No");
        addParameter("showall", "No");
         addParameter("higest", "No");
         addParameter("product", "No");
    }
    else if (Url.contains("http://localhost:8080/hello/showall.jsp")) {
        addParameter("showitem", "No");
        addParameter("editnumitem", "No");
        addParameter("avarage", "yes");
        addParameter("Withdraw", "No");
        addParameter("inseritem", "No");
        addParameter("showall", "No");
         addParameter("higest", "No");
         addParameter("product", "No");
    }


    this.Prices = new ArrayList<String>();
    read += "id" + "                          " + "name" + "                              " + "city" + "                              " + "grade" + "\n";

    if (this.method.equalsIgnoreCase("POST")) {
        sendData_POST();
    } else if (this.method.equalsIgnoreCase("GET")) {
        sendData_GET();
    }

    // Display the data in the GUI
    a1.setText(this.read.replaceAll("Success", "").replaceAll("enter", "\n"));

    setRead("");
    setDataStr("");
    getmethod();
} catch (ConnectException Ex) {
    a1.setText("The Server is Off");
} catch (FileNotFoundException Ex) {
    a1.setText("Error 404 Not Found File");
} catch (Exception e) {
    a1.setText("An error occurred: " + e.getMessage());
}
    }

private void numberr()
    {
try {
    if (Url.contains("http://127.0.0.1:80/NWIIASSII"))
        Url += "//numberrrr.php";
    else if (Url.contains("http://localhost:8080/hello/responseServlet")) {
        addParameter("showitem", "No");
        addParameter("editnumitem", "No");
        addParameter("avarage", "No");
        addParameter("Withdraw", "No");
        addParameter("inseritem", "No");
        addParameter("showall", "No");
        addParameter("higest", "No");
        addParameter("product", "yes");
    }
  else if (Url.contains("http://localhost:8080/hello/showall.jsp")) {
        addParameter("showitem", "No");
        addParameter("editnumitem", "No");
        addParameter("avarage", "No");
        addParameter("Withdraw", "No");
        addParameter("inseritem", "No");
        addParameter("showall", "No");
        addParameter("higest", "No");
        addParameter("product", "yes");
    }

    this.Prices = new ArrayList<String>();
    read += "id" + "                          " + "name" + "                              " + "city" + "                              " + "grade" + "\n";

    if (this.method.equalsIgnoreCase("POST")) {
        sendData_POST();
    } else if (this.method.equalsIgnoreCase("GET")) {
        sendData_GET();
    }

    // Display the data in the GUI
    String resultData = this.read.replaceAll("Success", "").replaceAll("enter", "\n");

    // Calculate and display the number of students who passed and failed in Palestine
   

   

    // Calculate and display the number of students per city
   int totalStudents = resultData.split("\n").length - 1; // Subtract 1 for the header line
    int passedStudents = 0;
    int failedStudents = 0;

    String[] lines = resultData.split("\n");
    for (int i = 1; i < lines.length; i++) { // Skip the header line
        String[] columns = lines[i].split("\\s+");
        if (columns.length >= 4) {
            String grade = columns[3]; // Assuming grade is the 4th column
            int gradeValue = Integer.parseInt(grade);
            if (gradeValue >= 50) {
                passedStudents++;
            } else {
                failedStudents++;
            }
        }
    }

    String resultText = resultData + "\n\n";
   // resultText += "Total Students in Palestine: " + totalStudents + "\n";
   // resultText += "Passed Students in Palestine: " + passedStudents + "\n";
   // resultText += "Failed Students in Palestine: " + failedStudents + "\n";

    // Calculate and display the number of students per city
    Map<String, Integer> cityStudentsMap = new HashMap<>();
    for (int i = 1; i < lines.length; i++) { // Skip the header line
        String[] columns = lines[i].split("\\s+");
        if (columns.length >= 3) {
            String city = columns[2]; // Assuming city is the 3rd column
            cityStudentsMap.put(city, cityStudentsMap.getOrDefault(city, 0) + 1);
        }
    }
   // resultText += "\nNumber of Students per City:\n";
    for (Map.Entry<String, Integer> entry : cityStudentsMap.entrySet()) {
        resultText += entry.getKey() + ": " + entry.getValue() + "\n";
    }

    a1.setText(resultText);
    setRead("");
    setDataStr("");
    getmethod();
} catch (ConnectException Ex) {
    a1.setText("The Server is Off");
} catch (FileNotFoundException Ex) {
    a1.setText("Error 404 Not Found File");
} catch (Exception e) {
    a1.setText("An error occurred: " + e.getMessage());
}}

    private void search() {
       
     
 if (Url.contains("http://127.0.0.1:80/NWIIASSII")){
        Url += "//search.php"; 

        try {
            String studentName=namet.getText();
            String url = "http://127.0.0.1:80/NWIIASSII/search.php?name=" + studentName;

            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Assuming the response contains the grade or an error message from the PHP script
                String gradeOrError = response.toString();

                // Display the result in your GUI (e.g., set it to a label or text area)
                a1.setText(gradeOrError);
            } else {
                a1.setText("Error: " + responseCode);
            }
        } catch (Exception ex) {
            a1.setText("Error: " + ex.getMessage());
        }
    }
    }
        
        
        
        

 }