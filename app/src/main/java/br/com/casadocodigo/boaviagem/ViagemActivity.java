package br.com.casadocodigo.boaviagem;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by Maths on 03/09/2016.
 */

public class ViagemActivity extends Activity {

    private int anoChegada, anoSaida, mesChegada, mesSaida, diaChegada, diaSaida;
    private Button dataChegada, dataSaida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viagem);

        dataChegada = (Button) findViewById(R.id.dataChegada);
        dataSaida = (Button) findViewById(R.id.dataSaida);

        Calendar calendar = Calendar.getInstance();
        anoChegada = anoSaida = calendar.get(Calendar.YEAR);
        mesChegada = mesSaida = calendar.get(Calendar.MONTH);
        diaChegada = diaSaida = calendar.get(Calendar.DAY_OF_MONTH);

    }

    public void selecionarData(View view) {
        showDialog(view.getId());
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (R.id.dataChegada == id) {
            return new DatePickerDialog(this, listenerChegada, anoChegada, mesChegada, diaChegada);
        } else if (R.id.dataSaida == id) {
            return new DatePickerDialog(this, listenerSaida, anoSaida, mesSaida, diaSaida);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener listenerChegada = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            anoChegada = year;
            mesChegada = monthOfYear;
            diaChegada = dayOfMonth;
            dataChegada.setText(diaChegada + "/" + (mesChegada+1) + "/" + anoChegada);
        }
    };

    private DatePickerDialog.OnDateSetListener listenerSaida = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            anoSaida = year;
            mesSaida = monthOfYear;
            diaSaida = dayOfMonth;
            dataSaida.setText(diaSaida + "/" + (mesSaida+1) + "/" + anoSaida);
        }
    };


    public void salvarViagem(View view) {
    }
}
