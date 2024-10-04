const http = require("http");

var helper = http.createServer((request, response) => {
  console.log("you requested for " + request.url);

  if (request.url == "/employees") {
    response.write("Some employees details");
    response.end();
  } else {
    response.write("something else");
    response.end();
  }
});

helper.listen(9199, () => {
  console.log("server started.");
});
