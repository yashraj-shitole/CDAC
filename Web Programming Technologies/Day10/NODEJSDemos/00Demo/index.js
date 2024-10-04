const http = require('http');
// console.log(http);

var helper =  http.createServer((request, response)=>{
    console.log("u called for " + request.url);
    if(request.url == "/api/users")
    {
        var users = [
                    {"No" : 11, Name: "Mahesh1", Address: "Pune1"},
                    {"No" : 12, Name: "Mahesh2", Address: "Pune2"},
                    {"No" : 13, Name: "Mahesh3", Address: "Pune3"},
                    {"No" : 14, Name: "Mahesh4", Address: "Pune4"}
                    ]
        response.setHeader("Content-Type", "application/json");
        response.write(JSON.stringify(users));
    

        response.end();
    }
    else
    {
        response.write("some other reply!");
        response.end();
    }
});
helper.listen(9999,()=>{console.log("Server started at port no 9999");})