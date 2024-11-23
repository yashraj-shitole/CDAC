import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { getProductList } from "../util/product";
import { toast } from "react-toastify";

const Products = () => {
  const [products, setProducts] = useState([])

  const onLoadProducts = async () => {
    const result = await getProductList()
    console.log(result)
    if (result['status'] == 'success') {
      setProducts(result['data'])
    } else {
      toast.error(result['error'])
    }
  }

  useEffect(() => {
    onLoadProducts()
  }, [])

  return (
    <div>
      <div className='flex flex-col items-center'>
        <h2 className='text-3xl p-3 font-bold'>Products</h2>

        <Link  className=" rounded-full w-fit border shadow-[#38383860] shadow-md hover:bg-[#222831] hover:text-white  px-5 py-2 font-extrabold border-accent" to='/home/addproducts'>
          Add
        </Link>
        {products.length == 0 && (
          <h4>There are no products, please use add button to add one</h4>
        )}
        {products.length > 0 && (
              <div className="flex p-10 w-full">

          <table className='w-full mt-5 border-2 border-[#31363F] border-collapse'>
            <thead>
              <tr>
                <th className="border-2 border-[#31363F] border-collapse">No</th>
                <th className="border-2 border-[#31363F] border-collapse">Image</th>
                <th className="border-2 border-[#31363F] border-collapse">Title</th>
                <th className="border-2 border-[#31363F] border-collapse">Details</th>
                <th className="border-2 border-[#31363F] border-collapse">Price</th>
                <th className="border-2 border-[#31363F] border-collapse">Tags</th>
                <th style={{ width: 135 }}>Actions</th>
              </tr>
            </thead>
            <tbody>
              {products.map((product) => {
                return (
                  <ProductRow
                    id={product['id']}
                    title={product['title']}
                    details={product['details']}
                    price={product['price']}
                    image={product['image']}
                    tags={product['tags']}
                  />
                )
              })}
            </tbody>
          </table>

          </div>
        )}
      </div>
    </div>
  )
}
export default Products;
