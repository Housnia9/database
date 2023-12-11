<?php
/*if(!isset($_REQUEST["Date"]) || !isset($_REQUEST["ID"]))
{
    echo "Not Set";
}
else
{
    $Date=$_REQUEST["Date"];
    $ID=$_REQUEST["ID"];
    $db = new mysqli('localhost', 'root', '', 'inventorys');
    echo "Success";
    $str="Update employee SET lastaccess='$Date'"."where ID='$ID'";
    $stmt = $db->prepare($str);
    $stmt->execute();
    echo "Success";
}*/
if( !isset($_REQUEST["ID"]))
{
    echo "Not Set";
}
else
{

    try
    {
        $ID = $_REQUEST["ID"];
        $db = new mysqli('localhost', 'root', '', 'inventory');
        $Date =  date ('Y-m-d H:i:s');
        echo $Date;
        $str = "Update employee SET lastaccess='$Date' where ID='$ID'" ;
        $stmt = $db->prepare($str);
        $stmt->execute();
        echo "Success";
    }
    catch (Exception $Ex)
    {
        echo "no connection";
    }
}
?>
