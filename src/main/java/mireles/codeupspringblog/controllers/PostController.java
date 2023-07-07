package mireles.codeupspringblog.controllers;

import mireles.codeupspringblog.Repository.PostRepository;

import mireles.codeupspringblog.Repository.UserRepository;
import models.Post;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller

public class PostController {
    private PostRepository postDao;
    private PostRepository postRepository;
    private UserRepository userRepository;

    @GetMapping("")
    public String posts(Model model) {
        List<Post> posts = postDao.findAll();

        model.addAttribute("posts",posts);
        return "/posts/show";
    }

    @GetMapping("/{id}")
    public String showSinglePost(@PathVariable Long id, Model model){
        // find the desired post in the db
        Optional<Post> optionalPost = postDao.findById(id);
        if(optionalPost.isEmpty()) {
            System.out.printf("Post with id " + id + " not found!");
            return "home";
        }

        // if we get here, then we found the post. so just open up the optional
        model.addAttribute("post", optionalPost.get());
        return "/posts/index";
    }

    @GetMapping("/create")
    public String showCreate() {
        return "/posts/create";
    }

    @PostMapping("/create")
    public String doCreate(@RequestParam String title, @RequestParam String body) {
        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);

        postDao.save(post);

        return "redirect:/posts";
    }
    @PostMapping("/posts/create")
    public String createPost(@RequestParam("title") String title,
                             @RequestParam("body") String body) {
        // Create a new post
        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);

        // Get a user from the UserRepository (for now, selecting the first user)
        User user = (User) userRepository.findAll().iterator().next();

        // Assign the user to the post
        post.setUser(user);

        // Save the post to the database
        postRepository.save(post);

        return "redirect:/posts";
    }

    @Autowired
    public PostController(UserRepository userRepository) {
    }
    public PostController(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }
}