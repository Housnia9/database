<?php
if(!isset($_REQUEST["ID"]))
{
    echo "Send Failed";
}
else
{
    try {


        $ID = $_REQUEST["ID"];
        $db = new mysqli('localhost', 'root', '', 'inventorys');
        $str = "select * from item  where ID= " . $ID;
        $result = $db->query($str);
        if($result->num_rows>0) {
            $row = $result->fetch_assoc();
            echo $row["ID"] . "                                " . $row["price"] . "                                " . $row["type"] . "                                " . $row["amount"];
        }// if($result->num_rows>0)
        else if($result->num_rows==0)
            echo "Product Not Found";

    }
    catch (ConnectionException $Ex)
    {
        echo "no connection";
    }
    catch (mysqli_sql_exception $Ex)
    {
        echo $Ex->getCode()."                 ";
        if($Ex->getCode()==1072)
        echo "Not existed";

    }
}
?>
