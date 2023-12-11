<?php
if (!isset($_REQUEST["name"]) || !isset($_REQUEST["city"]) || !isset($_REQUEST["grade"])) {
    echo "Not Set";
} else {
    try {
        $name = $_REQUEST["name"];
        $city = $_REQUEST["city"];
        $grade = $_REQUEST["grade"];

        // Create a new database connection
        $db = new mysqli('localhost', 'root', '', 'inventorys');

        // Prepare and execute the SQL query
        $stmt = $db->prepare("INSERT INTO students (name, city, grade) VALUES (?, ?, ?)");
        $stmt->bind_param("ssi", $name, $city, $grade);
        $stmt->execute();

        echo "Done";
    } catch (mysqli_sql_exception $Ex) {
        if ($Ex->getCode() == 1062)
            echo "Duplicate";
        else
            echo "Error: " . $Ex->getMessage();
    } catch (ConnectionException $Ex) {
        echo "No connection";
    } catch (Exception $exception) {
        echo $exception->getMessage();
    }
}
?>
