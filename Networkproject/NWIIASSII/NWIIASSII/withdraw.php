<?php


if (!isset($_REQUEST["ID"]) || !isset($_REQUEST["withdraw"])) {
    echo "Send Failed";
} else {
    try {


        $ID = $_REQUEST["ID"];
        $withdraw = $_REQUEST["withdraw"];
        $db = new mysqli('localhost', 'root', '', 'inventorys');
        $str1="select amount from item where ID='$ID'";
        $result=$db->query($str1);
        if($result->num_rows>0)
        {
            $row1 = $result->fetch_assoc();
            $amount = $row1["amount"];
            if ($amount > $withdraw) {
                $newamount = $amount - $withdraw;
                $str2 = " UPDATE  item set amount = '$newamount' where ID= '$ID'";
                $stmt2 = $db->prepare($str2);
                $stmt2->execute();
                echo "Success";
            } else {
                echo "We have only " . $amount . " of items";
            }
        }// if($result->num_rows>0)
        else if($result->num_rows==0)
            echo "Product Not Found";
    } //try
    catch (Exception $Ex)
    {
        echo "no connection";
    }
}

?>
