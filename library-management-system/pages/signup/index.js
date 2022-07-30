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

function SignUp() {

    const [user, setUser] = useState({
        name: '',
        email: '',
        password: '',
        mobile: '',
        address: ''
    })

    const onFormSubmit = (e) => {
        e.preventDefault()
        console.log("User : ", user)
    }

    return (
        <Box m={"auto"} mt={"4rem"} py={"4rem"} px={"2rem"} maxWidth="30rem" borderWidth={"0.2rem"}
             borderRadius={"1rem"} boxShadow="md">
            <form onSubmit={onFormSubmit}>
                <FormControl isRequired>
                    <HStack spacing={"4rem"}>
                        <Box>
                            <VStack spacing={"1.5rem"}>
                                <Box>
                                    <FormLabel>Name</FormLabel>
                                    <Input
                                        type={"text"}
                                        value={user.name}
                                        onChange={e => setUser({...user, name: e.target.value})}
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
                            </VStack>
                        </Box>
                        <Box>
                            <VStack spacing={"1.5rem"}>
                                <Box>
                                    <FormLabel>Mobile No.</FormLabel>
                                    <NumberInput min={10} max={10}>
                                        <NumberInputField
                                            value={user.mobile}
                                            onChange={e => setUser({...user, mobile: e.target.value})}/>
                                    </NumberInput>
                                </Box>
                                <Box>
                                    <FormLabel>Address</FormLabel>
                                    <Textarea
                                        value={user.address}
                                        onChange={e => setUser({...user, address: e.target.value})}
                                    />
                                </Box>
                                <Box>
                                    <Button type={'submit'} colorScheme={"blackAlpha"}>Signup</Button>
                                </Box>
                            </VStack>
                        </Box>
                    </HStack>
                </FormControl>
            </form>
        </Box>
    )
}

export default SignUp