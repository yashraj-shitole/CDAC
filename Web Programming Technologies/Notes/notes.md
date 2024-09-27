# module

- every file having .js extension or java script code is called as NodeJS module
- node js by default injects an object named module in every file (module)
- this module object contains all the information about the module
- to export anything from a module, use module.exports key

  ```js
  // page1.js

  function function1() {}

  // export function1
  module.exports = { function1 }
  ```

- to import a module use require function
- require() returns exported entities from loaded module

  ```js
  // page2.js

  // loading page1 module
  const page1 = require('./page1')

  // calling the function1 from page1 module
  page1.function1()
  ```

## web framework

- the framework allows developer to create web services
- e.g.
  - express
    - internally uses http module
  - fastify
  - hapi

## package manager

- used to manage the packages
  - install
  - remove
  - update or upgrade
- e.g.
  - npm is a node package manager (default)
  - yarn is better than npm
  - pnpm is another option for package management
- commands

```bash

# install a package
# > npm install <package name>
> npm install express

```

## middleware

- a function which gets called before every route
- it received parameters
  - request
    - request sent by the client
    - same as route's request
  - response
    - response to be sent to the client
    - same as route's response
  - next
    - refers the next function to be called
- to add middleware in express application express has use function

  ```js
  // middleware
  app.use((request, response, next) => {
    // body
    next()
  })
  ```

- in case of multiple middlewares, all of them get called sequentially in the order of declaration
