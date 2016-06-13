(function() {
	'use strict'
	
	angular.module('domicilios').factory('PedidoService', PedidoService);
	
	function PedidoService(resourceConstants, $resource) {
		var resource = $resource(resourceConstants.url + 'api/pedido/:id', 
			{id: '@id'}, {
				query: {
					params:{estado:null},
					isArray:true
				}, 
				update: {
 					method: 'PUT'
    			},
    			confirmarPedido: {
    				method: 'PUT',
    				url: 'api/pedido/confirmar/:id',
    				headers: {'Content-Type':'application/x-www-form-urlencoded'}
    			},
    			enviarPedido: {
    				method: 'POST',
    				url: 'api/pedido/enviar/:id'
    			},
    			pedidoEntregado: {
    				method: 'POST',
    				url: 'api/pedido/entrega/:id'
    			}
			});
		return resource;
	}
})();