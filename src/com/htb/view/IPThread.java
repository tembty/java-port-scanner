package com.htb.view;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * ip��ַ��ɨ���߳�
 * @author htb
 *
 */
public class IPThread extends Thread{
	public static InetAddress hostAddress;//����IP��ַ
    public String ipAll;//����IP��ַ
	public int MIN_PORT;//��С�˿ں�
	public int MAX_PORT;//���˿ں�
	/**
	 * ���캯��
	 * @param minPort
	 * @param maxPort
	 * @param Ip
	 */
	  public IPThread(int minPort,int maxPort,String Ip){
			this.MAX_PORT = maxPort;
			this.MIN_PORT = minPort;
			this.ipAll=Ip;
			
		 }
    	 /**
         * ���к���
         */
      public synchronized void run(){
           //ɨ��ָ���˿�
        	   for(int i = MIN_PORT;i <= MAX_PORT;i++)
              {  
            		try {//�����������Ͷ˿ںŴ����׽��ֵ�ַ
            			hostAddress = InetAddress.getByName(ipAll); 
            		    SocketAddress sockaddr = new InetSocketAddress(hostAddress,i);
    					Socket scans = new Socket();
    					//�����׽������ӵ�����ָ����ʱֵ�ķ�����
    					int time = 50;
    					scans.connect(sockaddr, time);
    			
    					if(scans.isConnected()==true){
    					ThreadScan.Result.append("����:"+ThreadScan.addr+" �˿�:"+i+"  ");
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
    				
    					//��ӽ����ʾ
            		}catch(Exception e){
            		
            		}

             }
}
      }