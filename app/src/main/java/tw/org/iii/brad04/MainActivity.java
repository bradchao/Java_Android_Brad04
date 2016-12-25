package tw.org.iii.brad04;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int count = 0;
    private long lastexit;
    private AlertDialog alert;

    public MainActivity(){
        Log.v("brad", "MainActivity");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lastexit = System.currentTimeMillis();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Warn");
        builder.setMessage("Exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.super.finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alert = builder.create();

    }

    public void end(View v){
        finish();
    }
    public void startMyService(View v){
        Intent it = new Intent(this, MyService.class);
        startService(it);
    }

    @Override
    public void finish() {
//        if (System.currentTimeMillis()-lastexit<3*1000) {
//            super.finish();
//        }else{
//            lastexit = System.currentTimeMillis();
//            Toast.makeText(this, "再按一次確定結束", Toast.LENGTH_SHORT).show();
//        }
        alert.show();


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("brad", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("brad", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("brad", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("brad", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("brad", "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("brad", "onRestart");
    }
}
