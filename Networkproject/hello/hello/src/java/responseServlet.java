/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.desktop.QuitEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Date;
import java.util.Queue;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author raed
 */
public class responseServlet extends HttpServlet {

private String result=new String("");
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            if (request.getParameter("showitem") != null || request.getParameter("editnumitem") != null || request.getParameter("showall") != null|| request.getParameter("inseritem") != null||request.getParameter("higest") != null||request.getParameter("inseritem") != null||request.getParameter("avarage") != null||request.getParameter("product") != null)
            {
                if (request.getParameter("showitem").equalsIgnoreCase("yes"))
                {
                    String ID = request.getParameter("ID");
                    String query = "select * from item where ID='" + ID + "'";

                    if (request.getParameter("ID") != null) {
                        Connection conn = null;
                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            String url = "jdbc:mysql://localhost:3306/inventorys";
                            conn = DriverManager.getConnection(url, "root", "");
                            if (conn != null) {
                                PreparedStatement stmt = conn.prepareStatement(query);
                                ResultSet rs = stmt.executeQuery(query);
                                if (rs.next()) {
                                    this.result = rs.getString("ID") + "                                ";
                                    this.result += rs.getString("price") + "                                " +
                                            rs.getString("type") + "                                " +
                                            rs.getString("amount") + "                                ";

                                }// if (rs.next())
                                else
                                    this.result = "Product Not Found";


                            } //   if (conn != null)

                            else {
                                this.result = "Failed to make connection!";
                            }//else


                        } //try
                        catch (ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        } catch (SQLException Ex) {
                            out.println(Ex.toString());
                        }

                    }// if(request.getParameter("ID")!=null)

                    else {
                        result = "Field in send data";
                    }
                    out.println(this.result);
                    this.result = "";

                } //   if (request.getParameter("showitem").equalsIgnoreCase("yes"))
                else if (request.getParameter("higest").equalsIgnoreCase("yes")){
    String query = "SELECT id, name, city, grade FROM students ORDER BY grade DESC LIMIT 3";

    Connection conn = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/inventorys";
        conn = DriverManager.getConnection(url, "root", "");

        if (conn != null) {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            StringBuilder resultBuilder = new StringBuilder();

            while (rs.next()) {
                String studentID = rs.getString("id");
                String name = rs.getString("name");
                String city = rs.getString("city");
                int grade = rs.getInt("grade");

                resultBuilder.append(studentID).append("                                ");
                resultBuilder.append(name).append("                                ");
                resultBuilder.append(city).append("                                ");
                resultBuilder.append(grade).append("                                ");
                resultBuilder.append("\n");
            }

            if (resultBuilder.length() > 0) {
                this.result = resultBuilder.toString();
            } else {
                this.result = "No students found";
            }
        } else {
            this.result = "Failed to make connection!";
        }

    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    } catch (SQLException Ex) {
        throw new RuntimeException(Ex);
    } finally {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    out.println(this.result);
    this.result = "";
}
                
                
                
                
                else if(request.getParameter("product").equalsIgnoreCase("yes")){
             
            String query = "SELECT id, name, city, grade FROM students ORDER BY grade DESC";

Connection conn = null;
try {  
    Class.forName("com.mysql.cj.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/inventorys";
    conn = DriverManager.getConnection(url, "root", "");

    if (conn != null) {
        
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        StringBuilder resultBuilder = new StringBuilder();
        int totalStudents = 0;
        int totalPassedStudents = 0;
        int totalFailedStudents = 0;

        // Create a map to store the count of students per city
        Map<String, Integer> cityStudentsMap = new HashMap<>();
        // Create a map to store the count of passed students per city
        Map<String, Integer> cityPassedStudentsMap = new HashMap<>();
        // Create a map to store the count of failed students per city
        Map<String, Integer> cityFailedStudentsMap = new HashMap<>();
      
        while (rs.next()) {
            String studentID = rs.getString("id");
            String name = rs.getString("name");
            String city = rs.getString("city");
            int grade = rs.getInt("grade");
            resultBuilder.append(studentID).append("                                ");
            resultBuilder.append(name).append("                                ");
            resultBuilder.append(city).append("                                ");
            resultBuilder.append(grade).append("                                ");
            resultBuilder.append("\n");

            totalStudents++;

            // Update the count of students per city
            cityStudentsMap.put(city, cityStudentsMap.getOrDefault(city, 0) + 1);

            // Update the count of passed students per city
            if (grade >= 50) {
                totalPassedStudents++;
                cityPassedStudentsMap.put(city, cityPassedStudentsMap.getOrDefault(city, 0) + 1);
            } else {
                totalFailedStudents++;
                cityFailedStudentsMap.put(city, cityFailedStudentsMap.getOrDefault(city, 0) + 1);
            }
        }

       // double averageGrade = (double) totalgrades / totalStudents;
       // resultBuilder.append("Average Grade: ").append(averageGrade).append("\n");

        // Show the total number of students who passed and failed in Palestine
        resultBuilder.append("Total Students in Palestine: ").append(totalStudents).append("\n");
        resultBuilder.append("Passed Students in Palestine: ").append(totalPassedStudents).append("\n");
        resultBuilder.append("Failed Students in Palestine: ").append(totalFailedStudents).append("\n");

        // Show the number of students per city
        resultBuilder.append("\nNumber of Students per City:\n");
        for (Map.Entry<String, Integer> entry : cityStudentsMap.entrySet()) {
            String city = entry.getKey();
            int totalCityStudents = entry.getValue();
            int passedCityStudents = cityPassedStudentsMap.getOrDefault(city, 0);
            int failedCityStudents = cityFailedStudentsMap.getOrDefault(city, 0);

            resultBuilder.append(city).append(": ").append(totalCityStudents).append("\n");
            resultBuilder.append("  Passed: ").append(passedCityStudents).append("\n");
            resultBuilder.append("  Failed: ").append(failedCityStudents).append("\n");
        }

        if (resultBuilder.length() > 0) {
            this.result = resultBuilder.toString();
        } else {
            this.result = "No students found";
        }
    } else {
        this.result = "Failed to make connection!";
    }

} catch (ClassNotFoundException e) {
    throw new RuntimeException(e);
} catch (SQLException ex) {
    throw new RuntimeException(ex);
} finally {
    try {
        if (conn != null) {
            conn.close();
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}

out.println(this.result);
this.result = "";

            
            
            
            
        
        }
                else if (request.getParameter("editnumitem").equalsIgnoreCase("yes"))
                {
                    if (request.getParameter("ID") != null && request.getParameter("amount") != null) {
                        String ID = request.getParameter("ID");
                        String amount = request.getParameter("amount");
                        String query = " select amount from item where ID='" + ID + "'";
                       // String query = " UPDATE item set amount='" + amount + "'where ID='" + ID + "'";
                        Connection conn = null;
                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            String url = "jdbc:mysql://localhost:3306/inventorys";
                            conn = DriverManager.getConnection(url, "root", "");
                            if (conn != null)
                            {

                                PreparedStatement stmt = conn.prepareStatement(query);
                               ResultSet rs=stmt.executeQuery();
                               if(rs.next())
                               {
                                   String oldamount=rs.getString("amount");
                                   String newamoumt=String.valueOf(Integer.parseInt(oldamount)+Integer.parseInt(amount));
                                   query = " UPDATE item set amount='" + newamoumt + "'where ID='" + ID + "'";
                                   stmt=conn.prepareStatement(query);
                                   stmt.executeUpdate();
                                   this.result = "The edited Done";
                               }//if(rs.next())
                                else
                                    this.result="Product Not Found";
                            } //   if (conn != null)

                            else
                            {
                                this.result = "Failed to make connection!";
                            }//else


                        } //try
                        catch (SQLException Ex)
                        {
                           result="Product Not Found";
                        } catch (ClassNotFoundException e) {
                            out.println(e.toString());
                        }

                    }// if(request.getParameter("ID")!=null && request.getParameter("amount")!=null)

                    else
                    {
                        result = "Field in send data";
                    }
                    out.println(this.result);
                    this.result = "";
                }// else if (request.getParameter("editnumitem").equalsIgnoreCase("yes"))

                else if (request.getParameter("showall").equalsIgnoreCase("yes")){
           
                    String query = "select * from students";
                    Connection conn = null;
                    try {
                       
                        Class.forName("com.mysql.cj.jdbc.Driver");
                    
                        String url = "jdbc:mysql://localhost:3306/inventorys";
                      
                    conn =DriverManager.getConnection(url, "root", "");
                      // this.result = "";
                  
                         this.result = "";
                        if (conn != null)
                        {
                            PreparedStatement stmt = conn.prepareStatement(query);
                            ResultSet rs = stmt.executeQuery(query);
                          
                            while (rs.next())
                            {
                                this.result += rs.getString("id") + "                                ";
                                this.result += rs.getString("name") + "                                " +
                                        rs.getString("city") + "                                " +
                                        rs.getString("grade") + "                                " + "enter";

                            }// while (rs.next())


                        } //   if (conn != null)

                        else
                        {
                            this.result += "Failed to make connection!";
                        }//else


                    } //try
                   catch (ClassNotFoundException e) {
                       out.print("lklklklklklklexeptiooooon");
                        throw new RuntimeException(e);
                        
                   } 
                catch (SQLException Ex) {
                        out.println(Ex.toString());
                        out.println("lllll");
                    }
                    out.println(this.result);
                    this.result = "";
                }// if (request.getParameter("showall").equals("yes"))

                else if(request.getParameter("Withdraw").equalsIgnoreCase("yes"))
                {
                    if (request.getParameter("ID") != null && request.getParameter("withdraw") != null)
                    {
                        String ID = request.getParameter("ID");
                        String withdraw = request.getParameter("withdraw");

                        String query = " select amount from item where ID='" + ID + "'";
                        Connection conn = null;
                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            String url = "jdbc:mysql://localhost:3306/inventorys";
                            conn = DriverManager.getConnection(url, "root", "");
                            if (conn != null)
                            {

                                PreparedStatement statement = conn.prepareStatement(query);
                              ResultSet rs=statement.executeQuery();
                              if(rs.next())
                              {
                                  String WI=rs.getString("amount");
                                  int amountold=Integer.parseInt(WI);
                                  int width=Integer.parseInt(withdraw);
                                  if(amountold<width)
                                  {
                                      this.result= "We have only "+ WI+" of items";
                                  }
                                  else
                                  {
                                      String newamount=String.valueOf(amountold-width);
                                      query="Update item set amount ='"+newamount+"' where ID ='"+ID+"'";
                                      statement=conn.prepareStatement(query);
                                      statement.executeUpdate();
                                      this.result="Success";

                                  }
                              }
                              else
                                  this.result="Product Not Found";

                            } //   if (conn != null)

                            else {
                                this.result = "Failed to make connection!";
                            }//else


                        } //try
                        catch (SQLException Ex) {
                            out.println(Ex.toString());
                        } catch (ClassNotFoundException e) {
                            out.println(e.toString());
                        }

                    }// if(request.getParameter("ID")!=null && request.getParameter("amount")!=null)

                    else {
                        result = "Field in send data";
                    }
                    out.println(this.result);
                    this.result = "";
                }//  else if(request.getParameter("Withdraw").equalsIgnoreCase("yes"))

                else if(request.getParameter("inseritem").equalsIgnoreCase("yes"))
                {
                    if( request.getParameter("name")!=null && request.getParameter("grade")!=null &&request.getParameter("city")!=null)
                    {
                       
                        String name=request.getParameter("name");
                        String grade=request.getParameter("grade");
                        String city=request.getParameter("city");
                        String query = "INSERT INTO students (name,city,grade) Values ('"+name+"','"+city+"','"+grade+"')";
                        Connection conn = null;
                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            String url = "jdbc:mysql://localhost:3306/inventorys";
                            conn = DriverManager.getConnection(url, "root", "");
                            if (conn != null)
                            {

                                PreparedStatement statement = conn.prepareStatement(query);
                                statement.executeUpdate();
                                result="Done";


                            } //   if (conn != null)

                            else {
                                this.result = "Failed to make connection!";
                            }//else


                        } //try
                        catch (SQLException Ex)
                        {
                            if(Ex.getErrorCode()==1062)
                                this.result="Duplicate";
                            out.println(Ex.toString());
                        } catch (ClassNotFoundException e) {
                            out.println(e.toString());
                        }


                    }
                        out.println(result);
                        result="";
                }
                
                else if (request.getParameter("avarage").equalsIgnoreCase("yes" ) ){
    String query = "SELECT id, name, city, grade FROM students ORDER BY grade DESC";

    Connection conn = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/inventorys";
        conn = DriverManager.getConnection(url, "root", "");

        if (conn != null) {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            StringBuilder resultBuilder = new StringBuilder();
            int totalStudents = 0;
            int totalGrades = 0;
            int excellentCount = 0;
            int veryGoodCount = 0;
            int goodCount = 0;
            int acceptableCount = 0;
            int failedCount = 0;

            while (rs.next()) {
                String studentID = rs.getString("id");
                String name = rs.getString("name");
                String city = rs.getString("city");
                int grade = rs.getInt("grade");

                resultBuilder.append(studentID).append("                                ");
                resultBuilder.append(name).append("                                ");
                resultBuilder.append(city).append("                                ");
                resultBuilder.append(grade).append("                                ");
                resultBuilder.append("\n");

                totalStudents++;
                totalGrades += grade;

                // Update the grade distribution counts
                if (grade >= 90) {
                    excellentCount++;
                } else if (grade >= 80) {
                    veryGoodCount++;
                } else if (grade >= 70) {
                    goodCount++;
                } else if (grade >= 60) {
                    acceptableCount++;
                } else {
                    failedCount++;
                }
            }

            double averageGrade = (double) totalGrades / totalStudents;
            resultBuilder.append("Average Grade: ").append(averageGrade).append("\n");
            resultBuilder.append("Grade Distribution:\n");
            resultBuilder.append("Excellent: ").append(excellentCount).append("\n");
            resultBuilder.append("Very Good: ").append(veryGoodCount).append("\n");
            resultBuilder.append("Good: ").append(goodCount).append("\n");
            resultBuilder.append("Acceptable: ").append(acceptableCount).append("\n");
            resultBuilder.append("Failed: ").append(failedCount).append("\n");

            if (resultBuilder.length() > 0) {
                this.result = resultBuilder.toString();
            } else {
                this.result = "No students found";
            }
        } else {
            this.result = "Failed to make connection!";
        }

    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    } catch (SQLException Ex) {
        throw new RuntimeException(Ex);
    } finally {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    out.println(this.result);
    this.result = "";
}





//  else if(request.getParameter("inseritem").equalsIgnoreCase("yes"))

        }
//if (request.getParameter("showitem") != null || request.getParameter("editnumitem") != null || request.getParameter("showall") != null)
else
    out.println("IllegalComunication");


        }//   try (PrintWriter out = response.getWriter())

    }



    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
