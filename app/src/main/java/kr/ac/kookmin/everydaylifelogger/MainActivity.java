package kr.ac.kookmin.everydaylifelogger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by user on 2016-12-01.
 */


public class MainActivity extends AppCompatActivity {

    Button memo_bt;
    Button event_bt;
    Button camera_bt;
    Button chart_bt;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(this,Splash.class));

        memo_bt = (Button)findViewById(R.id.memo);
        event_bt = (Button)findViewById(R.id.event);
        camera_bt = (Button)findViewById(R.id.camera);
        chart_bt = (Button)findViewById(R.id.chart);

        memo_bt.setOnClickListener(buttonClickListener);
        event_bt.setOnClickListener(buttonClickListener);
        camera_bt.setOnClickListener(buttonClickListener);
        chart_bt.setOnClickListener(buttonClickListener);

    }

    Button.OnClickListener buttonClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent;
            switch (v.getId())
            {
                //메모 버튼
                case R.id.memo:
                    intent = new Intent(MainActivity.this,MemoActivity.class);
                    startActivity(intent);
                    break;
                //이벤트 버튼
                case R.id.event:
                    intent = new Intent(MainActivity.this,EventActivity.class);
                    startActivity(intent);
                    break;
                //카메라 버튼
                case R.id.camera:
                    intent = new Intent(MainActivity.this,CameraActivity.class);
                    startActivity(intent);
                    break;
                //차트 버튼
                case R.id.chart:
                    intent = new Intent(MainActivity.this,ChartActivity.class);
                    startActivity(intent);
                    break;

            }
        }
    };
}