var aplicacion = angular.module('aplicacion');
aplicacion.controller('periodo', function($scope, periodo) {

  var leerPeriodos = function(){
    periodo.buscarPeriodos().then(function(response) {
      $scope.periodos = response.data;
    }, function(response) {
      alert("Error");
    });
  }

  leerPeriodos();

  $scope.eliminarPeriodo = function(id) {
    periodo.eliminarPeriodo(id).then(function(response) {
      alert("Eliminado Correctamente");

      //Vuelvo a leer
      leerPeriodos();
    }, function(response) {
      alert("Error");
    });
  }



  $scope.ano="";
  $scope.parte="";

  $scope.registrarPeriodo = function(ano, parte){
    periodo.registrarPeriodo(ano, parte).then(function(response) {
      alert("Registrado correctamente");

      //Vuelvo a leer
      leerPeriodos();
    }, function(response) {
      alert("Error");
    });
  }

}); //Controlador
