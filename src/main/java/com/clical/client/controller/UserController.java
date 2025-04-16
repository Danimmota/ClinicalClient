package com.clical.client.controller;

import com.clical.client.dto.UserDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.clical.client.service.UserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createuser")
    public ResponseEntity<UserDTO> saveUser(@RequestBody @Valid UserDTO userDTO) {

        userDTO.setIdUser(null); // Garante que o ID esteja nulo ao criar

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(userDTO));
    }

    @GetMapping("listar")
    public ResponseEntity<?> getAllUsers(){
        List<UserDTO> usersDTO = userService.findAllUsers();

        return ResponseEntity.status(HttpStatus.OK).body(usersDTO);
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<UserDTO> getOneUser(@Valid @PathVariable(value="idUser")UUID idUser) {
        UserDTO response = userService.getUser(idUser);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{idUser}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable(value="idUser")UUID idUser,
                                             @RequestBody @Valid UserDTO userDTO) {

        userDTO.setIdUser(idUser); // O saveUser vai identificar como atualização

        return ResponseEntity.status(HttpStatus.OK).body(userService.saveUser(userDTO));
    }

    @DeleteMapping("/{idUser}")
    public ResponseEntity<String> deleteUserById(@PathVariable(value="idUser") UUID idUser) {
        userService.deleteUserById(idUser);

        return ResponseEntity.status(HttpStatus.OK).body("Usuário excluído com sucesso!");
    }

}
