
const express = require('express');
var app = express.Router();

app.get("/", (request, response)=>{
    response.write("Admin requested using GET");
    response.end();
});

app.post("/", (request, response)=>{
    response.write("Admin requested using POST");
    response.end();
});

module.exports = app;