package kz.fakewhatsapp.fakewhatsapp.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.DefaultContentTypeResolver;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

import java.util.List;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry
                                               registry) {
        registry.addEndpoint("/ws")
                .setAllowedOrigins("http://localhost:3000/**").withSockJS();

        registry.addEndpoint("/ws")
                .setAllowedOrigins("http://localhost:3000/**");
    }
    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registry)
    {
        registry.setMessageSizeLimit(10000000);
        registry.setSendBufferSizeLimit(10000000);
        registry.setSendTimeLimit(1000000);
    }
}