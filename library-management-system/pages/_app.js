import {ChakraProvider} from '@chakra-ui/react'
import {AppWrapper} from "../context/auth";

function MyApp({Component, pageProps}) {
    return (
        <AppWrapper>
            <ChakraProvider>
                <Component {...pageProps} />
            </ChakraProvider>
        </AppWrapper>
    )
}

export default MyApp
