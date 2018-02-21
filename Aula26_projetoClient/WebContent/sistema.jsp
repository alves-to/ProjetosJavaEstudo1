<!doctype html>
<html ng-app="Myapp">
<head>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.0/jquery-ui.css"/>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.0.js"  ></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<script type="text/javascript" src="angular/angular.js"></script>
<script type="text/javascript" src="angular/angular-route.js"></script>

<script src="modulo/app.js"></script>
<script src="modulo/controller/cadastrocontroller.js"></script>
<script src="modulo/controller/consultacontroller.js"></script>

</head>

<body>
 <ul>
     <li><a href="#cadastro">Cadastrar Produto</a></li>
     <li><a href="#consulta">Consultar Produto</a></li>
 </ul>
 <p></p>
 <hr/>
 <div ng-view></div>
 </body>

</html>