package multi_client;

import java.net.Socket;

public class MainClient {
	
    //����ڰ� �� ���̵�
	public static String id;
	
	public static void main(String[] args) {
		
		try {
			//client��(�������)
			Socket socket = new Socket("172.30.1.55", 8383); //������ �������ּ�, ��Ʈ��ȣ
			
			//�޼����� ���Ź޴� Ŭ����
			Receive receive = new Receive(socket);
			
			//�޼����� �۽��ϴ� Ŭ����
			Sender sender = new Sender(socket);
			
			receive.start();
			sender.start();
			
			
			
		} catch (Exception e) {
			System.out.println("Ŭ���̾�Ʈ �� main ����");
			e.printStackTrace();
		}
		
		
		
		
	}
}
