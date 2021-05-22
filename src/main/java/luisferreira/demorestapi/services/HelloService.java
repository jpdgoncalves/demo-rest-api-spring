package luisferreira.demorestapi.services;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String getWelcomeMessage() {
        return "Hello, ";
    }

    public String getPartingMessage() {
        return "Goodbye, ";
    }
}
