package mandarine.dam.isi.frsf.utn.edu.ar.lab01c2016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnSeekBarChangeListener {

    SeekBar slider;
    double intereses;
    int cantDias;
    double capital;
    TextView textoSlider;

    public void calculadora(int cantDias,double capital){


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slider = (SeekBar)findViewById(R.id.seekBar);
        textoSlider = (TextView)findViewById(R.id.textSlider);

        slider.setOnSeekBarChangeListener(this);
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        cantDias = progress;
        textoSlider.setText(cantDias);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {  }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {   }
}
