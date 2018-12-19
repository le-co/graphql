package guru.leco.graphql.services.implementation;

import guru.leco.graphql.domain.Post;
import guru.leco.graphql.services.contracts.PostService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PostServiceIT {

    @Autowired
    private PostService postService;

    @Test
    public void get() throws Exception {
        Post post = new Post();
        post.setTitle("test-title");
        post.setMessage("test-description");
        this.postService.save(post);

        List<Post> posts = this.postService.get();

        assertTrue(!posts.isEmpty());
        assertTrue(posts.size() > 0);
    }

    @Test
    public void getById() throws Exception {
        Post post = new Post();
        post.setTitle("test-title");
        post.setMessage("test-description");
        Post save = this.postService.save(post);

        Optional<Post> result = this.postService.getById(save.getId());

        assertTrue(result.isPresent());
    }

    @Test
    public void deleteById() throws Exception {
        Post post = new Post();
        post.setTitle("test-title");
        post.setMessage("test-description");
        Post save = this.postService.save(post);

        Optional<Post> result = this.postService.getById(save.getId());

        assertTrue(result.isPresent());

        this.postService.deleteById(result.get().getId());

        result = this.postService.getById(save.getId());

        assertTrue(!result.isPresent());
    }

}