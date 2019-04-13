package com.htb.view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.*;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class ThreadScan extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextArea Result = new JTextArea();
	public static JTextField hostname = new JTextField();
	public static JTextField formip1 = new JTextField();
	public static JTextField formip2 = new JTextField();
	public static JTextField formip3 = new JTextField();
	public static JTextField formip4 = new JTextField();
	public static JTextField minPort = new JTextField();
	public static JTextField maxPort= new JTextField();
	public static JTextField maxThread= new JTextField();
	public static JButton Submit = new JButton("\u5F00\u59CB\u626B\u63CF");
	public JTextField dnsnametxt = new JTextField();
	public JRadioButton ipbtn = new JRadioButton("IP\u5730\u5740");
	public JRadioButton namebtn = new JRadioButton("\u57DF\u540D");
	public JTextField ipendtxt = new JTextField();
	public JTextField ipendname = new JTextField();
	public JRadioButton ipaddrbtn = new JRadioButton("ip\u5730\u5740\u6BB5");
	public static String addr="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThreadScan frame = new ThreadScan();
					frame.setVisible(true);
					 JOptionPane.showMessageDialog(null, "请选择扫描类型！");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ThreadScan() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ThreadScan.class.getResource("/image/images/search.png")));
		setFont(new Font("宋体", Font.PLAIN, 12));
		setTitle("JAVA\u7AEF\u53E3\u626B\u63CF\u5668");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 499);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u8BBE\u7F6E");
		mnNewMenu.setIcon(new ImageIcon(ThreadScan.class.getResource("/image/images/base.png")));
		mnNewMenu.setForeground(Color.BLACK);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u5173\u4E8E\u4F5C\u8005");
		mntmNewMenuItem.setIcon(new ImageIcon(ThreadScan.class.getResource("/image/images/about.png")));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "16级计科三班黄腾彬\n");
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(this, popupMenu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder());
		
		JLabel label_3 = new JLabel("");
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		
		JLabel label_7 = new JLabel("\u626B\u63CF\u7ED3\u679C");
		label_7.setFont(new Font("宋体", Font.PLAIN, 12));
		ipbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setunvisible(e);
			}
		});
		ipbtn.setFont(new Font("宋体", Font.PLAIN, 12));
		namebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDnsname(e);
			}
		});
		
		
		namebtn.setFont(new Font("宋体", Font.PLAIN, 12));
		
		JLabel label = new JLabel("\u57DF\u540D");
		label.setFont(new Font("宋体", Font.PLAIN, 12));
		
		dnsnametxt = new JTextField();
		dnsnametxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u626B\u63CF\u7C7B\u578B");
		label_2.setFont(new Font("宋体", Font.BOLD, 12));
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE))
						.addComponent(label_7)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(47)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(namebtn)
									.addGap(18)
									.addComponent(label)
									.addGap(18)
									.addComponent(dnsnametxt, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
								.addComponent(ipbtn)
								.addComponent(ipaddrbtn)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 406, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_7)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(152)
									.addComponent(label_3))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))))
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(41)
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(ipbtn)
								.addComponent(label_2))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(namebtn)
								.addComponent(label)
								.addComponent(dnsnametxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(8)
							.addComponent(ipaddrbtn)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(23))))
		);
		ipaddrbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ipendAction(e);
			}
		});
		ipaddrbtn.setFont(new Font("宋体", Font.PLAIN, 12));
		
		JButton Submit = new JButton("\u5F00\u59CB\u626B\u63CF");
		Submit.setIcon(new ImageIcon(ThreadScan.class.getResource("/image/images/search.png")));
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitAction(e);
			}
		});
		Submit.setFont(new Font("宋体", Font.PLAIN, 12));
		
		JButton Cancel = new JButton("\u9000\u51FA");
		Cancel.setIcon(new ImageIcon(ThreadScan.class.getResource("/image/images/delete.png")));
		Cancel.setFont(new Font("宋体", Font.PLAIN, 12));
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  int n = JOptionPane.showConfirmDialog(null, "确认退出扫描器吗？");
				  if( n == 0){
					  System.exit(0);}
				  }
		});
		
		JButton saveButton = new JButton("\u4FDD\u5B58\u7ED3\u679C");
		saveButton.setIcon(new ImageIcon(ThreadScan.class.getResource("/image/images/edit.png")));
		saveButton.setFont(new Font("宋体", Font.PLAIN, 12));
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   saveFile(e);
			}
		});
		
		JButton resetbtn = new JButton("\u91CD\u7F6E");
		resetbtn.setIcon(new ImageIcon(ThreadScan.class.getResource("/image/images/reset.png")));
		resetbtn.setFont(new Font("宋体", Font.PLAIN, 12));
		resetbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetaction(e);
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(Submit, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
						.addComponent(Cancel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(resetbtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(saveButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(19))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(Submit, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(Cancel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(saveButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(resetbtn)))
					.addContainerGap(120, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JLabel label_4 = new JLabel("\u8D77\u59CB\u7AEF\u53E3\u53F7");
		label_4.setFont(new Font("宋体", Font.PLAIN, 12));
		
		JLabel label_5 = new JLabel("\u7ED3\u675F\u7AEF\u53E3\u53F7");
		label_5.setFont(new Font("宋体", Font.PLAIN, 12));
		
		JLabel label_6 = new JLabel("\u7EBF\u7A0B\u6570");
		label_6.setFont(new Font("宋体", Font.PLAIN, 12));
		
		
		minPort.setColumns(10);
		maxPort.setColumns(10);
		maxThread.setColumns(10);
		
		JLabel label_8 = new JLabel("\u7AEF\u53E3\u8303\u56F4\uFF1A0-65535");
		label_8.setFont(new Font("宋体", Font.PLAIN, 12));
		
		JLabel label_1 = new JLabel("\u7EBF\u7A0B\u6570\uFF1A0-200");
		label_1.setFont(new Font("宋体", Font.PLAIN, 12));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label_4)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(minPort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label_8)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_1))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label_6)
							.addGap(18)
							.addComponent(maxThread, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label_5)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(maxPort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(minPort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(maxPort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(maxThread, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_8)
						.addComponent(label_1))
					.addContainerGap(127, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblip = new JLabel("\u4E3B\u673AIP/\u57DF\u540D");
		lblip.setFont(new Font("宋体", Font.PLAIN, 12));
		
		JLabel lblNewLabel = new JLabel("ip\u5730\u5740\u524D3\u4F4D");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		
		JLabel lblIp = new JLabel("ip\u5730\u57404-6\u4F4D");
		lblIp.setFont(new Font("宋体", Font.PLAIN, 12));
		
		JLabel lblIp_1 = new JLabel("ip\u5730\u57407-9\u4F4D");
		lblIp_1.setFont(new Font("宋体", Font.PLAIN, 12));
		
		JLabel lblIp_2 = new JLabel("ip\u5730\u5740\u540E3\u4F4D");
		lblIp_2.setFont(new Font("宋体", Font.PLAIN, 12));
		
		
		hostname.setColumns(15);
		
	
		formip1.setColumns(3);
		
		
		formip2.setColumns(3);
		
	
		formip3.setColumns(3);
		
		
		formip4.setColumns(3);
		
		JLabel label_9 = new JLabel("");
		
		JLabel lblip_1 = new JLabel("\u7EC8\u6B62ip\u5730\u5740\u6BB5\u540E3\u4F4D");
		lblip_1.setFont(new Font("宋体", Font.PLAIN, 12));
		
		ipendtxt = new JTextField();
		ipendtxt.setColumns(3);
		
		JLabel lblip_2 = new JLabel("\u76EE\u7684ip\u5730\u5740");
		lblip_2.setFont(new Font("宋体", Font.PLAIN, 12));
		
		ipendname = new JTextField();
		ipendname.setColumns(15);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_9)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel.createSequentialGroup()
													.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addComponent(lblIp)
														.addComponent(lblIp_2, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
													.addPreferredGap(ComponentPlacement.RELATED))
												.addGroup(gl_panel.createSequentialGroup()
													.addComponent(lblIp_1)
													.addGap(5)))
											.addGroup(gl_panel.createSequentialGroup()
												.addComponent(lblNewLabel)
												.addPreferredGap(ComponentPlacement.RELATED)))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblip)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(hostname, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
										.addComponent(formip1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
										.addComponent(formip3, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
										.addComponent(formip2, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
										.addComponent(formip4, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)))
								.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
									.addComponent(lblip_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(ipendname, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
										.addComponent(ipendtxt, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))))
							.addGap(104))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblip_2)
							.addContainerGap(336, Short.MAX_VALUE))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(3)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(hostname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblip))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(formip1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIp)
						.addComponent(formip2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblIp_1)
						.addComponent(formip3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIp_2)
						.addComponent(formip4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_9, Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblip_1)
								.addComponent(ipendtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblip_2)
								.addComponent(ipendname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(6))))
		);
		panel.setLayout(gl_panel);
		Result.setWrapStyleWord(true);
		scrollPane.setViewportView(Result);
		contentPane.setLayout(gl_contentPane);
	}
	/**
	 * ip地址段选择事件处理
	 * @param htb
	 */
	public void ipendAction(ActionEvent evt) {
		
		if(ipaddrbtn.isSelected()==true){//地址段
			dnsnametxt.setEditable(false);
			ipendname.setEditable(true);ipendtxt.setEditable(true);
			formip1.setEditable(true);formip2.setEditable(true);formip3.setEditable(true);formip4.setEditable(true);
			ipbtn.setSelected(false);
			namebtn.setSelected(false);
			maxPort.setEditable(true);minPort.setEditable(true);maxThread.setEditable(true);
		}
	}

	/**
	 * 重置事件处理
	 * @param e
	 */
	public void resetaction(ActionEvent evt) {
		formip1.setText("");formip2.setText("");formip3.setText("");formip4.setText("");
		hostname.setText("");Result.setText("");
		maxPort.setText("");minPort.setText("");maxThread.setText("");
		ipendname.setText("");ipendtxt.setText("");
		dnsnametxt.setText("");
		ipbtn.setSelected(false);
		namebtn.setSelected(false);
		ipaddrbtn.setSelected(false);
		
	}

	/**
	 * 域名选择处理
	 * @param e
	 */
	public void setDnsname(ActionEvent evt) {
		if(namebtn.isSelected()==true){
			dnsnametxt.setEditable(true);ipendname.setEditable(false);ipendtxt.setEditable(false);
			formip1.setEditable(false);formip2.setEditable(false);formip3.setEditable(false);formip4.setEditable(false);
			maxPort.setEditable(true);minPort.setEditable(true);maxThread.setEditable(true);
			ipbtn.setSelected(false);
			ipaddrbtn.setSelected(false);
		}
		
	}

	/**
	 * IP选择处理
	 * @param e
	 */
	public void setunvisible(ActionEvent evt) {
		if(ipbtn.isSelected()==true){
			dnsnametxt.setEditable(false);ipendname.setEditable(false);ipendtxt.setEditable(false);
			formip1.setEditable(true);formip2.setEditable(true);formip3.setEditable(true);formip4.setEditable(true);
			maxPort.setEditable(true);minPort.setEditable(true);maxThread.setEditable(true);
			namebtn.setSelected(false);
			ipaddrbtn.setSelected(false);
		}
		
	}

	/**
	 * 扫描事件处理
	 * @param htb
	 * @return 
	 * @return 
	 */
	public  void submitAction(ActionEvent evt) {
		int minPort;
		int maxPort;
		int maxThread;
		int ip1 = 0;int ip2 = 0;int ip3 = 0;
		int ipstart = 0;int ipend = 0;
		String ip="";
		String ipx="";
		Result.setText("");
		
		if(ipbtn.isSelected()||ipaddrbtn.isSelected()){
		//判断ip前三位是否为int型
		try {
			ip1 = Integer.parseInt(formip1.getText());
		    } catch (Exception e) {
			JOptionPane.showMessageDialog(null, "错误的IP地址1！");
			return;
		}
		//判断ip4-6位是否为int型
		try {
			ip2 = Integer.parseInt(formip2.getText());
			} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "错误的IP地址2！");
			return;}
	   //判断ip7-9位是否为int型
		try {
			ip3 = Integer.parseInt(formip3.getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "错误的IP地址3！");
				return;
				}
		//判断起始ip后3位是否为int型
		try {
			ipstart = Integer.parseInt(formip4.getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "错误的IP4！");
				return;
			}
		//若选择地址段扫描，判断目的ip后3位是否为int型是否为0-255
		if(ipaddrbtn.isSelected()){
				try {
					ipend = Integer.parseInt(ipendtxt.getText());
					if(ip1<0||ip1>255){
						JOptionPane.showMessageDialog(null, "起始ip地址为0-255整数！");
						return;
					}
					
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "错误的IP5！");
						return;
					}
		}
		
			
	//判断起始IP是否正确，条件：>0且<=255
	if(ip1<0||ip1>255||ip2<0||ip2>255||ip3<0||ip3>255||ipstart<0||ipstart>255){
		JOptionPane.showMessageDialog(null, "起始ip地址为0-255整数！");
		return;
	}else{
		TCPThread.ip1 = ip1;
		TCPThread.ip2 = ip2;
		TCPThread.ip3 = ip3;
		TCPThread.ipstart = ipstart;
		TCPThread.ipAll =ip1+"."+ip2+"."+ip3+"."+ipstart;
		ip=ip1+"."+ip2+"."+ip3+"."+ipstart;//起始地址ip
		ipx=ip1+"."+ip2+"."+ip3+"."+ipend;//目的地址ip
	}
		}
	/**
	 * 判断ip地址/域名有效性
	 */
	try {
		if(ipbtn.isSelected()==true){
		TCPThread.hostAddress = InetAddress.getByName(ip);
		hostname.setText(TCPThread.ipAll);
		}
	else{
		if(namebtn.isSelected()==true){
			TCPThread.hostAddress = InetAddress.getByName(dnsnametxt.getText());
			hostname.setText(dnsnametxt.getText());
		}
		else{
			if(ipaddrbtn.isSelected()== true){
			hostname.setText(TCPThread.ipAll);
			ipendname.setText(ipx);
	        }
		}
	}//end of if1
		
	}catch (Exception e) {
		JOptionPane.showMessageDialog(null, "错误的ip或域名不可达！");
		return;}
	
	
		//判断端口号的有效性
			try {
				minPort=Integer.parseInt(ThreadScan.minPort.getText());
				maxPort=Integer.parseInt(ThreadScan.maxPort.getText());
				maxThread=Integer.parseInt(ThreadScan.maxThread.getText());
			} catch (Exception e) {
		         JOptionPane.showMessageDialog(null, "错误的端口号或进程数！必须为整数");
				return;
			}
			//判断最小端口号的有效范围（0-65535）且应小于最大端口号
			if(minPort < 0 || minPort > 65535 || minPort > maxPort){
				JOptionPane.showMessageDialog(null, "错误的最小端口号，必须为0-65535且小于最大端口号！");
				return;	
			}
			//判断最大端口号的有效范围（0-65535）且应大于最小端口号
			if(maxPort < 0|| maxPort > 65535 || minPort > maxPort){
				JOptionPane.showMessageDialog(null, "错误的最大端口号，必须为0-65535且大于最小端口号！");
				return;	
			}
		
		//判断线程数量的有效性（1-200）
		if( maxThread < 1 || maxThread > 200){
			JOptionPane.showMessageDialog(null, "线程数必须为0-200！");
			return;
		}
		
		//进程开始（ip地址或域名扫描）
		if(ipbtn.isSelected()==true ||namebtn.isSelected()==true ){
		   Result.append("正在扫描"+hostname.getText()+" 线程数："+ThreadScan.maxThread.getText()+"\n");
			Result.append("开始扫描...\n");
		   Result.append("开始端口"+minPort+"结束窗口"+maxPort+"\n");
			//启动线程
			for(int i = minPort;i<=maxPort;){
	         if((i+maxThread)<=maxPort){
	        	 new TCPThread(i,i+maxThread).start();
	        	 i+=maxThread;
			}else{
				new TCPThread(i,maxPort).start();
				i+=maxThread;
			}
			}
	         try {
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}
	       Result.append("扫描完成！\n");
	}
		//扫描网段的进程
		if(ipaddrbtn.isSelected()==true){
			Result.append("开始扫描网段...\n起始ip地址:"+hostname.getText()+" 终止ip地址："+ipendname.getText()+"\n");
			 Result.append("开始端口"+minPort+"结束端口"+maxPort+"\n");
			//启动线程
			for(int j = ipstart;j<=ipend;j++){
			addr=ip1+"."+ip2+"."+ip3+"."+j;
				
			for(int i = minPort;i<=maxPort;){
				try {
					 
					if((i+maxThread)<=maxPort){
		        	 new IPThread(i,i+maxThread,addr).start();
		        	 i+=maxThread;
				}else{
					new IPThread(i,maxPort,addr).start();
					i+=maxThread;
				  }
				} catch (Exception e) {
					
					e.printStackTrace();
				}
		      
				}//for i
			}//for j
		         try {
					Thread.sleep(3000);
				} catch (Exception e) {
					e.printStackTrace();
				}
		       Result.append("扫描完成！\n");
			
		}
		}
		
	 
	


	/**
	 * 保存事件处理
	 * @param e
	 */
	public void saveFile(ActionEvent evt) {
		JFileChooser fc = new JFileChooser();
		int returnVal=fc.showSaveDialog(null);
		if(returnVal == 0){
			File saveFile = fc.getSelectedFile();
			try {
				FileWriter writeOut = new FileWriter(saveFile);
				writeOut.write(ThreadScan.Result.getText());
				writeOut.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "保存失败！");
			}return;
			
		}
		
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
