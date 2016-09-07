(function() {
	'use strict'

	angular.module('domicilios.admin', [ 'domicilios', 'ngNewRouter', 'ngMessages', 'ngImageInputWithPreview', 'ui.bootstrap', 'chart.js'])
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
		}, {
			path : '/repartidores',
			components : 'repartidor'
		}, {
			path : '/reportes',
			components : 'reportes'
		}]);
	}

})();