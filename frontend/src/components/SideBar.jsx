import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import { toast } from 'react-toastify';
import { ListGroup, ListGroupItem } from 'reactstrap'
import { fetchCategories } from '../services/categoryServices';

function SideBar() {
    const [categories,setcategories]=useState([]);
    useEffect(
        ()=>{
            loadCategories();
        }
        ,[])
        async function loadCategories() {
            try{
            const {data}=await fetchCategories();
            console.log(data)
            setcategories(data);
            }catch(err){
                console.log(err);
                toast.error("something went wrong while fetching the category")
            }

            
        }
  return (
    <ListGroup>
        <ListGroupItem action={true} tag={Link} to="/user/dashboard"  >
            All
        </ListGroupItem>
        {categories?.map((c,index)=>{
            return(
                <ListGroupItem key={index} action={true}  tag={Link} to={"/user/categories/"+c.id}>
                {
                    c.categoryTitle
                }

                </ListGroupItem>
            )
        })}
    </ListGroup>
  )
}

export default SideBar