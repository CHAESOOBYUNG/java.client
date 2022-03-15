package basic_client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;


public class MainClient {

	public static void main(String[] args) {
		
		try {
			//본인의 아이피 = 윈도우 + r -> cmd -> ipconfig
			
			Socket socket = new Socket("172.30.1.55", 8383); //접속할 IP, 포트번호
			
			//소켓 클래스의 inputStream을 사용해서 서버로 부터 데이터를받음
			InputStream is = socket.getInputStream();
			
			//버퍼드리더에게 전달해서 readLine으로 데이터를 받음
			BufferedReader bf = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			
			String str = bf.readLine();
			System.out.println(str);
			
			socket.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
