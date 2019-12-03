package kr.hs.dsm.java.taxipot_backend;

import kr.hs.dsm.java.taxipot_backend.repository.TaxipotRepository;
import kr.hs.dsm.java.taxipot_backend.repository.UserRepository;
import kr.hs.dsm.java.taxipot_backend.socket.SocketHandler;
import kr.hs.dsm.java.taxipot_backend.socket.SocketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class SocketConfigure implements WebSocketConfigurer {

    @Autowired
    UserRepository userRepository;
    @Autowired
    TaxipotRepository taxipotRepository;
    SocketRepository repository = new SocketRepository();

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(new SocketHandler(userRepository,repository, taxipotRepository),"/ws/socket").setAllowedOrigins("*");
    }
}
