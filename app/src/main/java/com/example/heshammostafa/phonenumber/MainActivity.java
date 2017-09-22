package com.example.heshammostafa.phonenumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hbb20.CountryCodePicker;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {
    CountryCodePicker ccp;
    EditText  editTextPhone;
    TextView t;
    String code;
    String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          t= (TextView) findViewById(R.id.t);
        editTextPhone=(EditText)findViewById(R.id.phone);
        ccp = (CountryCodePicker) findViewById(R.id.ccp);


        ccp.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {

            @Override
            public void onCountrySelected() {
                phone= String.valueOf(editTextPhone.getText());
                code=ccp.getSelectedCountryCode();

               Log.d("code",ccp.getSelectedCountryCode());
                Log.d("code",ccp.getSelectedCountryName());
                Log.d("code",ccp.getSelectedCountryNameCode());

            }
        });
    }

    public void onclick(View view) {
        phone=editTextPhone.getText().toString();
        code=ccp.getSelectedCountryCode();
        t.setText(code+phone);

    }
}
