<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title><%=tituloPagina%></title>

    <!-- Bootstrap Core CSS -->
    <link href="/debint/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/debint/css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="/debint/css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/debint/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/debint/index.jsp">DEBIT</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                
                
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Usuario <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#"><i class="fa fa-fw fa-user"></i> Iniciar Sesión</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                        </li>
                    </ul>
                </li>
            </ul>
            
            
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                	<li class="separador">
                     <p>Configuración</p>
                    </li>
                    <!-- <li class="active"> -->
                    <li>
                        <a href="/debint/periodoBuscarPeriodos"><i class="fa fa-calendar" aria-hidden="true"></i> Periodos Académicos</a>
                    </li>
                    <li>
                        <a href="/debint/vistas/panelAdmin/panelAdmin.jsp"><i class="fa fa-pencil" aria-hidden="true"></i> Carreras - Materias</a>
                    </li>
                    <li class="separador">
                     <p>Recursos</p>
                    </li>
                    <li>
                        <a href="/debint/vistas/recurso/compartirRecurso.jsp"><i class="fa fa-share-alt" aria-hidden="true"></i> Compartir Recursos</a>
                    </li>
                    <li>
                        <a href="/debint/vistas/recurso/solicitudRecurso.jsp"><i class="fa fa-bullhorn" aria-hidden="true"></i> Solicitar Recurso</a>
                    </li>
                   
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>
          <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            <%=tituloPagina%>
                        </h1>
                   
                    </div>
                </div>
                <!-- /.row -->
                




	
