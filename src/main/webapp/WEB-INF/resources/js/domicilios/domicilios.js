(function() {
	'use strict'
	
	angular.module('domicilios', ['ngResource'])
	.constant('resourceConstants', {
		url: '', 
		uploadUrl: 'api/imagen/'
	});
})();