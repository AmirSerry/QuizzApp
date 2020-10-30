package com.amirserry.quizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*
      Correct Answers are:
      1-  2 & 3 (Clouds & stars)
      2- false
      3- Seven
      4- Yellow
     */
    final String QUESTION_THREE_CORRECT_ANSWER = "Seven";
    final String QUESTION_FOUR_CORRECT_ANSWER = "Yellow";
    final int totalQuizScore = 4;

    CheckBox checkBoxAnswerOne;
    CheckBox checkBoxAnswerTwo;
    CheckBox checkBoxAnswerThree;
    CheckBox checkBoxAnswerFour;

    RadioButton radioButtonFalse;

    EditText EditTextAnswerThree;
    EditText EditTextAnswerFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxAnswerOne = (CheckBox) findViewById(R.id.checkbox_1);
        checkBoxAnswerTwo = (CheckBox) findViewById(R.id.checkbox_2);
        checkBoxAnswerThree = (CheckBox) findViewById(R.id.checkbox_3);
        checkBoxAnswerFour = (CheckBox) findViewById(R.id.checkbox_4);

        radioButtonFalse = (RadioButton) findViewById(R.id.radio_false);

        EditTextAnswerThree = (EditText) findViewById(R.id.edit_text_question_3);
        EditTextAnswerFour = (EditText) findViewById(R.id.edit_text_question_4);

    }

    /**
     * calculate the Score and show the result as toast
     *
     * @param view
     */
    public void submit(View view) {
        int points = 0;

        if (checkBoxAnswerThree.isChecked() && checkBoxAnswerTwo.isChecked() && !checkBoxAnswerOne.isChecked() && !checkBoxAnswerFour.isChecked()) {
            points++;
        }
        if (radioButtonFalse.isChecked()) {
            points++;
        }
        if ((EditTextAnswerThree.getText().toString()).equalsIgnoreCase(QUESTION_THREE_CORRECT_ANSWER)) {
            points++;
        }
        if ((EditTextAnswerFour.getText().toString()).equalsIgnoreCase(QUESTION_FOUR_CORRECT_ANSWER)) {
            points++;
        }

        if (points == totalQuizScore) {
            String Message = "Congratulation you got the Full mark " + points + " out of " + totalQuizScore;
            Toast.makeText(getApplicationContext(), Message, Toast.LENGTH_LONG).show();
        } else {
            String Message = "Try agian you got  " + points + " out of " + totalQuizScore;
            Toast.makeText(getApplicationContext(), Message, Toast.LENGTH_LONG).show();
        }


    }
}
