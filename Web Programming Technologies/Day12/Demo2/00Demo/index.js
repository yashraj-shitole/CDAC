const express = require('express');
const cors = require('cors');
const appViaEmployees = require('./routes/employees');
const appViaLogin = require('./routes/login');
const jwt = require('jsonwebtoken');

var app = express();
app.use(cors());
app.use(express.json()); 

app.use((request, response, next)=>
{
    console.log(request.url)

    if(!request.url.includes("login"))
    {
        //Check if request is carrying a token!
        var token  = request.headers["authorization"];
        console.log("Token received from client is : ")
        console.log(token)

       //if token found
       if(token!=undefined)
        { 
            console.log("Received token!")
            // //check the token
            
            var decodedToken = jwt.verify(token, "123");
            console.log(decodedToken);
            console.log(decodedToken.username);
            console.log(decodedToken.datetime);
            //let us check if the datetime given and rceceived is same
            if(decodedToken.datetime == "05102024-11:50") 
            {
                //here we need to write code to check token
                //if token is correct let user go to NEXT()
                next();
            }
            else
            {
                 //else reply from here that user token is invalid!
                var reply = {isUserValid :false, message: "You need to login!"};

                response.setHeader("Content-Type", "application/json");
                response.write (JSON.stringify(reply));
                response.end();
            }
        }
       else
       {
         //else reply from here that user needs a token!
         var reply = {isUserValid :false, message: "You need to login!"};

         response.setHeader("Content-Type", "application/json");
         response.write (JSON.stringify(reply));
         response.end();
       }
    }
    else
    {
     next();   
    }
});

app.use("/login",appViaLogin);
app.use("/employees",appViaEmployees);


app.listen(9999, ()=>{console.log("server started at port 9999")});

