const express = require('express');
const jwt = require('jsonwebtoken');
var app = express.Router();


//Some code here...

app.post("/",(request, response)=>{
    console.log("Credentials received:");
    console.log(request.body.username);
    console.log(request.body.password);

    response.setHeader("Content-Type", "application/json");
    var reply = {isUserValid: false, message : "", token: null};

    if(request.body.username == "mahesh" &&
        request.body.password == "mahesh123")
        {
            reply.isUserValid = true;
            reply.message = "User logged in!";
            reply.token = jwt.sign(
                                {
                                    username : request.body.username ,
                                    datetime:  "05102024-11:50"                     
                                },"123");
        }
    else
        {
            reply = {isUserValid: false, message : "", token: null};
        }
    response.write(JSON.stringify(reply));
    response.end();
})

module.exports = app;