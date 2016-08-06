var aplicacion = angular.module('aplicacion');
aplicacion.controller('solicitarRecurso',function($scope, solicitarRecurso){

  var leerRecursos = function(){
    solicitarRecurso.consultarSolicitudRecurso().then(function(response) {
      $scope.recursos = response.data;
    }, function(response) {
      alert("Error");
    });
  }
  leerRecursos();
  $scope.recursoSolicitado="";
  $scope.comentario="";

  $scope.solicitarRecurso = function(recursoSolicitado, comentario){
    solicitarRecurso.registrarSolicitudRecurso(recursoSolicitado, comentario).then(function(response) {
      alert("Ingresado Correctamente");

      //Vuelvo a leer
      leerRecursos();
    }, function(response) {
      alert("Error");
    });
  }
});//Controlador
