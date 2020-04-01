package de.owpgmdb.gmdbbackend.services;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import de.owpgmdb.gmdbbackend.models.User;
import de.owpgmdb.gmdbbackend.models.UserRole;
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

    @Test
    void whenUsernameIsMoreThanTwentyCharsThrowIllegalArgException() {
        String usernameWithTwentyOneChars = "abcdefghijklmnopqrstu";
        String expectedMessage = "Username is more than 20 chars";

        Exception actual = assertThrows(IllegalArgumentException.class, () -> this.service.loginByUsername(usernameWithTwentyOneChars));
        Assertions.assertThat(actual).hasMessage(expectedMessage);
    }

    @Test
    void returnUserWithGivenUsername() {
        String username = "Jan";
        User expectedUser = new User(username, UserRole.REVIEWER);
        expectedUser.setId(0L);
        when(this.userRepo.findByUsername(username)).thenReturn(Optional.of(expectedUser));

        User actualUser = service.loginByUsername(username);

        Assertions.assertThat(actualUser).isEqualTo(expectedUser);
    }

    @Test
    void whenUsernameIsNullThrowIllegalArgException(){
        String usernameIsNull = null;
        String expectedMessage = "Username can not be null";
        Exception actual = assertThrows(IllegalArgumentException.class, () -> this.service.loginByUsername(usernameIsNull));
        Assertions.assertThat(actual).hasMessage(expectedMessage);
    }    

    @Test
    void whenUsernameIsNotFoundThrowIllegalArgException(){
        String userName = "Jens";
        String expectedMessage = "Username could not be found";
        Exception actual = assertThrows(IllegalArgumentException.class, () -> this.service.loginByUsername(userName));
        Assertions.assertThat(actual).hasMessage(expectedMessage);
    }

}