import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(80);
        Socket socket=serverSocket.accept();
        PrintStream ps = new PrintStream(socket.getOutputStream());
        ps.println("HTTP/1.1 200 OK\n\nasdasd13123");

        InputStream in=socket.getInputStream();

        BufferedReader bf=new BufferedReader(new InputStreamReader(in));

        String data=null;

        while((data=bf.readLine())!=null){
            System.out.println(data);
        }

        ps.println("ggggg");
        ps.close();
    }
}
