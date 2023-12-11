<?php
try {


    $db = new mysqli('localhost', 'root', '', 'inventorys');
    echo "Success";
    $str="select * from students";
    $result=$db->query($str);
    for($i=0;$i<$result->num_rows;$i++)
    {
        $row = $result->fetch_assoc();
        echo $row["id"]."                                ";
        echo  $row["name"]."                                ";
        echo $row["city"]."                                ";
        echo $row["grade"]."                                "."enter";
    }


}
catch (Exception $ex)
{
    echo "no connection";
}
?>
