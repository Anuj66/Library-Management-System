import {createContext, useContext} from "react";

const AuthContext = createContext()

export function AppWrapper({children}) {

    const signupApi = async (user) => {
        const response = await fetch('http://localhost:8080/api/v1/auth/signup', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(user)
        })
        return await response.json()
    }

    const loginApi = async (userCredentials) => {
        const response = await fetch('http://localhost:8080/api/v1/auth/signin', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(userCredentials)
        })
        return await response.json()
    }

    return (
        <AuthContext.Provider value={{signupApi, loginApi}}>
            {children}
        </AuthContext.Provider>
    )
}

export function useAuthContext() {
    return useContext(AuthContext)
}