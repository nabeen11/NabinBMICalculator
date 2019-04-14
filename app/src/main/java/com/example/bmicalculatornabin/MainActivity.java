package com.example.bmicalculatornabin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView txtVheight,txtVWeight,txtVBmi,tvResult;
    private EditText edtheight,edtweight;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtheight = (EditText) findViewById(R.id.edtheight);
        edtweight = (EditText) findViewById(R.id.edtweight);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        tvResult = (TextView) findViewById(R.id.tvResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check()) {
                    float height = Float.parseFloat(edtheight.getText().toString());
                    float weight = Float.parseFloat(edtweight.getText().toString());

                    BMINabin bmig = new BMINabin(height, weight);
                    float result = bmig.Calculate();
                    tvResult.setText(new DecimalFormat("##.#").format(result));

                    if (result < 18.5) {
                        Toast.makeText(MainActivity.this, "you are under weight", Toast.LENGTH_LONG).show();
                    } else if (result > 18.4 && result < 25) {
                        Toast.makeText(MainActivity.this, "you are normal weight", Toast.LENGTH_LONG).show();
                    } else if (result > 24 && result < 30) {
                        Toast.makeText(MainActivity.this, "you are overweight", Toast.LENGTH_LONG).show();
                    } else if (result > 30) {
                        Toast.makeText(MainActivity.this, "obesity", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    private boolean check() {
        boolean isValid = true;

        if (TextUtils.isEmpty(edtheight.getText().toString())) {
            edtheight.setError("please enter your height");
            edtheight.requestFocus();
            isValid = false;
        } else if (TextUtils.isEmpty(edtweight.getText().toString())) {
            edtweight.setError("please enter your weight");
            edtweight.requestFocus();
            isValid = false;
        }
        return isValid;

    }
}
