package kr.hs.dsm.java.taxipot_backend.socket;

import java.util.HashMap;
import java.util.Map;

public class SocketRepository {
    Map<Integer, TaxiPotSocket> socketMap = new HashMap<>();

    public Map<Integer, TaxiPotSocket> getSocketMap() {
        return socketMap;
    }
}
