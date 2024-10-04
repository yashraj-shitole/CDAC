const express = require('express');
var app = express();

app.use((request, response, next)=>{
    response.write("Hi");
    next();
})

app.use((request, response)=>{
    response.write("Hello");
    response.end();
})

app.listen(9999, ()=>{console.log("server started at port 9999")});

