const sql=require('mysql2')


var connectionDetails={
    host:"localhost",
    database:"nodePractice",
    user:"KD1-Yashraj-86633",
    password:"yashraj123",
    port:3306
};


var connection=sql.createConnection(connectionDetails);

connection.connect();
console.log("Connected to database")


// var queryTxt="create table employees(id int, name varchar(255), salary int)"
// connection.query(queryTxt)


//--------------------TO INSERT----------------------------------------------

// var insertQuery="insert into employees  values(1,'yashraj',10000)"
// connection.query(insertQuery)

//--------------------TO UPDATE----------------------------------------------

// var updateQuery="update employees set salary=20000 where id=1"
// connection.query(updateQuery)

//--------------------TO DELETE----------------------------------------------

// var deleteQuery="delete from employees where id=1"
// connection.query(deleteQuery)

//--------------------TO SELECT----------------------------------------------

// var selectQuery="select * from employees"
// connection.query(selectQuery,(error,result)=>{
//     if(error==null){
//         console.log(JSON.stringify(result))
//     }
//     else{
//         console.log(error)
//     }
// })