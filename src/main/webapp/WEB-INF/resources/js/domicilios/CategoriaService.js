(function() {
	'use strict'
	
	angular.module('domicilios').factory('CategoriaService', CategoriaService);
	
	function CategoriaService(resourceConstants, $resource) {
		var resource = $resource(resourceConstants.url + 'api/categoria/:id', {categoriaId: '@id'});
		return resource;
	}
	
})();