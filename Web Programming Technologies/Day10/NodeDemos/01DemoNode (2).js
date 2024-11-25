
const v = require('./Calc');
console.log(v);

// v = 100; //this line will throw err because v is constant now 

var result = v.f1(10,20);
console.log(result);

//  var somethingExportedFromCalc = require('./Calc');
//  console.log(somethingExportedFromCalc);

// var result = somethingExportedFromCalc.f1(10,20);
// console.log(result);

//Below code will fail without import / export
// var result = Add(10,20);
// console.log(result);