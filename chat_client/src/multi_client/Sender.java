package multi_client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.regex.Pattern;

public class Sender extends Thread {

	private Socket socket;

	public Sender(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			//1. 키보드 입력객체 선언.
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in , "UTF-8"));
			//1-2. PrintWriter 메세지 전송 객체 선언.
			PrintWriter out = new PrintWriter( socket.getOutputStream());

			//2. 아이디를 입력받는다.
			System.out.print("닉네임:");
			while(true) {
				String id = br.readLine(); //입력받음

				//null이거나 구분자이면 안됨.
				if(id == null || Pattern.compile(":").matcher(id).find() ) {
					System.out.println("사용할 수 없는 아이디 입니다");
					System.out.println("닉네임:");
					continue; //다시입력받음
				} else {
					MainClient.id = id; //아이디를 저장
					break; //아이디 입력부분 탈출
				}	
			}
			
			//2-2. 아이디형식을 서버축으로 전송.
			out.println("ID:" + MainClient.id); //ID: 형식으로 아이디값전달.
			out.flush();


			//3. 메세지를 입력받아 서버축으로 전송한다.
		    while(true) {
		    	
		    	String message= br.readLine();
		    	
		    	if(message.equals("exit")) {
		    		break; //exit받으면 클라이언트 종료
		    	}
		    	out.println(message);
		    	out.flush();
		    	
		    }
			
            out.close();
            br.close();
            socket.close();
		    
		} catch (Exception e) {
			System.out.println("클라이언트 sender에러");
			e.printStackTrace();
		}


	}

}
