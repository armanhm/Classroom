package com.example.testclassroom;

import android.os.AsyncTask;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ReceiveMessage extends AsyncTask<String,Void,Void> {
    Socket socket;
    PrintWriter printWriter;
    InputStream inputStream;
    DataInputStream dataInputStream;
    @Override
    protected Void doInBackground(String... strings) {
        try {
            socket = new Socket("192.168.1.13",8867);
            printWriter = new PrintWriter(socket.getOutputStream());
            inputStream = socket.getInputStream();
            dataInputStream = new DataInputStream(inputStream);
        }
        catch (IOException e){

        }
        Thread readMessage = new Thread(() -> {
            while (true) {
                try {
                    String msg = dataInputStream.readUTF();
                    System.out.println(msg);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}
