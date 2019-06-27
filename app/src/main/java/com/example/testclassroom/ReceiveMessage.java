package com.example.testclassroom;

import android.os.AsyncTask;
import android.util.Log;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ReceiveMessage extends AsyncTask<Void,Void,String> {
    Socket socket;
    PrintWriter printWriter;
    InputStream inputStream;
    DataInputStream dataInputStream;
    String msg;

    @Override
    protected String doInBackground(Void... voids) {
        try {
            socket = new Socket("192.168.1.13",8867);
            inputStream = socket.getInputStream();
            dataInputStream = new DataInputStream(inputStream);
            msg = dataInputStream.readUTF();
            Log.e("tag",msg);

        }catch (IOException e){
            e.printStackTrace();
        }
        return msg;
    }
}
