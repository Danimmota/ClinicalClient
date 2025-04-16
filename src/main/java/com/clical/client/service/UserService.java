package com.clical.client.service;

import com.clical.client.dto.UserDTO;
import com.clical.client.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import com.clical.client.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clical.client.repository.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //Criar ou atualizar um usuário
    //gerar o UUID na sua aplicação Java com UUID.randomUUID()
    @Transactional
    public UserDTO saveUser(UserDTO userdto) {
        // Se o usuário já existir no banco (update), senão (create)
        if (userdto.getIdUser() != null) {
            userRepository.findById(userdto.getIdUser())
                    .orElseThrow(() -> new ResourceNotFoundException("Usuário com ID: " + userdto.getIdUser() + " não encontrado."));
        }

        User user = userRepository.save(toUser(userdto));

        return toUserDTO(user);
    }

    // Buscar usuário pelo Id
    @Transactional
    public UserDTO getUser(UUID idUser) {
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new ResourceNotFoundException("User com identificador " + idUser + " não encontrado."));

        return toUserDTO(user);
    }

    // Buscar o usuário pelo email
    @Transactional
    public UserDTO getUserEmail(String email) {
        User user = userRepository.findAllByEmailIgnoreCase(email);
        if (user == null) {
            throw new ResourceNotFoundException("Usuário com email: " + email + " não encontrado.");
        }

        return toUserDTO(user);
    }

    // Buscar lista com todos os usuários
    public List<UserDTO> findAllUsers() {
        try {
            List<User> users = userRepository.findAll();

            return users.stream()
                    .map(this::toUserDTO)
                    .toList();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar usuários. Por favor, tente novamente mais tarde." + e.getMessage());
        }

    }

    // Deletar o usuário
    @Transactional
    public void deleteUserById(UUID idUser) {
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário com ID: " + idUser + " não encontrado."));

        userRepository.delete(user);
    }

    // Metodo para converter o objeto Model em objeto DTO
    private User toUser(UserDTO dto) {
        var user = new User();

        user.setIdUser(dto.getIdUser());
        user.setNome(dto.getNome());
        user.setTelefone(dto.getTelefone());
        user.setEmail(dto.getEmail());
        user.setLogin(dto.getLogin());
        user.setSenha(dto.getSenha());
        user.setPerfil(dto.getPerfil());
        user.setCriacaoUsuario(dto.getCriacao_usuario());
        return user;
    }

    // Metodo para converter o objeto DTO em objeto Model
    private UserDTO toUserDTO(User user) {
        var dto = new UserDTO();

        dto.setIdUser(user.getIdUser());
        dto.setNome(user.getNome());
        dto.setTelefone(user.getTelefone());
        dto.setEmail(user.getEmail());
        dto.setLogin(user.getLogin());
        dto.setSenha(user.getSenha());
        dto.setPerfil(user.getPerfil());
        dto.setCriacao_usuario(user.getCriacaoUsuario());
        return dto;
    }

}