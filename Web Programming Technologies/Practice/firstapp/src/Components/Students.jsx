function Students(){


    const studentData=[
        {id:1,name:"Yashraj",rollNo:86633},
        {id:2,name:"Indrajeet",rollNo:86641},
        {id:3,name:"Prathamesh",rollNo:86639},
        {id:4,name:"Pratik",rollNo:86660}
    ]

    return(

        <div>
            <h1>This is student component.</h1>

            <div style={{width:"100%",display:"flex",flexWrap:"wrap",gap:"20px",alignItems:"center",justifyContent:"center"}}>
                {
                    studentData.map(student=> (
                    <div key={student.id} style={{display:"flex",gap:"20px",padding:"20px", backgroundColor:"#697565",width:"300px",borderRadius:"50px",border:"1px #38383860 solid", display:"flex",alignItems:"center",justifyContent:"center"}}>
                    <h3>{student.id}</h3>
                    <h3>{student.name}</h3>
                    <h3>{student.rollNo}</h3>
                    </div>
                ))
                }
            </div>
        </div>
        
    )


}

export default Students