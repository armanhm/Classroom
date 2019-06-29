package com.example.testclassroom;

import android.os.AsyncTask;
import android.util.Log;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

public class TransferMessage extends AsyncTask<String, Void, Void> {
    Socket socket;
    DataOutputStream dataOutputStream;
    DataInputStream dataInputStream;
    ObjectInputStream objectInputStream;
    String message;
    Object object;
    static ArrayList<Class> classes;
    static ArrayList<String> classList = new ArrayList<>();

    @Override
    protected Void doInBackground(String... voids) {
        String s = voids[0];
        try {
            socket = new Socket("192.168.56.1", 8867);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        dataOutputStream = new DataOutputStream(socket.getOutputStream());
                        dataOutputStream.writeUTF(s);
                        dataOutputStream.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            new Thread(() -> {
                try {
                    dataInputStream = new DataInputStream(socket.getInputStream());
                    //objectInputStream = new ObjectInputStream(socket.getInputStream());

                    message = dataInputStream.readUTF();
                    //object = objectInputStream.readObject();
                    //classes = (ArrayList<Class>) object;

                    String [] params = message.split(":");
                    switch (params[0]) {
                        case "listOfClasses":
                            for (int i = 1; i < params.length; i++) {
                                classList.add(params[i]);
                            }
                            break;
                        case "test":
                            SignInActivity.msg = params[1];
                            break;
                        default:
                            break;
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
//                    catch (ClassNotFoundException e) {
//                        e.printStackTrace();
//                    }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
