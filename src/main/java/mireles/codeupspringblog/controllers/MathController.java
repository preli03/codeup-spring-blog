package mireles.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MathController {

    @GetMapping("/add/{num1}/and/{num2}")
    public int add(@PathVariable int num1, @PathVariable int num2) {
        return num1 + num2;
    }

    @GetMapping("/subtract/{num2}/from/{num1}")
    public int subtract(@PathVariable int num1, @PathVariable int num2) {
        return num2 - num1;
    }

    @GetMapping("/multiply/{num1}/and/{num2}")
    public int multiply(@PathVariable int num1, @PathVariable int num2) {
        return num1 * num2;
    }

    @GetMapping("/divide/{num1}/by/{num2}")
    public int divide(@PathVariable int num1, @PathVariable int num2) {
        return num1 / num2;
    }
}
