package sg.edu.nus.tutorials;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick_simple(View view){
        Intent myIntent = new Intent(this,SimpleActivity.class);
        startActivity(myIntent);
    }

    public void onClick_graphing(View view){
        Intent myIntent = new Intent(this,GraphActivity.class);
        startActivity(myIntent);
    }

    public void onClick_sound(View view){
        Intent myIntent = new Intent(this, SoundSamplingActivity.class);
        startActivity(myIntent);
    }

}
