const sql=require('mysql2')
const http=require('http');
const { response } = require('express');

var connectionDetails={
    host:"localhost",
    database:"nodePractice",
    user:"KD1-Yashraj-86633",
    password:"yashraj123",
    port:3306
};

var server=http.createServer((req,res)=>{
    if(req.url=='/employees' && req.method=="GET"){

        var connection=sql.createConnection(connectionDetails)
        console.log("connection successful")
        connection.query("select * from employees",(error,result)=>{

            if(error ==null){
                res.write(JSON.stringify(result))
            }
            else{
                res.write("Connection error")
            }
            res.end();

        })

    }
    else{
        res.write("incorrect url")
        res.end()
    }

})



server.listen(3000,()=>{
    console.log("Server started at 3000")
})
