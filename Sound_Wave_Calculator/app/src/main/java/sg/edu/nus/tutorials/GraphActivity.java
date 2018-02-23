package sg.edu.nus.tutorials;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GraphActivity extends Activity {

    private String   trigo;
    private double   sineAmplitude;
    private double   cosineAmplitude;
    private double   sineFrequency;
    private double   cosineFrequency;
    private double   sinePhase;
    private double   cosinePhase;
    private TextView displayFunction;

    public  CSurfaceViewGraph   	surfaceView;
    public  static short[]  buffer;
    public  static int      bufferSize;     // in bytes

    public void goToMainActivity(View view) {

        // please fill in your code here.  Remember to stop drawing before you return to the MainActivity.
        finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        displayFunction = (TextView)findViewById(R.id.displayFunction);
        trigo = "sine";
        sineAmplitude=0.0;
        cosineAmplitude=0.0;
        sineFrequency=0.0;
        cosineFrequency=0.0;
        sinePhase = 0.0;
        cosinePhase=0.0;
        bufferSize = 1024;
        buffer = new short[bufferSize];
        surfaceView = (CSurfaceViewGraph)findViewById(R.id.surfaceView);
    }


    public void sinePressed(View view) {
        trigo = "sine";
    }

    public void cosinePressed(View view) {
        trigo = "cosine";
    }

    public void AplusPressed(View view){

        if (trigo.equalsIgnoreCase("sine")) {
            sineAmplitude += 1.0;

        } else if (trigo.equalsIgnoreCase("cosine")) {
            cosineAmplitude += 1.0;
        }

        composeSignal();

    }

    public void AminusPressed(View view){

        if (trigo.equalsIgnoreCase("sine")) {
            sineAmplitude -= 1.0;

        } else if (trigo.equalsIgnoreCase("cosine")) {
            cosineAmplitude -= 1.0;
        }

        composeSignal();


    }

    public void FplusPressed(View view){

        if (trigo.equalsIgnoreCase("sine")) {
            sineFrequency += 1.0;

        } else if (trigo.equalsIgnoreCase("cosine")) {
            cosineFrequency += 1.0;
        }

        composeSignal();

    }

    public void FminusPressed(View view){

        if (trigo.equalsIgnoreCase("sine")) {
            sineFrequency -= 1.0;

        } else if (trigo.equalsIgnoreCase("cosine")) {
            cosineFrequency -= 1.0;
        }

        composeSignal();

    }

    public void PplusPressed(View view){

        if (trigo.equalsIgnoreCase("sine")) {
            sinePhase += 1.0;

        } else if (trigo.equalsIgnoreCase("cosine")) {
            cosinePhase += 1.0;
        }

        composeSignal();

    }

    public void PminusPressed(View view){

        if (trigo.equalsIgnoreCase("sine")) {
            sinePhase -= 1.0;

        } else if (trigo.equalsIgnoreCase("cosine")) {
            cosinePhase -= 1.0;
        }

        composeSignal();

    }


    public void composeSignal() {

        displayFunction.setText(String.valueOf(sineAmplitude) + " sin( 2π" +
                String.valueOf(sineFrequency) + " + " + String.valueOf(sinePhase) + " )" + " + " +
                String.valueOf(cosineAmplitude) + " cos( 2π" +
                String.valueOf(cosineFrequency) + " + " + String.valueOf(cosinePhase) + " )");

        // plot 1 second duration of signal
        double radStepSine    = 2*Math.PI*sineFrequency   / (double)bufferSize;
        double radStepCosine  = 2*Math.PI*cosineFrequency / (double)bufferSize;
        double freqSine       = 0.0;
        double freqCosine     = 0.0;
        double sinePhaseRad   = sinePhase*Math.PI/180;
        double cosinePhaseRad = cosinePhase*Math.PI/180;
        for (int i=0; i<bufferSize; i++) {
            buffer[i] = (short)(sineAmplitude*Math.sin(freqSine + sinePhaseRad) + cosineAmplitude*Math.cos(freqCosine + cosinePhaseRad));
            freqSine   += radStepSine;
            freqCosine += radStepCosine;
        }
        surfaceView.drawThread.setBuffer(buffer);
    }




}
