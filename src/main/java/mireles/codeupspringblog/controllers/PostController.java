package mireles.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {



    public static class Post {
        private String title;
        private String body;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }
    }
    @GetMapping("/posts")
    public String showAllPosts(Model model) {
        List<Post> posts = new ArrayList<>();

        Post post1 = new Post();
        post1.setTitle("First Post");
        post1.setBody("This is the body of the first post");
        posts.add(post1);

        Post post2 = new Post();
        post2.setTitle("Second Post");
        post2.setBody("This is the body of the second post");
        posts.add(post2);

        model.addAttribute("posts", posts);

        return "posts/index";
    }

    @GetMapping("/posts/{title}")
    public String showPost(@PathVariable String title, Model model) {
        // Create a new post object
        Post post = new Post();
        post.setTitle(title);
        post.setBody("This is the body of the post with title: " + title);

        model.addAttribute("post", post);

        return "posts/show";
    }
}
