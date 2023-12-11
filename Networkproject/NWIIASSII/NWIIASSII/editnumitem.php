<?php
if(!isset($_REQUEST["ID"])||!isset($_REQUEST["amount"]))
{
    echo "Send Failed";
}
else
{
    try
    {


        $ID = $_REQUEST["ID"];
        $amount = $_REQUEST["amount"];
        $db = new mysqli('localhost', 'root', '', 'inventorys');
        $str1="select amount from item where ID='$ID'";
        $result=$db->query($str1);
        if($result->num_rows>0)
        {
            $row = $result->fetch_assoc();
            $oldamount = $row["amount"];
            $newamount=$oldamount+$amount;
            $str = " UPDATE  item set amount = '$newamount' where ID= '$ID'";
            $stmt2 = $db->prepare($str);
            $stmt2->execute();
            echo "The edited Done";
        }
        else if($result->num_rows==0)
            echo "Product Not Found";
    }
    catch (Exception $Ex)
    {
        echo "no connection";
    }
}
?>
