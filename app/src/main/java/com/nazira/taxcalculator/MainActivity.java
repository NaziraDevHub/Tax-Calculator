package com.nazira.taxcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText etIncome;
    RadioGroup rgTaxCategory;
    RadioButton rbMale, rbFemale, rbSeniorCitizen;
    Button btnCalculate;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etIncome = findViewById(R.id.etIncome);
        rgTaxCategory = findViewById(R.id.rgTaxCategory);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        rbSeniorCitizen = findViewById(R.id.rbSeniorCitizen);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the entered income
                String incomeStr = etIncome.getText().toString().trim();

                if (incomeStr.isEmpty()) {
                    tvResult.setText("Please enter your annual income.");
                    return;
                }

                double income = Double.parseDouble(incomeStr);
                double tax = 0;

                // Get selected tax category
                int selectedId = rgTaxCategory.getCheckedRadioButtonId();

                // Check which RadioButton is selected and calculate tax accordingly
                if (selectedId == R.id.rbMale) {
                    // Tax calculation logic for Male
                    if (income <= 300000) {
                        tax = 0;
                    } else if (income <= 700000) {
                        tax = (income - 300000) * 0.10;
                    } else {
                        tax = (income - 700000) * 0.20 + (400000 * 0.10);
                    }
                } else if (selectedId == R.id.rbFemale) {
                    // Tax calculation logic for Female
                    if (income <= 350000) {
                        tax = 0;
                    } else if (income <= 700000) {
                        tax = (income - 350000) * 0.10;
                    } else {
                        tax = (income - 700000) * 0.20 + (350000 * 0.10);
                    }
                } else if (selectedId == R.id.rbSeniorCitizen) {
                    // Tax calculation logic for Senior Citizen
                    if (income <= 400000) {
                        tax = 0;
                    } else if (income <= 700000) {
                        tax = (income - 400000) * 0.10;
                    } else {
                        tax = (income - 700000) * 0.20 + (300000 * 0.10);
                    }
                }

                // Display the result
                tvResult.setText(String.format("Your calculated tax is: BDT %.2f", tax));
            }
        });

    }
}

