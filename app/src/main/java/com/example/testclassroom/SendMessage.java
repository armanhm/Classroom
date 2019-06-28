package com.example.testclassroom;

import android.os.AsyncTask;
import android.util.Log;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SendMessage extends AsyncTask<String, Void, Void> {
    Socket socket;
    DataOutputStream dataOutputStream;
    DataInputStream dataInputStream;
    String message;

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
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        dataInputStream = new DataInputStream(socket.getInputStream());
                        message = dataInputStream.readUTF();
                        String [] params = message.split(":");
                        if(params[0].equals("listOfClasses")){
                            for (int i = 1; i < params.length-1; i++) {
                                String [] newParams = params[i].split("@") ;
                                String name = newParams[0];
                                String number = newParams[1];
                                Class c = new Class();
                                ItemClass itemClass = new ItemClass(name,number);
                                c.setName(name);
                                c.setStudentNumbers(number);
                                RegisterActivity.p.getClasses().add(c);
                                RegisterActivity.p.getItemClasses().add(itemClass);
                            }
                        }
                        else if (params[0].equals("test")){
                            SignInActivity.msg = params[1];
                        }
                        else if(params[0].equals("testList")){
                            Log.e("taga",message);
                            for (int i = 1; i < params.length-1; i++) {
                                ClassActivity.arrayList.add(params[i]);
                            }
                        }
                        else {
                            Log.e("taga",params[0]);
                        }
//                        Log.e("taga",ClassActivity.arrayList.get(1));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
