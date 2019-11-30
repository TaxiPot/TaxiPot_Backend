package kr.hs.dsm.java.taxipot_backend;

import kr.hs.dsm.java.taxipot_backend.socket.SocketHandler;
import kr.hs.dsm.java.taxipot_backend.socket.SocketRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class SocketConfigure implements WebSocketConfigurer {

    SocketRepository repository = new SocketRepository();

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(new SocketHandler(repository),"/ws/socket").setAllowedOrigins("*");
    }
}
