import { useEffect, useState } from "react";
import '../node_modules/bootstrap/dist/css/bootstrap.css';
import axios from "axios";

function Home() 
{
    const [emps, setEmps]  = useState([]);
    const [emp, setEmp] = useState({no :0, name : "", address: ""});
    const [message, setMessage] = useState("");
    var url = `http://localhost:5158/Emps`;

    const GetData = ()=>{
        axios.get(url).then((result)=>{
            debugger;
            setEmps(result.data);
        })
    }

    useEffect(()=>{
        GetData();
        setMessage("Data Fetched!");
    }, [])

    const OnTextChanged=(args)=>{
        var copyOfEmp = {...emp};
        copyOfEmp[args.target.name] = args.target.value;
        setEmp(copyOfEmp);
    }

    const AddRecord =()=>{
        axios.post(url, emp).then((reply)=>{
            if(reply.status == 200)
            {
                GetData();
                setMessage("Data Added!");
            }
        });
    }

    const UpdateRecord =()=>{
        axios.put(url + `/${emp.no}`, emp).then((reply)=>{
            if(reply.status == 200)
            {
                GetData();
                setMessage("Data Updated!");
            }
        });
    }

    const Delete =(no)=>{
        axios.delete(url + `/${no}`).then((reply)=>{
            if(reply.status == 200)
            {
                GetData();
                setMessage("Data Deleted!");
            }
        });
    }


    const Edit=(emp)=>{
        debugger;
        setEmp(emp);
        setMessage("Record Found!");
    }

    const Clear = ()=>{
        setEmp({no :0, name : "", address: ""});
    }

    useEffect(()=>{
        if(message!="")
        {
            setTimeout(() => {
                setMessage("");
            }, (3000));
        }
    }, [message]);

    return (<>
              <div className="container">
                   <div className="table-responsive">
                        <table className="table table-bordered">
                            <tbody>
                                <tr>
                                    <td>Name</td>
                                    <td>
                                        <input type="hidden" name="no" value={emp.no} onChange={OnTextChanged}/>
                                        <input type="text" name="name" value={emp.name} onChange={OnTextChanged}/>
                                    </td>
                                </tr>

                                <tr>
                                    <td>Address</td>
                                    <td>
                                        <input type="text" name="address" value={emp.address} onChange={OnTextChanged}/>
                                    </td>
                                </tr>
                                <tr>
                                    <td colSpan={2}>
                                      <button className="btn btn-primary" onClick={AddRecord}>Add record</button>
                                      <button className="btn btn-success" onClick={UpdateRecord}>Update record</button>
                                    </td>
                                      
                                </tr>
                            </tbody>
                        </table>
                    </div>
                <hr></hr>
                <h1 className="alert alert-success">{message}</h1>
                <hr></hr>
                <div className="table-responsive">
                    <table className="table table-bordered">
                        <thead>
                            <th>No</th>
                            <th>Name</th>
                            <th>Address</th>
                        </thead>
                        <tbody>
                            {
                                emps.map(emp=>{
                                    return  (<tr key={emp.no}>
                                                <td>{emp.no}</td>
                                                <td>{emp.name}</td>
                                                <td>{emp.address}</td>
                                                <td>
                                                    <button className="btn btn-warning" onClick={()=>{
                                                        Edit(emp);
                                                    }}>Edit</button>
                                                </td>
                                                <td>
                                                    <button className="btn btn-danger" onClick={()=>{
                                                        Delete(emp.no);
                                                    }}>Delete</button>
                                                </td>
                                            </tr>)
                                })
                            }
                        </tbody>
                    </table>
                </div>
              </div>
            </>);
}

export default Home;