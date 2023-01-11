import React from 'react';

export default function Card(posts) {
    console.log(posts)
    return (
        <div className='group w-96 h-96 [perspective:1000px]'>
            <div className="relative w-full h-full [transform-style:preserve-3d] group-hover:[transform:rotateY(180deg)] transition-all duration-700">
                <div className='absolute inset-0 w-full h-full border-2 rounded-2xl bg-slate-200 [backface-visibility:hidden]'>
                    <div>{posts.children[0].title}</div>
                    <div>{posts.children[0].peopleNo}</div>
                    <div>{posts.children[0].cost}</div>
                    <div>성별 : 남자</div>
                    <div>흠냐</div>
                </div>
                <div className='absolute inset-0 w-full h-full border-2 rounded-2xl px-12 text-center bg-slate-500 [transform:rotateY(180deg)] [backface-visibility:hidden]'>
                    sdas
                </div>
            </div>

        </div>
    );
}

