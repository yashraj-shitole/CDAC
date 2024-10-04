const http=require('http')


const fs = require('fs');


//createing server
var helper= http.createServer((request,response)=>{

    //printing when server gets request
    console.log("Called for "+ request.url)

    //setting response dayta for called link
    if(request.url == "/api/mydata"){

        const page1 = fs.readFileSync('index.html', 'utf8');

        response.writeHead(200, {"Content-Type": "text/html"});
        response.write(page1);

        response.end()
    }

    else if(request.url == "/api/newdata"){

        const page2 = fs.readFileSync('page2.html', 'utf8');

        response.writeHead(200, {"Content-Type": "text/html"});
        response.write(page2);

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