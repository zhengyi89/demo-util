package com.sample.socket;

import java.io.*;

import java.net.*;

public class TalkServer{
	public static void main(String args[]) {
		try{
			ServerSocket server=null;
			try{
				//����һ��ServerSocket�ڶ˿�4700�����ͻ�����
				server=new ServerSocket(4700);
			}catch(Exception e) {
				//������ӡ������Ϣ
				System.out.println("can not listen to:"+e);
			}
			Socket socket=null;
			try{
				//ʹ��accept()�����ȴ��ͻ������пͻ�
				//�����������һ��Socket���󣬲�����ִ��
				socket=server.accept();
				}catch(Exception e) {
					//������ӡ������Ϣ
					System.out.println("Error."+e);
			}
			String line;
			BufferedReader is=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//��Socket����õ�����������������Ӧ��BufferedReader����
			PrintWriter os=new PrintWriter(socket.getOutputStream());
			//��Socket����õ��������������PrintWriter����
			BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));
			//��ϵͳ��׼�����豸����BufferedReader����
			System.out.println("TimeClient:"+is.readLine());
			//�ڱ�׼����ϴ�ӡ�ӿͻ��˶�����ַ���
			line=sin.readLine();
			//�ӱ�׼�������һ�ַ���
			while(!line.equals("bye")){
				//������ַ���Ϊ "bye"����ֹͣѭ��
				os.println(line);
				//��ͻ���������ַ���
				os.flush();
				//ˢ���������ʹClient�����յ����ַ���
				System.out.println("DiscardServer:"+line);
				//��ϵͳ��׼����ϴ�ӡ������ַ���
				System.out.println("TimeClient:"+is.readLine());
				//��TimeClient����һ�ַ���������ӡ����׼�����
				line=sin.readLine();
				//��ϵͳ��׼�������һ�ַ���
			} //����ѭ��
			os.close(); //�ر�Socket�����
			is.close(); //�ر�Socket������
			socket.close(); //�ر�Socket
			server.close(); //�ر�ServerSocket
			}catch(Exception e){
				//������ӡ������Ϣ
				System.out.println("Error:"+e);
			}
	}
}
