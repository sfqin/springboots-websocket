var stompClient = null;

function connect() {
    var socket = new SockJS('/endpoint-websocket');

    stompClient = Stomp.over(socket);

    stompClient.connect({},function (frame) {

    })
}