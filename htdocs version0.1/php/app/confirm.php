<?php
require ("conn.php"); 
$confirm = $_POST["confirm"];
$role = $_POST["role"];


$result = mysqli_query($con,"UPDATE JobConfirmation SET `$role` = '$confirm' WHERE id = 1");

//var_dump($result);

if($result == true) {
    echo '{"query_result":"SUCCESS"}';
}
else{
    echo '{"query_result":"FAILURE"}';
}
mysqli_close($con);
?>