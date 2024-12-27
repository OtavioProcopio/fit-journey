package com.fitjourney.back_end.test_service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fitjourney.back_end.model.User;
import com.fitjourney.back_end.repository.UserRepository;
import com.fitjourney.back_end.services.UserService;

@RunWith(MockitoJUnitRunner.class)
public class TestUserService {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    private User user;

    @Before
    public void reateFakeUser() {
        user = new User(UUID.randomUUID(), "Otavio Procópio", "tavinprocopio@gmail.com", "senhadootavio");
    }

    @Test
    public void testSaveUser() {
        when(passwordEncoder.encode(any(CharSequence.class))).thenReturn("encodedPassword");

        when(userRepository.save(any(User.class))).thenReturn(user);

        userService.save(user);

        verify(passwordEncoder).encode(any(CharSequence.class)); // Verificando que o método foi chamado com qualquer CharSequence
        verify(userRepository).save(user);
    }

    @Test
    public void testDeleteUserSuccess() {
        UUID userId = UUID.randomUUID();
        when(userRepository.existsById(userId)).thenReturn(true);

        // Execução
        boolean result = userService.delete(userId);

        // Verificação
        assertTrue(result);
        verify(userRepository).deleteById(userId);
    }

    @Test
    public void testDeleteUserNotFound() {
        UUID userId = UUID.randomUUID();
        when(userRepository.existsById(userId)).thenReturn(false);

        boolean result = userService.delete(userId);

        assertFalse(result);
        verify(userRepository).existsById(userId);
    }

    @Test
    public void testFindByUserId() {
        UUID userId = UUID.randomUUID();
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        User foundUser = userService.findByUserId(userId);

        verify(userRepository).findById(userId);
        assertTrue(foundUser.getEmail().equals(user.getEmail()));
    }
}
