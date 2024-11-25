import { useEffect, useState } from 'react'
import { getOrderList } from '../services/order'
import { toast } from 'react-toastify'
import { createUrl } from '../utils'
import './Order.css'

function Orders() {
  const [orders, setOrders] = useState([])

  const onLoadOrders = async () => {
    const result = await getOrderList()
    console.log(result)
    if (result['status'] == 'success') {
      setOrders(result['data'])
    } else {
      toast.error(result['error'])
    }
  }

  useEffect(() => {
    onLoadOrders()
  }, [])

  return (
    <div>
      <h2 className='header'>Orders</h2>

      {orders.length == 0 && <h5>There are no orders placed by you </h5>}
      {orders.length > 0 && (
        <div>
          {orders.map((order) => {
            return (
              <div className='order-item'>
                <div>
                  <label style={{ width: 100, fontWeight: 'bold' }} htmlFor=''>
                    Order Id:{' '}
                  </label>
                  <span>{order['order']['id']}</span>
                </div>
                <div>
                  <label style={{ width: 100, fontWeight: 'bold' }} htmlFor=''>
                    Date:{' '}
                  </label>
                  <span>{order['order']['createdDateTime']}</span>
                </div>
                <div>
                  <label style={{ width: 100, fontWeight: 'bold' }} htmlFor=''>
                    Status:{' '}
                  </label>
                  <span>{order['order']['status']}</span>
                </div>
                <hr />
                <table className='table'>
                  <tbody>
                    {order['details'].map((orderDetails) => {
                      return (
                        <tr>
                          <td>
                            <img
                              style={{ width: 50, height: 50 }}
                              src={createUrl(orderDetails['image'])}
                              alt=''
                            />
                          </td>
                          <td>{orderDetails['title']}</td>
                          <td>{orderDetails['quantity']}</td>
                          <td>{orderDetails['price']}</td>
                          <td>
                            {orderDetails['quantity'] * orderDetails['price']}
                          </td>
                        </tr>
                      )
                    })}
                  </tbody>
                </table>
              </div>
            )
          })}
        </div>
      )}
    </div>
  )
}

export default Orders
