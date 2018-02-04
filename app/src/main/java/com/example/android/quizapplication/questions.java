package com.example.android.quizapplication;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.quizapplication.R;

public class questions extends AppCompatActivity {

    // storing number of pts which should be added in case correct answer
    int firstQuestionPoints = 0;
    int secondQuestionPoints = 0;
    int thirdQuestionPoints = 0;
    int fourthQuestionPoints = 0;
    int fifthQuestionPoints = 0;
    int sixthQuestionPoints = 0;
    int seventhQuestionPoints = 0;
    int eighthQuestionPoints = 0;
    int ninthQuestionPoints = 0;
    int tenthQuestionPoints = 0;

    EditText stringInputOne;
    EditText stringInputTwo;
    EditText stringInputThree;

    // variable that helps to store number of checked boxes in 7. question
    int numberOfChecks = 0;
    // variables that help to store values when calculating points in 7. question
    boolean supportOne = false;
    boolean supportTwo = false;

    static final String FIRST_QUESTION_STATE = "questionOne";
    static final String SECOND_QUESTION_STATE = "questionTwo";
    static final String THIRD_QUESTION_STATE = "questionThree";
    static final String FOURTH_QUESTION_STATE = "questionFour";
    static final String FIFTH_QUESTION_STATE = "questionFive";
    static final String SIXTH_QUESTION_STATE = "questionSix";
    static final String SEVENTH_QUESTION_STATE = "questionSeven";
    static final String EIGHTH_QUESTION_STATE = "questionEight";
    static final String NINTH_QUESTION_STATE= "questionNine";
    static final String TENTH_QUESTION_STATE = "questionTen";

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putInt(FIRST_QUESTION_STATE, firstQuestionPoints);
        savedInstanceState.putInt(SECOND_QUESTION_STATE, secondQuestionPoints);
        savedInstanceState.putInt(THIRD_QUESTION_STATE, thirdQuestionPoints);
        savedInstanceState.putInt(FOURTH_QUESTION_STATE, fourthQuestionPoints);
        savedInstanceState.putInt(FIFTH_QUESTION_STATE, fifthQuestionPoints);
        savedInstanceState.putInt(SIXTH_QUESTION_STATE, sixthQuestionPoints);
        savedInstanceState.putInt(SEVENTH_QUESTION_STATE, seventhQuestionPoints);
        savedInstanceState.putInt(EIGHTH_QUESTION_STATE, eighthQuestionPoints);
        savedInstanceState.putInt(NINTH_QUESTION_STATE, ninthQuestionPoints);
        savedInstanceState.putInt(TENTH_QUESTION_STATE, tenthQuestionPoints);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        stringInputOne = findViewById(R.id.top_scorer_name);
        stringInputTwo = findViewById(R.id.city_name_with_clock);
        stringInputThree = findViewById(R.id.trainer_name);

        // Check whether we're recreating a previously destroyed instance
        if (savedInstanceState != null) {
            // Restore value of members from saved state
            firstQuestionPoints = savedInstanceState.getInt(FIRST_QUESTION_STATE);
            secondQuestionPoints = savedInstanceState.getInt(SECOND_QUESTION_STATE);
            thirdQuestionPoints = savedInstanceState.getInt(THIRD_QUESTION_STATE);
            fourthQuestionPoints = savedInstanceState.getInt(FOURTH_QUESTION_STATE);
            fifthQuestionPoints = savedInstanceState.getInt(FIFTH_QUESTION_STATE);
            sixthQuestionPoints = savedInstanceState.getInt(SIXTH_QUESTION_STATE);
            seventhQuestionPoints = savedInstanceState.getInt(SEVENTH_QUESTION_STATE);
            eighthQuestionPoints = savedInstanceState.getInt(EIGHTH_QUESTION_STATE);
            ninthQuestionPoints = savedInstanceState.getInt(NINTH_QUESTION_STATE);
            tenthQuestionPoints = savedInstanceState.getInt(TENTH_QUESTION_STATE);
        }
    }

    // all methods that check whether player scored point or not
    public void calculateAnswerOne(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked in each of all questions with RadioButtons
        switch(view.getId()) {
            case R.id.first_q_second_answer:
                if (checked)
                    firstQuestionPoints = 1;
                break;
            default:
                firstQuestionPoints = 0;
                break;
        }
    }

    public void calculateAnswerTwo(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.second_q_third_answer:
                if (checked)
                    secondQuestionPoints = 1;
                break;
            default:
                secondQuestionPoints = 0;
                break;
        }
    }

    public void calculateAnswerThree(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.third_q_first_answer:
                if (checked)
                    thirdQuestionPoints = 1;
                break;
            default:
                thirdQuestionPoints = 0;
                break;
        }
    }

    public void calculateAnswerSix(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.sixth_q_third_answer:
                if (checked)
                    sixthQuestionPoints = 1;
                break;
            default:
                sixthQuestionPoints = 0;
                break;
        }
    }

    public void calculateAnswerSeven(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // if/else statement prevents from checking more than 2 boxes
        if (checked) {
            if (numberOfChecks == 2)
                ((CheckBox) view).setChecked(false);
            else
                numberOfChecks++;
        } else
            numberOfChecks--;

        // checking if there is checked correct answer
        switch (view.getId()){
            case R.id.seventh_q_fourth_answer:
                if (checked)
                    supportOne = true;
                else
                    supportOne = false;
                break;
            case R.id.seventh_q_sixth_answer:
                if (checked)
                    supportTwo = true;
                else
                    supportTwo = false;
                break;
        }

        // setting point for correct answer
        if(supportOne && supportTwo)
            seventhQuestionPoints = 1;
        else
            seventhQuestionPoints = 0;
    }

    public void calculateAnswerEight(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.eighth_q_fourth_answer:
                if (checked)
                    eighthQuestionPoints = 1;
                break;
            default:
                eighthQuestionPoints = 0;
                break;
        }
    }

    public void calculateAnswerTen(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.tenth_q_first_answer:
                if (checked)
                    tenthQuestionPoints = 1;
                break;
            default:
                tenthQuestionPoints = 0;
                break;
        }
    }

    // method checking answers from questions 4, 5, 9 (views which are EditTexts)
    public void calculateAnswerEditText(){
        String string = stringInputOne.getText().toString();

        if(string.contains("Muller") || string.contains("Mueller") || string.contains("Müller"))
            fourthQuestionPoints = 1;

        string = stringInputTwo.getText().toString();

        if(string.contains("Hamburg"))
            fifthQuestionPoints = 1;

        string = stringInputThree.getText().toString();

        if(string.contains("Klopp"))
            ninthQuestionPoints = 1;
    }

    // method called when user clicks button to check his score
    public void checkYourScore(View view){
        calculateAnswerEditText();
        int totalScore = calculateAllPoints(firstQuestionPoints, secondQuestionPoints, thirdQuestionPoints,
                fourthQuestionPoints, fifthQuestionPoints, sixthQuestionPoints, seventhQuestionPoints,
                eighthQuestionPoints, ninthQuestionPoints, tenthQuestionPoints);

        String messageString;
        if(totalScore == 0)
            messageString = "Oops! You didn't score any points. That means relegation " +
                    "from the league :(";
        else if (totalScore == 1)
            messageString = "Oops! You scored only " + totalScore + " point. That means relegation " +
                    "from the league :(";
        else if(totalScore > 1 && totalScore <= 2)
            messageString = "Oops! You scored only " + totalScore + " points. That means relegation " +
                    "from the league :(";
        else if (totalScore > 2 && totalScore < 7)
            messageString = "Well.. I guess you need to practice a bit more. You scored " +
                    totalScore + " points.";
        else if (totalScore >= 7 && totalScore <= 9)
            messageString = "Nice! You just get qualified to the International Tournament with "
                    + totalScore + " points!";
        else
            messageString ="WOW! You just won the trophy scoring all " + totalScore + " points!";

        Toast.makeText(this, messageString, Toast.LENGTH_LONG).show();
    }

    // method calculating number of all points in quiz
    private int calculateAllPoints(int one, int two, int three, int four, int five, int six,
                                   int seven, int eight, int nine, int ten){
        return one + two + three + four + five + six + seven + eight + nine + ten;
    }
}
