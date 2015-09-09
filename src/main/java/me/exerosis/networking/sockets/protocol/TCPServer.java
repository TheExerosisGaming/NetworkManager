package me.exerosis.networking.sockets.protocol;

import me.exerosis.networking.NetworkUtil;
import me.exerosis.networking.sockets.channel.ClientConnection;
import me.exerosis.networking.sockets.ServerBase;
import me.exerosis.networking.sockets.channel.ChannelBase;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPServer extends ServerBase {
    private final ExecutorService executor;
    private ServerSocketChannel server;
    private Map<InetSocketAddress, ChannelBase> channels = new HashMap<>();

    public TCPServer(int port) {
        executor = Executors.newFixedThreadPool(1);
        try {
            server = ServerSocketChannel.open();
            server.bind(new InetSocketAddress(NetworkUtil.getLocalHost(), port));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        executor.execute(() -> {
            while (server.isOpen()) {
                try {
                    SocketChannel socket = server.accept();
                    InetSocketAddress address = (InetSocketAddress) socket.getRemoteAddress();
                    ChannelBase channel = new ChannelBase(socket, address);
                    channel.setReceiver(object -> receive(object, channel.getAddress()));
                    channels.put(address, channel);
                    super.getConnections().put(address, new ClientConnection(address, ProtocolType.TCP, this));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void send(Object packet, InetSocketAddress address) {
        channels.get(address).send(packet);
    }
}