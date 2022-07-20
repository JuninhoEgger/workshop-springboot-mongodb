package com.juninhoegger.workshopmongo.resource;

import com.juninhoegger.workshopmongo.domain.User;
import com.juninhoegger.workshopmongo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping("/find-all")
    public ResponseEntity<List<User>> findAll() {
        log.info("Buscando todos os usuários do banco");
        return ok().body(userService.findAll());
    }

}
