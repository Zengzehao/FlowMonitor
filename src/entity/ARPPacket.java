package entity;

public class ARPPacket {
    private int length;

    public ARPPacket() {
    }

    public ARPPacket(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "ARPPacket{" +
                "length=" + length +
                '}';
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
