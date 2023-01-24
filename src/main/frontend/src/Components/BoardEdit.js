import React, { useState,useEffect } from 'react';
import { useNavigate, redirect } from 'react-router-dom';

import axios from "axios";
import {getUser} from "../Utils/authentication";

export default function BoardEdit() {
    const navigate = useNavigate()

    const [form, setForm] = useState({
        title:"",
        description:"",
        departure:"",
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
        (async function noUserRedirect() {
            await fetchUserData();
            if (userData) {
                return redirect("/login");
            }
        })()
    }, [])

    const sendPost = async () => {
        try{
            const response = await axios.post(`/api/board/write`, {
                title : form.title,
                description : form.description,
                departure : form.departure,
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
        <div className="w-full flex justify-center items-center flex-wrap">
            <div className="w-full flex justify-center items-center">
                <div className="w-1/5 h-20 flex justify-center items-center text-2xl">제목</div>
                <div className="w-1/5"><input className="border-2" name="title" value={form.title} onChange={handleForm}/></div>
            </div>
            <div className="w-full flex justify-center items-center">
                <div className="w-1/5 h-20 flex justify-center items-center text-2xl">출발지</div>
                <div className="w-1/5"><input className="border-2" name="departure" value={form.departure} onChange={handleForm}/></div>
            </div>
            <div className="w-full flex justify-center items-center">
                <div className="w-1/5 h-20 flex justify-center items-center text-2xl">목적지</div>
                <div className="w-1/5"><input className="border-2" name="destination" value={form.destination} onChange={handleForm}/></div>
            </div>
            <div className="w-full flex justify-center items-center">
                <div className="w-1/5 h-20 flex justify-center items-center text-2xl">가격</div>
                <div className="w-1/5"><input className="border-2" name="cost" value={form.cost} onChange={handleForm}/></div>
            </div>
            <div className="w-full flex justify-center items-center">
                <div className="w-1/5 h-20 flex justify-center items-center text-2xl">모을 사람 수</div>
                <div className="w-1/5"><input className="border-2" name="peopleNo" value={form.peopleNo} onChange={handleForm}/></div>
            </div>
            <button className="bg-transparent hover:bg-blue-500 text-blue-700 font-semibold hover:text-white py-2 px-4 border border-blue-500 hover:border-transparent rounded" onClick={sendPost}>제출</button>
        </div>
    );
}

