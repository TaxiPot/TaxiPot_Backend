package kr.hs.dsm.java.taxipot_backend.socket;

import kr.hs.dsm.java.taxipot_backend.entity.User;
import kr.hs.dsm.java.taxipot_backend.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaxiPotSocket {
    static Logger logger = LoggerFactory.getLogger(TaxiPotSocket.class);
    private static WebSocketSession[] sessions = new WebSocketSession[4];
    private int socketId;
    private int[][] confidenceCheck = new int[4][4];

    private TaxiPotSocket(int socket_id) {
        socketId = socket_id;
    }

    public static TaxiPotSocket create(int socket_id) {
        return new TaxiPotSocket(socket_id);
    }

    public void join(WebSocketSession session, int seat_num) {
        logger.info("join : " + session.toString() + seat_num);
        if (sessions[seat_num] == null || !sessions[seat_num].isOpen()) {
            sessions[seat_num] = session;
            onMessage(session, "JOIN");
            return;
        }
    }

    public void onOpen(WebSocketSession session) {
        try {
            session.sendMessage(new TextMessage("Connection Established"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onMessage(WebSocketSession session, String message) {
        logger.info(message);

        for (WebSocketSession receive : sessions) {
            sendMessage(session, checkReceiver(isOpen(receive), session), message);
        }
    }

    public void onError(Throwable t, WebSocketSession session) {
        logger.info(t.getMessage() + "\nsessionId : " + session.getId());
    }

    public void onClose(WebSocketSession session) {
        for (WebSocketSession receive : sessions) {
            sendMessage(session, checkReceiver(isOpen(receive), session), "REMOVE");
        }
        sessions[getSessionIndex(session)] = null;
    }

    private WebSocketSession isOpen(WebSocketSession webSocketSession) {
        if(webSocketSession==null) return null;
        if(webSocketSession.isOpen()) return webSocketSession;
        return null;
    }

    private void sendMessage(WebSocketSession sender, WebSocketSession receiver, String message) {
        try {
            receiver.sendMessage(new TextMessage(getSessionIndex(sender) + ":" + message));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            logger.info(e.getMessage());
        }
    }

    public void messageBack(WebSocketSession session, String message) {
        sendMessage(session,session,message);
    }

    private int getSessionIndex(WebSocketSession session) {
        for (int i = 0; i < 4; i++) {
            if (isSessionNull(sessions[i])) continue;
            if (sessions[i].equals(session)) return i;
        }
        throw new NullPointerException("session not found");
    }

    private WebSocketSession checkReceiver(WebSocketSession receive, WebSocketSession session) {
        if (receive == null) {
            return null;
        }
        if (receive.equals(session)) {
            return null;
        }
        return receive;
    }

    private boolean isSessionNull(WebSocketSession session) {
        return session == null;
    }

    public void initChangeConfidence(int target) {
        for(int i=0 ;i<4; i++) {
            confidenceCheck[i][target] = 0;
            confidenceCheck[target][i] = 0;
        }
    }

    public void initChangeConfidence(WebSocketSession session) {
        int target = getSessionIndex(session);
        for(int i=0 ;i<4; i++) {
            confidenceCheck[i][target] = 0;
            confidenceCheck[target][i] = 0;
        }
    }

    public boolean checkChangeConfidence(WebSocketSession session, int point, int target) {
        if(confidenceCheck[getSessionIndex(session)][target]>=1) return true;
        return false;
    }

    public void applyChangeConfidence(WebSocketSession session, int target) {
        confidenceCheck[getSessionIndex(session)][target] = 1;
    }
}
