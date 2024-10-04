//imports multiple functions in a single object which are exported from other js file and stores into variable as object
const calculate=require('./file1_Functions');


var arr=[1,2,3,4,5,6,7,7]

var result=calculate.cal(arr,"mul")

console.log(result)
