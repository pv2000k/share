package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    TextView forgot;
    EditText username, password, cpassword;
    Button btn_register, btn_login;
    String user, pass, cpass;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText)findViewById(R.id.et_username);
        password = (EditText)findViewById(R.id.et_password);
        cpassword = (EditText)findViewById(R.id.et_cpassword);
        btn_register = (Button)findViewById(R.id.btn_register);
        btn_login = (Button)findViewById(R.id.btn_login);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCondition();

            }
        });
        forgot=(TextView)findViewById(R.id.forgot);
 /*       Typeface custom_font = Typeface.createFromAsset(getAssets(), "font/xyz.ttf");
        forgot.setTypeface(custom_font);*/

        int PICK_IMAGE_REQUEST = 1;

        Intent intent = new Intent();
        intent.setAction(android.content.Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivityForResult(intent,PICK_IMAGE_REQUEST);



        forgot.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                forgot_password();
            }
        });
}

    private void checkCondition() {

        if (username.getText().toString().trim().length()== 0||password.getText().toString().trim().length()== 0||cpassword.getText().toString().trim().length()== 0){

            Toast.makeText(MainActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
        }
        else if (password.getText().toString().equals(cpassword.getText().toString())){
            open_newScreen();
        }
        else {
            Toast.makeText(MainActivity.this, "Password does not match", Toast.LENGTH_SHORT).show();
        }
    }





    private void open_newScreen() {

        user = username.getText().toString();
//        System.out.println("Lakshay Value "+ user);
        pass = password.getText().toString();
        cpass = cpassword.getText().toString();
        Intent intent1 = new Intent(getApplicationContext(), Second.class);
        intent1.putExtra("Test1",user);
        intent1.putExtra("Test2", pass);
        intent1.putExtra("Test3",cpass);
        startActivity(intent1);
        finish();
    }
    private void forgot_password() {
        Intent intent2 = new Intent(getApplicationContext(),Third.class);
        startActivity(intent2);
        finish();
    }


}
