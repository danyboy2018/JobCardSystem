<?php
require ("php/conn.php");
    //Query the database for the results we want
    //$employees_query = mysqli_query($con,"SELECT * FROM employees");
    $jobcard_query = mysqli_query($con,"SELECT projectsName,PartName
      FROM jobcard,parts,projects
      WHERE jobcard.IDparts = parts.IDparts
      AND parts.IDprojects = projects.IDprojects
      ORDER BY jobcard.IDjobcards");

      $project_query = mysqli_query($con,"SELECT * FROM projects");
      $parts_query = mysqli_query($con,"SELECT * FROM parts");

      while($project_results[] = $project_query->fetch_object());
      while($parts_results[] = $parts_query->fetch_object());

      array_pop($project_results);
      array_pop($parts_results);


    //Create an array  of objects for each returned row
    //while($employees_results[] = $employees_query->fetch_object());
    while($jobcard_results[] = $jobcard_query->fetch_object());


    //array_pop($employees_results);
    array_pop($jobcard_results);

?>
