package com.zainabali.yz.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void web_uri(View view) {
        //action view لفتح الروابط او لفتح تطبيقات
        Intent website= new Intent(Intent.ACTION_VIEW);
        website.setData(Uri.parse("https://www.youtube.com/"));
        //حتى ليصير خلل بالتطبيق
        if (website.resolveActivity(getPackageManager())!=null);{
            startActivity(website);
        }
    }

    public void call(View view) {
        //dial خاصه بالاتصال
        Intent phone= new Intent(Intent.ACTION_DIAL);
        phone.setData(Uri.parse("tel:079886"));
        //حتى ليصير خلل بالتطبيق
        if (phone.resolveActivity(getPackageManager())!=null);{
            startActivity(phone);
        }
    }

    public void map(View view) {
        Intent Map= new Intent(Intent.ACTION_VIEW);
        Map.setData(Uri.parse("geo:33.30925425622553, 44.33850415418729?z=17"));
            startActivity(Map);

    }

    public void Image(View view) {
        Intent openActivity =new Intent(MainActivity.this,Photo.class);
        startActivity(openActivity);
    }

    public void MultiImage(View view) {
        Intent Activity =new Intent(MainActivity.this,MultiImage.class);
        startActivity(Activity);
    }

    public void sendEmail(View view) {
        Intent email= new Intent(Intent.ACTION_SEND);
        email.setData(Uri.parse("mailto:"));
        email.setType("message/rfc822");
        email.putExtra(Intent.EXTRA_EMAIL," ");
        startActivity(email);
    }

    public void turnAlarm(View view) {
        //لتشغيل المنبه نحتاج وضع اذن للوصول الى المنبه الخاص بالهاتف في المنفست
        Intent i=new Intent(AlarmClock.ACTION_SET_TIMER);
              i.putExtra(AlarmClock.EXTRA_MESSAGE,"getup");
                i.putExtra(AlarmClock.EXTRA_LENGTH,5);
                i.putExtra(AlarmClock.EXTRA_SKIP_UI,true);
        if (i.resolveActivity(getPackageManager())!=null){
            startActivity(i);
        }
    }

    public void message(View view) {
        Intent text= new Intent(Intent.ACTION_SEND);
        text.setType("text/plain");
        text.putExtra(Intent.EXTRA_TEXT," ");
        startActivity(Intent.createChooser(text," "));
    }
}