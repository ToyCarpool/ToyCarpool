import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import axios from "axios";


export default function BoardDetail() {
    const [post, setPost] = useState(null);
    const { id } = useParams();

    const fetchData = async () => {
        try{
            const response = await axios.get(`/api/board/${id}`)
            console.log(response.data)

            setPost(response.data);
        } catch(e) {
            console.log(e)
        }
    }
    useEffect(() => {
        fetchData()
    }, [])    

    if (!post) {
        return null
    }
    return (
        <div className='board_box'>
            <div>
                {post.cost}<br/>
                {post.description}<br/>
                {post.id}<br/>
                {post.member_id}<br/>
                {post.open}<br/>
                {post.peopleNo}<br/>
                {post.startTime}<br/>
                {post.title}
                
            </div>
        </div>
    );
}

