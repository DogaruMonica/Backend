package iss.sirius;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SiriusApplicationTests {

    public UserControllerTest userControllerTest;

    /*
    THE WAY TO TEST:
        Fiecare Controller va avea un set de teste specifice
        Aici se apeleaza fiecare set
     */
    @Test
    void userCotrollerTestSuite() throws Exception {
        userControllerTest.createUser();
    }


}
