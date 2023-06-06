 <?php
//require ("conn.php");
require_once(realpath($_SERVER["DOCUMENT_ROOT"]) .'/php/conn.php');

//file_put_contents('somefilename1.txt', print_r($_POST,true), FILE_APPEND);


if(($_POST['action'] == 'delete') && !empty($_POST['id'])){

    //file_put_contents('somefilename1.txt', print_r($_POST,true), FILE_APPEND);

    $id =  $_POST['id'];
    //$jobcarf_query = mysqli_query($con,"DELETE FROM jobcard WHERE IDprojects = '$id'");
    $parts_query = mysqli_query($con,"DELETE FROM parts WHERE IDprojects = '$id'");
    $projects_query = mysqli_query($con,"DELETE FROM projects WHERE IDprojects = '$id'");

    file_put_contents('some1.txt', $parts_query, FILE_APPEND);
    file_put_contents('some2.txt', $projects_query, FILE_APPEND);


    file_put_contents('some3.txt', print_r(mysqli_affected_rows($con),true), FILE_APPEND);



    if(mysqli_affected_rows($con) > 0){
        $returnData = array(
            'status' => 'ok',
            'msg' => 'projects data has been deleted successfully.'
        );
    }else{
        $returnData = array(
            'status' => 'error',
            'msg' => 'to delete the project you have to delete all the reference in the system'
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
