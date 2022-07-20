package com.juninhoegger.workshopmongo.resources;

import com.juninhoegger.workshopmongo.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Arrays.asList;
import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserResource {

    @GetMapping("/find-all")
    public ResponseEntity<List<User>> findAll() {
        log.info("Buscando todos os usuários do banco");
        User junior = new User("1", "Junior", "junior@gmail.com");
        User juliana = new User("2", "Juliana", "juliana@gmail.com");
        return ok().body(asList(junior, juliana));
    }

}
