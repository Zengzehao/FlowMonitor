package flow;

import jpcap.JpcapCaptor;
import jpcap.NetworkInterface;
import jpcap.PacketReceiver;
import jpcap.packet.*;

/**
 * 使用jpcap显示网络上的各种数据包
 * 
 * @author www.NetJava.cn
 */
public class jpcapPacket {

	/*// 程序启动主方法
	public static void main(String args[]) {
		try {
			// 获取本机上的网络接口对象数组
			final NetworkInterface[] devices = JpcapCaptor.getDeviceList();

			for (int i = 0; i < devices.length; i++) {

				NetworkInterface nc = devices[i];

				// 创建某个卡口上的抓取对象,最大为2000个
				JpcapCaptor jpcap = JpcapCaptor.openDevice(nc, 2000, true, 20);
				startCapThread(jpcap);
				System.out.println("开始抓取第" + i + "个卡口上的数据");
			}
		} catch (Exception ef) {
			ef.printStackTrace();
			System.out.println("启动失败:  " + ef);
		}

	}*/

	// 程序启动主方法
		public static void startCapture() {
			try {
				// 获取本机上的网络接口对象数组
				final NetworkInterface[] devices = JpcapCaptor.getDeviceList();

				for (int i = 0; i < devices.length; i++) {

					NetworkInterface nc = devices[i];

					// 创建某个卡口上的抓取对象,最大为2000个
					JpcapCaptor jpcap = JpcapCaptor.openDevice(nc, 2000, true, 20);
					startCapThread(jpcap);
					System.out.println("开始抓取第" + i + "个卡口上的数据");
				}
			} catch (Exception ef) {
				ef.printStackTrace();
				System.out.println("启动失败:  " + ef);
			}

		}
	
	
	// 将每个Captor放到独立线程中运行
	public static void startCapThread(final JpcapCaptor jpcap) {
		JpcapCaptor jp = jpcap;
		Runnable rnner = new Runnable() {
			public void run() {
				// 使用接包处理器循环抓包
				jpcap.loopPacket(-1, new TestPacketReceiver());
			}
		};
		new Thread(rnner).start();// 启动抓包线程
	}



}



