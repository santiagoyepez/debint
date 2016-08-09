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

  $scope.buscarPorID = function(){
    recursos.buscarPorID($scope.idRecurso).then(function(response) {
      $scope.recursos = response.data;
    }, function(response) {
      alert("Error");
    });
  }

  $scope.buscarPorTitulo = function(){
    recursos.buscarPorTitulo($scope.tituloBuscar).then(function(response) {
      $scope.recursos = response.data;
    }, function(response) {
      alert("Error");
    });
  }

});
