const express = require('express');
const appViaEmployees = require('./routes/employees');
const appViaAdmin = require('./routes/admin');

var app = express();
app.use((request, response, next)=>{
    response.setHeader("Access-Control-Allow-Origin","*");
    next();
})
app.use(express.json()); //this line will create request.body from
                        //request stream received. More of middleware
                        //function.
app.use("/employees",appViaEmployees);
app.use("/admin", appViaAdmin);

app.listen(9999, ()=>{console.log("server started at port 9999")});

