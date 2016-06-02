(function() {
	'use strict'

	angular.module('domicilios.web')
	.controller('ListaproductosController', ListaproductosController);

	function ListaproductosController($routeParams, ProductoService) {
		var vm = this;
		$routeParams.id;
		vm.productosCollection = [];
		vm.productosCollection = productos;
		/*vm.promise = ProductoService.get(function(productos){
				vm.productosCollection = productos;
		}).$promise;*/
	}
})();