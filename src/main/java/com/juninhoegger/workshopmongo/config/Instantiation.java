package com.juninhoegger.workshopmongo.config;

import com.juninhoegger.workshopmongo.domain.User;
import com.juninhoegger.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import static java.util.Arrays.asList;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) {

        //Deleta os dados do banco de teste
        userRepository.deleteAll();

        //Instancia novos usuários
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        //Salva os objetos acima instanciados
        userRepository.saveAll(asList(maria, alex, bob));
    }
}
