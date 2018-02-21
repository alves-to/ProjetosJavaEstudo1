Myapp.controller('fnCadastroController',function($scope, $http){
	     $scope.model = { nomeProduto : '',
	    		            preco     : ''
	                       };
	
	     
	   $scope.gravar=function(){
	    var url = "http://localhost:8184/projetoAngular/json/produto/gravar/"+
	     $scope.model.nomeProduto  +  "/" +  $scope.model.preco ;  
	 
	    
	      $http.get(url)
	      .success(
	    		 function(msg){
	    			$scope.model.nomeProduto ='';
	    			$scope.model.preco ='';
	    			$scope.message =msg;
	    		 })
	     .error(
	    		 function(err){
	    		   $scope.message=err;
	          });
	   }
});