package mireles.codeupspringblog.Repository;


import mireles.codeupspringblog.controllers.PostController;
import models.Post;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PostRepo {

@Autowired
    public PostRepo(PostRepository postRepository) {
    }
    public void createPost(PostController.Post post) {
        PostRepository.save(post);
    }



}
