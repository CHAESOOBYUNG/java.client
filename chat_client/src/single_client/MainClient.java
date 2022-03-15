package single_client;

import java.net.Socket;

public class MainClient {

	public static void main(String[] args) {
		
		try {
			//클라이언트 측(아이피는 본인주소)
			Socket socket = new Socket("172.30.1.55", 8383); 
			
			//메시지 받는 클래스
			Receive receive = new Receive(socket);
			
			//메시지 보내는 클래스
			Sender sender = new Sender(socket);
			
			
			receive.start();
			sender.start();
			
		} catch (Exception e) {
			System.out.println("클라이언트main에러");
			e.printStackTrace();
		}
		
		
	}
}
