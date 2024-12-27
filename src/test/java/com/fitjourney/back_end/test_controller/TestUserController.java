package com.fitjourney.back_end.test_controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fitjourney.back_end.controller.UserController;
import com.fitjourney.back_end.model.User;
import com.fitjourney.back_end.services.UserService;

@RunWith(MockitoJUnitRunner.class)
public class TestUserController {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private User user;

    @Before
    public void createFakeUser() {
        user = new User(UUID.randomUUID(), "Otavio Procópio", "tavinprocopio@gmail.com", "senhadootavio");
    }

    @Test
    public void testSaveUserSuccess() {
        // Configuração
        when(userService.save(any(User.class))).thenReturn(true);

        // Execução
        ResponseEntity<String> response = userController.save(user);

        // Verificação
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Usuário criado com sucesso", response.getBody());
    }

    @Test
    public void testSaveUserInvalidData() {
        // Configuração de um usuário inválido
        User invalidUser = new User(UUID.randomUUID(), "", "", "");

        // Execução
        ResponseEntity<String> response = userController.save(invalidUser);

        // Verificação
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Dados do usuário inválidos", response.getBody());
    }

    @Test
    public void testSaveUserError() {
        // Configuração
        when(userService.save(any(User.class))).thenReturn(false);

        // Execução
        ResponseEntity<String> response = userController.save(user);

        // Verificação
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Erro ao salvar o usuário", response.getBody());
    }

    @Test
    public void testDeleteUserSuccess() {
        // Configuração
        when(userService.delete(user.getUserId())).thenReturn(true);

        // Execução
        ResponseEntity<String> response = userController.delete(user);

        // Verificação
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Usuário deletado com sucesso.", response.getBody());
    }

    @Test
    public void testDeleteUserNotFound() {
        // Configuração
        when(userService.delete(user.getUserId())).thenReturn(false);

        // Execução
        ResponseEntity<String> response = userController.delete(user);

        // Verificação
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Usuário não encontrado.", response.getBody());
    }

    @Test
    public void testDeleteUserMissingId() {
        // Configuração de um usuário com ID nulo
        User invalidUser = new User(null, "Nome", "email@gmail.com", "senha");

        // Execução
        ResponseEntity<String> response = userController.delete(invalidUser);

        // Verificação
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("ID do usuário não fornecido.", response.getBody());
    }

    @Test
    public void testDeleteUserError() {
        // Configuração
        when(userService.delete(any(UUID.class))).thenThrow(new RuntimeException("Erro interno"));

        // Execução
        ResponseEntity<String> response = userController.delete(user);

        // Verificação
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Ocorreu um erro ao deletar o usuário.", response.getBody());
    }
    
}
