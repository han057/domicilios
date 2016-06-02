(function() {
	'use strict'
	
	angular.module('domicilios').factory('ProductoService', ProductoService);
	
	function ProductoService(resourceConstants, $resource) {
		var resource = $resource(resourceConstants.url + 'api/producto/:id', 
			{id: '@id'}, {
				update: {
 					method: 'PUT'
    			}
			});
		return resource;
	}
})();