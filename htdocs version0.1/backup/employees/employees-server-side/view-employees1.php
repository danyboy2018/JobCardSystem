<?php require ("php/view-employees-server-side.php"); ?>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <link rel="shortcut icon" href="vendor/assets/favicon.ico">
  <link rel="stylesheet" type="text/css" href="css/add-employee-style.css">


  <title>JobCard System</title>

  <link rel="stylesheet" href="css/bootstrap-multiselect.css" type="text/css"/>


  <!-- Bootstrap core CSS-->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">

  <!-- Navigation-->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="index.html">JobCard System</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">

        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Home">
          <a class="nav-link" href="index.html">
            <i class="fa fa-fw fa-home"></i>
            <span class="nav-link-text">Home</span>
          </a>
        </li>

        <!-- /. (Create, read, update and delete) Employee -->

        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Employees">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-users"></i>
            <span class="nav-link-text">Employees</span>
          </a>
          <ul class="sidenav-second-level collapse" id="collapseMulti">
            <li>
              <a href="view-employees.php">View employees</a>
            </li>
            <li>
              <a href="add-employee.php">Add Employee</a>
            </li>
            <li>
              <a href="edit-employee.php">Edit Employee</a>
            </li>
            <li>
              <a href="#">Deleting Employee</a>
            </li>
          </ul>
        </li>

        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Actions">
          <a class="nav-link" href="charts.html">
            <i class="fa fa-fw fa-rocket"></i>
            <span class="nav-link-text">Actions</span>
          </a>
        </li>

        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Parts">
          <a class="nav-link" href="charts.html">
            <i class="fa fa-fw fa fa-gears"></i>
            <span class="nav-link-text">Parts</span>
          </a>
        </li>

        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="JobCard">
          <a class="nav-link" href="tables.html">
            <i class="fa fa-fw fa-check-square-o"></i>
            <span class="nav-link-text">JobCard</span>
          </a>
        </li>

        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Project">
          <a class="nav-link" href="tables.html">
            <i class="fa fa-fw fa-folder-open-o"></i>
            <span class="nav-link-text">Project</span>
          </a>
        </li>
      </ul>


      <ul class="navbar-nav sidenav-toggler">
        <li class="nav-item">
          <a class="nav-link text-center" id="sidenavToggler">
            <i class="fa fa-fw fa-angle-left"></i>
          </a>
        </li>
      </ul>

      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <form class="form-inline my-2 my-lg-0 mr-lg-2">
            <div class="input-group">
              <input class="form-control" type="text" placeholder="Search for...">
              <span class="input-group-append">
                <button class="btn btn-primary" type="button">
                  <i class="fa fa-search"></i>
                </button>
              </span>
            </div>
          </form>
        </li>
        <li class="nav-item">
          <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
            <i class="fa fa-fw fa-sign-out"></i>Logout</a>
        </li>
      </ul>
    </div>
  </nav>



  <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">JobCard System</a>
        </li>
        <li class="breadcrumb-item active">View Employees</li>
      </ol>


      <div class="form-group">
        <div class="col-xs-12 col-sm-6 col-md-6" id="alert">
          <?php
            //Check for success flag in get query param
            $ok = isset($_GET['ok']);

            //Insert this code where you wanted to show the msg
            if($ok)  {
                 echo '<div class="alert alert-success in text-center" role="alert" id="disappeared">
                         <strong>success!</strong> employee added to the system.
                       </div>';
            }
          ?>
        </div>
      </div>


      <!-- Example DataTables Card-->
      <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> Employees Data Table

          <!-- Large modal -->
          <button type="button" class="btn btn-secondary float-right" data-toggle="modal" data-target=".bd-example-modal-lg"> + New Employee</button>
          <div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
              <div class="modal-content">
                <!-- Modal Header -->
                <div class="modal-header">
                  <h4 class="modal-title">Please Add New Employee</h4>
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">

                  <form action="php/add-employee_server_side.php" method="post">
                    <div class="row">
                      <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                          <input type="text" name="first_name" id="first_name" class="form-control input-lg" placeholder="First Name" tabindex="1">
                        </div>
                      </div>
                      <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                          <input type="text" name="last_name" id="last_name" class="form-control input-lg" placeholder="Last Name" tabindex="2">
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                          <input type="text" name="UserName" id="UserName" class="form-control input-lg" placeholder="UserName" tabindex="1">
                        </div>
                      </div>
                      <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                          <input type="text" name="Password" id="Password" class="form-control input-lg" placeholder="Password" tabindex="2">
                        </div>
                      </div>
                    </div>

                    <div class="row">
                      <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group" id="my_centered_text_select">
                          <h2><small><p class="font-weight-light"><b>Select Actions :</b></p></small></h2>
                        </div>
                      </div>
                        <div class="col-xs-12 col-sm-6 col-md-6">
                            <div class="form-group" >
                              <select class="custom" name="ary[]" id="basic" multiple="multiple" >
                                <?php foreach ( $actions_results as $option ) : ?>
                                  <option value="<?php echo $option->IDactions; ?>"> <?php echo $option->ActionsName; ?> </option>
                                <?php endforeach; ?>
                               </select>
                            </div>
                        </div>
                    </div>

                    <!-- Modal footer -->
                    <div class="modal-footer">
                      <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                      <button type="submit" class="btn btn-primary">Save changes</button>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>



        </div>
        <div class="card-body">
          <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>Number</th>
                  <th>First Name</th>
                  <th>Last Name</th>
                  <th>Username</th>
                  <th>Password</th>
                  <th>delete</th>
                </tr>
              </thead>
              <tfoot>
                <tr>
                  <th>Number</th>
                  <th>First Name</th>
                  <th>Last Name</th>
                  <th>Username</th>
                  <th>Password</th>
                  <th>delete</th>
                </tr>
              </tfoot>
              <tbody>
                <?php
                  $i = 1;
                  foreach ( $employees_results as $option ) :
                    if($option->firstName == "")
                    {
                      continue;
                    }
                    echo "<tr>";
                    echo "<td>" . $i . "</td>";
                    echo "<td>" . $option->firstName . "</td>";
                    echo "<td>" . $option->lastName . "</td>";
                    echo "<td>" . $option->username . "</td>";
                    echo "<td>" . $option->password . "</td>";
                    echo "<td><a href=\"http://localhost/php/delete-employee.php?id=".$option->IDemployees."\">delete</a></td>";
                    echo "</tr>";
                    $i = $i + 1;
                   endforeach;
                 ?>
              </tbody>
            </table>
          </div>
        </div>
        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
      </div>
    </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <footer class="sticky-footer">
      <div class="container">
        <div class="text-center">
          <small>Copyright © Self Ltd 2023</small>
        </div>
      </div>
    </footer>
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>
    <!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            <a class="btn btn-primary" href="login.html">Logout</a>
          </div>
        </div>
      </div>
    </div>
    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Page level plugin JavaScript-->
    <script src="vendor/datatables/jquery.dataTables.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin.min.js"></script>
    <!-- Custom scripts for this page-->
    <script src="js/sb-admin-datatables.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <script src="vendor/bootstrap/js/bootstrap-multiselect.js"></script>


    <script src="js/dropdown-checkbox.js"></script>

    <script src="js/successfull-added-employee.js"></script>

  </div>

</body>

</html>
<?php require ("php/close-conn.php"); ?>
