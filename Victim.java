import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;

public class Victim {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        long start = System.currentTimeMillis(); // start time of the victimc class
        long end = start + 3000 * 1000; // we remain active till 3000 seconds after start
        HashMap<String, Integer> count = new HashMap<>(); // count of different soource IP
        ServerSocket ss = new ServerSocket(7777); // used in the implementation of circuit programming
        while (System.currentTimeMillis() < end) {

            Socket socket = ss.accept(); // conn bw victim and host class
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            @SuppressWarnings(value = "unchecked") //
            List<PacketInformation> Packet = (List<PacketInformation>) objectInputStream.readObject(); // one packet
                                                                                                       // only
            String sourceIP = Packet.get(0).getText();
            if (count.containsKey(sourceIP)) {
                count.put(sourceIP, count.get(sourceIP) + 1);
            } else {
                count.put(sourceIP, 1);
            }
            int countFromIP = count.get(sourceIP);
            System.out.println("Connection from " + socket + ". Packet number is " + countFromIP);
            new PortScanning(Packet, socket); // extracts info from packets
            if (countFromIP > 1000) {
                System.out.println("-------------------An attack is happening!!--------------------------");
            }
            socket.close();
        }
        ss.close();
        System.out.println("Closing sockets.");

    }
}
