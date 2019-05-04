package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONObject;

public class InsertUser extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_user);

        Button btn = (Button)findViewById(R.id.insert);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    EditText id = (EditText)findViewById(R.id.id);
                    String ids = id.getText().toString();
                    EditText pw = (EditText)findViewById(R.id.pw);
                    String pws = pw.getText().toString();
                    EditText email = (EditText)findViewById(R.id.email);
                    String emails = email.getText().toString();
                    EditText nick = (EditText)findViewById(R.id.nickname);
                    String nickname = nick.getText().toString();

                    JSONObject js = new JSONObject();
                    js.accumulate("id", ids);
                    js.accumulate("pw", pws);
                    js.accumulate("email", emails);
                    js.accumulate("nickname", nickname);

                    String str;
                    str = js.toString();

                    HttpPost hp = new HttpPost();
                    hp.execute(str);
                    finish();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
