const express = require('express');
const appViaEmployees = require('./routes/employees');

var app = express();
app.use((request, response, next)=>{
    response.setHeader("Access-Control-Allow-Origin","*");
    response.setHeader("Access-Control-Allow-Methods", "*");
    response.setHeader("Access-Control-Allow-Headers", "*");
    next();
})
app.use(express.json()); //this line will create request.body from
                        //request stream received. More of middleware
                        //function.
app.use("/employees",appViaEmployees);


app.listen(9999, ()=>{console.log("server started at port 9999")});

