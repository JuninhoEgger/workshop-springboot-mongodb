package com.juninhoegger.workshopmongo.resource;

import com.juninhoegger.workshopmongo.domain.User;
import com.juninhoegger.workshopmongo.dto.UserDTO;
import com.juninhoegger.workshopmongo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

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

    @PostMapping("/insert")
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO) {
        log.info("Inserindo no banco o usuário {}", userDTO);
        User user = userService.insert(userService.fromDTO(userDTO));
        URI uri = fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return created(uri).build();
    }


}
