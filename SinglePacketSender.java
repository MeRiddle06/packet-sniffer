import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.net.InetAddress;

public class SinglePacketSender {
    private Socket socket;
    private String sourceIP;
    private String destinationIP;
    private String sourcePort;
    private String destinationPort;
    private String typeOfProtocol;
    private List<PacketInformation> Packet;

    public SinglePacketSender() throws IOException {
        socket = new Socket("localhost", 7777);
        System.out.println("Connected!");

        InetAddress IP = InetAddress.getLocalHost();
        sourceIP = IP.getHostAddress();
        destinationIP = "192.168.29.173";
        sourcePort = String.valueOf(socket.getPort());
        destinationPort = String.valueOf(socket.getLocalPort());
        typeOfProtocol = "TCP/IP";
        Packet = new ArrayList<>();
        Packet.add(new PacketInformation(sourceIP)); // source IP address
        Packet.add(new PacketInformation(destinationIP)); // destination IP address
        Packet.add(new PacketInformation(sourcePort)); // source port
        Packet.add(new PacketInformation(destinationPort)); // destination port
        Packet.add(new PacketInformation(typeOfProtocol)); // type of protocol

    }

    void sendPacket() throws IOException {

        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        System.out.println("Sending messages to the ServerSocket");
        objectOutputStream.writeObject(Packet);
        socket.close();
    }
}
