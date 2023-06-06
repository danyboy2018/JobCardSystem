<?php
require_once(realpath($_SERVER["DOCUMENT_ROOT"]) .'/php/app/conn.php');

$userName = $_POST["username"];
$passWord = $_POST["password"];

$result = mysqli_query($con,"SELECT firstName,lastName,username,password FROM employees WHERE username = '$userName' and password = $passWord");
$fullname = array();

if(mysqli_num_rows($result) > 0 ) {

    while($row = mysqli_fetch_assoc($result)) {
        $firstname = $row['firstName'];
        $lastname = $row['lastName'];
        $username = $row['username'];
        $password = $row['password'];

    }

    $data = [ 'query_result' => 'SUCCESS', 'firstname' => $firstname , 'lastname' => $lastname, 'username' => $username , 'password' => $password];
    echo json_encode( $data );

}
else{
    echo '{"query_result":"FAILURE"}';
}
mysqli_close($con);
?>
