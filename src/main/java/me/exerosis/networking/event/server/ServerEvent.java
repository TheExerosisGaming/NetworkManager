package me.exerosis.networking.event.server;

import me.exerosis.networking.event.Event;

public class ServerEvent extends Event {
    private ServerBase server;

    public ServerEvent(ServerBase server) {
        this.server = server;
    }

    public ServerBase getServer() {
        return server;
    }
}