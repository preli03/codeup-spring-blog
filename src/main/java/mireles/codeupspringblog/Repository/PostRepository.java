package mireles.codeupspringblog.Repository;
import mireles.codeupspringblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;




public interface PostRepository extends JpaRepository <Post,Long> {


}
