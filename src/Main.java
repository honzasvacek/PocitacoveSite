import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Start");

        //funkce date()
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); //vypisuje datum a čas v tomto formátu pomocí ofPattern("")
        LocalDateTime now = LocalDateTime.now(); //lokální časová zona

        //nastavení serveru, se kterým se chci spojit
        ServerSocket server = new ServerSocket(10000);

        System.out.println("Krok 1");

        //čekám než spustím server --> localhost:int port serveru
        try(Socket socket = server.accept()) {
            //server je spušťený
            System.out.println("Krok 2");

            try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                System.out.println("Krok 3");
                out.println("HTTP/1.0 200");
                out.println(dtf.format(now));
            }
        }
    }
}
