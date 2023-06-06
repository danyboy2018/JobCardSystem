 <?php
//require ("conn.php");
require_once(realpath($_SERVER["DOCUMENT_ROOT"]) .'/php/conn.php');

//file_put_contents('somefilename1.txt', print_r($_POST,true), FILE_APPEND);


if(($_POST['action'] == 'delete') && !empty($_POST['id'])){

    //file_put_contents('somefilename1.txt', print_r($_POST,true), FILE_APPEND);

    $id =  $_POST['id'];

    $actionsworksmatch_query = mysqli_query($con,"DELETE FROM actionsworksmatch WHERE IDactions = '$id'");
    $actiontaken_query = mysqli_query($con,"DELETE FROM actiontaken WHERE IDactions = '$id'");
    $actions_query = mysqli_query($con,"DELETE FROM actions WHERE IDactions = '$id'");


    //file_put_contents('some.txt', print_r(mysqli_affected_rows($con),true), FILE_APPEND);


    if(mysqli_affected_rows($con) > 0){
        $returnData = array(
            'status' => 'ok',
            'msg' => 'Action data has been deleted successfully.'
        );
    }else{
        $returnData = array(
            'status' => 'error',
            'msg' => 'Some problem occurred, please try again.'
        );
    }

    echo json_encode($returnData);


}
/*
$actionsworksmatch_query = mysqli_query($con,"DELETE FROM actionsworksmatch WHERE IDemployees = '$id'");
$actiontaken_query = mysqli_query($con,"DELETE FROM actiontaken WHERE IDemployees = '$id'");
$employees_query = mysqli_query($con,"DELETE FROM employees WHERE IDemployees = '$id'");

header('Location: http://localhost/view-employees.php');
*/
?>
