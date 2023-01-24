import React from 'react';

export default function CardElement({tag, children}) {
    return (
        <div className="flex flex-wrap justify-center items-center w-full p-2 text-sm">
            <div className="flex justify-center items-center w-1/4" >{tag}</div>
            <div className="flex justify-center items-center w-3/4" >{children}</div>
        </div>
    );
}