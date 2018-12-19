package guru.leco.graphql.services.implementation;

import guru.leco.graphql.domain.Post;
import guru.leco.graphql.repositories.PostRepository;
import guru.leco.graphql.services.contracts.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> get() {
        return this.postRepository.findAll();
    }

    @Override
    public Optional<Post> getById(Long id) {
        return this.postRepository.findById(id);
    }

    @Override
    public Post save(Post object) {
        return this.postRepository.save(object);
    }

    @Override
    public void deleteById(Long id) {
        this.postRepository.deleteById(id);
    }
}
