package edu.duke.intro_to_android_development;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText nameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameTextField);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usrTxt = nameEditText.getText().toString();
                goToSecondActivity(usrTxt);
            }
        });
    }

    private void goToSecondActivity(String usrTxt){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("user_txt", usrTxt);
        startActivity(intent);
    }
}
