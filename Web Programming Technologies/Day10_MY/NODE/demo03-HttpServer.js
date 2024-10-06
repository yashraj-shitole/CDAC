const http=require('http')


var data={
    name:'yashraj',
    address:"Majrewadi road, Kurundwad",
    pinCode: 416106,
    age: 20
}

//createing server
var helper= http.createServer((request,response)=>{

    //printing when server gets request
    console.log("Called for "+ request.url)

    //setting response dayta for called link
    if(request.url == "/api/mydata"){


        response.writeHead(200, {"Content-Type": "application/json"});
        response.write(JSON.stringify(data));

        response.end()
    }
    //default data to be sent
    else{
        response.write("Some other reply");
        response.end()
    }
})

helper.listen(3000,()=>{
    console.log("Server started")
})