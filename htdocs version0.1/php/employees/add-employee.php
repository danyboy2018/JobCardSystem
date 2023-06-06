<?php
//require ("../php/conn.php");
require_once(realpath($_SERVER["DOCUMENT_ROOT"]) .'/php/conn.php');


$first_name = $_POST["first_name"];
$last_name = $_POST["last_name"];
$UserName = $_POST["UserName"];
$Password = $_POST["Password"];
$selected_values = $_POST['ary'];



$result = mysqli_query($con,"INSERT INTO employees (firstName, lastName, username , password)
          VALUES ('$first_name', '$last_name', '$UserName' , '$Password')");

$id_employees_result = mysqli_query($con,"SELECT IDemployees FROM employees
  WHERE firstName = '$first_name' AND lastName = '$last_name';");

while($row = mysqli_fetch_assoc($id_employees_result)) {
    $id_employees = $row['IDemployees'];
}

foreach ($selected_values as $values){
  $result_of_selected = mysqli_query($con,"INSERT INTO actionsworksmatch (IDemployees, IDactions)
            VALUES ('$id_employees', '$values')");
}

if($result AND $result_of_selected == true) {
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
header('Location: http://localhost/employees.php?ok='.$ok);

mysqli_close($con);
?>
