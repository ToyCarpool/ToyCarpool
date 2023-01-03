import React, { useState,useEffect } from 'react';
import { useNavigate, redirect } from 'react-router-dom';

import axios from "axios";
import {getUser} from "../Utils/authentication";

export default function BoardEdit() {
    const navigate = useNavigate()

    const [form, setForm] = useState({
        title:"",
        description:"",
        destination:"",
        cost:0,
        peopleNo:0,
        member_id:0
    });
    const [userData, setUserData] = useState(null)

    const fetchUserData = async () => {
        const userRes = await getUser()
        setUserData(userRes);
    }

    const handleForm = (e) => {
        setForm({
            ...form, [e.target.name] :e.target.value
        })
    }

    useEffect(() => {
        async function noUserRedirect() {
            await fetchUserData();
            if (userData) {
                return redirect("/api/member/loginForm");
            }
        }
        noUserRedirect()
    }, [])

    const sendPost = async () => {
        try{
            const response = await axios.post(`/api/board/write`, {
                title : form.title,
                description : form.description,
                destination : form.destination,
                cost : form.cost,
                peopleNo : form.peopleNo,
                member_id : userData.data.id
            })
            console.log(response)
            navigate(`/Board/${response.data.id}`)
        } catch(e) {
            console.log(e)
            alert(e)
        }
    }    
    return (
        <div>
            제목:<input name="title" value={form.title} onChange={handleForm}/>
            내용:<input name="description" value={form.description} onChange={handleForm}/>
            목적지:<input name="destination" value={form.destination} onChange={handleForm}/>
            가격:<input name="cost" value={form.cost} onChange={handleForm}/>
            모을 사람 수:<input name="peopleNo" value={form.peopleNo} onChange={handleForm}/>
            <button onClick={sendPost}>제출</button>
        </div>
    );
}

