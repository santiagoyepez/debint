var aplicacion = angular.module('aplicacion');
aplicacion.controller('recursos',function($scope, recursos){

  $scope.directorioDescargas = recursos.directorioDescargas();

  var leerRecursos = function(){
    recursos.buscarRecursos().then(function(response) {
      $scope.recursos = response.data;
    }, function(response) {
      alert("Error");
    });
  }

  leerRecursos();

  $scope.tituloBuscar="";
  $scope.idRecurso="";

  $scope.buscarPorID = function(idRecurso){
    recursos.buscarPorID(idRecurso).then(function(response) {
      $scope.recursos = response.data;
    }, function(response) {
      alert("Error");
    });
  }

  $scope.buscarPorTitulo = function(tituloBuscar){
    recursos.buscarPorTitulo(tituloBuscar).then(function(response) {
      $scope.recursos = response.data;
    }, function(response) {
      alert("Error");
    });
  }

});//Controlador
