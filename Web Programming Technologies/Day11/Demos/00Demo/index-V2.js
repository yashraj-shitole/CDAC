// --------------------------------------------DELETE
// const mysql = require('mysql');
// // console.log(mysql);

// var connectionDetails =
//                         {
//                             host: "localhost",
//                             database : "classwork",
//                             user: "root",
//                             password: "manager",
//                             port : 3306
//                         };

// var connection = mysql.createConnection(connectionDetails);
// connection.connect();

// var queryText = `delete from Employees where No = 5`;
// connection.query(queryText, (error, result)=>{
//     if(error==null)
//     {
//         console.log("Success!!!")
//         console.log(JSON.stringify(result));
//     }
//     else
//     {
//         console.log("something wrong!")
//         console.log(error);
//     }
// });

// connection.end();

// ------------------------------------------------UPDATE
// const mysql = require('mysql');
// // console.log(mysql);

// var connectionDetails =
//                         {
//                             host: "localhost",
//                             database : "classwork",
//                             user: "root",
//                             password: "manager",
//                             port : 3306
//                         };

// var connection = mysql.createConnection(connectionDetails);
// connection.connect();

// var queryText = `update Employees set Address='Goa' where No = 5`;
// connection.query(queryText, (error, result)=>{
//     if(error==null)
//     {
//         console.log("Success!!!")
//         console.log(JSON.stringify(result));
//     }
//     else
//     {
//         console.log("something wrong!")
//         console.log(error);
//     }
// });

// connection.end();

// ---------------------------------------------INSERT
// const mysql = require('mysql');
// // console.log(mysql);

// var connectionDetails =
//                         {
//                             host: "localhost",
//                             database : "classwork",
//                             user: "root",
//                             password: "manager",
//                             port : 3306
//                         };

// var connection = mysql.createConnection(connectionDetails);
// connection.connect();

// var queryText = `insert into Employees values(5, 'Amit', 'Kolhapur')`;
// connection.query(queryText, (error, result)=>{
//     if(error==null)
//     {
//         console.log("Success!!!")
//         console.log(JSON.stringify(result));
//     }
//     else
//     {
//         console.log("something wrong!")
//         console.log(error);
//     }
// });

// connection.end();

// -------------------------------------------SELECT
// const mysql = require('mysql');
// // console.log(mysql);

// var connectionDetails =
//                         {
//                             host: "localhost",
//                             database : "classwork",
//                             user: "root",
//                             password: "manager",
//                             port : 3306
//                         };

// var connection = mysql.createConnection(connectionDetails);
// connection.connect();

// var queryText = `select * from Employees`;
// connection.query(queryText, (error, result)=>{
//     if(error==null)
//     {
//         console.log("Success!!!")
//         console.log(JSON.stringify(result));
//     }
//     else
//     {
//         console.log("something wrong!")
//         console.log(error);
//     }
// });

// connection.end();
