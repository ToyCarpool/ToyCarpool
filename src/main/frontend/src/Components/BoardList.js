import React, { useEffect, useState } from 'react'
import axios from "axios"
import { useNavigate } from 'react-router-dom'
import { getUser } from "../Utils/authentication";
import Card from "./Card";

export default function BoardList() {
    const [posts, setPosts] = useState(null)
    const [page, setPage] = useState(1) 
    const [pageCount, setPageCount] = useState(null)

    const makeButton = () => {
        let arr = []
        for (let i = 0; i < pageCount; i++){
            arr.push(<button key={i} className="bg-transparent hover:bg-blue-500 text-blue-700 font-semibold hover:text-white py-2 px-4 border border-blue-500 hover:border-transparent rounded" onClick={pageLoad} value={i+1}> {i+1} </button>)
        }
        return arr 
    }
    
    const pageLoad = (e) => {
        setPage(e.target.value)
    }

    const fetchData = async (page, size) => {
        try{
            const response = await axios.get(`api/board/list?page=${page-1}&size=${size}`)
            setPosts(response.data.content)
            setPageCount(response.data.totalPages)
            // console.log(response.data)
        } catch(e) {
            console.log(e)
        }
    }

    useEffect(() => {
        fetchData(page, 9)
    }, [])


    useEffect(() => {
        fetchData(page, 9)
    }, [page])

    if (!posts) {
        return null
    }

    return (
        <div className='flex flex-wrap w-cardlist justify-evenly items-start'>
            {
                posts.map((post) => {
                    return (<Card key={post.id} post={post}/>)
                })
            }
            <div className='flex justify-center w-full'>
                {makeButton()}
            </div>
        </div>
    );
}

