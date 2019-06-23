package ua.elma.clientbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ua.elma.clientbank.property.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class ClientBankPostmanApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientBankPostmanApplication.class, args);
    }
}
