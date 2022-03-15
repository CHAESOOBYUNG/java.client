package multi_client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Receive extends Thread{

	private Socket socket;
	
	public Receive(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader( socket.getInputStream(), "UTF-8"));
			
			while(true) {
				
				String message = br.readLine();
				
				//�޼����� �޾ƿ��� ��, �ڽ��̶��, �ܼ�â���� ������� �ʵ��� ó��
				String[] split = message.split(">");
				if(split.length == 2 && split[0].equals(MainClient.id)) {
					continue; //����� �ѱ��, �����޼����� ���� �����·� �̵�
				}
				
				
				System.out.println(message);
			}
			
			
			
			
		} catch (Exception e) {
			System.out.println("Ŭ���̾�Ʈ receive ����");
			e.printStackTrace();
		}
	}
	
	
	
	
}