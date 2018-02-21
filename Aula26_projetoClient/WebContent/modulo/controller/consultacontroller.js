Myapp.controller('fnConsultaController',function($scope, $http){
	    
	$scope.listar=function(){
	    var url = "http://localhost:8184/projetoAngular/json/produto/listar"; 
	 
	      $http.get(url)
	      .success(
	    		 function(dados){
	    			$scope.lista = dados;
	    		 })
	     .error(
	    		 function(err){
	    		   $scope.message=err;
	          });
	   }
});