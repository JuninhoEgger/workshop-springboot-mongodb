package com.juninhoegger.workshopmongo.config;

import com.juninhoegger.workshopmongo.domain.Post;
import com.juninhoegger.workshopmongo.domain.User;
import com.juninhoegger.workshopmongo.repository.PostRepository;
import com.juninhoegger.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static java.util.Arrays.asList;
import static java.util.TimeZone.getTimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(getTimeZone("GMT"));

        //Deleta os dados do banco de teste
        userRepository.deleteAll();
        postRepository.deleteAll();

        //Instancia novos usuários
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", maria);

        //Salva os objetos acima instanciados
        userRepository.saveAll(asList(maria, alex, bob));
        postRepository.saveAll(asList(post1, post2));
    }
}
