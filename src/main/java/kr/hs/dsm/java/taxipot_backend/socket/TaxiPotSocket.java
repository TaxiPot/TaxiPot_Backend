package kr.hs.dsm.java.taxipot_backend.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

public class TaxiPotSocket {
    static Logger logger = LoggerFactory.getLogger(TaxiPotSocket.class);
    private static WebSocketSession[] sessions = new WebSocketSession[4];

    private TaxiPotSocket(int socket_id) {

    }

    public static TaxiPotSocket create(int socket_id) {
        return new TaxiPotSocket(socket_id);
    }

    public void join(WebSocketSession session, int seat_num) {
        if(sessions[seat_num]==null) {
            sessions[seat_num] = session;
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

        for(WebSocketSession receive : sessions) {
            sendMessage(checkReceiver(receive,session),message);
        }
    }

    public void onError(Throwable t, WebSocketSession session) {
        logger.info(t.getMessage() + "\nsessionId : " + session.getId());
    }

    public void onClose(WebSocketSession session) {
        for(WebSocketSession receive : sessions) {
            sendMessage(checkReceiver(receive,session),"REMOVE");
        }
    }

    private void sendMessage(WebSocketSession receiver, String message) {
        try{
            receiver.sendMessage(new TextMessage(getSessionIndex(receiver) + ":" +message));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            logger.info(e.getMessage());
        }
    }

    private int getSessionIndex(WebSocketSession session) {
        for(int i=0; i<4; i++) {
            sessions[i].equals(session);
            return i;
        }
        throw new NullPointerException("session not found");
    }

    private WebSocketSession checkReceiver(WebSocketSession receive, WebSocketSession session) {
        if(receive==null) {
            return null;
        }
        if(receive.equals(session)){
            return null;
        }
        return receive;
    }
}
