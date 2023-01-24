import React from 'react';
import CardElement from "./card/CardElement";

export default function Card({post}) {
    console.log(post)
    return (
        <div className='group w-card h-card mb-10 [perspective:1000px]'>
            <div className="relative w-full h-full [transform-style:preserve-3d] group-hover:[transform:rotateY(180deg)] transition-all duration-700">
                <div className='flex flex-wrap justify-center items-center absolute inset-0 w-full h-full border-2 rounded-2xl bg-slate-200 [backface-visibility:hidden]'>
                    <CardElement tag={"출발지"}>{post.departure}</CardElement>
                    <CardElement tag={"행선지"}>{post.destination}</CardElement>
                    <CardElement tag={"인원수"}>{post.peopleNo}</CardElement>
                    <CardElement tag={"참가비"}>{post.cost}</CardElement>
                    <CardElement tag={"성별"}>{post.writer_gender === "MALE"? "남자" : "여자"}</CardElement>
                </div>
                <div className='flex flex-wrap justify-center items-center absolute inset-0 w-full h-full border-2 rounded-2xl px-12 text-center bg-slate-500 [transform:rotateY(180deg)] [backface-visibility:hidden]'>
                    <CardElement tag={"출발지"}>{post.departure}</CardElement>
                    <CardElement tag={"행선지"}>{post.destination}</CardElement>
                    <CardElement tag={"인원수"}>{post.peopleNo}</CardElement>
                    <CardElement tag={"참가비"}>{post.cost}</CardElement>
                    <CardElement tag={"성별"}>{post.writer_gender === "MALE"? "남자" : "여자"}</CardElement>
                </div>
            </div>

        </div>
    );
}

