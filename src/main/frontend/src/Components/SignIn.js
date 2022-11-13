import React, {useState} from 'react'
import axios from "axios";

export default function SignIn() {

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleUsername = (e) => {
        setUsername(e.target.value)
    }
    const handlePassword = (e) => {
        setPassword(e.target.value)
    }
    const buttonClick = () => {
        axios.post('member/signin', {
            username: username,
            password: password
        }).then(response => {
            if (response.data === "ok_success") {
                console.log("로그인 성공")
                alert("로그인 성공")
            } else {
                console.log("로그인 실패")
                alert("로그인 실패")
            }
        }).catch(error => console.log(error))
        setUsername('')
        setPassword('')

    }
    const enterPress = (e) => {
        if (e.key ==="Enter") {
            buttonClick()
        }
    }
    return (
        <>
            아이디 :<input value={username} onChange={handleUsername}/><br/>
            비밀번호 :<input value={password} onChange={handlePassword} onKeyPress={enterPress}/>
            <button onClick={buttonClick}>로그인</button>
        </>
    )
}

