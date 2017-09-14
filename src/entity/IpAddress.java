package entity;

public class IpAddress {
    private int id;  //主键
    private String IpAddress;  //IP地址
    private int count;  //数量

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIpAddress() {
        return IpAddress;
    }

    public void setIpAddress(String ipAddress) {
        IpAddress = ipAddress;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "IpAddress{" +
                "id=" + id +
                ", IpAddress='" + IpAddress + '\'' +
                ", count=" + count +
                '}';
    }
}
