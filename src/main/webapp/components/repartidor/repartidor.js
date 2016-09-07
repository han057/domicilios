(function() {
	'use strict'

	angular.module('domicilios.admin')
	.controller('RepartidorController', RepartidorController);

	function RepartidorController(RepartidorService, resourceConstants) {
		var vm = this;

		vm.repartidorCollectionPart = [];
		vm.maxSize = 8;
		vm.currentPage = 1;
		vm.modalAction = '';
		vm.repartidorCollection = [];
		vm.repartidorSelected = null;

		vm.abrirModal = abrirModal;
		vm.changePage = changePage;
		vm.eliminarRepartidor = eliminarRepartidor;
		vm.enviar = enviar;
		vm.selectRepartidor = selectRepartidor;

		vm.repartidorCollection = RepartidorService.query(function(){
			vm.repartidorCollectionPart = vm.repartidorCollection.slice(0, vm.maxSize); 
		});

		
		function abrirModal(accion) {
			if(accion === 'Agregar') {
				if(vm.repartidorSelected != null) {
					vm.repartidorSelected.selected=false;
				}
				vm.repartidorSelected = new RepartidorService();
			}
			vm.modalAction = accion;
		}
		
		function changePage() {
			var start = vm.currentPage * vm.maxSize - vm.maxSize;
			vm.repartidorCollectionPart = vm.repartidorCollection.slice(start, (start + vm.maxSize));
		}
		
		function eliminarRepartidor() {
			RepartidorService.cambiarEstado({id:vm.repartidorSelected.id}, vm.repartidorSelected, function(data){
				vm.repartidorSelected.estado = !vm.repartidorSelected.estado;
			});			
		}
		
		function enviar() {
			var id = 0;
			if (vm.modalAction == 'Agregar') {
				RepartidorService.save(vm.repartidorSelected, function(data){
					vm.repartidorCollection.push(data.body);
				});
			} else {
				RepartidorService.update(vm.repartidorSelected, function(data){
					
				});
			}
			vm.repartidorSelected.selected = false;
			vm.repartidorSelected = null;
			$('.modal').modal('hide');
		}

		function selectRepartidor(r) {
			if (vm.repartidorSelected == r) {
				r.selected=false;
				vm.repartidorSelected = null;
			} else {
				vm.repartidorSelected != null?vm.repartidorSelected.selected = false:'';
				r.selected = true;
				vm.repartidorSelected = r;
			}
		}
	}
})();