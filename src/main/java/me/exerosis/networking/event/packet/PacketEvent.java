package me.exerosis.networking.event.packet;

import me.exerosis.networking.event.server.ServerEvent;
import me.exerosis.networking.sockets.channel.PacketContainer;

public class PacketEvent extends ServerEvent {
    private PacketContainer  packet;

    public PacketEvent(ServerBase server, PacketContainer packet) {
        super(server);
        this.packet = packet;
    }

    public PacketContainer getPacket() {
        return packet;
    }

    public void setPacket(PacketContainer packet) {
        this.packet = packet;
    }
}