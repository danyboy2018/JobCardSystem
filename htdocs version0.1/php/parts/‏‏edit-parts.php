 <?php
//require ("conn.php");
require_once(realpath($_SERVER["DOCUMENT_ROOT"]) .'/php/conn.php');

if(($_POST['action'] == 'edit') && !empty($_POST['id'])){

  //file_put_contents('somefilename1.txt', print_r($_POST,true), FILE_APPEND);

    //update data
    $id =  $_POST['id'];
    $parts_name = $_POST['parts_name'];


    $update_rquery = mysqli_query($con,"UPDATE parts SET PartName = '$parts_name' WHERE IDparts = $id");
    $select_rquery = mysqli_query($con,"SELECT * FROM parts WHERE IDparts = $id");

    // Create a new array.
    $results = array();
    while($row = mysqli_fetch_assoc($select_rquery)){
        foreach($row as $cname => $cvalue){
          array_push($results, $cvalue);
        }
    }

    $id = $results[0];
    $part_name = $results[1];

    //file_put_contents('somefilename1.txt', $action_name, FILE_APPEND);


    $userData = array(
        'part_name' => $part_name
      );

    if(mysqli_affected_rows($con) > 0){
        $returnData = array(
            'status' => 'ok',
            'msg' => 'Part data has been updated successfully.',
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
