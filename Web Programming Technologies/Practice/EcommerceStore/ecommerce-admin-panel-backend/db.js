const mysql = require('mysql2')

const pool = mysql.createPool({
  host: 'localhost',
  user: 'KD1-Yashraj-86633',
  password: 'yashraj123',
  database: 'ecommerce_store_db',
  waitForConnections: true,
  connectionLimit: 10,
  maxIdle: 10, // max idle connections, the default value is the same as `connectionLimit`
  idleTimeout: 60000, // idle connections timeout, in milliseconds, the default value 60000
  queueLimit: 0,
  enableKeepAlive: true,
  keepAliveInitialDelay: 0,
})

module.exports = { pool }