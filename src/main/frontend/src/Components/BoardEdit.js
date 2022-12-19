import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

import axios from "axios";

export default function BoardEdit() {
    const [title, setTitle] = useState("")
    const [description, setDescription] = useState("")
    const [destination, setDestination] = useState("")
    const [cost, setCost] = useState(0)
    const [peopleNo, setPeopleNo] = useState(0)
    const [member_id, setMemberId] = useState(0)

    const navigate = useNavigate();

    const handleTitle = (e) => {
        setTitle(e.target.value)
    }

    const handleDescription = (e) => {
        setDescription(e.target.value)
    }    

    const handleDestination = (e) => {
        setDestination(e.target.value)
    }    
    
    const handleCost = (e) => {
        setCost(e.target.value)
    }

    const handlePeopleNo = (e) => {
        setPeopleNo(e.target.value)
    }

    const sendPost = async () => {
        try{
            const response = await axios.post(`/api/board/write`, {
                title,
                description,
                destination,
                cost,
                peopleNo,
                member_id
            })
            console.log(response)
            navigate(`/Board/${response.data.id}`)
        } catch(e) {
            console.log(e)
        }
    }    
    return (
        <div>
            제목:<input value={title} onChange={handleTitle}/>
            내용:<input value={description} onChange={handleDescription}/>
            목적지:<input value={destination} onChange={handleDestination}/>
            가격:<input value={cost} onChange={handleCost}/>
            모을 사람 수:<input value={peopleNo} onChange={handlePeopleNo}/>
            <button onClick={sendPost}>제출</button>
        </div>
    );
}

