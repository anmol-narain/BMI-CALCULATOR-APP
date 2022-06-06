package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edtWeight,edtHeightFt,edtHeightIn;
        Button btnAns;
        TextView txtAns;
        TextView txtQuote;
        ImageView bannerImg;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        edtHeightIn = findViewById(R.id.edtHeightIn);
        bannerImg = findViewById(R.id.bannerImg);
        btnAns = findViewById(R.id.btnAns);
        txtAns = findViewById(R.id.txtAns);
        txtQuote = findViewById(R.id.txtQuote);

        btnAns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int weight = Integer.parseInt(edtWeight.getText().toString());
                int heightFt = Integer.parseInt(edtHeightFt.getText().toString());
                int heightIn = Integer.parseInt(edtHeightIn.getText().toString());

                int Inches = 12*heightFt +heightIn;
                double Cm = Inches*2.53;
                double meters = Cm/100;
                // BMI -->  weight(Kg) / (height(m))^
                double BMI = Math.round(weight/(meters*meters));
                if(BMI > 25){
                     txtAns.setText("Your BMI is "+": "+BMI);
                     txtQuote.setText("You are OverWeight!!");
                     bannerImg.setImageDrawable(getResources().getDrawable(R.drawable.ic_overweight));

                }
                else if(BMI <18){
                    txtAns.setText("Your BMI is "+": "+BMI);
                    txtQuote.setText("You are UnderWeight!!");
                    bannerImg.setImageDrawable(getResources().getDrawable(R.drawable.ic_underweight));
                }
                else{
                    txtAns.setText("Your BMI is "+": "+BMI);
                    txtQuote.setText("You are Healthy!!");
                }
            }
        });



    }
}