package tw.org.iii.brad04;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

public class MyService extends Service {
    private Timer timer;
    private int i;

    @Override
    public IBinder onBind(Intent intent) {
        //throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        timer = new Timer();
        timer.schedule(new MyTask(), 0, 1000);
        Log.v("brad", "MyService:onCreate");
    }

    private class MyTask extends TimerTask {
        @Override
        public void run() {
            try {
                URL url = new URL("http://10.0.2.2:8080/BradWeb/Brad91.jsp?lat=11&lng=22");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.connect();
                conn.getInputStream();

            } catch (Exception e) {
                Log.v("brad", e.toString());
            }


        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v("brad", "MyService:onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (timer != null){
            timer.cancel();
            timer.purge();
            timer = null;
        }
    }
}
