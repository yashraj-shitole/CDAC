const express = require('express');
//console.log(express);
var app = express();
app.get("/employees", (request, response)=>{
    response.write("EMPLOYEE requested using GET");
    response.end();
});
app.post("/employees", (request, response)=>{
    response.write("EMPLOYEE requested using POST");
    response.end();
});
app.put("/employees", (request, response)=>{
    response.write("EMPLOYEE requested using PUT");
    response.end();
});
app.delete("/employees", (request, response)=>{
    response.write("EMPLOYEE requested using DELETE");
    response.end();
});
app.listen(9999, ()=>{console.log("server started at port 9999")});

