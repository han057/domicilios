<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>Admin::Mr.K - Food & Drinks</title>

    <!-- Bootstrap core CSS -->
    <link href="resources/assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
    
    <link rel="stylesheet" type="text/css" href="resources/assets/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="resources/assets/js/gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="resources/assets/lineicons/style.css">
    
    <!-- Custom styles for this template -->
    <link href="resources/assets/css/style.css" rel="stylesheet">
    <link href="resources/assets/css/style-responsive.css" rel="stylesheet">

    <link rel="stylesheet" type="text/css" href="resources/css/style.css">

    <script src="resources/assets/js/chart-master/Chart.js"></script>
    
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body ng-app="domicilios.admin" ng-cloak class="ng-cloak" ng-controller="AppController">

  <section id="container" >
      <!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
      <!--header start-->
      <header class="header black-bg">
              <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
              </div>
            <!--logo start-->
            <a href="index.html" class="logo"><b>Mr. K</b></a>
            <!--logo end-->
            <div class="nav notify-row" id="top_menu">
                <!--  notification start -->
                <ul class="nav top-menu">
                
                </ul>
                <!--  notification end -->
            </div>
            <div class="top-menu">
            	<ul class="nav pull-right top-menu">
                    <li><a class="logout" href="login.html">Logout</a></li>
            	</ul>
            </div>
        </header>
      <!--header end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
      <!--sidebar start-->
      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
              
              	  <!--<p class="centered"><a href="profile.html"><img src="resources/assets/img/ui-sam.jpg" class="img-circle" width="60"></a></p>
              	  <h5 class="centered">{{"Usuario"}}</h5>-->
              	  	
                  <li class="mt">
                      <a class="active" ng-href="#/">
                          <i class="fa fa-dashboard"></i>
                          <span>Inicial</span>
                      </a>
                  </li>

                  <li class="sub-menu">
                      <a href="#/pedidos" >
                          <i class="fa fa-shopping-cart"></i>
                          <span>Pedidos</span>
                      </a>
                  </li>

                  <li class="sub-menu">
                      <a href="#/productos" >
                          <i class="fa fa-cutlery"></i>
                          <span>Productos</span>
                      </a>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-list-ol"></i>
                          <span>Categorias</span>
                      </a>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-motorcycle"></i>
                          <span>Repartidores</span>
                      </a>
                  </li>
              </ul>
              <!-- sidebar menu end-->
          </div>
      </aside>
      <!--sidebar end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
      <!--main content start-->
      <section id="main-content" class="wrapper" ng-viewport>
          
      </section>

      <!--main content end-->
      <!--footer start-->
      <!--<footer class="site-footer">
          <div class="text-center">
              2014 - Alvarez.is
              <a href="index.html#" class="go-top">
                  <i class="fa fa-angle-up"></i>
              </a>
          </div>
      </footer>-->
      <!--footer end-->
  </section>

    <!-- js placed at the end of the document so the pages load faster -->    

    <script src="resources/assets/js/jquery.js"></script>
    <script src="resources/assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="resources/assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="resources/assets/js/jquery.scrollTo.min.js"></script>
    <script src="resources/assets/js/jquery.nicescroll.js" type="text/javascript"></script>


    <!--common script for all pages-->
    <script src="resources/assets/js/common-scripts.js"></script>

    <!--script for this page-->
    <script src="resources/assets/js/jquery-ui-1.9.2.custom.min.js"></script>

    <!--custom switch-->
    <script src="resources/assets/js/bootstrap-switch.js"></script>

    <!--custom tagsinput-->
    <script src="resources/assets/js/jquery.tagsinput.js"></script>

    <!--custom checkbox & radio-->
    <script type="text/javascript" src="resources/assets/js/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>


    <!--<script src="resources/assets/js/form-component.js"></script>-->
    <!--custom switch-->
    <script src="resources/assets/js/bootstrap-switch.js"></script>

    <!--common script for all pages-->
    <script src="resources/assets/js/common-scripts.js"></script>
    
    <script type="text/javascript" src="resources/assets/js/gritter/js/jquery.gritter.js"></script>
    <script type="text/javascript" src="resources/assets/js/gritter-conf.js"></script>

    <!--script for this page-->
    <!--<script src="resources/assets/js/sparkline-chart.js"></script>    -->
  	<script src="resources/assets/js/zabuto_calendar.js"></script>	
  	<script type="text/javascript" src="resources/js/lib/angular.min.js"></script>
    <script type="text/javascript" src="resources/js/lib/angular-messages.js"></script>
  	<script type="text/javascript" src="resources/js/lib/router.es5.min.js"></script>
  	<script type="text/javascript" src="resources/js/lib/angular-resource.min.js"></script>
  	<script type="text/javascript" src="resources/js/lib/ng-image-input-with-preview.min.js"></script>
  	<script type="text/javascript" src="resources/js/domicilios/domicilios.js"></script>
  	<script type="text/javascript" src="resources/js/domicilios/CategoriaService.js"></script>
  	<script type="text/javascript" src="resources/js/domicilios/ProductoService.js"></script>
  	<script type="text/javascript" src="resources/js/domicilios/FileUpload.js"></script>
  	<script type="text/javascript" src="resources/js/domicilios/FileModel.js"></script>
  	<script type="text/javascript" src="resources/js/domicilios.admin/domicilios.admin.js"></script>
  	<script type="text/javascript" src="components/indexadmin/indexadmin.js"></script>
    <script type="text/javascript" src="components/productos/productos.js"></script>
  </body>
</html>