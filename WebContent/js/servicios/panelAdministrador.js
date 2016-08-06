var aplicacion = angular.module('aplicacion');
aplicacion.service('panelAdministrador', function($http, $rootScope) {
  var path = $rootScope.servidor+"/"+$rootScope.proyecto+"/"+$rootScope.aplicationPath+"/";

  this.buscarCarreras = function() {
    return $http({
      method: 'GET',
      url: path+'carrera/listar'
    });
  }


  this.registrarCarrera = function(carrera) {
    return $http({
      method: 'POST',
      url: path+'carrera/registrar',
      data: {
        'carrera' : carrera
      }
    });
  }

  this.buscarMaterias = function() {
    return $http({
      method: 'GET',
      url: path+'materia/listar'
    });
  }


  this.registrarMateria = function(materia, idCarrera) {
    return $http({
      method: 'POST',
      url: path+'materia/registrar',
      data: {
        'materia' : materia,
        "carrera":  {
          "idCarrera": parseInt(idCarrera)
        }
      }
    });
  }

});
