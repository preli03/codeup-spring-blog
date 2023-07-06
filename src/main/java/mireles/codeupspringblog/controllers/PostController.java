package mireles.codeupspringblog.controllers;

import mireles.codeupspringblog.Repository.PostRepository;

import models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/post")
public class PostController {
    private PostRepository postDao;

    @GetMapping("/post")
    public String posts(Model model) {
        model.addAttribute("posts", new Post("id", "title", "body"));

        return "posts/index";
    }

    public static class Post {
        public Post(String id, String title, String body) {

        }
    }
}