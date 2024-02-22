package com.smp.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView reset_text;
    private RadioButton radio_button_male;
    private RadioButton radio_button_female;
    private EditText edit_text_age;
    private EditText height_feet;
    private EditText height_inch;
    private EditText weight_kg;
    private Button button_calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setUpButtonOnClickListener();
    }

    private void findViews() {
        reset_text = findViewById(R.id.fnal_text);
        radio_button_male = findViewById(R.id.radio_button_male);
        radio_button_female = findViewById(R.id.radio_button_female);
        edit_text_age = findViewById(R.id.edit_text_age);
        height_feet = findViewById(R.id.height_feet);
        height_inch = findViewById(R.id.height_inch);
        weight_kg = findViewById(R.id.weight_kg);
        button_calculate = findViewById(R.id.button_calculate);
    }

    private void setUpButtonOnClickListener() {
        button_calculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (radio_button_male.isChecked() || radio_button_female.isChecked()) {
                    double[] bmi_height = calculateBmi();
                    String ageText = edit_text_age.getText().toString();
                    if (ageText.isEmpty()) {
                        reset_text.setText("Enter Age");
                    } else {
                        int age = Integer.parseInt(ageText);
                        if (age >= 18) {
                            finalDecisionAdult(bmi_height);
                        } else {
                            finalDecisionKids();
                        }
                    }
                } else {
                    reset_text.setText("Select Gender");
                }
            }
        });
    }

    private double[] calculateBmi() {
        String feetText = height_feet.getText().toString();
        String inchText = height_inch.getText().toString();
        String weightText = weight_kg.getText().toString();
        double[] bmi_height;
        if (feetText.isEmpty() || inchText.isEmpty() || weightText.isEmpty()) {
            bmi_height = new double[]{0, 0};
        } else {
            int feet = Integer.parseInt(feetText);
            int inch = Integer.parseInt(inchText);
            int weight = Integer.parseInt(weightText);
            double total_height = ((feet * 12) + inch) * 0.0254;
            double bmi = ((weight / (total_height * total_height)));
            bmi_height = new double[]{bmi, total_height};
        }
        return bmi_height;
    }

    @SuppressLint("SetTextI18n")
    private void finalDecisionAdult(double[] bmi_height) {
        double bmi = bmi_height[0];
        double height = bmi_height[1];
        double min_weight = 18.5 * (height * height);
        double max_weight = 24.9 * (height * height);
        @SuppressLint("DefaultLocale") String preference = "Your Healthy Weight Range is from " + String.format("%.0f", min_weight) + " kg to " + String.format("%.0f", max_weight) + " kg. ";
        @SuppressLint("DefaultLocale") String bmiString = String.format("%.1f", bmi);
        String finalOutcome;
        if (bmi == 0) {
            finalOutcome = ("Please Fill-up Height & Weight Properly");
            reset_text.setText(finalOutcome);
        } else if (bmi < 18.5) {
            finalOutcome = ("Your BMI is: " + bmiString + " and You are UNDERWEIGHT. ");
            reset_text.setText(finalOutcome + "\n" + preference);
        } else if (bmi < 25.0) {
            finalOutcome = ("Your BMI is: " + bmiString + " and You are HEALTHY. ");
            reset_text.setText(finalOutcome + "\n" + preference);
        } else if (bmi < 30.0) {
            finalOutcome = ("Your BMI is: " + bmiString + " and You are OVERWEIGHT. ");
            reset_text.setText(finalOutcome + "\n" + preference);
        } else {
            finalOutcome = ("Your BMI is: " + bmiString + " and You are OBESE. ");
            reset_text.setText(finalOutcome + "\n" + preference);
        }
        Toast.makeText(MainActivity.this, "Your BMA Calculation is Done!!!", Toast.LENGTH_SHORT).show();

    }


    @SuppressLint("SetTextI18n")
    private void finalDecisionKids() {
        if (radio_button_male.isChecked()) {
            reset_text.setText("As You are Under 18, Consult With Your Doctor about Boys Healthy Weight Range");
        } else if (radio_button_female.isChecked()) {
            reset_text.setText("As You are Under 18, Consult With Your Doctor about Girls Healthy Weight Range");
        }
    }
}