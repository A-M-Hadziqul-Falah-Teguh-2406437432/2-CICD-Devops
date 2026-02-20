package id.ac.ui.cs.advprog.eshop;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.springframework.boot.SpringApplication;

import static org.mockito.Mockito.mockStatic;

class EshopApplicationMainTest {

    @Test
    void mainRunsSpringApplication() {
        String[] args = new String[] {"--spring.main.web-application-type=none"};

        try (MockedStatic<SpringApplication> mockedSpringApplication = mockStatic(SpringApplication.class)) {
            EshopApplication.main(args);

            mockedSpringApplication.verify(() -> SpringApplication.run(EshopApplication.class, args));
        }
    }
}
