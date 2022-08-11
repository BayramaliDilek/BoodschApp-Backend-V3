package nl.novi.eindopdracht.boodschappbackendv3.services;

import nl.novi.eindopdracht.boodschappbackendv3.models.Authority;
import nl.novi.eindopdracht.boodschappbackendv3.models.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomUserDetailServiceTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private CustomUserDetailService customUserDetailService;

    @Test
    @DisplayName("Should throw UsernameNotFoundException when user is not found")
    void loadUserByUsernameWhenUserIsNotFoundThenThrowUsernameNotFoundException() {
        when(userService.getUser(anyString())).thenReturn(Optional.empty());

        assertThrows(
                UsernameNotFoundException.class,
                () -> customUserDetailService.loadUserByUsername("username"));
    }

    @Test
    @DisplayName("Should return UserDetails when user is found")
    void loadUserByUsernameWhenUserIsFoundThenReturnUserDetails() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("test");
        user.addAuthority(new Authority("test", "ROLE_USER"));

        when(userService.getUser(anyString())).thenReturn(Optional.of(user));

        UserDetails userDetails = customUserDetailService.loadUserByUsername("test");

        assertEquals("test", userDetails.getUsername());
        assertEquals("test", userDetails.getPassword());
        assertTrue(userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER")));
    }
}