package com.example.myapplication;

import android.os.AsyncTask;
import android.renderscript.ScriptGroup;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpPost extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... strings) {

        try{
            Log.d("string[0] : ", strings[0]);
            return POST(strings[0]);

        }catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }
    private String POST(String string) throws  IOException{
        InputStream inputStream = null;
        String returnString = "";
        try{
            URL url =  new URL("http://192.168.0.250:3000/insert");
            HttpURLConnection con = (HttpURLConnection)url.openConnection();

            con.setRequestProperty("Content-Type", "application/json");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.connect();

            OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());

            Log.d("check", string);
            wr.write(string);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            System.out.println("HTTP 응답 코드 : " + responseCode);



        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(inputStream != null){
                inputStream.close();
            }
        }

        return returnString;
    }
}
