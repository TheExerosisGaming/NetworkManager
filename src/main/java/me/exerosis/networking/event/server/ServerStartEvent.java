package me.exerosis.networking.event.server;

import me.exerosis.reflection.event.Cancellable;

public class ServerStartEvent extends ServerEvent implements Cancellable {
    private boolean cancelled;

    public ServerStartEvent(ServerBase server) {
        super(server);
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
