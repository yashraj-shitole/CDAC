const express = require('express');
const mysql = require('mysql');

const connectionDetails = {
                            host: "localhost", 
                            database: "classwork",
                            user: "root", 
                            password: "manager",
                            port: 3306
                          };

var app = express.Router();

//Select
app.get("/", (request, response)=>
  {
    var connection = mysql.createConnection(connectionDetails);
    connection.connect();

    var queryText = `select * from Employees`;
    //  var queryText = `select * from Employees1`; //try this as well

    connection.query(queryText, (error, result)=>
    {
        response.setHeader("Content-Type", "application/json");

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
    connection.end();
});

//Select
app.get("/:No", (request, response)=>
  {
    var connection = mysql.createConnection(connectionDetails);
    connection.connect();

    var queryText = `select * from Employees where No = ${request.params.No}`;

    connection.query(queryText, (error, result)=>
    {
        response.setHeader("Content-Type", "application/json");

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
    connection.end();
});

//Insert
app.post("/", (request, response)=>
  {
    console.log( request.body);

    var connection = mysql.createConnection(connectionDetails);
    connection.connect();

    var queryText = `insert into Employees values(${request.body.No}, '${request.body.Name}', '${request.body.Address}')`;

    console.log(queryText);

    connection.query(queryText, (error, result)=>
    {
        response.setHeader("Content-Type", "application/json");

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
    connection.end();
});

//Update
//app.put("/:No/:Name", (request, response)=>
 app.put("/:No", (request, response)=>
  {
    console.log(request.params.No)  //This is data from header
    console.log(request.body);      //This is data from body

    var connection = mysql.createConnection(connectionDetails);
    connection.connect();

    var queryText =  `update Employees set  
                      Name='${request.body.Name}', 
                      Address='${request.body.Address}' 
                      where No = ${request.params.No}`;

    console.log(queryText);

    connection.query(queryText, (error, result)=>
    {
        response.setHeader("Content-Type", "application/json");

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
    connection.end();
});

//Delete
 app.delete("/:No", (request, response)=>
  {
    console.log(request.params.No)  //This is data from header

    var connection = mysql.createConnection(connectionDetails);
    connection.connect();

    var queryText =  `delete from Employees  
                      where No = ${request.params.No}`;

    console.log(queryText);

    connection.query(queryText, (error, result)=>
    {
        response.setHeader("Content-Type", "application/json");

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
    connection.end();
});



module.exports = app;