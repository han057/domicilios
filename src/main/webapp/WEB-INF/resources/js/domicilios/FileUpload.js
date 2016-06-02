(function(){
	'use strict'
	
	angular.module('domicilios').service('FileUpload', ['$http', FileUpload]);
	
	function FileUpload($http) {
		this.uploadFileToUrl = function(file, uploadUrl){
            var fd = new FormData();
            fd.append('file', file);
            $http.post(uploadUrl, fd, {
                headers: {'Content-Type': undefined },
                transformRequest: angular.identity
			})
            .success(function(){file = null})
            .error(function(){});
         }
	}
})();