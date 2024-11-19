import persondata from '../Data/demodata.json'

function DataTable(){

    return(
            <table style={{margin:"20px", backgroundColor:"#3C3D37",border:"1px #38383860 solid",borderRadius:"25px"}}>
            <tr style={{backgroundColor:"#697565"}}>
                <th>Name</th>
                <th>Language</th>
                <th>Id</th>
                <th>Bio</th>
            </tr>
            
            {
                persondata.map(person=>(
                    <tr style={{}}>
                    <td>{person.name}</td>
                    <td>{person.language}</td>
                    <td>{person.id}</td>
                    <td>{person.bio}</td>
                    </tr>
                ))
            }
            </table>
    )
}

export default DataTable