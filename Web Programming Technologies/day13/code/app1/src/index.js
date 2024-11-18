// const React = require('react')
import React from 'react'
import ReactDOM from 'react-dom/client'
import './index.css'
import App from './App'
import reportWebVitals from './reportWebVitals'

const root = ReactDOM.createRoot(document.getElementById('root'))
// root.render(App())
root.render(<App />)

// console.log(<App />)
// create html h1 element (tag)
// const h1 = React.createElement(
//   'h1',
//   { className: 'h1' },
//   'This is my h1 element'
// )
// root.render(h1)

// const div = React.createElement('div', {}, 'this is my div')
// root.render(div)

let number = 200
number = 300

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals()
