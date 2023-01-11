import React, { useEffect, useState } from 'react'
import axios from "axios"
import { useNavigate } from 'react-router-dom'
import { getUser } from "../Utils/authentication";
import Card from "./Card";

export default function BoardList() {
    const [posts, setPosts] = useState(null)
    const [page, setPage] = useState(1) 
    const [pageCount, setPageCount] = useState(null)
    const [userData, setUserData] = useState(null)
    
    const navigate = useNavigate()

    const handleClick = (id) => {
      navigate(`${id}`)
    };

    const makeButton = () => {
        let arr = []
        for (let i = 0; i < pageCount; i++){
            arr.push(<button className="bg-transparent hover:bg-blue-500 text-blue-700 font-semibold hover:text-white py-2 px-4 border border-blue-500 hover:border-transparent rounded" onClick={pageLoad} value={i+1}> {i+1} </button>)
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
            console.log(response.data)
        } catch(e) {
            console.log(e)
        }
    }
    const fetchUserData = async () => {
        const userRes = await getUser()
        setUserData(userRes)
    }

    useEffect(() => {
        fetchData(page, 9)
        fetchUserData()
    }, [])


    useEffect(() => {
        fetchData(page, 9)
    }, [page])

    if (!posts) {
        return null
    }

    return (
        <div className='board_box'>
            <Card>{posts}</Card>
            <Card>{posts}</Card>
            <Card>{posts}</Card>
            <Card>{posts}</Card>
            <Card>{posts}</Card>
            <Card>{posts}</Card>
            <Card>{posts}</Card>
            {/*<div className='board_table'>*/}
            {/*    <div className='board_table--header'>*/}
            {/*        <div className='board_table--header--num'>#</div>*/}
            {/*        <div className='board_table--header--title'>제목</div>*/}
            {/*        <div className='board_table--header--peopleNo'>인원 수</div>*/}
            {/*        <div className='board_table--header--cost'>가격</div>*/}
            {/*    </div>*/}
            {/*    {posts.map(post=>{*/}
            {/*        return(*/}
            {/*            <div className='board_table--item' onClick={()=>handleClick(post.id)}>*/}
            {/*                <div className='board_table--item--num'>{post.id}</div>*/}
            {/*                <div className='board_table--item--title'>{post.title}</div>*/}
            {/*                <div className='board_table--item--peopleNo'>{post.peopleNo}</div>*/}
            {/*                <div className='board_table--item--cost'>{post.cost}</div>*/}
            {/*            </div>*/}
            {/*        )*/}
            {/*    })}*/}
            {/*</div>*/}
            <div className='button_box'>
            {makeButton()}
            </div>
            {userData && <div onClick={()=>navigate("/Board/edit")}>글쓰기</div>}
        </div>
    );
}

