var aplicacion = angular.module('aplicacion',['ui.router']);

aplicacion.config(function($stateProvider, $urlRouterProvider) {
  //
  // For any unmatched url, redirect to /state1
  $urlRouterProvider.otherwise("/inicio");
  //
  var nombreEstado = 'inicio';
 $stateProvider.state(nombreEstado, {
   url: '/'+nombreEstado,
   templateUrl: 'pantallas/'+nombreEstado+'.html',
   controller: nombreEstado
  });

  var nombreEstado = 'periodo';
 $stateProvider.state(nombreEstado, {
   url: '/'+nombreEstado,
   templateUrl: 'pantallas/'+nombreEstado+'.html',
   controller: nombreEstado
  });

  var nombreEstado = 'solicitarRecurso';
 $stateProvider.state(nombreEstado, {
   url: '/'+nombreEstado,
   templateUrl: 'pantallas/'+nombreEstado+'.html',
   controller: nombreEstado
  });

  var nombreEstado = 'recursos';
 $stateProvider.state(nombreEstado, {
   url: '/'+nombreEstado,
   templateUrl: 'pantallas/'+nombreEstado+'.html',
   controller: nombreEstado
  });

  var nombreEstado = 'compartirRecurso';
 $stateProvider.state(nombreEstado, {
   url: '/'+nombreEstado,
   templateUrl: 'pantallas/'+nombreEstado+'.html',
   controller: nombreEstado
  });

  var nombreEstado = 'panelAdministrador';
 $stateProvider.state(nombreEstado, {
   url: '/'+nombreEstado,
   templateUrl: 'pantallas/'+nombreEstado+'.html',
   controller: nombreEstado
  });

});

aplicacion.run(function($rootScope) {
  $rootScope.servidor="http://localhost:8080";
  $rootScope.proyecto="debint";
  $rootScope.aplicationPath="utl";
});
