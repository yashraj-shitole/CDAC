const fs = require('fs');
//console.log(fs);

console.log("Hi...............");

var arr = fs.readdirSync("C:\\KDACWEB\\Day10\\NODEJSDemos\\00Demo");
for(var i = 0; i <arr.length; i++)
{
    console.log(arr[i]);
}

console.log("Bye...............");

