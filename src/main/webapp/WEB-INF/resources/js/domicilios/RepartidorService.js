(function() {
	'use strict'
	
	angular.module('domicilios').factory('RepartidorService', RepartidorService);
	
	function RepartidorService(resourceConstants, $resource) {
		var resource = $resource(resourceConstants.url + 'api/repartidor/:id', 
			{id: '@id'}, {
				update: {
 					method: 'PUT'
    			},
    			cambiarEstado: {
    				method: 'POST',
    				url: 'api/repartidor/estado/:id'
    			},
			});
		return resource;
	}
})();