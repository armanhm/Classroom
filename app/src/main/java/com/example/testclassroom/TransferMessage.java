package com.example.testclassroom;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class TransferMessage extends AsyncTask<String, Void, Void> {
    Socket socket;
    DataOutputStream dataOutputStream;
    DataInputStream dataInputStream;
    String message;
    //static ArrayList<Class> classes;


    @Override
    protected Void doInBackground(String... voids) {
        String s = voids[0];

        try {
            socket = new Socket("192.168.56.1", 8867);
            new Thread(() -> {
                try {
                    dataOutputStream = new DataOutputStream(socket.getOutputStream());
                    dataOutputStream.writeUTF(s);
                    dataOutputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
            new Thread(() -> {
                try {
                    dataInputStream = new DataInputStream(socket.getInputStream());
                    message = dataInputStream.readUTF();

                    String [] params = message.split(":");
                    switch (params[0]) {
                        case "classList": {
                            MainActivity.classList.clear();
//                            for (int i = 1; i < params.length; i++) {
//                                MainActivity.classList.add(params[i]);
//                            }
                            ListOfClassActivity.listString = message;
                            Log.e("message >>>>" ,message) ;
                        }
                            break;
                        case "test": {
                            SignInActivity.msg = params[1];
                            break;
                        }
                        case "makeClass":
                        {
                            if (params[1].equals("success")){
                            }
                            break;
                        }
                        case "joinClass" :{
                            if (params[1].equals("success")){
                                JoinClassActivity.result = "success";
                            }
                            else if (params[1].equals("error")){
                                JoinClassActivity.editTextCode.setError("Wrong class code");
                            }
                            break;
                        }
                        default:
                            break;
                    }



                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
