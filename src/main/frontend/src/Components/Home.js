import React from 'react';
import { Link } from 'react-router-dom';

export default function Home() {
    return (
        <div>
            <a href="/api/member/loginForm">로그인</a>
            <Link to={"/SignUp"}>회원가입</Link>
            <Link to={"/Board"}>게시판</Link>
        </div>
    );
}

