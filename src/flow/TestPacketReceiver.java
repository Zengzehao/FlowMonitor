package flow;

import jpcap.PacketReceiver;
import jpcap.packet.ARPPacket;
import jpcap.packet.DatalinkPacket;
import jpcap.packet.EthernetPacket;
import jpcap.packet.ICMPPacket;
import jpcap.packet.Packet;
import jpcap.packet.TCPPacket;
import jpcap.packet.UDPPacket;

/**
 * 抓包监听器,实现PacketReceiver中的方法:打印出数据包说明
 * 
 * @author www.NetJava.cn
 */
class TestPacketReceiver implements PacketReceiver {
	/**
	 * 实现的接包方法:
	 */
	static int count1 = 0;
	static int count2 = 0;
	static int count3 = 0;
	static int count4 = 0;
	static int count5 = 0;
	static int count6 = 0;

	public void receivePacket(Packet packet) {
		// Tcp包,在java Socket中只能得到负载数据
		if (packet instanceof jpcap.packet.TCPPacket) {
			TCPPacket p = (TCPPacket) packet;
			String s = "TCPPacket:| dst_ip " + p.dst_ip + ":" + p.dst_port + "|src_ip " + p.src_ip + ":" + p.src_port
					+ " |len: " + p.len;
			// System.out.println(s);
			count1++;
			System.out.println("Tcp包"+count1);
		}
		
		// UDP包,开着QQ,你就会看到:它是tcp+udp
		else if (packet instanceof jpcap.packet.UDPPacket) {
			UDPPacket p = (UDPPacket) packet;
			String s = "UDPPacket:| dst_ip " + p.dst_ip + ":" + p.dst_port + "|src_ip " + p.src_ip + ":" + p.src_port
					+ " |len: " + p.len;
			// System.out.println(s);
			count2++;
			System.out.println("UDP包"+count2);
		}
		
		// 如果你要在程序中构造一个ping报文,就要构建ICMPPacket包
		else if (packet instanceof jpcap.packet.ICMPPacket) {
			ICMPPacket p = (ICMPPacket) packet;
			// ICMP包的路由链
			String router_ip = "";
			for (int i = 0; i < p.router_ip.length; i++) {
				router_ip += " " + p.router_ip[i].getHostAddress();
			}
			String s = "@ @ @ ICMPPacket:| router_ip " + router_ip + " |redir_ip: " + p.redir_ip + " |mtu: " + p.mtu
					+ " |length: " + p.len;
			// System.out.println(s);
			count3++;
			System.out.println("ICMPPacket包"+count3);
		}
		
		// 是否地址转换协议请求包
		else if (packet instanceof jpcap.packet.ARPPacket) {
			ARPPacket p = (ARPPacket) packet;
			// Returns the hardware address (MAC address) of the sender
			Object saa = p.getSenderHardwareAddress();
			Object taa = p.getTargetHardwareAddress();
			String s = "* * * ARPPacket:| SenderHardwareAddress " + saa + "|TargetHardwareAddress " + taa + " |len: "
					+ p.len;
			// System.out.println(s);
			count4++;
			
			System.out.println("ARPPacket包"+count4);
		}
		
		// 取得链路层数据头 :如果你想局网抓包或伪造数据包，嘿嘿
		DatalinkPacket datalink = packet.datalink;
		// 如果是以太网包
		if (datalink instanceof jpcap.packet.EthernetPacket) {
			EthernetPacket ep = (EthernetPacket) datalink;
			String s = "  datalink layer packet: " + "|DestinationAddress: " + ep.getDestinationAddress()
					+ "|SourceAddress: " + ep.getSourceAddress();
			// System.out.println(s);
			count5++;
			System.out.println("DatalinkPacket包"+count5);
		}
	}

}