(function() {
	angular.module('domicilios.admin')
		.service('PedidosSocketService',
					PedidosSocketService);
	
	function PedidosSocketService($q, $timeout) {
		var service = {}
			, listener = $q.defer()
			, socket = {
				cliente: null, 
				stomp: null
			}, messageIds = [];
		
		service.RECONNECT_TIMEOUT = 30000;
		service.SOCKET_URL = '/domicilios/pedidos';
		service.PEDIDOS_TOPIC = '/topic/pedidos';
		service.PEDIDOS_BROKER = '/app/pedidos';
		
		service.receive = function() {
			return listener.promise;
		};
		
		service.send = function(message) {
			var id = Math.floor(Math.random() * 10000000);
			socket.stomp.send(service.PEDIDOS_BROKER, {
				priority: 9
			}, JSON.stringyfy({
				message: message,
				id: id
			}));
			messageIds.push(id);
		};
		
		var reconnect = function() {
			$timeout(function(){
				initialize();
			}, this.RECONNECT_TIMEOUT);
		};
		
		var getMessage = function(data) {	
			return JSON.parse(data);
		}
		
		var startListener = function() {
			socket.stomp.subscribe(service.PEDIDOS_TOPIC, function(data){
				listener.notify(getMessage(data.body));
			})
		};
		
		var initialize = function(){
			socket.client = new SockJS(service.SOCKET_URL);
			socket.stomp = Stomp.over(socket.client);
			socket.stomp.connect({}, startListener);
			socket.stomp.onclose = reconnect;
		}
		
		initialize();
		return service;
	}
})();