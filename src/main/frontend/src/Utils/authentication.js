import axios from "axios";

export async function getUser() {
    try {
        let response = await axios.get("/api/auth")
        console.log(response)
        return response
    } catch (e) {
        alert(e)
    }
}