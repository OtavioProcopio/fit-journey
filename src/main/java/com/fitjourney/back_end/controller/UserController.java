package com.fitjourney.back_end.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitjourney.back_end.model.User;
import com.fitjourney.back_end.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;  
    
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody User user){    
        try {

            if (user.getName() == null || user.getName().isEmpty() || 
                user.getEmail() == null || user.getEmail().isEmpty() || 
                user.getPassword() == null || user.getPassword().isEmpty()) {
                return new ResponseEntity<>("Dados do usuário inválidos", HttpStatus.BAD_REQUEST);
            }

            boolean isSaved = userService.save(user);

            if (isSaved) {
                return new ResponseEntity<>("Usuário criado com sucesso", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Erro ao salvar o usuário", HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            return new ResponseEntity<>("Ocorreu um erro ao salvar o usuário.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody User user){
        try{
            if (user.getUserId() == null) {
                return new ResponseEntity<>("ID do usuário não fornecido.", HttpStatus.BAD_REQUEST);
            }
            boolean isDeleted = userService.delete(user.getUserId());

            if (isDeleted) {
                return new ResponseEntity<>("Usuário deletado com sucesso.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Usuário não encontrado.", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Ocorreu um erro ao deletar o usuário.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
