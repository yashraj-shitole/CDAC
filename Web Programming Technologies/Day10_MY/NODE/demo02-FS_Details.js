const fs = require('fs')

// console.log(fs)

var a=fs.readdirSync("c:\\Users\\yashr\\OneDrive\\Desktop\\CDAC\\Web Programming Technologies")

for(var i=0;i<a.length;i++){
    console.log(a[i])
}

