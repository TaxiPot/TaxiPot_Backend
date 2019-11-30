package kr.hs.dsm.java.taxipot_backend.socket;

import kr.hs.dsm.java.taxipot_backend.entity.User;
import kr.hs.dsm.java.taxipot_backend.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Optional;

public class SocketHandler extends TextWebSocketHandler {

    UserRepository repository;
    SocketRepository socketRepo;

    Logger logger = LoggerFactory.getLogger(SocketHandler.class);

    public SocketHandler(UserRepository repository, SocketRepository socketRepo) {
        this.repository = repository;
        this.socketRepo = socketRepo;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        session.sendMessage(new TextMessage("Connect"));
        logger.info(session.getId());
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
                disconnect(session, strToInt(strings[0]), strings[2]);
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

    private void disconnect(WebSocketSession session, int room_id, String userId) { //TODO DB에서 USER.ROOMID, SEATNUM 삭제 작업 해줘야함.
        socketRepo.getSocketMap().get(room_id).onClose(session);
        applyUserChange(removeSocketInfoOnUser(repository.findById(userId)));
    }

    private User removeSocketInfoOnUser(Optional<User> userOptional) {
        if(userOptional.isPresent()) {
            User user = userOptional.get();
            user.setRoomId(null);
            user.setSeatNum(null);
            return user;
        }
        return null;
    }

    private void applyUserChange(User user) {
        if(user==null) {
            return;
        }
        repository.save(user);
    }

}
