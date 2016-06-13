(function() {
	'use strict'

	angular.module('domicilios.admin')
	.controller('PedidosController', PedidosController);

	function PedidosController(PedidoService, PedidosSocketService, RepartidorService) {
		var vm = this;
		
		vm.pedidosCollection = [];
		vm.pedidosConfirmadosCollection = [];
		vm.pedidosEnviadosCollection = []
		vm.repartidoresCollection = [];
		
		vm.confirmar = confirmar;
		vm.entregado = entregado;
		vm.enviar = enviar;
		vm.getTotal = getTotal;
		
		
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
			vm.pedidosCollection.push(p);
		})
		
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