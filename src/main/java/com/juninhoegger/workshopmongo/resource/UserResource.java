package com.juninhoegger.workshopmongo.resource;

import com.juninhoegger.workshopmongo.domain.User;
import com.juninhoegger.workshopmongo.dto.UserDTO;
import com.juninhoegger.workshopmongo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping("/find-all")
    public ResponseEntity<List<UserDTO>> findAll() {
        log.info("Buscando todos os usuários do banco");
        List<User> userList = userService.findAll();
        List<UserDTO> userDTOList = userList.stream().map(UserDTO::new).collect(toList());
        return ok().body(userDTOList);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        log.info("Buscando no banco o usuário com ID {}.", id);
        return ok().body(new UserDTO(userService.findById(id)));
    }

}
