package kr.hs.dsm.java.taxipot_backend.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class SocketHandler extends TextWebSocketHandler {
    SocketRepository socketRepo;
    Logger logger = LoggerFactory.getLogger(SocketHandler.class);

    public SocketHandler(SocketRepository socketRepo) {
        this.socketRepo = socketRepo;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        session.sendMessage(new TextMessage("Connect"));
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String[] strings = splitMessage(message, ","); // {roomId},{command},{message}
        for(String item : strings) {
            System.out.println(item+"\n");
        }
        switch (strings[1]) {
            case "JOIN": {
                createSocket(strToInt(strings[0]));
                joinToSocket(strToInt(strings[0]), session, strToInt(strings[2]));
                break;
            }
            case "MESSAGE": {
                isExistSocket(strToInt(strings[0]));
                applyMessage(session, strToInt(strings[0]),strings[2]);
                break;
            }
            case "DISCONNECT": {
                isExistSocket(strToInt(strings[0]));
                disconnect(session, strToInt(strings[0]));
                break;
            }
            default: {
                session.sendMessage(new TextMessage("Command Error!"));
            }
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
    }

    private void createSocket(int roomId) {
        if(!socketRepo.getSocketMap().containsKey(roomId)) {
            socketRepo.getSocketMap().put(roomId, TaxiPotSocket.create(roomId));
        }
    }

    private void joinToSocket(int roomId, WebSocketSession session, int seat_num) {
        socketRepo.getSocketMap().get(roomId).join(session, seat_num);
    }

    private void isExistSocket(int room_Id) throws Exception{
        if(!socketRepo.getSocketMap().containsKey(room_Id)) throw new Exception("Socket Not Exist.");
    }

    private void applyMessage(WebSocketSession session, int room_id, String message) {
        logger.info(room_id + " : " + message);
        socketRepo.getSocketMap().get(room_id).onMessage(session,message);
    }

    private int strToInt(String string) {
        return Integer.valueOf(string);
    }

    private String[] splitMessage(TextMessage message, String regex) {
        return message.getPayload().split(regex);
    }

    private void disconnect(WebSocketSession session, int room_id) {
        socketRepo.getSocketMap().get(room_id).onClose(session);
    }

}
