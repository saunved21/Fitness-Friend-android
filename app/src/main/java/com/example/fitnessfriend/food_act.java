package com.example.fitnessfriend;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
public class food_act extends AppCompatActivity {
    TextView bmi_ans;
    TextView cal_ans;
    TextView pro_ans;
    EditText cm;
    EditText kg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        bmi_ans = findViewById(R.id.bmi_ans);
        cal_ans = findViewById(R.id.cal_ans);
        pro_ans = findViewById(R.id.pro_ans);
        cm = findViewById(R.id.cm);
        kg = findViewById(R.id.kg);
    }

    public void calc(View view) {
        String s = kg.getText().toString();
        String s1 = cm.getText().toString();

        if (s.length() == 0) {
            kg.requestFocus();
            kg.setError("Field is empty");
            return;
        } else if (!isFloat(s)) {
            kg.requestFocus();
            kg.setError("Enter valid weight");
            return;
        }

        if (s1.length() == 0) {
            cm.requestFocus();
            cm.setError("Field is empty");
            return;
        } else if (!s1.matches("\\d+")) {
            cm.requestFocus();
            cm.setError("Enter numbers");
            return;
        }

        float kg1 = Float.parseFloat(s);
        int cm1 = Integer.parseInt(s1);

        double heightInMeters = cm1 / 100.0;
        double bmi = kg1 / (heightInMeters * heightInMeters);
        int calorie = (int)(kg1 * 29);
        int protein = (int)(kg1 * 2);

        bmi_ans.setText(String.format("Your BMI: %.2f", bmi));
        cal_ans.setText("Calories to be consumed: " + calorie);
        pro_ans.setText("Protein to be consumed: " + protein);
    }

    private boolean isFloat(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
