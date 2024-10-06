const http= require('http')
const sql=require('mysql2')

var connectionDetails= {
    host: "localhost",
    database : "nodePractice",
    port : 3306,
    user : "KD1-Yashraj-86633",
    password : "yashraj123"
};



var server=http.createServer((req,res)=>{
    
    if(req.url == "/salespeople" && req.method =="GET"){
        var connection=sql.createConnection(connectionDetails)

    var selectQuery="select * from salespeople"

    connection.query(selectQuery, (error, result)=>
        {
            res.setHeader("content-type", "application/json");
            if(error==null)
            {
                res.write(JSON.stringify(result));
            }
            else
            {
                res.write(JSON.stringify(error));
            }
            res.end();
        })
    }
    else if(req.url == "/insertsalespeople" && req.method =="GET"){
        var connection=sql.createConnection(connectionDetails)

    
    var insertQuery="Insert into salespeople values(3,'Yash','105')"

    connection.query(insertQuery, (error, result)=>
        {
            if(error==null)
            {
                res.write("Inserted");
            }
            else
            {
                res.write("Not inserted");
            }
            res.end();
        })
    }
    
    // var query=`Insert into salespeople values(${id}, ${name}, ${department})`


})


server.listen(9999,()=>{
    console.log("Server started")
})



