(function() {
	'use strict'

	angular.module('domicilios.admin', [ 'domicilios', 'ngNewRouter', 'ngMessages', 'ngImageInputWithPreview', 'ui.bootstrap'])
	.controller('AppController', ['$router', AppController]);

	function AppController($router) {
		$router.config([{
			path : '/',
			components : 'indexadmin'
		}, {
			path : '/productos',
			components : 'productos'
		}, {
			path : '/pedidos',
			components : 'pedidos'
		}, {
			path : '/reportes',
			components : 'reportes'
		}]);
	}

})();