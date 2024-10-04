const os=require('os')

// console.log(os)

var platFormDetails= os.platform()

var freeMemoryDetails= os.freemem()

var cpuArchitectureDetails= os.arch()

var availableParallelism= os.availableParallelism()

var hostname= os.hostname()



console.log(platFormDetails)
console.log(freeMemoryDetails)
console.log(cpuArchitectureDetails)
console.log(availableParallelism)
console.log(hostname)
