package me.exerosis.networking.sockets;

import me.exerosis.component.event.EventManager;
import me.exerosis.networking.event.packet.PacketReceiveEvent;
import me.exerosis.networking.event.packet.PacketSendEvent;
import me.exerosis.networking.sockets.channel.ClientConnection;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

public abstract class ServerBase {
    private Map<InetSocketAddress, ClientConnection> bans = new HashMap<>();
    private Map<InetSocketAddress, ClientConnection> connections = new HashMap<>();
    private EventManager eventManager = new EventManager();

    public ServerBase() {

    }

    public void terminateConnection(InetSocketAddress address){

    }

    public String authenticateClient(InetSocketAddress address){
        address.s
    }

    public void sendPacket(Object packet, ClientConnection connection){
        eventManager.callEvent(new PacketSendEvent(this, packet), event -> {
            if (!event.isCancelled())
                send(packet, connection.getAddress());
        });
    }

    protected void send(Object packet, InetSocketAddress address){}


    public void receive(Object packet, InetSocketAddress address){
        eventManager.callEvent(new PacketReceiveEvent(this, packet));
        connections.get(address).receive(packet);
    }

    public Map<InetSocketAddress, ClientConnection> getConnections() {
        return connections;
    }

    public EventManager getEventManager() {
        return eventManager;
    }
}
