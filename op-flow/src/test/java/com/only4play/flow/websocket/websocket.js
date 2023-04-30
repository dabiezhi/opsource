var socket = new WebSocket("ws://localhost:8080/ws/flow/v1/1");

socket.onopen = function(event) {
    console.log("WebSocket opened: " + socket.readyState);
};

socket.onmessage = function(event) {
    console.log("Received message: " + event.data);
};

socket.onclose = function(event) {
    console.log("WebSocket closed: " + socket.readyState + ", " + event.code);
};

socket.onerror = function(event) {
    console.log("WebSocket error: " + event.data);
};

function sendMessage() {
    var message = document.getElementById("message").value;
    socket.send(message);
}
