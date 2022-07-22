package com.juninhoegger.workshopmongo.resource;

import com.juninhoegger.workshopmongo.domain.Post;
import com.juninhoegger.workshopmongo.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static com.juninhoegger.workshopmongo.util.URL.convertDate;
import static com.juninhoegger.workshopmongo.util.URL.decodeParam;
import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@RequestMapping("/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        log.info("Buscando o post com id {}", id);
        return ok().body(postService.findById(id));
    }

    @GetMapping("/title-search")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        log.info("Buscando os posts que contenham no título {}", text);
        text = decodeParam(text);
        List<Post> posts = postService.findByTitle(text);
        return ok().body(posts);
    }

    @GetMapping("/full-search")
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
        log.info("Fazendo uma consulta completa");
        text = decodeParam(text);
        Date min = convertDate(minDate, new Date(0L));
        Date max = convertDate(maxDate, new Date());
        return ok().body(postService.fullSearch(text, min, max));
    }

}
