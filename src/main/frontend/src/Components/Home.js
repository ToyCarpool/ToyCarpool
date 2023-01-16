import React from 'react';

import BoardList from "./BoardList";

export default function Home() {
    return (
        <div>
            <a className="text-3xl" href="/loginForm">로그인</a>
            <a href="/loginForm">회원가입</a>
            <BoardList></BoardList>
        </div>
    );
}

