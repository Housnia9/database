<?php
$db = new mysqli('localhost', 'root', '', 'inventorys');

if ($db->connect_errno) {
    echo "Failed to connect to MySQL: " . $db->connect_error;
    exit();
}

// Calculate average grade and grade distribution
$query = "SELECT grade FROM students";
$result = $db->query($query);

$totalStudents = $result->num_rows;
$totalGrades = 0;
$excellentCount = 0;
$veryGoodCount = 0;
$goodCount = 0;
$acceptableCount = 0;
$failedCount = 0;

while ($row = $result->fetch_assoc()) {
    $grade = $row['grade'];
    $totalGrades += $grade;

    if ($grade >= 90) {
        $excellentCount++;
    } elseif ($grade >= 80) {
        $veryGoodCount++;
    } elseif ($grade >= 70) {
        $goodCount++;
    } elseif ($grade >= 60) {
        $acceptableCount++;
    } else {
        $failedCount++;
    }
}

$result->free();

$averageGrade = $totalGrades / $totalStudents;
$gradeDistribution = [
    "Excellent" => $excellentCount,
    "Very Good" => $veryGoodCount,
    "Good" => $goodCount,
    "Acceptable" => $acceptableCount,
    "Failed" => $failedCount
];

// Retrieve the top three highest grades
$query = "SELECT id, name, city, grade FROM students ORDER BY grade DESC LIMIT 3";
$result = $db->query($query);

if ($result) {
    $topThreeGrades = array();

    while ($row = $result->fetch_assoc()) {
        $topThreeGrades[] = $row;
    }

    $result->free();

    // Create an array to hold all the data
    $data = [
        "average_grade" => $averageGrade,
        "grade_distribution" => $gradeDistribution,
        "top_three_grades" => $topThreeGrades
    ];

    // Return the data in JSON format
    echo json_encode($data);
} else {
    echo "Error executing query: " . $db->error;
}

$db->close();
?>
