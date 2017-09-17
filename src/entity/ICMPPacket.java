package entity;

public class ICMPPacket {
    private int length;

    public ICMPPacket() {
    }

    public ICMPPacket(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "ICMPPacket{" +
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
