package com.example.mylandmark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class CallActivity extends AppCompatActivity {

    EditText edit_name, edit_phone, edit_mail;
    CheckBox chk_agree;
    Button btn_mail, btn_callcenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        edit_name = findViewById(R.id.edit_name);
        edit_phone = findViewById(R.id.edit_phone);
        edit_mail = findViewById(R.id.edit_mail);
        chk_agree = findViewById(R.id.chk_agree);
        btn_mail = findViewById(R.id.btn_mail);
        btn_callcenter = findViewById(R.id.btn_callcenter);

        btn_callcenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:010-111-2222"));
                startActivity(intent);
            }
        });

        btn_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(edit_name.length()<1){
                   MyToast("이름을 입력하세요");
                   edit_name.requestFocus();
                }else if(edit_phone.length()<1){
                    MyToast("전화번호를 입력하세요");
                    edit_phone.requestFocus();
                }else if(edit_mail.length()<1){
                    MyToast("상담 내용을 입력하세요");
                    edit_mail.requestFocus();
                }else if(!chk_agree.isChecked()){
                    MyToast("개인정보방침에 동의해주세요");
                    chk_agree.requestFocus();
                }else{
                    //문자 메시지 보내기
                    Intent intent = new Intent(Intent.ACTION_SENDTO,
                            Uri.parse("smsto:01023732726"));
                    intent.putExtra("sms_body",edit_mail.getText().toString());
                    startActivity(intent);
                }
            }
        });

    }
    void MyToast(String msg){
        Toast.makeText(CallActivity.this,
                msg,Toast.LENGTH_SHORT).show();
    }
}