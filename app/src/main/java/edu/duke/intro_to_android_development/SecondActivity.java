package edu.duke.intro_to_android_development;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private ConstraintLayout container;
    private EditText userEntryEditText;
    private TextView convertedTextView;

    private Double CONVERSION_FACTOR = 1609.344;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        container = findViewById(R.id.container);
        TextView resultTextView = findViewById(R.id.results_tv);

        userEntryEditText = findViewById(R.id.entryEditText);
        convertedTextView = findViewById(R.id.convertedTextView);
        RadioGroup optionsRadioGroup = findViewById(R.id.optionsRadioGroup);

        Intent intent = getIntent();
        String message = intent.getStringExtra("user_txt");

        resultTextView.setText(message);

        resultTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                container.setBackgroundColor(Color.RED);
            }
        });

        optionsRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String userStr = userEntryEditText.getText().toString();
                String convertedValue = "0";
                switch (checkedId){
                    case R.id.metersRadioButton:
                        convertedValue = convertToMeters(userStr);
                        break;
                    case R.id.milesRadioButton:
                        convertedValue = convertToMiles(userStr);
                        break;
                }
                convertedTextView.setText(convertedValue);
                userEntryEditText.setText(userStr);
            }
        });
    }

    private String convertToMiles(String meters){
        String convertedMiles = "";
        try{
            convertedMiles = String.format( "%.5f", (Double.parseDouble(meters)/CONVERSION_FACTOR));
        }catch (NumberFormatException e){
            Toast.makeText(getBaseContext(), "Enter correct format number", Toast.LENGTH_SHORT).show();
        }


        return convertedMiles;
    }

    private String convertToMeters(String miles){
        String convertedMeters = "";
        try{
            convertedMeters =  String.format( "%.5f", (Double.parseDouble(miles)*CONVERSION_FACTOR));
        }catch (NumberFormatException e){
            Toast.makeText(getBaseContext(), "Enter correct format number", Toast.LENGTH_SHORT).show();
        }

        return convertedMeters;
    }
}
