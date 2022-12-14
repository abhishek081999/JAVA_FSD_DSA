// Example of Resolve using Promises and Then Method.

/* DONE 1: Created a promise with the producer code which gets the email given in the question from the server
Mock this functionality of getting email from server using a setTimeout() method which returns this email after 2 seconds as the response from the server.
*/
let promiseObj = new Promise((resolve, reject) => {
    console.log("Getting email from server...");
    setTimeout(() => {
        // DONE 2: Inside the producer code, invoked the resolve() callback while passing in the email as the argument
        resolve("srishti.gupta@upgrad.com");
    }, 2000);
});

// DONE 3: Defined a then() consumer method which has two arguments - one as the successCallbackHandler and the other as the errorCallbackHandler
promiseObj.then((result) => {
    // DONE 4: Printed the email received as an argument in the successCallbackHandler of the then() method
    console.log(`Email = ${result}`);
}, (err) => {
    console.log(err);
});





// Example of Reject using Promises and Then Method.


/* DONE 1: Created a promise with the producer code which gets the email given in the question from the server
    Mock this functionality of getting email from server using a setTimeout() method which returns this email after 2 seconds as the response from the server.
*/
let promiseObj1 = new Promise((resolve, reject) => {
    console.log("Getting email from server...");
    setTimeout(() => {
        // DONE 2: Inside the producer code, invoked the reject() callback while passing in the plain string 'Could not get email from server!' as the argument without creating an Error object
        reject('Could not get email from server!');
    }, 2000);
});

// DONE 3: Defined a then() consumer method which has two arguments - one as the successCallbackHandler and the other as the errorCallbackHandler
promiseObj1.then((result) => {
    console.log(`Email = ${result}`);
}, (err) => {
    // DONE 4: Printed the error received as an argument in the errorCallbackHandler of the then() method
    console.log(err);
});