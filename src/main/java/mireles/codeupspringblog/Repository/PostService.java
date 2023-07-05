package mireles.codeupspringblog.Repository;


import mireles.codeupspringblog.controllers.PostController;
import models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void createPost(PostController.Post post) {
        PostRepository.save(post);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

}
