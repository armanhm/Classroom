package com.example.testclassroom;

import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SendMessage extends AsyncTask<String,Void,Void> {
    Socket socket;
    DataOutputStream dataOutputStream;

    @Override
    protected Void doInBackground(String... voids) {
        String s = voids[0];
        try {
            socket = new Socket("172.20.120.40",8867);
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(s);
            dataOutputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
