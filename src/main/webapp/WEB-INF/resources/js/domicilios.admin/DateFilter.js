(function() {
	'use strict'

	angular.module('domicilios.admin').filter("dateFilter", dateFilter);
	
	function parseDate(input) {
		var parts = input.split('-');
		return new Date(parts[2], parts[1]-1, parts[0]); 
	}
	
	function dateFilter() {
		  return function(items, from, to) {
		        var df = parseDate(from);
		        var dt = parseDate(to);
		        var result = [];        
		        for (var i=0; i<items.length; i++){
		            var tf = new Date(items[i].date1 * 1000),
		                tt = new Date(items[i].date2 * 1000);
		            if (tf > df && tt < dt)  {
		                result.push(items[i]);
		            }
		        }            
		        return result;
		  };
	}
})();