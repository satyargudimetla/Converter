package com.example.satya.converter;

import android.content.Context;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private RadioButton rbFromMile;
    private RadioButton rbToMile;
    private RadioButton rbFromKm;
    private RadioButton rbToKm;
    private EditText txtResult;
    private EditText txtVal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbFromMile = (RadioButton)findViewById(R.id.rbFromMile);
        rbToMile = (RadioButton)findViewById(R.id.rbToMile);
        rbFromKm = (RadioButton)findViewById(R.id.rbFromKm);
        rbToKm = (RadioButton)findViewById(R.id.rbToKm);
        txtVal = (EditText)findViewById(R.id.txtVal);
        txtResult = (EditText)findViewById(R.id.txtResult);
    }

    public void handleClick(View view){

        switch (view.getId()){

            case R.id.btnConvert:
                String value = txtVal.getText().toString();
                if (value.length() > 0){
                    txtResult.setText(milesTokm(txtVal.getText().toString()));
                }
                else{
                    Context context = getApplicationContext();
                    CharSequence text = "Empty value!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context,text, duration);
                    toast.show();
                }
                break;

            case R.id.btnReset:
                txtVal.setText("");
                txtResult.setText("");
                rbFromMile.setChecked(true);
                rbToKm.setChecked(true);
                break;
        }
    }

    public String milesTokm(String StrMiles){
        Double miles = Double.parseDouble((StrMiles));
        Double km = miles * 1.604;
        DecimalFormat format = new DecimalFormat("##.#");
        return String.valueOf(format.format(km));

    }

    public String kmToMiles(String StrKm ) {
        Double km = Double.parseDouble((StrKm));
        Double miles = km/1.604;
        DecimalFormat format = new DecimalFormat("##.#");
        return String.valueOf(format.format(miles));

    }
}
