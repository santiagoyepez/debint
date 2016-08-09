var aplicacion = angular.module('aplicacion');

aplicacion.controller('compartirRecurso',function($scope, recursos){

	$scope.recurso={};
	$scope.recurso.usuario={};
	$scope.recurso.categoria={};
	
	
  $scope.recurso.usuario.idUsuario = 8;
  $scope.recurso.categoria.idCategoria = 1;
  $scope.recurso.visible = 1;
  $scope.recurso.solicitudRecurso = null;
  $scope.recurso.titulo = "";
  

  $scope.compartirRecurso = function(){
    recursos.compartirRecurso($scope.recurso).then(function(response) {
      alert("Registrado correctamente");
    }, function(response) {
      alert("Error");
    });
  }

  console.log("Controlador compartir");
});