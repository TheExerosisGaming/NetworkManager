package me.exerosis.networking.packets.in.connection;


import me.exerosis.networking.packets.ConnectionPacket;
import me.exerosis.networking.packets.in.PacketIn;

/**
 * Created by The Exerosis on 8/7/2015.
 */
public class PacketInAttemptConnection implements ConnectionPacket, PacketIn {
    private final ClientConnection connection;

    public PacketInAttemptConnection(ClientConnection connection) {
        this.connection = connection;
    }

    public ClientConnection getConnection() {
        return connection;
    }
}