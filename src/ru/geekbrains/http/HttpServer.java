package ru.geekbrains.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    public static void main(String[] args) {
        try (final ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true){
                final Socket socket= serverSocket.accept();
               final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                while (!reader.ready()){
                    ;
                }
                while ((reader.ready())){
                    System.out.println(reader.readLine());
                }
                writer.println("HTTP/1.1 200 OK");
                writer.println("Content-Type: text/html; charset=utf-8");
                writer.println();
                writer.println("<html>");
                writer.println("<p><b> Добрый вечер! <b></p>");
                writer.println("<hr>");
                writer.println("</html>");
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
