package mandarine.dam.isi.frsf.utn.edu.ar.lab01c2016;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, Button.OnClickListener {

    SeekBar slider;
    Button confButton;
    TextView aCobrar;
    TextView resultado;
    EditText montoIngresado;
    double intereses;
    int cantDias;
    double capital;
    TextView textoSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slider = (SeekBar)findViewById(R.id.seekBar);
        textoSlider = (TextView)findViewById(R.id.textSlider);
        confButton = (Button)findViewById(R.id.button);
        aCobrar = (TextView)findViewById(R.id.intereses);
        resultado = (TextView)findViewById(R.id.resultado);
        montoIngresado = (EditText)findViewById(R.id.inputImporte);

        slider.setOnSeekBarChangeListener(this);
        confButton.setOnClickListener(this);
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        textoSlider.setText(String.valueOf(Integer.valueOf(progress)));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {  }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {   }

    @Override
    public void onClick(View v) {

        String resPlazoFijo = calculadora();
        aCobrar.setText("$"+resPlazoFijo);
        aCobrar.setVisibility(v.VISIBLE);
        resultado.setText(getString(R.string.exito, resPlazoFijo));
        resultado.setVisibility(v.VISIBLE);
        resultado.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.Verde));


    }

    public String calculadora() {

        cantDias = slider.getProgress();
        capital = Integer.parseInt(montoIngresado.getText().toString());

        Double tasa = getTasa(cantDias, capital);

        intereses = getInteres(capital, tasa, cantDias);


        return String.valueOf(intereses);
    }

    private double getInteres(double capital, Double tasa, int cantDias ) {
        double intereses;

        intereses = capital*((Math.pow(1+tasa,(double) cantDias/360)-1));
        DecimalFormat df = new DecimalFormat("#.##");
        intereses = Double.valueOf(df.format(intereses));

        return intereses;
    }

    @NonNull
    private Double getTasa(int cantDias, double capital) {
        String tasa = null;
        if(capital<5000){
            tasa = cantDias < 30 ?   getString(R.string.menor30menos5k) : getString(R.string.mayig30menos5k);
        }
        else if(capital>5000 && capital<99999 ){
            tasa =  cantDias < 30 ?   getString(R.string.menor30entre5y99k) : getString(R.string.mayig30entre5y99k);
        }
        else if(capital>99999 ){
            tasa =  cantDias < 30 ?   getString(R.string.menor30mas99k) : getString(R.string.mayig30mas99k);
        }
        return Double.parseDouble(tasa);
    }

}
