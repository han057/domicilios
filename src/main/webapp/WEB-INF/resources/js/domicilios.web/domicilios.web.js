(function() {
	'use strict'

	angular.module('domicilios.web', [ 'domicilios', 'ngNewRouter' ])
	.controller('AppController', 
		function($router) {
				$router.config([ {
					path : '/',
					components : 'index'
				},
				{
					path : '/listaproductos/:id',
					components : 'listaproductos'
				}
				 ]);
			});
})();