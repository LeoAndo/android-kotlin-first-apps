package jp.ac.jec.cm0199.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        final CountDownData countDownData = new CountDownData();
        new CountDownTimer(countDownData.millisInFuture, countDownData.countDownInterval) {
            @Override
            public void onTick(long millisUntilFinished) {
                final long seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished);
                countDownData.showMessage(SubActivity.this, seconds + "秒");
            }

            @Override
            public void onFinish() {
                countDownData.showMessage(SubActivity.this);
            }
        }.start();

        CountDownData.doSomeThingStaticMethod();
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, SubActivity.class);
        context.startActivity(starter);
    }
}