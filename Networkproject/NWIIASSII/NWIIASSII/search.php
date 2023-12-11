<?php
if (!isset($_REQUEST["name"])) {
    echo "Name parameter not provided";
} else {
    try {
        $name = $_REQUEST["name"];

        // Create a new database connection
        $db = new mysqli('localhost', 'root', '', 'inventorys');

        // Prepare and execute the SQL query
        $stmt = $db->prepare("SELECT grade FROM students WHERE name = ?");
        $stmt->bind_param("s", $name);
        $stmt->execute();
        $stmt->bind_result($grade);
        
        if ($stmt->fetch()) {
            // If a row is found, display the grade
            echo "Grade for " . $name . ": " . $grade;
        } else {
            // If no row is found, the student is not in the database
            echo "Grade not found for " . $name;
        }

        $stmt->close();
        $db->close();

    } catch (mysqli_sql_exception $Ex) {
        echo "Error: " . $Ex->getMessage();
    } catch (ConnectionException $Ex) {
        echo "No connection";
    } catch (Exception $exception) {
        echo $exception->getMessage();
    }
}
?>
