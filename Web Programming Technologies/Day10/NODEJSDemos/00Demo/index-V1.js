const os = require('os');
// console.log(os);

var platFormDetails =  os.platform();
console.log("Platform Details " + platFormDetails);

var freeMemoryDetails =  os.freemem();
console.log("Avalaible Free Memory " + freeMemoryDetails);

var cpuArchitectureDetails =  os.arch();
console.log("Architecture Details " + cpuArchitectureDetails);
