(function() {
	'use strict'

	angular.module('domicilios.admin')
	.controller('PedidosController', PedidosController);

	function PedidosController(PedidoService, PedidosSocketService, RepartidorService, ProductoService) {
		var vm = this;
				
		vm.buscandoProducto = false;
		vm.nombreProducto = '';
		vm.pedidosCollection = [];
		vm.pedidosConfirmadosCollection = [];
		vm.pedidosEnviadosCollection = []
		vm.productosCollection = [];
		vm.repartidoresCollection = [];
		
		
		vm.agregarItem = agregarItem; 
		vm.buscarProducto = buscarProducto;
		vm.cancelarPedido = cancelarPedido;
		vm.confirmar = confirmar;
		vm.entregado = entregado;
		vm.elimiarItem = elimiarItem;
		vm.enviar = enviar;
		vm.getTotal = getTotal;
		vm.selectPedido = selectPedido;
		
		
		PedidoService.query({estado:1}, function(data) {
			vm.pedidosCollection = data;
		});
		
		PedidoService.query({estado:2}, function(data) {
			vm.pedidosConfirmadosCollection = data;
		});
		
		PedidoService.query({estado:3}, function(data) {
			vm.pedidosEnviadosCollection = data;
		});
		
		RepartidorService.query(function(data){
			vm.repartidoresCollection = data;
		});
		
		PedidosSocketService.receive().then(null, null, function(p){
			document.getElementById("audio").play();
			for(var i = 0; i < vm.pedidosCollection.lenght; i++) {
				if (vm.pedidosCollection[i].id == p.id) {
					return;
				}
			}
			vm.pedidosCollection.push(p);
		})
		
		function agregarItem(p) {
			PedidoService.agregarProducto({id:vm.pedidoSelected.id}, {producto:p, cantidad: p.cantidad, valor: p.cantidad * p.valor}, function(data){
				vm.pedidoSelected.detalle.push(data.body);
			});
		}
		
		function buscarProducto() {
			vm.buscandoProducto = true;
			ProductoService
			.listarProductosPorNombre({nombre: vm.nombreProducto}, $.param({nombre: vm.nombreProducto}), 
					function(data){
						vm.productosCollection = data;
			});
		}
		
		function confirmar() {
			PedidoService
			.confirmarPedido({id: vm.pedidoSelected.id, repartidor: vm.pedidoSelected.repartidor.id}, 
					$.param({repartidor: vm.pedidoSelected.repartidor.id}), 
					function(data){
						var p = vm.pedidoSelected;
						console.log('Index: ' + vm.pedidosCollection.indexOf(vm.pedidoSelected));
						vm.pedidosCollection.splice(vm.pedidosCollection.indexOf(vm.pedidoSelected), 1);
						vm.pedidosConfirmadosCollection.push(p);
						$('.modal').modal('hide');
						showGritter('Confirmado', 'El pedido fue confirmado y asignado a ' + vm.pedidoSelected.repartidor.nombre, false);
			});
		}
		
		function cancelarPedido() {
			PedidoService
			.cancelarPedido({id: vm.pedidoSelected.id}, 
					function(data){
						vm.pedidosCollection.splice(vm.pedidosCollection.indexOf(vm.pedidoSelected), 1);
						$('.modal').modal('hide');
						showGritter('Confirmado', 'El pedido fue cancelado', false);
			});
		}
		
		function elimiarItem(i) {
			PedidoService.eliminarProducto({id:i.id}, null, function(data){
				vm.pedidoSelected.detalle.splice(vm.pedidoSelected.detalle.indexOf(i), 1);
			});
		}
		
		function enviar() {
			PedidoService
			.enviarPedido({id: vm.pedidoSelected.id}, 
					function(data){
						var p = vm.pedidoSelected;
						console.log('Index: ' + vm.pedidosCollection.indexOf(vm.pedidoSelected));
						vm.pedidosConfirmadosCollection.splice(vm.pedidosConfirmadosCollection.indexOf(vm.pedidoSelected), 1);
						vm.pedidosEnviadosCollection.push(p);
						$('.modal').modal('hide');
						showGritter('Enviado', 'El pedido ha sido enviado correctamente', false);
			});
		}
		
		function entregado(estado) {
			PedidoService
			.pedidoEntregado({id: vm.pedidoSelected.id, entregado: estado},
					$.param({entregado: estado}),
					function(data){
						var p = vm.pedidoSelected;
						console.log('Index: ' + vm.pedidosCollection.indexOf(vm.pedidoSelected));
						vm.pedidosEnviadosCollection.splice(vm.pedidosEnviadosCollection.indexOf(vm.pedidoSelected), 1);
						$('.modal').modal('hide');
						showGritter('Modificado', 'El estado de entrega del pedido fue modificado correctamente', false);
			});
		}
		
		function selectPedido(pedido, accion) {
			vm.pedidoSelected = pedido;
			vm.accion = accion;
		}
		
		function showGritter(title, text, sticky) {
			$.gritter.add({
	            // (string | mandatory) the heading of the notification
	            title: title,
	            // (string | mandatory) the text inside the notification
	            text: text,
	            // (string | optional) the image to display on the left
	            //image: 'assets/img/ui-sam.jpg',
	            // (bool | optional) if you want it to fade out on its own or just sit there
	            sticky: sticky,
	            // (int | optional) the time you want it to be alive for before fading out
	            time: '',
	            // (string | optional) the class name you want to apply to that specific message
	            class_name: 'my-sticky-class'
	        });
		}
		
		function getTotal() {
			var total = 0;
			for(var i = 0; i < vm.pedidoSelected.detalle.length; i++) {
				total += vm.pedidoSelected.detalle[i].valor; 
			}
			return total;
		}
		
		
	}
})();