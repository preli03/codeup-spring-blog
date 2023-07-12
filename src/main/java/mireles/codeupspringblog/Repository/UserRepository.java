package mireles.codeupspringblog.Repository;


import mireles.codeupspringblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long > {
    User findByUsername(String username);
}
