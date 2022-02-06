package pl.sdacademy.unit.test.advance.exercises.mockito.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    private static final long IDENTIFIER = 1L;
    private static final User USER = new User(IDENTIFIER, "Jan", "Kowalski");

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserValidator userValidator;
    @InjectMocks
    private UserService userService;

    @Test
    void shouldReturnUserById() {
        //given
        when(userRepository.findById(IDENTIFIER)).thenReturn(Optional.of(USER));
        //when
        User actualUser = userService.getUserById(IDENTIFIER);
        //then
        assertThat(actualUser).isEqualTo(USER);
    }

    @Test
    void shouldThrowExceptionWhenUserDoesNotExist() {
        //given
        when(userRepository.findById(IDENTIFIER)).thenReturn(Optional.empty());
        //when & then
        assertThatThrownBy(() -> userService.getUserById(IDENTIFIER))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void shouldCreateUser() {
        //given
        User inputUser = new User("Jan", "Kowalski");
        when(userValidator.isUserValid(inputUser)).thenReturn(true);
        when(userRepository.addUser(inputUser)).thenReturn(USER);
        //when
        User actualUser = userService.createUser(inputUser);
        //then
        assertThat(actualUser.getFirstName()).isEqualTo(USER.getFirstName());
        assertThat(actualUser.getLastName()).isEqualTo(USER.getLastName());
        assertThat(actualUser.getId()).isPositive();
    }

    @Test
    void shouldThrowExceptionWhenUserIsNotValid() {
        //given
        when(userValidator.isUserValid(USER)).thenReturn(false);
        //when & then
        assertThatThrownBy(() -> userService.createUser(USER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("User is invalid");
    }
}