const fs = require('fs');

console.log("Hi...............");

fs.readdir("C:\\KDACWEB\\Day10\\NODEJSDemos\\00Demo",(error, result)=>
{
    if(error == null)
    {
        for(var i = 0; i <result.length; i++)
        {
            console.log(result[i]);
        }
    }
});


console.log("Bye...............");

