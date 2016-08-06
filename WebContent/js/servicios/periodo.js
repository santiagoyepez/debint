var aplicacion = angular.module('aplicacion');
aplicacion.service('periodo', function($http, $rootScope) {
  var path = $rootScope.servidor+"/"+$rootScope.proyecto+"/"+$rootScope.aplicationPath+"/";

  this.buscarPeriodos = function() {
    return $http({
      method: 'GET',
      url: path+'periodo/listar'
    });
  }

  this.eliminarPeriodo = function(id) {
	console.log(id);
    return $http({
      method: 'POST',
      url: path+'periodo/eliminar/' + parseInt(id)
    });
  }

  this.registrarPeriodo = function(ano, parte) {
    return $http({
      method: 'POST',
      url: path+'periodo/registrar',
      data: {
        'anio' : parseInt(ano),
        'parte': parte
      }
    });
  }
});
