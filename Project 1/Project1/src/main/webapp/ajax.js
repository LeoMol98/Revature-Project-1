/**
 * 
 * AJAX = Asynchronous JavaScript and XML
 * - describes the process of exchanging data from
 * a web server asynchronously with the help of
 * HTML and JavaScript (and XML, but we're
 * going to be using JSON)
 * 
 * AJAX uses the Browser's built in 
 * XMLHttpRequest Object (xhr, xhttp)
 * - this object is used to send and receive data
 * from a server asynchronously, in the background,
 * without blocking or interfering with the user's
 * experience
 *  - *AND without reloading the page*
 * 
 * 
 * AJAX Workflow
 * 1. A client event occurs on a webpage
 * 2. JavaScript creates an XHR Object
 * 3. That object makes an asycnhronous request
 * 4. The server processes the request
 * 5/ Creates a response and sends it back to client
 * 6. The client processes that response using JS
 * 7. JS updates the page
 * 
 * 
 * 
 */

 let baseUrl = "https://jsonplaceholder.typicode.com/posts";

function getData() {

    // this is where we would want to get the number input by the user 
    let input = document.getElementById('dataInput').value;
    let url = `${baseUrl}/${input}`;

    // 4 Steps to creating an AJAX call
    
    // 1. Create our XHR Object
    let xhr = new XMLHttpRequest();

    // 2. Set a callback function for the readystatechange event
    xhr.onreadystatechange = receiveData;

    // 3. Open the request
    xhr.open('GET', url, true); // async=true is default but I like to put it here

    // 4. Send the request
    xhr.send(); // with a GET request - the send() function takes no arguments
    // if we were sending a request with a body (POST) then we would pass 
    // the body into this send() function as an argument.

    function receiveData() {

        /*
        The possible readyStates for an XHR Object
        0: Unsent
        1: Opened (but not sent yet)
        2: Headers Received (we have sent the request)
        3: Loading (the server is processing request and preparing a response)
        4: Done (server has sent back a response)
        */
        // Check if the readyState is 'DONE' aka '4' and if the HTTP status is 'OK' or 200
        if (xhr.readyState == 4 && xhr.status == 200) {
            let r = xhr.responseText;
            console.log(r);

            rJson = JSON.parse(r);
            console.log(rJson);

            // and then we would do some DOM manipulation to display (present) the data to the user.
        }
    }

}