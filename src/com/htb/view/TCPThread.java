package com.htb.view;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
/**
 * ip��ַɨ�������ɨ���߳�
 * @author htb
 *
 */
 public class TCPThread extends Thread{
	public static InetAddress hostAddress;//����IP��ַ
	public int MIN_PORT;//��С�˿ں�
	public int MAX_PORT;//���˿ں�
	public static int threadnum;//�߳�����
    
    public static int ip1;//ip��ַ1~3��4~6��7~9λ
	public  static int ip2;
	public  static int ip3;
    public  static int ipstart;//��ʼIP��ַ���3λ
    public static String ipAll;//����IP��ַ
    
    String hostname ="";//ɨ����������ƻ���IP��ַ
    String porttype="0";//ɨ��Ķ˿����
     
    /**
     * ���캯��
     */
    public TCPThread(int minPort,int maxPort){
	this.MAX_PORT = maxPort;
	this.MIN_PORT = minPort;
	}
	  /**
     * ���к���
     */
  public void run(){
    	
    	//ɨ��ָ���˿�
          for(int i = MIN_PORT;i <= MAX_PORT;i++)
          {
        		try {//�����������Ͷ˿ںŴ����׽��ֵ�ַ
        			SocketAddress sockaddr = new InetSocketAddress(hostAddress, i);
					Socket scans = new Socket();	
					//�����׽������ӵ�����ָ����ʱֵ�ķ�����
					int time = 50;
					scans.connect(sockaddr, time);
	
				
					//��ӽ����ʾ
					if(scans.isConnected()==true){
					ThreadScan.Result.append( "����"+ThreadScan.hostname.getText()+"�˿�"+i+"  ");
					switch(i){
					case 20:ThreadScan.Result.append("����FTP Data!");break;
					case 21:ThreadScan.Result.append("����FTP Control!");break;
					case 23:ThreadScan.Result.append("����TELNET!");break;
					case 25:ThreadScan.Result.append("����SMTP!");break;
					case 38:ThreadScan.Result.append("����RAP!");break;
					case 80:ThreadScan.Result.append("����HTTP!");break;
					case 110:ThreadScan.Result.append("����POP!");break;
					case 161:ThreadScan.Result.append("����SNMP!");break;
					case 139:ThreadScan.Result.append("����netBIOS!");break;
					case 1433:ThreadScan.Result.append("����SQL server!");break;
					case 3389:ThreadScan.Result.append("����Terminal Service!");break;
					case 443:ThreadScan.Result.append("����https!");break;
					case 1521:ThreadScan.Result.append("����Oracle!");break;
					case 8000:ThreadScan.Result.append("����OICQ!");break;
					} ThreadScan.Result.append("Open!\n");
					scans.close();//�ر��׽���
					}
				 } catch ( IOException e) {
					 //ThreadScan.Result.append( "����"+ThreadScan.hostname.getText()+"�˿�"+i+":����ʱ!\n");
				 }	 
          }
    	//ɨ����ɺ���ʾɨ�����
  }//run
  }//class
