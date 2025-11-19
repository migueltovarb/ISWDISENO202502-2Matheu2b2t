package vehiculos.vehiculos.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class MongoIntegrationCheck implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(MongoIntegrationCheck.class);

    private final MongoTemplate mongoTemplate;

    public MongoIntegrationCheck(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void run(ApplicationArguments args) {
        try {
            mongoTemplate.executeCommand("{ ping: 1 }");
            log.info("MongoDB disponible - integración correcta");
        } catch (Exception exception) {
            log.error("No se pudo confirmar la conexión con MongoDB: {}", exception.getMessage());
        }
    }
}
