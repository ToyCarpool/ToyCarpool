import React, {useState} from 'react'
import axios from "axios";
export default function SignUp() {

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleUsername = (e) => {
        setUsername(e.target.value)
    }
    const handlePassword = (e) => {
        setPassword(e.target.value)
    }
    const buttonClick = () => {
        axios.post('member/signup', {
            username: username,
            password: password
        }).then(response => {
            if (response.data === "ok_success") {
                console.log("회원가입 성공")
                alert("회원가입 성공")
            } else {
                console.log("회원가입 실패")
                alert("회원가입 실패")
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
            <button onClick={buttonClick}>회원가입</button>
        </>
    )
}

