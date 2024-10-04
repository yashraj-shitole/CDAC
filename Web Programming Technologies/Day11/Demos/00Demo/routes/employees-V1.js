const express = require('express');
var app = express.Router();

app.get("/", (request, response)=>{
    response.write("EMPLOYEE requested using GET");
    response.end();
});
app.post("/", (request, response)=>{
    response.write("EMPLOYEE requested using POST");
    response.end();
});
app.put("/", (request, response)=>{
    response.write("EMPLOYEE requested using PUT");
    response.end();
});
app.delete("/", (request, response)=>{
    response.write("EMPLOYEE requested using DELETE");
    response.end();
});


module.exports = app;