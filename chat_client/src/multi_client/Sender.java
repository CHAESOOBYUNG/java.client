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
			//1. Ű���� �Է°�ü ����.
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in , "UTF-8"));
			//1-2. PrintWriter �޼��� ���� ��ü ����.
			PrintWriter out = new PrintWriter( socket.getOutputStream());

			//2. ���̵� �Է¹޴´�.
			System.out.print("�г���:");
			while(true) {
				String id = br.readLine(); //�Է¹���

				//null�̰ų� �������̸� �ȵ�.
				if(id == null || Pattern.compile(":").matcher(id).find() ) {
					System.out.println("����� �� ���� ���̵� �Դϴ�");
					System.out.println("�г���:");
					continue; //�ٽ��Է¹���
				} else {
					MainClient.id = id; //���̵� ����
					break; //���̵� �Էºκ� Ż��
				}	
			}
			
			//2-2. ���̵������� ���������� ����.
			out.println("ID:" + MainClient.id); //ID: �������� ���̵�����.
			out.flush();


			//3. �޼����� �Է¹޾� ���������� �����Ѵ�.
		    while(true) {
		    	
		    	String message= br.readLine();
		    	
		    	if(message.equals("exit")) {
		    		break; //exit������ Ŭ���̾�Ʈ ����
		    	}
		    	out.println(message);
		    	out.flush();
		    	
		    }
			
            out.close();
            br.close();
            socket.close();
		    
		} catch (Exception e) {
			System.out.println("Ŭ���̾�Ʈ sender����");
			e.printStackTrace();
		}


	}

}