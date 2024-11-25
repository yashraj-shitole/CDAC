const http = require('http');
const mysql = require('mysql');

var connectionDetails = {
                            host: "localhost",
                            database : "classwork",
                            port : 3306,
                            user : "root",
                            password : "manager"
                        };

var helper = http.createServer((request, response)=>{

    if(request.url == "/employees" && request.method =="GET")
    {
        var connection = mysql.createConnection(connectionDetails);
        connection.query("select * from Employees", (error, result)=>
        {
            response.setHeader("content-type", "application/json");
            if(error==null)
            {
                response.write(JSON.stringify(result));
            }
            else
            {
                response.write(JSON.stringify(error));
            }
            response.end();
        })
    }
    else if(request.url == "/employees" && request.method =="POST")
    {
        response.write("INSERT CODE EXECUTED!");
        response.end();
    }
    else if(request.url == "/employees" && request.method =="PUT")
    {
        response.write("UPDATE CODE EXECUTED!");
        response.end();
    }
    else if(request.url == "/employees" && request.method =="DELETE")
    {
        response.write("DELETE CODE EXECUTED!");
        response.end();
    }
    else
    {
        response.setHeader("content-type", "application/json");
        var error = {"message" : "Pls check the URL requested!"}
        response.write(JSON.stringify(error));
        response.end();
    }
});
helper.listen(9999, ()=>{console.log("server started at port no 9999")})