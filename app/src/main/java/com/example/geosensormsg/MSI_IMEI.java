package com.example.geosensormsg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MSI_IMEI extends AppCompatActivity {

    Button btn;
    int  REQUEST_CODE_ASK_PERMISSIONS = 13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msi__imei);

        btn = (Button) findViewById(R.id.btnGetIMEI_IMSI);

//        // request permission in run time
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{
                            Manifest.permission.READ_PHONE_STATE},
                    REQUEST_CODE_ASK_PERMISSIONS);
        }

        // Code For IMEI AND IMSI NUMBER
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TelephonyManager m_telephonyManager = (TelephonyManager) getSystemService( Context.TELEPHONY_SERVICE);
                if (ActivityCompat.checkSelfPermission(MSI_IMEI.this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                Log.e("", "value " + m_telephonyManager.getDeviceId());
                Log.e("", "value " + m_telephonyManager.getSubscriberId());

            }
        });
    }
}
