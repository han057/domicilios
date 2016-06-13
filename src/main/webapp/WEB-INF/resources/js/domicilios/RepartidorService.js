(function() {
	'use strict'
	
	angular.module('domicilios').factory('RepartidorService', PedidoService);
	
	function PedidoService(resourceConstants, $resource) {
		var resource = $resource(resourceConstants.url + 'api/repartidor/:id', 
			{id: '@id'}, {
				update: {
 					method: 'PUT'
    			}
			});
		return resource;
	}
})();