var aplicacion = angular.module('aplicacion');
aplicacion.service('solicitarRecurso', function($http, $rootScope) {
  var path = $rootScope.servidor+"/"+$rootScope.proyecto+"/"+$rootScope.aplicationPath+"/";

  this.registrarSolicitudRecurso = function(recursoSolicitado, comentario){
    return $http({
      method: 'POST',
      url: path+'solicitudRecurso/registrar',
      data: {
        'recursoSolicitado' : recursoSolicitado,
        'comentario': comentario
      }
    });
  }

  this.consultarSolicitudRecurso = function(){
    return $http({
      method: 'GET',
      url: path+'solicitudRecurso/listar'
    });
  }

});
