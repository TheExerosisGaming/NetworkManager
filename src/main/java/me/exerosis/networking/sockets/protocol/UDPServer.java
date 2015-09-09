package me.exerosis.networking.sockets.protocol;

import me.exerosis.networking.NetworkUtil;
import me.exerosis.networking.packets.in.connection.PacketInAttemptConnection;
import me.exerosis.networking.sockets.ServerBase;
import me.exerosis.networking.sockets.channel.ChannelBase;

import java.net.InetSocketAddress;

public class UDPServer extends ServerBase {
    private final ChannelBase channel;

    public UDPServer(int port) {
        channel = new ChannelBase(ProtocolType.UDP, new InetSocketAddress(NetworkUtil.getLocalHost(), port));
        channel.setReceiver(object -> {
            if (object instanceof PacketInAttemptConnection)
                authenticateClient(channel.getAddress());

            receive(object, channel.getAddress())
        });
    }

    @Override
    protected void send(Object packet, InetSocketAddress address) {
        channel.send(packet, address);
    }
}