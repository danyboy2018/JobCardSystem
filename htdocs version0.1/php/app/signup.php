<?php
require ("conn.php"); 

$fullName = $_POST["fullname"];
$userName = $_POST["username"];
$passWord = $_POST["password"];
$Role = $_POST["role"];

 
$result = mysqli_query($con,"INSERT INTO user (fullname, username, password, role) 
          VALUES ('$fullName', '$userName', '$passWord','$Role')");
 
if($result == true) {
    echo '{"query_result":"SUCCESS"}';
}
else{
    echo '{"query_result":"FAILURE"}';
}
mysqli_close($con);
?>