import React, { useEffect, useState } from 'react';
import axios from "axios";
import { useNavigate } from 'react-router-dom';

export default function Board() {
    const [posts, setPosts] = useState(null)
    const [page, setPage] = useState(1) 
    const [pageCount, setPageCount] = useState(null)
    
    const navigate = useNavigate();

    const handleClick = (id) => {
      // 👇️ navigate programmatically
      navigate(`${id}`);
    };

    const makeButton = () => {
        let arr = []
        for (let i = 0; i < pageCount; i++){
            arr.push(<button onClick={pageLoad} value={i+1}> {i+1} </button>)
        }
        return arr 
    }
    
    const pageLoad = (e) => {
        setPage(e.target.value)
    }

    const fetchData = async (page, size) => {
        try{
            const response = await axios.get(`api/board/list?page=${page}&size=${size}`)
            setPosts(response.data.content)
            setPageCount(response.data.totalPages)
            console.log(response.data)
        } catch(e) {
            console.log(e)
        }
    }

    useEffect(() => {
        fetchData(page, 3)
    }, [])
    
    useEffect(() => {
        fetchData(page, 3)
    }, [page])

    if (!posts) {
        return null
    }


    return (
        <div className='board_box'>
            <div className='board_table'>
                <div className='board_table--header'>
                    <div className='board_table--header--num'>#</div>
                    <div className='board_table--header--title'>제목</div>
                    <div className='board_table--header--peopleNo'>인원 수</div>
                    <div className='board_table--header--cost'>가격</div>
                </div>
                {posts.map(post=>{
                    return(
                        <div className='board_table--item' onClick={()=>handleClick(post.id)}>
                            <div className='board_table--item--num'>{post.id}</div>
                            <div className='board_table--item--title'>{post.title}</div>
                            <div className='board_table--item--peopleNo'>{post.peopleNo}</div>
                            <div className='board_table--item--cost'>{post.cost}</div>
                        </div>
                        
                    )
                })}
            </div>
            <div className='button_box'>
            {makeButton()}
            </div>
            <div onClick={()=>navigate("/Board/edit")}>글쓰기</div>
        </div>
    );
}

