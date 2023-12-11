<?php
if(!isset($_REQUEST["ID"]) || !isset($_REQUEST["password"]))
{
    echo "Not set";
}
else
{
    $ID=$_REQUEST["ID"];
    $pw=$_REQUEST["password"];
    $login="false";
    $lastseen="";
    try {


        $db = new mysqli('localhost', 'root', '', 'inventorys');
        echo "Success";
        $str="select * from employee";
        $result=$db->query($str);
        for($i=0;$i<$result->num_rows;$i++)
        {
            $row = $result->fetch_assoc();
            if($row["ID"]==$ID && $row["password"]==$pw)
            {
               $login="true";
               $lastseen=$row["lastaccess"];
                break;
            }
        }
        echo $login;
        echo " ".$lastseen;

    }
    catch (Exception $ex)
    {
        echo "no connection";
    }
}

?>