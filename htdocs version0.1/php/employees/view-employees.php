<?php
require ("php/conn.php");
    //Query the database for the results we want
    $employees_query = mysqli_query($con,"SELECT * FROM employees");
    $actions_query = mysqli_query($con,"SELECT * FROM actions");


    //Create an array  of objects for each returned row
    while($employees_results[] = $employees_query->fetch_object());
    while($actions_results[] = $actions_query->fetch_object());


    array_pop($employees_results);
    array_pop($actions_results);

?>
