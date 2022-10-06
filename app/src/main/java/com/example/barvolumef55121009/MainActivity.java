package com.example.barvolumef55121009;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtWidth = findViewById(R.id.edt_width);
        edtHeight = findViewById(R.id.edt_height);
        edtLength = findViewById(R.id.edt_length);
        btncalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);

        btncalculate.setOnClickListener(this);

        if(savedInstanceState 1=null){
            String results = savedInstanceState.getString(STATE_RESULT);
            tvResult.setText(results);
        }


    }

    private EditText edtWidth;
    private EditText edtHeight;
    private EditText edtLength;
    private Button btncalculate;
    private TextView tvResult;

    private static final String STATE_RESULT = "state_result";

    @Override
    protected void onSaveInstance(Bundle outState){
        super, onSaveInstance(outState);
        outState.putString(STATE_RESULT, tvResult.getText().toString());
    }


    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.btn_calculate) {
            String inputlength = edtLength.getText().toString().trim();
            String inputwidth = edtWidth.getText().toString().trim();
            String inputheight = edtHeight. getText().toString().trim();

                             boolean isEmptyFields=false;
                             if(TextUtils.isEmpty(inputlength)) {
                                 isEmptyFields = true;
                                 edtLength.setError("field ini tidak boleh kosong");
                             }

                             if (TextUtils.isEmpty(inputwidth)) {
                                 isEmptyFields = true;
                                 edtWidth.setError("field ini tidak boleh kosong");
                             }

                             if (TextUtils.isEmpty(inputheight)) {
                                 isEmptyFields = true;
                                 edtHeight.setError("field ini tidak boleh kosong");
                             }

                             if(!isEmptyFields) {
                                 Double volume = Double.parseDouble(inputlength) * Double.parseDouble(inputwidth) * Double.parseDouble(inputheight);
                                 tvResult.setText(String.valueOf(volume));
                             }

            }
        }
    }
