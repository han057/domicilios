(function() {
	'use strict'
	
	angular.module('domicilios').factory('ProductoService', ProductoService);
	
	function ProductoService(resourceConstants, $resource) {
		var resource = $resource(resourceConstants.url + 'api/producto/:id', 
			{id: '@id'}, {
				update: {
 					method: 'PUT'
    			},
    			cambiarEstado: {
    				method: 'POST',
    				url: 'api/producto/estado/:id'
    			},
    			listarProductosPorNombre:{
    				method: 'POST',
    				url: 'api/producto/nombre',
    				isArray:true
    			}
			});
		return resource;
	}
})();