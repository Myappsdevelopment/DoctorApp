package com.mad.grubxvendor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OTPEntry extends AppCompatActivity {

    EditText edt_otp1, edt_otp2, edt_otp3, edt_otp4, edt_otp5, edt_otp6;
    private int previousLength;
    Button verify;
    private boolean backSpace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpentry);
        init();
    }

    private void init() {
        edt_otp1 = findViewById(R.id.edt_otp1);
        edt_otp2 = findViewById(R.id.edt_otp2);
        edt_otp3 = findViewById(R.id.edt_otp3);
        edt_otp4 = findViewById(R.id.edt_otp4);
        edt_otp5 = findViewById(R.id.edt_otp5);
        edt_otp6 = findViewById(R.id.edt_otp6);
        verify = findViewById(R.id.btn_verify);

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(OTPEntry.this, MainActivity.class);
                finish();
                startActivity(in);
            }
        });

        edt_otp1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                previousLength = charSequence.length();

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (edt_otp1.getText().toString().length() == 1) {
                    edt_otp2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        edt_otp2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                previousLength = charSequence.length();

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (edt_otp2.getText().toString().length() == 1) {
                    edt_otp3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                backSpace = previousLength > s.length();

                if (backSpace) {
                    edt_otp2.setText("");
                    edt_otp1.requestFocus();
                }

            }
        });

        edt_otp3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                previousLength = charSequence.length();

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (edt_otp3.getText().toString().length() == 1) {
                    edt_otp4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                backSpace = previousLength > s.length();

                if (backSpace) {
                    edt_otp3.setText("");
                    edt_otp2.requestFocus();
                }

            }
        });

        edt_otp4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                previousLength = charSequence.length();

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (edt_otp4.getText().toString().length() == 1) {
                    edt_otp5.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

                backSpace = previousLength > s.length();

                if (backSpace) {
                    edt_otp4.setText("");
                    edt_otp3.requestFocus();
                }

            }
        });

        edt_otp5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                previousLength = charSequence.length();

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (edt_otp5.getText().toString().length() == 1) {
                    edt_otp6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                backSpace = previousLength > s.length();

                if (backSpace) {
                    edt_otp5.setText("");
                    edt_otp4.requestFocus();
                }

            }
        });

        edt_otp6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                previousLength = charSequence.length();

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                backSpace = previousLength > s.length();

                if (backSpace) {
                    edt_otp6.setText("");
                    edt_otp5.requestFocus();
                }

            }
        });


    }
}
