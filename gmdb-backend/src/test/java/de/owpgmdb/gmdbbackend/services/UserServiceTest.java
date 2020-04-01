package de.owpgmdb.gmdbbackend.services;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import de.owpgmdb.gmdbbackend.repositories.UserRepository;

/**
 * UserService.Test
 */
@SpringBootTest
public class UserServiceTest {


    @MockBean
    private UserRepository userRepo;

    @Autowired
    UserService service;


    @BeforeEach
    void clearMocks(){
        Mockito.reset(userRepo);
    }


    @Test
    void dependencyAreNotNull(){
        Assertions.assertThat(userRepo).isNotNull();
        Assertions.assertThat(service).isNotNull();
    }
       
    // * N - null - return: X, params: username
    // * Z - zero - X
    // * O - One - one username and one User
    // * M - many - X
    // * B - boundries - length of username 3-20
    // * I - interface User loginByUsername(String username)
    // * E - exceptions - IllegalArgs bei Null username und bei zu kurzem/langem username, 
    // * S - Simple Cases IllegalArg if username not found
    
    @Test
    void whenUsernameIsLessThanThreeCharsThrowIllegalArgException() {
        String usernameWithTwoChars = "ab";
        String expectedMessage = "Username is less than 3 chars";

        Exception actual = assertThrows(IllegalArgumentException.class, () -> this.service.loginByUsername(usernameWithTwoChars));
        Assertions.assertThat(actual).hasMessage(expectedMessage);
    }
    
}