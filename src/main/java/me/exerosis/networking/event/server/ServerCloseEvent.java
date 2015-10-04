package me.exerosis.networking.event.server;

import me.exerosis.component.event.Cancellable;

public class ServerCloseEvent extends ServerEvent implements Cancellable {
    private boolean cancelled;

    public ServerCloseEvent(ServerBase server) {
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
