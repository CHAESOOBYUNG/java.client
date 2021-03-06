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
				
				//메세지를 받아왔을 때, 자신이라면, 콘솔창에서 출력하지 않도록 처리
				String[] split = message.split(">");
				if(split.length == 2 && split[0].equals(MainClient.id)) {
					continue; //출력을 넘기고, 다음메세지를 받을 대기상태로 이동
				}
				
				
				System.out.println(message);
			}
			
			
			
			
		} catch (Exception e) {
			System.out.println("클라이언트 receive 에러");
			e.printStackTrace();
		}
	}
	
	
	
	
}
