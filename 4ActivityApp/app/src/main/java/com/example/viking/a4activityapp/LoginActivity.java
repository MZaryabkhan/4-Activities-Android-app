package com.example.viking.a4activityapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;
    EditText mail, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mail=(EditText) findViewById(R.id.email);
        password= (EditText) findViewById(R.id.pass);          //https://www.youtube.com/watch?v=BzfUXY0ptoo

        button1= (Button) findViewById(R.id.login);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  openLogin();
                String validemail = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +             //for email pattern

                        "\\@" +

                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +

                        "(" +

                        "\\." +

                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +

                        ")+";


                String email = mail .getText().toString();

                Matcher matcher= Pattern.compile(validemail).matcher(email);

                final String m=mail.getText().toString();

                final String pas=password.getText().toString();


                if (!matcher.matches())
                {
                    mail.requestFocus();
                    mail.setError("ENTER VALID EMAIL ");
                }

                else if(m.length()==0)
                                                                                  //checks
                {
                    mail.requestFocus();
                    mail.setError("FIELD CANNOT BE EMPTY");
                }

                else if(pas.length()==0)

                {
                    password.requestFocus();
                    password.setError("FIELD CANNOT BE EMPTY");
                }

                else {
                    Toast.makeText(getApplicationContext(),"LOGIN SUCCESFUL",Toast.LENGTH_LONG).show();
                    openLogin();
                }
            }
        });

        button2= (Button) findViewById(R.id.reg);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openReg();
            }
        });


    }
    public void openLogin(){
        Intent intent = new Intent(this, HomeActivity.class);                   //for opening new activity
        startActivity(intent);
    }

    public void openReg(){
        Intent intent = new Intent(this, RegisterActivity.class);              //for opening new activity
        startActivity(intent);
    }
}
