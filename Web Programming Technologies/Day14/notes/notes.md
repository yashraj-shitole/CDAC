# react

## install and configure nodejs environment

```bash

# OS: linux (ubuntu)
# install node:

# installs nvm (Node Version Manager)
> curl -o https://raw.githubusercontent.com/nvm-sh/nvm/v0.40.0/install.sh | bash

# download and install Node.js (you may need to restart the terminal)
> nvm install 22

# verifies the right Node.js version is in the environment
> node -v # should print `v22.11.0`

# verifies the right npm version is in the environment
> npm -v # should print `10.9.0`


# OS: windows
# install node:

# installs fnm (Fast Node Manager)
> winget install Schniz.fnm

# configure fnm environment
> fnm env --use-on-cd | Out-String | Invoke-Expression

# download and install Node.js
> fnm use --install-if-missing 22

# verifies the right Node.js version is in the environment
> node -v # should print `v22.11.0`

# verifies the right npm version is in the environment
> npm -v # should print `10.9.0`

```

## install yarn package manager

```bash

# install yarn on linux
> sudo npm install -g yarn

# install yarn on windows
> npm install -g yarn

```

## create a new react application

```bash

# create a new application
# > npx create-react-app <application name>
> npx create-react-app app1

# run a react application
# NOTE: please make sure that you are in the application directory
# > cd app1
# > npm start
# > npm run start
> yarn start

# unit test the react application
# > npm test
# > npm run test
> yarn test

# build the application (compile the source into JS deployable package)
# > npm build
# > npm run build
> yarn build

```

## react application directory structure

- build (directory)
  - contains the compiled version of the current application
  - the code inside this directory needs to get deployed on the server
  - by default this directory does exist
  - when yarn build command is fired, the whole react application source code gets compiled into the build directory
- node_modules (directory)
  - contains the application dependencies (node modules)
  - since the application is using react library, this directory contains the react and its dependencies
- public (directory)
  - contains the public files of the website
  - contains
    - index.html
      - is the only web page in the react application
      - remaining JS code gets compiled into JS modules and get imported inside the index.html file
      - this is the file which starts when the react application starts
    - favicon.ico
      - icon file which is rendered as tab icon
    - logo files (logo192 and logo512)
      - multiple resolutions of website logo
    - manifest.json
      - contains the application resources metadata
- .gitignore (file)
  - non-react file used to ignore the files or directories while committing the version in git repository
- package.json (file)
  - used to define the application dependencies
  - contains
    - two types of dependencies
      - dependencies: list of dependencies which will be needed for running the application and hence will be compiled while building the application
      - devDependencies: list of dependencies which will NOT be needed for running the application, but needed to develop the application and hence will not be compiled while building the application
    - scripts
      - the commands which can be executed using yarn or npm command
    - lint configuration
      - lint is the process for fixing the syntax issues
      - uses JS linter to find and fix the syntax issues
- package-lock.json (file)
  - contains the list of node modules installed in node_modules directory
  - contains the versions of all modules installed
- README.md (file)
  - contains the read me information about the project
- src (directory)
  - index.js (file)
    - startup file which loads the react application
    - which creates React Root element and loads the first component of the application
  - app.js (file)
    - default or first component, the application (index.js) will load
    - the default name of first component is: App
  - app.test.js (file)
    - contains unit tests for App component present in app.js file
  - App.css (file)
    - contains CSS rules for the first component
  - reportWebVitals.js
    - used to get the web vital report (monitoring)
  - setupTests.js
    - used to configure the unit testing of react application

## react application startup

- execute command yarn start or npm run start
- react subsystem
  - compiles the application (JS code) into bundle.js
  - loads the script bundle.js into public/index.html file
    - <script src="/static/bundle.js">
  - loads the contents of index.css into public/index.html file
    - <style>contents of index.css</style>
  - starts a lite server instance on port 3000
  - loads the updated index.html inside the lite server
  - starts executing the code in index.html
  - which
    - finds an element with id as root and creates it as react root
    - the react root element is used to load the whole react application (component by component)
    - loads the first component named App inside the react root
    - the component App is a functional component which renders default UI
    - finally the UI starts appearing on the web browser

```javascript
// this line will create a DOM for react with the (div) element whose id is root
// this root element or DOM is used to manipulate the react component(s)
const root = ReactDOM.createRoot(document.getElementById('root'))

// this line will create html h1 tag object
const h1 = React.createElement(
  'h1', // tag to be created
  { className: 'h1' }, // properties
  'This is my h1 element' // contentsx
)

// this line will render the h1 tag created earlier in browser
root.render(h1)
```

## component

- react component is a function or class which has
  - code to render UI
  - code to handle the logic (UI elements)
- used as reusable entity
- react website is a collection of reusable components
- component can be as small as a single item or as big as a whole page
- a bigger component (like a page) can be created by combing smaller components
- types

  - class component
    - deprecated
  - functional component

    - a component created using a function
    - is faster in performance compared with class component
    - with react hook, now functional component can also maintain its state
    - a function which returns GUI design using jsx syntax

    ```javascript
    function App() {
      return <div> Welcome to first component </div>
    }
    ```

- difference between class component and functional component before react 16.8 version
  - class component by default maintains its state using state object and hence these components are known as stateful components (stateful component is the one which has a state)
  - functional component by default does not maintain the state and hence its known as stateless component

## props

- object which represents the properties of a component
- it is the only way to send the data from parent to child component
- props can be use only parent to send the data to the child (not vice-a-versa)
- the props object is readonly object (immutable)
  - child component is not allowed to update/modify the props sent by parent
  - even if child updates the value of props, it will not get reflected in parent

```javascript
function Parent() {
  return <div>
    <Child1 property1="value1" property2="value2">
    <Child2 property1="value1" property2="value2">
    <Child3 property1="value1" property2="value2">
  </div>
}
```

```javascript
// props here is an object which has all the properties sent by parent component
function Child1(props) {
  return (
    <div>
      <div>Property1 = {props.property1}</div>
      <div>Property2 = {props.property2}</div>
    </div>
  )
}
```

```javascript
// props here is an object which has all the properties sent by parent component
function Child2(props) {
  const { property1, property2 } = props
  return (
    <div>
      <div>Property1 = {property1}</div>
      <div>Property2 = {property2}</div>
    </div>
  )
}
```

```javascript
// props here is an object which has all the properties sent by parent component
function Child2({ property1, property2 }) {
  return (
    <div>
      <div>Property1 = {property1}</div>
      <div>Property2 = {property2}</div>
    </div>
  )
}
```

## virtual DOM

- is a copy of actual DOM
- used to compare the changes with actual DOM and update the UI accordingly
- manipulating the virtual DOM is faster than actual DOM
- react application performance is better than other frameworks because of the virtual DOM
- process
  - if a component's state is updated, the virtual DOM gets updated first
  - then react compares the virtual DOM with actual DOM and copies only the required changes in the actual DOM
  - this will avoid the whole page reloading and makes the application faster

## state

- render: loading the UI in browser
- need of state
  - react UI gets rendered when the application starts (root.render() in index.js)
  - react UI does not re-render on its own as it is a heavy and time consuming process
  - it has to get triggered to render the UI again
  - the component state is the one which can trigger the rendering of a component UI
- state
  - object created and managed by respective component
  - unlike props, the state object is rewritable (mutable)
  - if state changes, the UI for the component gets re-rendered
  - to add a state inside component
    - create a class component (which by default manages the state using state member)
    - use react hook named useState() in a functional component

## react hook

- a special function which starts with 'use'
- react uses this feature to modify the component dynamically
- types
  - system hooks
    - the hooks/functions provided by React
  - custom hook
    - the user defined hook
- e.g.
  - useState
  - useEffect
  - useMemo
  - useCallback
  - useReducer
  - useContent
- rules
  - always call the react hook outside of any function inside a component
    - must not be used inside loops, functions etc.
  - you can use hooks only within a functional component

### useState()

- react hook used to add state in functional component
- it accepts a parameter which will be the initial value of the state member
- it returns an array with
  - 1: reference to access the value from state object
  - 2: reference of a function to update the value inside the state object
- if the state object changes, only the component UI gets re-render (not the whole page)

```javascript
function Counter() {
  // manage the state
  // a new state member named counter will be added in state object with
  // initial value as 0
  // counter: reference to the position from state object
  // setCounter: reference to a function to update the state of counter member
  const [counter, setCounter] = useState(0)

  const onIncrement = () => {
    // this will trigger the component UI re-render
    setCounter(counter + 1)
  }

  const onDecrement = () => {
    // this will trigger the component UI re-render
    setCounter(counter - 1)
  }

  return (
    <div>
      <button onClick={onIncrement}>increment</button>
      counter = {counter}
      <button onClick={onDecrement}>decrement</button>
    </div>
  )
}
```

## adding external libraries

### bootstrap

- bootstrap is a framework having pre-defined css classes and javascript components
- it is mainly used to make the website responsive
  - which responds to the browser size change events
  - the website may get different look and feel on different devices like desktop, mobile, tablet and large screens
- adding bootstrap to react application

  - add the link and script tags in public/index.html

  ```html
  <html>
    <head>
      <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous"
      />

      <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"
      ></script>
    </head>
  </html>
  ```

## libraries

### client

- react: adds the react runtime
- react-dom: adds the DOM behavior from react
- axios: used to call REST APIs

### express server

- express: used to add express subsystem
- cors: used to enable CORS (Cross Origin Resource Sharing)
- multer: used to upload files
- mysql2: used to add mysql db connection support
- morgan: used to add logging
- jsonwebtoken: used to add JWT implementation
- nodemailer: used to send emails

## asynchronous or parallel programming

- JS support asynchronous programming using promises
- ways to implement promises
  - use Promise() to create a promise object
  - use async and await to create a promise object
- async..await is known as sugar statement (internally it uses promises)
- promise
  - way to execute a parallel code
  - states
    - created
    - success
    - error
