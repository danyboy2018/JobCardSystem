<?php
$server_name = "localhost";
$mysql_username = "root";
$mysql_password = "";
$db_name = "a_system";

$con = mysqli_connect($server_name,$mysql_username,$mysql_password,$db_name);
if (mysqli_connect_errno($con))
{
   echo '{"query_result":"ERROR"}';
}
?>
