package mireles.codeupspringblog.controllers;

import jakarta.annotation.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/hello")
public class HelloController {
    /*
    /hello -> Hello World!
    /hello?name=patrick -> Hello patrick!
    /hello/Patrick -> Hello Patrick!
    **/

    @GetMapping("/hello")
    @ResponseBody
    public String sayHello(@RequestParam @Nullable String name ){
        if(name == null){
            name = "World";
        }
        return getHelloString(name);
    }


    @GetMapping("/{personName}")
    @ResponseBody
    public String sayHelloToName(@PathVariable String personName ){

        return "<h1>Hello " + personName + "!</h1>";
    }

    @GetMapping("/hello{personName}")
    private String getHelloString(String personName) {
        return "<h1>Hello " + personName + "!</h1>";
    }
}
