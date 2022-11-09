import React, {useState} from 'react'
import axios from "axios";
function Login() {

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
            name: username,
            password: password
        }).then(response => {

            if (response.data === "ok_success") {
                console.log("로그인 성공")
                // 여기랑 밑에 둘 다 중복되니까 if else 밖으로
                setUsername('')
                setPassword('')
            } else {
                console.log("로그인 실패")
                setUsername('')
                setPassword('')
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

export default Login