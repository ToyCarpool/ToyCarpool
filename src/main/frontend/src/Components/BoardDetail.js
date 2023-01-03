import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import axios from "axios"


export default function BoardDetail() {
    const [post, setPost] = useState(null)
    const { id } = useParams()

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
        async function fetching() {
            await fetchData()
        }
        fetching()
    }, [])


    return (
        <div className='board_box'>
            {post &&
            <div>
                {post.cost}<br/>
                {post.description}<br/>
                {post.id}<br/>
                {post.member_id}<br/>
                {post.open}<br/>
                {post.peopleNo}<br/>
                {post.startTime}<br/>
                {post.title}
            </div>}

        </div>
    );
}

