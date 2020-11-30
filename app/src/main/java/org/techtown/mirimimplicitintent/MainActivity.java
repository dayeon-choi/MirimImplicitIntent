package org.techtown.mirimimplicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCall=findViewById(R.id.btn_call);
        Button btnWeb=findViewById(R.id.home_open);
        Button btnSms=findViewById(R.id.btn_sms);
        Button btnMap=findViewById(R.id.btn_map);
        Button btnSearch=findViewById(R.id.btn_search);
        Button btnCamera=findViewById(R.id.btn_camera);

        btnCall.setOnClickListener(btnListener);
        btnWeb.setOnClickListener(btnListener);
        btnSms.setOnClickListener(btnListener);
        btnMap.setOnClickListener(btnListener);
        btnSearch.setOnClickListener(btnListener);
        btnCamera.setOnClickListener(btnListener);
    }
    View.OnClickListener btnListener=new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Intent intent = null;
            Uri uri=null;
            switch (view.getId()){
                case R.id.btn_call:
                    uri=Uri.parse("tel:01077777777");
                    intent = new Intent(Intent.ACTION_DIAL,uri);
                    break;
                case R.id.home_open:
                    uri=Uri.parse("http://www.naver.com");
                    intent=new Intent(Intent.ACTION_VIEW,uri);
                    break;
                case R.id.btn_map:
                    uri=Uri.parse("http://maps.google.com/maps?q=37.559133,126.927824");
                    intent=new Intent(Intent.ACTION_VIEW,uri);
                    break;
                case R.id.btn_search:
                    intent=new Intent(Intent.ACTION_WEB_SEARCH);
                    intent.putExtra(SearchManager.QUERY,"미림여자정보과학고등학교");
                    break;
                case R.id.btn_sms:
                    uri=Uri.parse("smsto:"+Uri.encode("010-7777-7777"));
                    intent=new Intent(Intent.ACTION_SENDTO);
                    intent.putExtra("sms_body","안녕하세요? 여러분...");
                    intent.setData(uri);
                    break;
                case R.id.btn_camera:
                    intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    break;
            }
            startActivity(intent);
        }
    };
}