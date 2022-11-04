package com.zainabali.yz.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MultiImage extends AppCompatActivity {
ImageView m1,m2,m3,m4;
Button button;
ArrayList<Uri>ArrayUri=new ArrayList<Uri>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_image);
        m1=findViewById(R.id.imageOne);
        m2=findViewById(R.id.imageTwo);
        m3=findViewById(R.id.imageThree);
        m4=findViewById(R.id.imageFour);
        button=findViewById(R.id.shareButton);
    }

    public void imgOne(View view) {
        Intent imgOne= new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(imgOne,1);
    }

    public void imgTwo(View view) {
        Intent imgTwo= new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(imgTwo,2);
    }

    public void imgThree(View view) {
        Intent imgThree= new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(imgThree,3);
    }

    public void imgFour(View view) {
        Intent imgFour= new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(imgFour,4);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
          if (resultCode==1){
              ArrayUri.add(data.getData());
              m1.setImageURI(data.getData());
          }
            if (resultCode==2){
                ArrayUri.add(data.getData());
                m2.setImageURI(data.getData());
            }
            if (resultCode==3){
                ArrayUri.add(data.getData());
                m3.setImageURI(data.getData());
            }
            if (resultCode==4){
                ArrayUri.add(data.getData());
                m4.setImageURI(data.getData());
            }
        }
    }

    public void share(View view) {
        Intent intent=new Intent(Intent.ACTION_SEND_MULTIPLE);
        intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM,ArrayUri);
        intent.setType("image/*");
        startActivity(Intent.createChooser(intent," "));

    }
}