 <?php
//require ("conn.php");
require_once(realpath($_SERVER["DOCUMENT_ROOT"]) .'/php/conn.php');

if(($_POST['action'] == 'edit') && !empty($_POST['id'])){

  //file_put_contents('somefilename1.txt', print_r($_POST,true), FILE_APPEND);

    //update data
    $id =  $_POST['id'];
    $project_name = $_POST['project_name'];


    $update_rquery = mysqli_query($con,"UPDATE projects SET projectsName = '$project_name' WHERE IDprojects = $id");
    $select_rquery = mysqli_query($con,"SELECT * FROM projects WHERE IDprojects = $id");

    // Create a new array.
    $results = array();
    while($row = mysqli_fetch_assoc($select_rquery)){
        foreach($row as $cname => $cvalue){
          array_push($results, $cvalue);
        }
    }

    $id = $results[0];
    $project_name = $results[1];

    //file_put_contents('somefilename1.txt', $project_name, FILE_APPEND);


    $userData = array(
        'project_name' => $project_name
      );

    if(mysqli_affected_rows($con) > 0){
        $returnData = array(
            'status' => 'ok',
            'msg' => 'Project data has been updated successfully.',
            'data' => $userData
        );
    }else{
        $returnData = array(
            'status' => 'error',
            'msg' => 'Some problem occurred, please try again.',
            'data' => ''
        );
    }

    echo json_encode($returnData);
}
?>
