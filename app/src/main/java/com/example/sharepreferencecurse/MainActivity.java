package com.example.sharepreferencecurse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edidText);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        DisplaySetText();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enterText = editText.getText().toString();
                DisplayAndSaveText(enterText);
            }

            //save the data
            private void DisplayAndSaveText(String string) {
                //display the text
                textView.setText(string);
                //saving the text into Sarepref
                SharedPreferences sharedPreferences= getSharedPreferences("MySharePref",MODE_PRIVATE);
                //WRITIN data  to share pref
                SharedPreferences.Editor editor =sharedPreferences.edit();
                editor.putString("name",string);
                editor.commit();
            }
        });
    }

    private void DisplaySetText() {
        //readin values for sharepreferens
        SharedPreferences sharedPreferences = getSharedPreferences("MySharePref",MODE_PRIVATE);
        String s1 = sharedPreferences.getString("name"," ");
        textView.setText(s1);
    }
}