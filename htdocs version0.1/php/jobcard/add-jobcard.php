<?php
//require ("../php/conn.php");
require_once(realpath($_SERVER["DOCUMENT_ROOT"]) .'/php/conn.php');

$actions_name = $_POST["actions_name"];
$result = mysqli_query($con,"INSERT INTO actions (ActionsName) VALUES ('$actions_name')");

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
header('Location: http://localhost/actions.php?ok='.$ok);

mysqli_close($con);
?>
