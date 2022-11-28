import React from 'react';
import { Link } from 'react-router-dom';

export default function Home() {
    return (
        <div>
            <Link to={"/SignIn"}>로그인</Link>
            <Link to={"/SignUp"}>회원가입</Link>
            <Link to={"/Board"}>게시판</Link>
        </div>
    );
}

