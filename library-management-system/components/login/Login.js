import styles from './Login.module.css'
import {Box, Button, FormControl, FormHelperText, FormLabel, Input, VStack} from "@chakra-ui/react";
import {useState} from "react";

function Login() {
    const [user, setUser] = useState({email: '', password: ''})

    const onFormSubmit = (e) => {
        e.preventDefault()
        console.log("User : ", user)
    }

    return (
        <Box m={"auto"} mt={"4rem"} py={"4rem"} px={"2rem"} maxWidth="30rem" borderWidth={"0.2rem"}
             borderRadius={"1rem"} boxShadow="md">
            <form onSubmit={onFormSubmit}>
                <FormControl>
                    <VStack spacing={'1.5rem'}>
                        <Box>
                            <FormLabel>Email</FormLabel>
                            <Input type={"email"} value={user.email}
                                   onChange={(e) => setUser({...user, email: e.target.value})}/>
                            <FormHelperText>We will never share your text</FormHelperText>
                        </Box>
                        <Box>
                            <FormLabel>Password</FormLabel>
                            <Input type={"password"} value={user.password}
                                   onChange={(e) => setUser({...user, password: e.target.value})}/>
                        </Box>
                        <Box pt={"1rem"}>
                            <Button type={'submit'} colorScheme={"blue"}>Submit</Button>
                        </Box>
                    </VStack>
                </FormControl>
            </form>
        </Box>
    )
}

export default Login