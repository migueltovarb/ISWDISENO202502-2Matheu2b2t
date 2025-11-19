package vehiculos.vehiculos.config;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

class WebConfigTest {

    @Test
    void corsConfigurationShouldAllowAnyOriginAndBasicMethods() {
        WebConfig config = new WebConfig("*");

        CorsConfigurationSource source = config.corsConfigurationSource();
        CorsConfiguration cors = source.getCorsConfiguration(new MockHttpServletRequest());

        assertThat(cors).isNotNull();
        assertThat(cors.getAllowedOriginPatterns()).contains("*");
        assertThat(cors.getAllowedMethods()).contains("GET", "POST", "PUT", "DELETE", "OPTIONS");
        assertThat(cors.getAllowCredentials()).isFalse();
    }
}
