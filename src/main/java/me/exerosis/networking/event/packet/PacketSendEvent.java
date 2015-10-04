package me.exerosis.networking.event.packet;

import me.exerosis.component.event.Cancellable;
import me.exerosis.networking.sockets.channel.PacketContainer;

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