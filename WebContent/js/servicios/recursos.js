var aplicacion = angular.module('aplicacion');

aplicacion.service('recursos', function($http, $rootScope) {
  var path = $rootScope.servidor+"/"+$rootScope.proyecto+"/"+$rootScope.aplicationPath+"/";

  this.buscarRecursos = function() {
    return $http({
      method: 'GET',
      url: path+'recurso/listar'
    });
  }

  this.directorioDescargas = function(){
    return "http://localhost:8080/debint/subidas/";
  }


  this.compartirRecurso = function(recurso) {
    return $http({
      method: 'POST',
      url: path+'recurso/registrar',
      data: recurso
    });
  }

  this.buscarPorID = function(idRecurso) {
    return $http({
      method: 'GET',
      url: path+'recurso/consultar/'+parseInt(idRecurso)
    });
  }

  this.buscarPorTitulo = function(tituloBuscar) {
    return $http({
      method: 'GET',
      url: path+'recurso/consultarPorTitulo/'+tituloBuscar
    });
  }


});
