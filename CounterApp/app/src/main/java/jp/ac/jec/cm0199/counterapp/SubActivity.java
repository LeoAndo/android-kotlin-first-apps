package jp.ac.jec.cm0199.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
    }

    public static void startActivity(Context context) {
        final Intent starter = new Intent(context, SubActivity.class);
        context.startActivity(starter);
    }
}
