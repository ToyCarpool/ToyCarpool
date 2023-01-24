import React, {useEffect, useState} from 'react';

import BoardList from "./BoardList";
import {getUser} from "../Utils/authentication";
import {useNavigate} from "react-router-dom";

export default function Home() {
    const [userData, setUserData] = useState(null)
    const navigate = useNavigate()

    const fetchUserData = async () => {
        const userRes = await getUser()
        setUserData(userRes)
    }
    useEffect(() => {
        fetchUserData()
    }, [])
    return (
        <div className="w-full flex justify-center align-middle flex-wrap">
            <header className="w-full h-header flex justify-end items-center">
                <div className="w-1/6 flex justify-center items-center">
                    <a className="flex justify-center align-center text-2xl" href="/login">로그인</a>
                </div>
                <div className="w-1/6 flex justify-center align-middle">
                    <a className="flex justify-center align-center text-2xl" href="/login">회원가입</a>
                </div>
            </header>
            <BoardList></BoardList>
            <div className='w-full'></div>
            {userData && <div onClick={()=>navigate("/Board/edit")}>글쓰기</div>}
        </div>
    );
}

