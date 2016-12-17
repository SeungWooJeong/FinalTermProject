package kr.ac.kookmin.everydaylifelogger;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by user on 2016-12-01.
 */

public class CameraActivity extends MemoActivity {

    ImageView img = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,1);

        img = (ImageView)findViewById(R.id.imageView);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        img.setImageURI(data.getData());
    }


}
