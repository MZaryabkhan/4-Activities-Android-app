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


public class RegisterActivity extends AppCompatActivity {


    private Button regs;
    EditText fname, lname, mail, password, cpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fname=(EditText) findViewById(R.id.fnamee);
        lname=(EditText) findViewById(R.id.lnamee);
        mail=(EditText) findViewById(R.id.emaill);
        password=(EditText) findViewById(R.id.passwordd);
        cpassword=(EditText) findViewById(R.id.cpasswordd);

        regs=(Button) findViewById(R.id.regreg);

        regs.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String validemail = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +  //for email pattern

                        "\\@" +

                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +

                        "(" +

                        "\\." +

                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +

                        ")+";

                String eemail = mail .getText().toString();
                Matcher matcher= Pattern.compile(validemail).matcher(eemail);

                final String f=fname.getText().toString();

                final String l=lname.getText().toString();

                final String m=mail.getText().toString();

                final String p=password.getText().toString();

                final String c=cpassword.getText().toString();

                if(f.length()==0)                                 //Validation checks

                {
                    fname.requestFocus();
                    fname.setError("FIELD CANNOT BE EMPTY");
                }

               else if(l.length()==0)

                {
                    lname.requestFocus();
                    lname.setError("FIELD CANNOT BE EMPTY");
                }

                else  if(m.length()==0)

                {
                    mail.requestFocus();
                    mail.setError("FIELD CANNOT BE EMPTY");
                }

                else if(p.length()==0)

                {
                    password.requestFocus();
                    password.setError("FIELD CANNOT BE EMPTY");
                }

                else if(c.length()==0)

                {
                    cpassword.requestFocus();
                    cpassword.setError("FIELD CANNOT BE EMPTY");
                }




                else  if (!matcher.matches())
                {
                    mail.requestFocus();
                    mail.setError("ENTER VALID EMAIL ");
                }




                else
                {
                    Toast.makeText(RegisterActivity.this,"Validation Successful",Toast.LENGTH_LONG).show();
                    openReg();
                }
            }
        });

    }





    public void openReg(){                                                     //for opening new activity
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
