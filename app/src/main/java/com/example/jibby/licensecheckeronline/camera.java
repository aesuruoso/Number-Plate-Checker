package com.example.jibby.licensecheckeronline;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

import java.io.InputStream;

/**
 * Created by Jibby on 03-Aug-17.
 */

public class camera extends AppCompatActivity {

    private TextRecognizer detector;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);

        textView = (TextView)this.findViewById(R.id.textView);
        detector = new TextRecognizer.Builder(this).build();

        this.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, 100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 100 && resultCode == RESULT_OK) {
            try{
                InputStream stream = getContentResolver().openInputStream(data.getData());
                Bitmap bitmap = BitmapFactory.decodeStream(stream);
                stream.close();
                if(detector.isOperational() && null != bitmap) {
                    Frame frame = new Frame.Builder().setBitmap(bitmap).build();
                    SparseArray<TextBlock> textBlocks = detector.detect(frame);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < textBlocks.size(); ++i) {
                        TextBlock tb = textBlocks.get(i);
                        sb.append(tb.getValue());
                    }
                    if(textBlocks.size() == 0) {
                        textView.setText("Scan Failed");
                    }else {
                        textView.setText(sb.toString());
                    }
                } else {
                    textView.setText("Invalid Image");
                }
            }catch (Exception e) {
                    textView.setText("Problem encoured");
            }
        }
    }

    @Override
    protected void onStop() {
        detector.release();
        super.onStop();
    }
    public void OnSearch(View view) {
        String registration_number = textView.getText().toString();
        String type = "login";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, registration_number);
    }
    public void Options(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}