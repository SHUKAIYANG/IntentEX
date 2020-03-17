package com.example.intentex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextName,editTextEmail;
    private Context context;
    private Button buttonCancel, buttonOK;
    private final int ReturnRegisterCode = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        context = this;

        editTextName = (EditText) findViewById(R.id.editText_nameRegister);
        editTextName.setText("");

        editTextEmail = (EditText) findViewById(R.id.editText_emailRegister);
        editTextEmail.setText("");

        buttonCancel = (Button) findViewById(R.id.button_cancelRegister);
        buttonOK = (Button) findViewById(R.id.button_okRegister);

        buttonCancel.setOnClickListener(new MyButton());
        buttonOK.setOnClickListener(new MyButton());

    } // onCreate


    private class MyButton implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.button_cancelRegister:
                    editTextName.setText("");
                    editTextEmail.setText("");
                    break;

                case R.id.button_okRegister:
                    String name = editTextName.getText().toString();
                    String email = editTextEmail.getText().toString();
                    if(name.length() == 0 || email.length() == 0) {
                        Toast.makeText(context, "Please input name and Email.", Toast.LENGTH_SHORT).show();
                    }else {
                        Intent intent = new Intent();
                        intent.putExtra("nameRegister", name);
                        intent.putExtra("emailRegister", email);
                        setResult(ReturnRegisterCode, intent);
                        finish();
                    }


                    break;
            }

        }
    }


}// class registerActivity
