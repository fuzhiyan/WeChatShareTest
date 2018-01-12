package cn.mixky.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.onekeyshare.OnekeyShare;

public class MainActivity extends AppCompatActivity {
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.weChat_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                OnekeyShare oks = new OnekeyShare();
                oks.setText("text");
                oks.setTitle("title");
                oks.show(MainActivity.this);
                oks.setCallback(new PlatformActionListener() {
                    @Override
                    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                        Log.i("weChatShare", "complete");
                    }

                    @Override
                    public void onError(Platform platform, int i, Throwable throwable) {

                        Log.i("weChatShare", "error");
                    }

                    @Override
                    public void onCancel(Platform platform, int i) {

                        Log.i("weChatShare", "cancel");
                    }
                });
            }
        });
    }
}
