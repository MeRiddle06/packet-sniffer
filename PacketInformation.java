import java.io.Serializable;

public class PacketInformation implements Serializable {
    private final String text;

    public PacketInformation(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}