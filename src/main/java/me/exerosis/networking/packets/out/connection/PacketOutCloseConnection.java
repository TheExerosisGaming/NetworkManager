package me.exerosis.networking.packets.out.connection;


import me.exerosis.networking.packets.ConnectionPacket;
import me.exerosis.networking.packets.out.PacketOut;

/**
 * Created by The Exerosis on 8/7/2015.
 */
public class PacketOutCloseConnection implements ConnectionPacket, PacketOut {
    private final String reason;
    private final boolean ban;

    public PacketOutCloseConnection(String reason, boolean ban) {
        this.reason = reason;
        this.ban = ban;
    }

    public String getReason() {
        return reason;
    }

    public boolean isBan() {
        return ban;
    }
}