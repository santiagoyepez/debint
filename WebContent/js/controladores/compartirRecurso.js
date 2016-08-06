var aplicacion = angular.module('aplicacion');
aplicacion.controller('compartirRecurso',function($scope, recursos){

  $scope.titulo="";
  $scope.descripcion="";
  $scope.nombreArchivo="";

  $scope.compartirRecurso = function(titulo, descripcion, nombreArchivo){
    recursos.compartirRecurso(titulo, descripcion, nombreArchivo).then(function(response) {
      alert("Registrado correctamente");
    }, function(response) {
      alert("Error");
    });
  }

});//Controlador
