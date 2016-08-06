var aplicacion = angular.module('aplicacion');
aplicacion.controller('panelAdministrador',function($scope, panelAdministrador){

 var buscarCarreras = function(){
   panelAdministrador.buscarCarreras().then(function(response) {
     $scope.carreras = response.data;
   }, function(response) {
	   console.log(response);
   });
 }

 buscarCarreras();

 $scope.nombreCarrera="";
 $scope.agregarCarrera = function(nombre) {
   panelAdministrador.registrarCarrera(nombre).then(function(response) {
     alert("Agregado Correctamente");

     //Vuelvo a leer
     buscarCarreras();
   }, function(response) {
     console.log(response);
   });
 }

 var buscarMaterias = function(){
   panelAdministrador.buscarMaterias().then(function(response) {
     $scope.materias = response.data;
   }, function(response) {
	   console.log(response);
   });
 }

 buscarMaterias();

 $scope.materia="";
 $scope.idCarrera="";

 $scope.agregarMateria = function(materia, idCarrera) {
   panelAdministrador.registrarMateria(materia, idCarrera).then(function(response) {
     alert("Agregado Correctamente");

     //Vuelvo a leer
     buscarMaterias();
   }, function(response) {
	   console.log(response);
   });
 }

});//Controlador
