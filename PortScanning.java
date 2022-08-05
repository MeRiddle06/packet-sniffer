import java.net.Socket;
import java.util.List;

public class PortScanning {
    public PortScanning(List<PacketInformation> Packet, Socket socket) {

        System.out.println("Received [" + Packet.size() + "] packet information from: " + socket);
        System.out.println("Packet Information are:");
        System.out.println("Source IP is " + Packet.get(0).getText());
        System.out.println("Destination IP is " + Packet.get(1).getText());
        System.out.println("Source Port is " + Packet.get(2).getText());
        System.out.println("Destination Port is " + Packet.get(3).getText());
        System.out.println("Type of Protocol is " + Packet.get(4).getText());

    }
}