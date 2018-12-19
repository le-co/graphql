package guru.leco.graphql.resources;

import guru.leco.graphql.resources.requests.PostRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.net.URISyntaxException;

import static guru.leco.graphql.resources.PostResource.PATH;

@RequestMapping(PATH)
public class PostResource {

    static final String PATH = "/post";

    @PostMapping
    public ResponseEntity create(@RequestBody PostRequest post) throws URISyntaxException {

        return ResponseEntity.created(new URI(PATH + "/")).build();
    }
}
