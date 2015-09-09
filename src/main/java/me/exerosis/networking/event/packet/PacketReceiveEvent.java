package me.exerosis.networking.event.packet;

import me.exerosis.networking.sockets.channel.PacketContainer;

public class PacketReceiveEvent extends PacketEvent {
    public PacketReceiveEvent(ServerBase server, PacketContainer packet) {
        super(server, packet);
    }
}