package com.example.alam.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.

    EditText number1, number2;
    TextView tv;
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        tv = (TextView) findViewById(R.id.sample_text);


        number1 = (EditText)findViewById(R.id.editText);
        number2 = (EditText)findViewById(R.id.editText2);

        int value = intFromJNI(1);
        Log.d("MainActivity","JNI return value: "+value );
        tv.setText(stringFromJNI() + " Value JNI: "+ value);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    public native int intFromJNI(int value);

    public native int intSumFromJNI(int value1, int value2);

    public void SumOnClick(View view) {


        /*
        int n1 = Integer.parseInt(number1.getText().toString());
        int n2 = Integer.parseInt(number2.getText().toString());
        Log.d("MA", "Data: "+n1+ " Data1: "+n2);
        tv.setText(stringFromJNI() + " Value Sum: "+ intSumFromJNI(n1,n2));
        */


        if(number1.getText().toString().equals("") || number2.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Please Enter Some Value", Toast.LENGTH_LONG).show();
        }else{
            int n1 = Integer.parseInt(number1.getText().toString());
            int n2 = Integer.parseInt(number2.getText().toString());
            Log.d("MA", "Data: "+n1+ " Data1: "+n2);
            tv.setText(stringFromJNI() + " Value Sum: "+ intSumFromJNI(n1,n2));
        }
        /**/
    }
}
