package me.exerosis.networking.event.packet;

import me.exerosis.networking.sockets.channel.PacketContainer;
import me.exerosis.reflection.event.Cancellable;

public class PacketSendEvent extends PacketEvent implements Cancellable {
    private boolean cancelled;

    public PacketSendEvent(ServerBase server, PacketContainer packet) {
        super(server, packet);
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}