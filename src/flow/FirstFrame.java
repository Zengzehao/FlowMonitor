package flow;

import java.awt.event.*;

import javax.swing.*;

public class   FirstFrame extends JFrame {


	private static final long serialVersionUID = -7702775022830426851L;

	public FirstFrame() {

		setTitle("流量监控系统");// 设置窗口标题
		setSize(520, 460);// 设置窗口大小
		setLocationRelativeTo(null);// 设置窗口居中
		setDefaultCloseOperation(EXIT_ON_CLOSE);// 设置关闭时退出虚拟机
		setResizable(false);//是否可以自由改变大小
		
		getContentPane().setLayout(null);// 设置窗口布局为流式布局

		JButton jb1 = new JButton("启动监控");
		JButton jb2 = new JButton("关闭监控");
		JButton jb3 = new JButton("图形显示");
				
		jb1.setBounds(10, 10, 100, 40);
		jb2.setBounds(10, 10, 100, 40);
		jb3.setBounds(10, 10, 100, 40);
				
		jb1.setLocation(20, 120);
		jb2.setLocation(120, 220);
		jb3.setLocation(220, 120);
				
		getContentPane().add(jb1);
		getContentPane().add(jb2);
		getContentPane().add(jb3);
	
		
		jb1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				//启动监控
				jpcapPacket.startCapture();
			}
		});
		
		
		jb2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				//关闭监控
			}
		});
		
		
		jb3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				BarGraph.paintBarGraph();
			}
		});
		
		
		
	}

	// 给按钮添加事件

	public static void main(String[] args) {

		new FirstFrame().setVisible(true);// 创建窗口,被设置为可见

	}

}