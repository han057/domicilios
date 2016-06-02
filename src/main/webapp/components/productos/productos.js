(function() {
	'use strict'

	angular.module('domicilios.admin')
	.controller('ProductosController', ProductosController);

	function ProductosController(ProductoService, CategoriaService, FileUpload, resourceConstants) {
		var vm = this;

		vm.categoriasCollection = [];
		vm.modalAction = '';
		vm.productosCollection = [];
		vm.productoSelected = null;
		vm.imagen = null;

		vm.abrirModal = abrirModal;
		vm.eliminarProducto = eliminarProducto;
		vm.enviar = enviar;
		vm.selectProducto = selectProducto;

		vm.productosCollection = ProductoService.query(function(){
			vm.categoriasCollection = CategoriaService.query();
		});
		/*vm.promise = ProductoService.query(function(productos){
			vm.productosCollection = productos;
			CategoriaService.query(function(categorias){
				vm.categoriasCollection = categorias;
			});
		}).$promise;*/

		
		function abrirModal(accion) {
			if(accion === 'Agregar') {
				if(vm.productoSelected != null) {
					vm.productoSelected.selected=false;
				}
				vm.productoSelected = new ProductoService();
			}
			vm.modalAction = accion;
		}
		
		function eliminarProducto() {
			ProductoService.delete(vm.productoSelected, function(data){
				vm.productoSelected.activo = false;
			});			
		}
		
		function enviar() {
			var id = 0;
			if (vm.modalAction == 'Agregar') {
				ProductoService.save(vm.productoSelected, function(data){
					vm.productosCollection.push(data.body);
					if (vm.imagen != null) {
						FileUpload.uploadFileToUrl(vm.imagen, resourceConstants.uploadUrl + data.body.id);
					}
				});
			} else {
				ProductoService.update(vm.productoSelected, function(data){
					if (vm.imagen != null) {
						FileUpload.uploadFileToUrl(vm.imagen, resourceConstants.uploadUrl + data.body.id);
					}
				});
			}
			vm.productoSelected.selected = false;
			vm.productoSelected = null;
			$('.modal').modal('hide');
		}

		function selectProducto(p) {
			if (vm.productoSelected == p) {
				p.selected=false;
				vm.productoSelected = null;
			} else {
				vm.productoSelected != null?vm.productoSelected.selected = false:'';
				p.selected = true;
				vm.productoSelected = p;
			}
		}
	}
})();