import java.io.IOException;

class AttackTraffic implements Traffic {
    @Override
    public void generateTraffic() throws IOException, InterruptedException {
        for (int i = 0; i < 1050; i++) {
            SinglePacketSender sps = new SinglePacketSender();
            sps.sendPacket();
            Thread.sleep(10);
        }
    }
}
