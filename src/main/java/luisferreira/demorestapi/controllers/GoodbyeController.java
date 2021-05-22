package luisferreira.demorestapi.controllers;

import luisferreira.demorestapi.services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("goodbye")
public class GoodbyeController {

    public final HelloService service;

    @Autowired
    public GoodbyeController(HelloService service) {
        this.service = service;
    }

    @GetMapping("/{name}")
    public String getGoodbyeMessage(@PathVariable String name) {
        return this.service.getPartingMessage() + name;
    }
}
