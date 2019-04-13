package com.htb.view;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
/**
 * ip地址扫描或域名扫描线程
 * @author htb
 *
 */
 public class TCPThread extends Thread{
	public static InetAddress hostAddress;//主机IP地址
	public int MIN_PORT;//最小端口号
	public int MAX_PORT;//最大端口号
	public static int threadnum;//线程总数
    
    public static int ip1;//ip地址1~3、4~6、7~9位
	public  static int ip2;
	public  static int ip3;
    public  static int ipstart;//起始IP地址最后3位
    public static String ipAll;//完整IP地址
    
    String hostname ="";//扫描的主机名称或者IP地址
    String porttype="0";//扫描的端口类别
     
    /**
     * 构造函数
     */
    public TCPThread(int minPort,int maxPort){
	this.MAX_PORT = maxPort;
	this.MIN_PORT = minPort;
	}
	  /**
     * 运行函数
     */
  public void run(){
    	
    	//扫描指定端口
          for(int i = MIN_PORT;i <= MAX_PORT;i++)
          {
        		try {//根据主机名和端口号创建套接字地址
        			SocketAddress sockaddr = new InetSocketAddress(hostAddress, i);
					Socket scans = new Socket();	
					//将此套接字连接到具有指定超时值的服务器
					int time = 50;
					scans.connect(sockaddr, time);
	
				
					//添加结果显示
					if(scans.isConnected()==true){
					ThreadScan.Result.append( "主机"+ThreadScan.hostname.getText()+"端口"+i+"  ");
					switch(i){
					case 20:ThreadScan.Result.append("服务：FTP Data!");break;
					case 21:ThreadScan.Result.append("服务：FTP Control!");break;
					case 23:ThreadScan.Result.append("服务：TELNET!");break;
					case 25:ThreadScan.Result.append("服务：SMTP!");break;
					case 38:ThreadScan.Result.append("服务：RAP!");break;
					case 80:ThreadScan.Result.append("服务：HTTP!");break;
					case 110:ThreadScan.Result.append("服务：POP!");break;
					case 161:ThreadScan.Result.append("服务：SNMP!");break;
					case 139:ThreadScan.Result.append("服务：netBIOS!");break;
					case 1433:ThreadScan.Result.append("服务：SQL server!");break;
					case 3389:ThreadScan.Result.append("服务：Terminal Service!");break;
					case 443:ThreadScan.Result.append("服务：https!");break;
					case 1521:ThreadScan.Result.append("服务：Oracle!");break;
					case 8000:ThreadScan.Result.append("服务：OICQ!");break;
					} ThreadScan.Result.append("Open!\n");
					scans.close();//关闭套接字
					}
				 } catch ( IOException e) {
					 //ThreadScan.Result.append( "主机"+ThreadScan.hostname.getText()+"端口"+i+":请求超时!\n");
				 }	 
          }
    	//扫描完成后显示扫描完成
  }//run
  }//class
