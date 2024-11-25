import { useEffect, useState } from 'react'
import Navbar from '../components/Navbar'
import { getCustomerList, toggleUser } from '../services/customer'
import { toast } from 'react-toastify'

function Customers() {
  const [customers, setCustomers] = useState([])

  const onLoadCustomers = async () => {
    const result = await getCustomerList()
    if (result['status'] == 'success') {
      setCustomers(result['data'])
    } else {
      toast.error(result['error'])
    }
  }

  useEffect(() => {
    onLoadCustomers()
  }, [])

  const onToggleCustomer = async (userId, status) => {
    const result = await toggleUser(userId, status)
    if (result['status'] == 'success') {
      toast.success('Successfully updated customer')
      onLoadCustomers()
    } else {
      toast.error(result['error'])
    }
  }

  return (
    <div>
      <Navbar />
      <h2 className='header'>Users</h2>
      <div className='container'>
        {customers.length > 0 && (
          <table className='table table-hover'>
            <thead>
              <tr>
                <th>No</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {customers.map((customer, index) => {
                return (
                  <tr>
                    <td>{index + 1}</td>
                    <td>{customer['firstName']}</td>
                    <td>{customer['lastName']}</td>
                    <td>{customer['email']}</td>
                    <td>{customer['phone']}</td>
                    <td>
                      <button
                        onClick={() => {
                          onToggleCustomer(
                            customer['id'],
                            customer['isActive'] == 1 ? 0 : 1
                          )
                        }}
                        className={
                          'btn ' +
                          (customer['isActive'] == 1
                            ? ' btn-danger'
                            : ' btn-success')
                        }
                      >
                        {customer['isActive'] == 1 ? 'block' : 'unblock'}
                      </button>
                    </td>
                  </tr>
                )
              })}
            </tbody>
          </table>
        )}
      </div>
    </div>
  )
}

export default Customers
