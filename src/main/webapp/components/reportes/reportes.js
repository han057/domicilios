(function() {
	'use strict'

	angular.module('domicilios.admin')
	.controller('ReportesController', ReportesController);

	function ReportesController(PedidoService, $filter) {
		var vm = this;
		
		vm.pedidosCollection = [];
		vm.valorPedidoPorDia = [];
		vm.valorPedidoPorMes = [];
		vm.labels = [];
		vm.data = [];		
		vm.series = [];
		
		vm.labelsMes = [];
		vm.dataMes = [];		
		vm.seriesMes = [];
		
		vm.calcularTotalPedido = calcularTotalPedido;
		
		vm.pedidosCollection = PedidoService.query({estado:4}, function(data){
			listarPedidoPorDia();
			listarPedidoPorMes();
		});
		
		function calcularTotalPedido(pedido) {
			var total = 0;
			for(var i = 0; i < pedido.detalle.length; i++) {
				total += pedido.detalle[i].valor;
			}
			return total;
		}
		
		function listarPedidoPorMes(){
			var found = false;
			for(var i = 0; i < vm.pedidosCollection.length; i++) {
				if(i == 0) {
					vm.valorPedidoPorMes.push({fecha: vm.pedidosCollection[i].fecha, total: calcularTotalPedido(vm.pedidosCollection[i])});
				} else {
					found = false;
					for(var j = 0; (j < vm.valorPedidoPorMes.length && !found); j++) {
						
						var dateList = new Date(vm.valorPedidoPorMes[j].fecha);
						var datePedido = new Date(vm.pedidosCollection[i].fecha);
						
						dateList.setHours(0,0,0,0);
						datePedido.setHours(0,0,0,0);

						if (dateList.getMonth() === datePedido.getMonth()) {
							found = true;
							vm.valorPedidoPorMes[j].total += calcularTotalPedido(vm.pedidosCollection[i]);
						}
					}
					
					if (!found) {
						vm.valorPedidoPorMes.push({fecha: vm.pedidosCollection[i].fecha, total: calcularTotalPedido(vm.pedidosCollection[i])});
					}
				}
			}
			
			vm.series.push("Ventas por Mes");
			for(var j = 0; j < vm.valorPedidoPorDia.length; j++) {
				vm.labelsMes.push($filter('date')(vm.valorPedidoPorMes[j].fecha, "yyyy-MM-dd"));
				vm.dataMes.push(vm.valorPedidoPorMes[j].total);
			}
		}
		
		function listarPedidoPorDia() {
			var found = false;
			for(var i = 0; i < vm.pedidosCollection.length; i++) {
				if(i == 0) {
					vm.valorPedidoPorDia.push({fecha: vm.pedidosCollection[i].fecha, total: calcularTotalPedido(vm.pedidosCollection[i])});
				} else {
					found = false;
					for(var j = 0; (j < vm.valorPedidoPorDia.length && !found); j++) {
						
						var dateList = new Date(vm.valorPedidoPorDia[j].fecha);
						var datePedido = new Date(vm.pedidosCollection[i].fecha);
						
						dateList.setHours(0,0,0,0);
						datePedido.setHours(0,0,0,0);

						if (dateList.valueOf() === datePedido.valueOf()) {
							found = true;
							vm.valorPedidoPorDia[j].total += calcularTotalPedido(vm.pedidosCollection[i]);
						}
					}
					
					if (!found) {
						vm.valorPedidoPorDia.push({fecha: vm.pedidosCollection[i].fecha, total: calcularTotalPedido(vm.pedidosCollection[i])});
					}
				}
			}
			
			vm.series.push("Ventas por día");
			for(var j = 0; j < vm.valorPedidoPorDia.length; j++) {
				vm.labels.push($filter('date')(vm.valorPedidoPorDia[j].fecha, "yyyy-MM-dd"));
				vm.data.push(vm.valorPedidoPorDia[j].total);
			}
		}
		
		
	}
})();