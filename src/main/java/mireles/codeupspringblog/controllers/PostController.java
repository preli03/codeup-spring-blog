package mireles.codeupspringblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class PostController {

@GetMapping("/posts")
    @ResponseBody
    public String postIndex(){
    return "This is the posts index page";
}

@GetMapping("/posts/{id}")
    @ResponseBody
    public String viewPost(@PathVariable Long id){
    return "Viewing post with ID:" + id;
}

@GetMapping("/posts/create")
    @ResponseBody
    public String viewCreatePostForm(){
    return "Viewing the form for creating a post";
}

@PostMapping("/posts/create")
    @ResponseBody
    public String saveNewPost(){
    return "create a new post";
}

}
