package com.example.testclassroom;

import android.os.AsyncTask;
import android.util.Log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TransferMessage extends AsyncTask<String, Void, Void> {
    Socket socket;
    DataOutputStream dataOutputStream;
    DataInputStream dataInputStream;
    String message;
    static String msg;
    //static ArrayList<Class> classes;


    @Override
    protected Void doInBackground(String... voids) {
        String s = voids[0];

        try {
            //192.168.56.1 // Emulator
            // 192.168.43.80  The Real
            socket = new Socket("192.168.43.80", 8867);
            new Thread(() -> {
                try {
                    dataOutputStream = new DataOutputStream(socket.getOutputStream());
                    dataOutputStream.writeUTF(s);
                    Log.e("SEND::" , s);
                    dataOutputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
            new Thread(() -> {
                try {
                    dataInputStream = new DataInputStream(socket.getInputStream());
                    message = dataInputStream.readUTF();
                    Log.e("SERVER" ,  message);
                    msg = message;

                    String[] params = message.split(":");
                    switch (params[0]) {
                        case "signUp": {
                            if (params[1].equals(WelcomeActivity.username)){
                                if (params[2].equals("success")) {
                                    //WelcomeActivity.username = params[1];
                                    RegisterActivity.result = "SUCCESS";
                                } else if (!params[2].equals("error")) {
                                    RegisterActivity.result = "ERROR";
                                }
                            }
                            break;
                        }
                        case "userChecker": {
                            RegisterActivity.result = params[2];
                            Log.e("tag User Checker", message);
                            break;
                        }
                        case "signIn": {
                            if (params[2].equals("success")) {
                                SignInActivity.result = "SUCCESS";
                            } else {
                                SignInActivity.result = "ERROR";
                            }
                            break;
                        }
                        case "classList": {
                            MainActivity.classList.clear();
                            ListOfClassActivity.listString = message;
                        }
                        break;
                        case "createClass": {
                            if (params[1].equals("success")) {
                                ListOfClassActivity.classCode = params[2];
                                ItemClass.classCodes.add(ListOfClassActivity.classCode);
                                //ListOfClassActivity.classCode = "";

                            }
                            break;
                        }
                        case "joinClass": {
                            if (params[1].equals("success")) {
                                JoinClassActivity.result = "success";
                                JoinClassActivity.className = params[2];
                            } else if (params[1].equals("error")) {
                                JoinClassActivity.result = "error";
                            }
                            break;
                        }
                        case "homeworkList": {
                            Log.e("homeworkList(transfer)", message);
                            if (params[1].equals("teacher")) {
                                ListOfHomeworkActivity.userType = "teacher";
                            } else if (params[1].equals("student")) {
                                ListOfHomeworkActivity.userType = "student";
                            }
                            ListOfHomeworkActivity.listOfHomework = message;
                            break;
                        }
                        case "createHomework": {
                            if (params[1].equals("success")) {
                                CreateHomeworkActivity.result = "success";
                            } else if (params[1].equals("error")) {
                                CreateHomeworkActivity.result = "error";
                                //
                            }
                            break;
                        }
                        case "people": {
                            ListOfHomeworkActivity.listOfTeachers = params[1];
                            ListOfHomeworkActivity.listOfStudents = params[2];
                            break;
                        }
                        case "homeworkProfile": {
                            ProfileHomeworkActivity.homeworkProfileResult = message;

                        }
                        case "commentsList:" :{
                            ListOfCommentsActivity.result = message ;
                            break;
                        }
                        case "classInfo" : {
                            ClassSettingActivity.result = message ;
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
