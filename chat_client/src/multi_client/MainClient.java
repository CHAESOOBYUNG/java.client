package multi_client;

import java.net.Socket;

public class MainClient {
	
    //사용자가 쓸 아이디
	public static String id;
	
	public static void main(String[] args) {
		
		try {
			//client측(사용자측)
			Socket socket = new Socket("172.30.1.55", 8383); //연결할 아이피주소, 포트번호
			
			//메세지를 수신받는 클래스
			Receive receive = new Receive(socket);
			
			//메세지를 송신하는 클래스
			Sender sender = new Sender(socket);
			
			receive.start();
			sender.start();
			
			
			
		} catch (Exception e) {
			System.out.println("클라이언트 측 main 에러");
			e.printStackTrace();
		}
		
		
		
		
	}
}
