package mireles.codeupspringblog.controllers;
import lombok.AllArgsConstructor;
import mireles.codeupspringblog.Repository.PostRepository;
import mireles.codeupspringblog.Repository.UserRepository;
import mireles.codeupspringblog.models.EmailService;
import mireles.codeupspringblog.models.Post;
import mireles.codeupspringblog.models.User;
import mireles.codeupspringblog.services.Authorization;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Controller
@RequestMapping("/posts")
public class PostController {
        private PostRepository postDao;
        private UserRepository userDao;
        private EmailService emailService;

        @GetMapping("")
        public String posts(Model model){

            User loggedInUser = Authorization.getLoggedInUser();
            model.addAttribute("loggedInUser", loggedInUser);

            List<Post> posts = postDao.findAll();

            model.addAttribute("posts",posts);
            return "/posts/index";
        }

        @GetMapping("/{id}")
        public String showSinglePost(@PathVariable Long id, Model model){
            User loggedInUser = Authorization.getLoggedInUser();
            model.addAttribute("loggedInUser", loggedInUser);
            Optional<Post> optionalPost = postDao.findById(id);
            if(optionalPost.isEmpty()) {
                System.out.printf("Post with id " + id + " not found!");
                return "home";
            }

            model.addAttribute("post", optionalPost.get());
            return "/posts/show";
        }

        @GetMapping("/create")
        public String showCreate(Model model) {
            User loggedInUser = Authorization.getLoggedInUser();
            if(loggedInUser.getId() == 0) {
                return "redirect:/login";
            }

            model.addAttribute("loggedInUser", loggedInUser);

            model.addAttribute("newPost", new Post());
            return "/posts/create";
        }

        @PostMapping("/create")
        public String doCreate(@RequestParam String title, @RequestParam String body) {
            User loggedInUser = Authorization.getLoggedInUser();
            if(loggedInUser.getId() == 0) {
                return "redirect:/login";
            }

            Post post = new Post();
            post.setCreator(loggedInUser);
            postDao.save(post);

            return "redirect:/posts";
        }
    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable Long id, Model model) {
        User loggedInUser = Authorization.getLoggedInUser();
        model.addAttribute("loggedInUser", loggedInUser);

        Post postToEdit = postDao.getReferenceById(id);
        model.addAttribute("newPost", postToEdit);
        return "/posts/create";
    }
    }