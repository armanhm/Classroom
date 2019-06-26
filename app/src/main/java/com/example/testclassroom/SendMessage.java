package com.example.testclassroom;

import android.os.AsyncTask;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class SendMessage extends AsyncTask<String,Void,Void> {
    Socket socket;
    PrintWriter printWriter;

    @Override
    protected Void doInBackground(String... voids) {
        String s = voids[0];
        try {
            socket = new Socket("192.168.1.13",8867);
            printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.write(s);
            printWriter.flush();
            printWriter.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
