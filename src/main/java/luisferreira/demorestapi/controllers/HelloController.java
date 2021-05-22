package luisferreira.demorestapi.controllers;

import luisferreira.demorestapi.services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

    private final HelloService helloService;

    @Autowired
    public HelloController(HelloService service) {
        this.helloService = service;
    }

    @GetMapping("/{name}")
    public String getHelloMessage(@PathVariable String name) {
        return this.helloService.getWelcomeMessage() + name;
    }
}
