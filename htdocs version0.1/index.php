<?php require ("php/actiontaken/view-actiontaken.php"); ?>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <link rel="shortcut icon" href="vendor/assets/favicon.ico">
  <link rel="stylesheet" type="text/css" href="css/‏‏add-actions-style.css">


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
      <a class="navbar-brand" href="index.php">JobCard System</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">

          <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Home">
            <a class="nav-link" href="index.php">
              <i class="fa fa-fw fa-home"></i>
              <span class="nav-link-text">Home</span>
            </a>
          </li>

          <!-- /. (Create, read, update and delete)  -->
          <li class="nav-item" data-toggle="tooltip" data-placement="right" title="JobCard">
            <a class="nav-link" href="jobcard.php">
              <i class="fa fa-fw fa-check-square-o"></i>
              <span class="nav-link-text">JobCard</span>
            </a>
          </li>

          <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Parts">
            <a class="nav-link" href="parts.php">
              <i class="fa fa-fw fa fa-gears"></i>
              <span class="nav-link-text">Parts</span>
            </a>
          </li>

          <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Project">
            <a class="nav-link" href="projects.php">
              <i class="fa fa-fw fa-folder-open-o"></i>
              <span class="nav-link-text">Project</span>
            </a>
          </li>

          <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Employees">
            <a class="nav-link" href="employees.php">
              <i class="fa fa-fw fa-users"></i>
              <span class="nav-link-text">Employees</span>
            </a>
          </li>

          <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Actions">
            <a class="nav-link" href="actions.php">
              <i class="fa fa-fw fa-rocket"></i>
              <span class="nav-link-text">Actions</span>
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
          <li class="breadcrumb-item active">Home</li>
        </ol>


        <!-- Example DataTables Card-->
        <div class="card mb-3">
          <div class="card-header">
            <i class="fa fa-table"></i> Action-taken Data Table
          </div>

          <div class="card-body">
            <div class="table-responsive">
              <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                  <tr>
                    <th>#</th>
                    <th>Action Name</th>
                    <th>Project Name</th>
                    <th>Part Name</th>
                    <th>Employee Name</th>
                    <th>Comments</th>
                  </tr>
                </thead>
                <tfoot>
                  <tr>
                    <th>#</th>
                    <th>Action Name</th>
                    <th>Project Name</th>
                    <th>Part Name</th>
                    <th>Employee Name</th>
                    <th>Comments</th>
                  </tr>
                </tfoot>
                <tbody id="TableID">
                  <?php
                    $i = 1;
                    foreach ( $actiontaken_results as $option ) : ?>
                      <tr id="<?php echo $option->IDactiontaken; ?>">
                        <td>
                          <?php echo $i; ?>
                        </td>
                        <td>
                          <span class="editSpan aname"><?php echo $option->IDactions; ?></span>
                          <input class="editInput aname form-control input-sm" type="text" name="action_name" value="<?php echo $option->IDactions; ?>" style="display: none;">
                        </td>
                        <td>
                          <span class="editSpan aname"><?php echo $option->IDjobcards; ?></span>
                          <input class="editInput aname form-control input-sm" type="text" name="action_name" value="<?php echo $option->IDjobcards; ?>" style="display: none;">
                        </td>
                        <td>
                          <span class="editSpan aname"><?php echo $option->IDjobcards; ?></span>
                          <input class="editInput aname form-control input-sm" type="text" name="action_name" value="<?php echo $option->IDjobcards; ?>" style="display: none;">
                        </td>
                        <td>
                          <span class="editSpan aname"><?php echo $option->IDemployees; ?></span>
                          <input class="editInput aname form-control input-sm" type="text" name="action_name" value="<?php echo $option->IDemployees; ?>" style="display: none;">
                        </td>
                        <td>
                          <span class="editSpan aname"><?php echo $option->comments; ?></span>
                          <input class="editInput aname form-control input-sm" type="text" name="action_name" value="<?php echo $option->comments; ?>" style="display: none;">
                        </td>
                      </tr>
                      <?php
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

        <footer class="sticky-footer">
          <div class="container">
            <div class="text-center">
              <small>Copyright © Sself Ltd 2023</small>
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


        <script src="js/actiontaken/dropdown-checkbox.js"></script>

        <script src="js/actiontaken/successfull-added-actiontaken.js"></script>

        <script src="js/actiontaken/data-table-view-actiontaken.js"></script>

        <script src="js/actiontaken/remove-successfull-added-actiontaken.js"></script>


      </div>

    </body>

    </html>

    <?php require ("php/close-conn.php"); ?>
