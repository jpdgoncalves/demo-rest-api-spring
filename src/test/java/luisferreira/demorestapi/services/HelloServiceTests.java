package luisferreira.demorestapi.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class HelloServiceTests {

    private final HelloService helloService;

    @Autowired
    public HelloServiceTests(HelloService helloService) {
        this.helloService = helloService;
    }

    @Test
    @DisplayName("Test getWelcomeMessage()")
    public void testGetWelcomeMessage() {
        assertThat(this.helloService.getWelcomeMessage()).isEqualTo("Hello, ");
    }

    @Test
    @DisplayName("Test getPartingMessage()")
    public void testGetPartingMessage() {
        assertThat(this.helloService.getPartingMessage()).isEqualTo("Goodbye, ");
    }
}
