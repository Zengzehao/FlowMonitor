package entity;

public class TCPPacket {
    private int src_port;
    private int dst_port;
    private int length;

    public TCPPacket() {
    }

    public TCPPacket(int src_port, int dst_port, int length) {
        this.src_port = src_port;
        this.dst_port = dst_port;
        this.length = length;
    }

    public int getSrc_port() {
        return src_port;
    }

    public void setSrc_port(int src_port) {
        this.src_port = src_port;
    }

    public int getDst_port() {
        return dst_port;
    }

    public void setDst_port(int dst_port) {
        this.dst_port = dst_port;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "TCPPacket{" +
                "src_port=" + src_port +
                ", dst_port=" + dst_port +
                ", length=" + length +
                '}';
    }
}
