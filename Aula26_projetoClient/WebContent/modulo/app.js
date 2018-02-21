var Myapp = angular.module('Myapp',['ngRoute']);


  Myapp.config(
		  function($routeProvider){
			       $routeProvider
			     .when("/cadastro",
			    		 {
			      	      templateUrl : "modulo/cadastro.html",
			              controller : "fnCadastroController"
			    		 }
			    	
			     )  
			     .when("/consulta",
			    		 {
		      	      templateUrl : "modulo/consulta.html",
		              controller : "fnConsultaController"
		    		 });

 });