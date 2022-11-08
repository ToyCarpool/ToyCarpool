package kt.carpool.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @GetMapping("/api/hello")
    public String test1() {
        return "Hello, world!";
    }
}
