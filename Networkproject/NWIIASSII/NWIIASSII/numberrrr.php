<?php
$db = new mysqli('localhost', 'root', '', 'inventorys');

if ($db->connect_errno) {
    die("Failed to connect to MySQL: " . $db->connect_error);
}

// Calculate and display the number of students who passed and failed in Palestine
$query = "SELECT grade FROM students";
$result = $db->query($query);

if (!$result) {
    die("Error executing query: " . $db->error);
}

$totalStudents = $result->num_rows;
$passedStudents = 0;
$failedStudents = 0;

while ($row = $result->fetch_assoc()) {
    $grade = $row['grade'];
    if ($grade >= 50) {
        $passedStudents++;
    } else {
        $failedStudents++;
    }
}

$result->free();

// Calculate and display the number of students per city
$query = "SELECT city, COUNT(*) AS num_students FROM students GROUP BY city";
$result = $db->query($query);

if (!$result) {
    die("Error executing query: " . $db->error);
}

$cityStudentsMap = array();
while ($row = $result->fetch_assoc()) {
    $city = $row['city'];
    $numStudents = $row['num_students'];
    $cityStudentsMap[$city] = $numStudents;
}

$result->free();
$db->close();

// Create an array to hold all the data
$data = [
    "total_students" => $totalStudents,
    "passed_students" => $passedStudents,
    "failed_students" => $failedStudents,
    "city_students" => $cityStudentsMap
];

// Return the data in JSON format
header('Content-Type: application/json');
echo json_encode($data);
?>