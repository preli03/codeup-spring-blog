package mireles.codeupspringblog.Repository;

import mireles.codeupspringblog.controllers.PostController;
import models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository <Post,Long> {


    static void save(PostController.Post post) {
    }
}
