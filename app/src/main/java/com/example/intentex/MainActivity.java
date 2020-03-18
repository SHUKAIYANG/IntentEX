package com.example.intentex;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "main";
    private Button buttonRegister, buttonOrder;
    private TextView textViewReturn;
    private Context context;
    private final int RegisterRequestCode = 1;
    private final int ReturnRegisterCode = 2;
    private final int ReturnOrderCode = 3;
    private final int OrderRequestCode = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context= this;

        buttonRegister = (Button) findViewById(R.id.button_register);
        buttonOrder = (Button) findViewById(R.id.button_order);

        textViewReturn = (TextView) findViewById(R.id.textView_return);
        textViewReturn.setText("");

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RegisterActivity.class);
                startActivityForResult(intent, RegisterRequestCode);
            }
        });

        buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OrderActivity.class);
                startActivityForResult(intent, OrderRequestCode);
            }
        });

    } // onCreate()

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == RegisterRequestCode) {
            Log.d(TAG, "requestCode = " + requestCode);
            if(resultCode == ReturnRegisterCode) {
                String name = data.getStringExtra("nameRegister");
                String email = data.getStringExtra("emailRegister");
                String phoneNum = data.getStringExtra("phoneNumRegister");
                textViewReturn.setText("Register : \n");
                textViewReturn.append("Name : " + name + "\n");
                textViewReturn.append("Email : " + email + "\n");
                textViewReturn.append("Phone Number : " + phoneNum + "\n");
            }
        }else if(requestCode == OrderRequestCode) {
            Log.d(TAG, "requestCode = " + requestCode);
            if(resultCode == ReturnOrderCode) {
                String orderResult = data.getStringExtra("orderResult");
                textViewReturn.setText(orderResult);
            }
        }
    }

} // class Main
