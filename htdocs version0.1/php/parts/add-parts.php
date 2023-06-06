<?php
//require ("../php/conn.php");
require_once(realpath($_SERVER["DOCUMENT_ROOT"]) .'/php/conn.php');

$parts_name = $_POST["parts_name"];
$id_projects = $_POST['selectedOption'];

$result = mysqli_query($con,"INSERT INTO parts (IDparts, PartName, IDprojects) VALUES (NULL, '$parts_name', (SELECT IDprojects FROM projects WHERE IDprojects = '$id_projects'))");

file_put_contents('some.txt', $result, FILE_APPEND);

if($result == true) {
  //$msg ='<div class="alert alert-success">Thank You! I will be in touch</div>';
  //$msg = 'success';
  $ok = 1;
}
else{
    $ok = 0;
    //$msg='<div class="alert alert-danger">Sorry there was an error sending your message. Please try again later</div>';
    //$msg = 'error';
    //echo '{"query_result":"FAILURE"}';
}
header('Location: http://localhost/parts.php?ok='.$ok);

mysqli_close($con);
?>
