(function() {
	'use strict'

	angular.module('domicilios.admin', [ 'domicilios', 'ngNewRouter', 'ngMessages', 'ngImageInputWithPreview'])
	.controller('AppController', ['$router', AppController]);

	function AppController($router) {
		$router.config([{
			path : '/',
			components : 'indexadmin'
		}, {
			path : '/productos',
			components : 'productos'
		}]);
	}

})();