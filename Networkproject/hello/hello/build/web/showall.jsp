<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
  
   
        String result = "";
        if (request.getParameter("showall") != null && request.getParameter("showall").equalsIgnoreCase("yes")) {
            String query = "select * from students";
            Connection conn = null;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/inventorys";
                conn = DriverManager.getConnection(url, "root", "");

                if (conn != null) {
                    PreparedStatement stmt = conn.prepareStatement(query);
                    ResultSet rs = stmt.executeQuery();

                    while (rs.next()) {
                        result += rs.getString("id") + "                                ";
                        result += rs.getString("name") + "                                ";
                        result += rs.getString("city") + "                                ";
                        result += rs.getString("grade") + "                                " + "enter";
                    }
                } else {
                    result += "Failed to make a connection!";
                }
            } catch (ClassNotFoundException e) {
                out.print("Exception: " + e.getMessage());
                throw new RuntimeException(e);
            } catch (SQLException ex) {
                out.println(ex.toString());
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException ex) {
                    out.println(ex.toString());
                }
            }
        

        out.println(result);
          result="";}
        if (request.getParameter("higest") != null && request.getParameter("higest").equalsIgnoreCase("yes")) {  
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
                    result = resultBuilder.toString();
                } else {
                    result = "No students found";
                }
            } else {
                result = "Failed to make connection!";
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

    out.println(result);
     result = "";}

    if (request.getParameter("avarage") != null && request.getParameter("avarage").equalsIgnoreCase("yes")) {
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
                    result = resultBuilder.toString();
                } else {
                    result = "No students found";
                }
            } else {
                result = "Failed to make connection!";
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
     out.println(result);
result="";}

   
if(request.getParameter("inseritem").equalsIgnoreCase("yes"))
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
                              result = "Failed to make connection!";
                            }//else


                        } //try
                        catch (SQLException Ex)
                        {
                            if(Ex.getErrorCode()==1062)
                             result="Duplicate";
                            out.println(Ex.toString());
                        } catch (ClassNotFoundException e) {
                            out.println(e.toString());
                        }


                    }
                        out.println(result);
                        result="";
                }

 if(request.getParameter("product").equalsIgnoreCase("yes")){
             
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
           result = resultBuilder.toString();
        } else {
            result = "No students found";
        }
    } else {
       result = "Failed to make connection!";
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

out.println(result);
result = "";

            
            
            
            
        
        }

   
%>
