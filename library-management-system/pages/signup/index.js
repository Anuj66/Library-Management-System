import {
    Box,
    Button,
    FormControl,
    FormLabel,
    HStack,
    Input,
    NumberInput,
    NumberInputField,
    Textarea,
    VStack
} from "@chakra-ui/react";
import {useState} from "react";
import {useAuthContext} from "../../context/auth";

function SignUp() {

    const [user, setUser] = useState({
        username: '',
        email: '',
        password: '',
        phoneNumber: '',
        roles: ['user']
    })

    const { signupApi } = useAuthContext()

    const onFormSubmit = async (e) => {
        e.preventDefault()
        console.log("User : ", user)
        const data = await signupApi(user)
        console.log(data)
    }

    return (
        <Box m={"auto"} mt={"4rem"} py={"4rem"} px={"2rem"} maxWidth="30rem" borderWidth={"0.2rem"}
             borderRadius={"1rem"} boxShadow="md">
            <form onSubmit={onFormSubmit}>
                <FormControl isRequired>
                    <Box>
                        <VStack spacing={"1.5rem"}>
                            <Box>
                                <FormLabel>Name</FormLabel>
                                <Input
                                    type={"text"}
                                    value={user.username}
                                    onChange={e => setUser({...user, username: e.target.value})}
                                />
                            </Box>
                            <Box>
                                <FormLabel>Email</FormLabel>
                                <Input
                                    type={"email"}
                                    value={user.email}
                                    onChange={e => setUser({...user, email: e.target.value})}
                                />
                            </Box>
                            <Box>
                                <FormLabel>Password</FormLabel>
                                <Input
                                    type={"password"}
                                    value={user.password}
                                    onChange={e => setUser({...user, password: e.target.value})}
                                />
                            </Box>
                            <Box>
                                <FormLabel>Mobile No.</FormLabel>
                                <NumberInput min={10} max={10}>
                                    <NumberInputField
                                        value={user.phoneNumber}
                                        onChange={e => setUser({...user, phoneNumber: e.target.value})}/>
                                </NumberInput>
                            </Box>
                            <Box>
                                <Button type={'submit'} colorScheme={"blackAlpha"}>Signup</Button>
                            </Box>
                        </VStack>
                    </Box>
                </FormControl>
            </form>
        </Box>
    )
}

export default SignUp