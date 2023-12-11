<?php
$db = new mysqli('localhost', 'root', '', 'inventorys');

if ($db->connect_errno) {
    echo "Failed to connect to MySQL: " . $db->connect_error;
    exit();
}

$query = "SELECT id, name, city, grade FROM students ORDER BY grade DESC LIMIT 3";
$result = $db->query($query);

if ($result) {
    $topThreeGrades = array();

    while ($row = $result->fetch_assoc()) {
        $topThreeGrades[] = $row;
    }

    $result->free();

    // Return the data in JSON format
    echo json_encode($topThreeGrades);
} else {
    echo "Error executing query: " . $db->error;
}

$db->close();
?>
