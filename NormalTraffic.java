import java.io.IOException;

class NormalTraffic implements Traffic {
    @Override
    public void generateTraffic() throws IOException, InterruptedException {
        for (int i = 0; i < 5; i++) {
            SinglePacketSender sps = new SinglePacketSender();
            sps.sendPacket();
            Thread.sleep(10);
        }
    }
}