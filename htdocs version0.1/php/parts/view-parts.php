<?php
require ("php/conn.php");
    //Query the database for the results we want
    $project_query = mysqli_query($con,"SELECT * FROM projects");
    $parts_query = mysqli_query($con,"SELECT * FROM parts");


    //Create an array  of objects for each returned row
    while($project_results[] = $project_query->fetch_object());
    while($parts_results[] = $parts_query->fetch_object());


    array_pop($project_results);
    array_pop($parts_results);

?>
