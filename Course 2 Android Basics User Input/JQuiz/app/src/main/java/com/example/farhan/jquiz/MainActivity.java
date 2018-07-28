package com.example.farhan.jquiz;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int totalMarksCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Question One ViewHint OnClick Event
     **/
    public void questionOneHintOnClick(View v) {

        // Question One ViewHint OnClick ViewAnswer Visible
        TextView questionOneHintTextView = (TextView) findViewById(R.id.questionOneHintAnswer);
        questionOneHintTextView.setVisibility(View.VISIBLE);

        // Question One ViewHint OnClick Color Changes
        TextView onClickColorChange = (TextView) findViewById(R.id.questionOneHintOnClickColorChange);
        onClickColorChange.setTextColor(Color.parseColor("#D500F9"));
    }

    /**
     * Question Two ViewHint OnClick Event
     **/
    public void questionTwoHintOnClick(View v) {

        // Question Two ViewHint OnClick ViewAnswer Visible
        TextView questionTwoHintTextView = (TextView) findViewById(R.id.questionTwoHintAnswer);
        questionTwoHintTextView.setVisibility(View.VISIBLE);

        // Question Two ViewHint OnClick Color Changes
        TextView onClickColorChange = (TextView) findViewById(R.id.questionTwoHintOnClickColorChange);
        onClickColorChange.setTextColor(Color.parseColor("#D500F9"));
    }

    /**
     * Question Three ViewHint OnClick Event
     **/
    public void questionThreeHintOnClick(View v) {

        // Question Three ViewHint OnClick ViewAnswer Visible
        TextView questionThreeHintTextView = (TextView) findViewById(R.id.questionThreeHintAnswer);
        questionThreeHintTextView.setVisibility(View.VISIBLE);

        // Question Three ViewHint OnClick Color Changes
        TextView onClickColorChange = (TextView) findViewById(R.id.questionThreeHintOnClickColorChange);
        onClickColorChange.setTextColor(Color.parseColor("#D500F9"));
    }

    /**
     * Question Four ViewHint OnClick Event
     **/
    public void questionFourHintOnClick(View v) {

        // Question Four ViewHint OnClick ViewAnswer Visible
        TextView questionFourHintTextView = (TextView) findViewById(R.id.questionFourHintAnswer);
        questionFourHintTextView.setVisibility(View.VISIBLE);

        // Question Four ViewHint OnClick Color Changes
        TextView onClickColorChange = (TextView) findViewById(R.id.questionFourHintOnClickColorChange);
        onClickColorChange.setTextColor(Color.parseColor("#D500F9"));
    }

    /**
     * Question Five ViewHint OnClick Event
     **/
    public void questionFiveHintOnClick(View v) {

        // Question Five ViewHint OnClick ViewAnswer Visible
        TextView questionFiveHintTextView = (TextView) findViewById(R.id.questionFiveHintAnswer);
        questionFiveHintTextView.setVisibility(View.VISIBLE);

        // Question Five ViewHint OnClick Color Changes
        TextView onClickColorChange = (TextView) findViewById(R.id.questionFiveHintOnClickColorChange);
        onClickColorChange.setTextColor(Color.parseColor("#D500F9"));
    }

    /**
     * Question Six ViewHint OnClick Event
     **/
    public void questionSixHintOnClick(View v) {

        //Question Six ViewHint OnClick ViewAnswer Visible
        TextView questionSixHintTextView = (TextView) findViewById(R.id.questionSixHintAnswer);
        questionSixHintTextView.setVisibility(View.VISIBLE);

        // Question Six ViewHint OnClick Color Changes
        TextView onClickColorChange = (TextView) findViewById(R.id.questionSixHintOnClickColorChange);
        onClickColorChange.setTextColor(Color.parseColor("#D500F9"));
    }

    /**
     * Question Seven ViewHint OnClick Event
     **/
    public void questionSevenHintOnClick(View v) {

        // Question Seven ViewHint OnClick ViewAnswer Visible
        TextView questionSevenHintTextView = (TextView) findViewById(R.id.questionSevenHintAnswer);
        questionSevenHintTextView.setVisibility(View.VISIBLE);

        // Question Seven ViewHint OnClick Color Changes
        TextView onClickColorChange = (TextView) findViewById(R.id.questionSevenHintOnClickColorChange);
        onClickColorChange.setTextColor(Color.parseColor("#D500F9"));
    }

    /**
     * Show Result Button onClick Event
     **/
    public void showResultsOnClick(View v) {

        //Question One Correct Answer RadioButton
        RadioButton questionOneAnswerRadioButton = (RadioButton) findViewById(R.id.questionOneCorrectAnswer);
        boolean questionOneCorrectAnswer = questionOneAnswerRadioButton.isChecked();

        //Question Two Correct Answer RadioButton
        RadioButton questionTwoAnswerRadioButton = (RadioButton) findViewById(R.id.questionTwoCorrectAnswer);
        boolean questionTwoCorrectAnswer = questionTwoAnswerRadioButton.isChecked();

        //Question Three Correct Answer RadioButton
        RadioButton questionThreeAnswerRadioButton = (RadioButton) findViewById(R.id.questionThreeCorrectAnswer);
        boolean questionThreeCorrectAnswer = questionThreeAnswerRadioButton.isChecked();

        //Question Four Correct Answer CheckBox One
        CheckBox questionFourAnswerOneCheckBox = (CheckBox) findViewById(R.id.questionFourCorrectAnswerOne);
        boolean questionFourCorrectAnswerOne = questionFourAnswerOneCheckBox.isChecked();

        //Question Four Correct Answer CheckBox Two
        CheckBox questionFourAnswerTwoCheckBox = (CheckBox) findViewById(R.id.questionFourCorrectAnswerTwo);
        boolean questionFourCorrectAnswerTwo = questionFourAnswerTwoCheckBox.isChecked();

        //Question Five Correct Answer CheckBox One
        CheckBox questionFiveAnswerOneCheckBox = (CheckBox) findViewById(R.id.questionFiveCorrectAnswerOne);
        boolean questionFiveCorrectAnswerOne = questionFiveAnswerOneCheckBox.isChecked();

        //Question Five Correct Answer CheckBox Two
        CheckBox questionFiveAnswerTwoCheckBox = (CheckBox) findViewById(R.id.questionFiveCorrectAnswerTwo);
        boolean questionFiveCorrectAnswerTwo = questionFiveAnswerTwoCheckBox.isChecked();

        //Question Six Correct Answer EditText
        EditText questionSixAnswerEditText = (EditText) findViewById(R.id.answerSixEditText);
        String answerSixEditText = questionSixAnswerEditText.getText().toString();

        //Question Seven Correct Answer EditText
        EditText questionSevenAnswerEditText = (EditText) findViewById(R.id.answerSevenEditText);
        String answerSevenEditText = questionSevenAnswerEditText.getText().toString();


        // Checking For Answer to get Total Marks
        if (questionOneCorrectAnswer) {
            totalMarksCount += 1;

        }
        if (questionTwoCorrectAnswer) {
            totalMarksCount += 1;

        }
        if (questionThreeCorrectAnswer) {
            totalMarksCount += 1;

        }
        if (questionFourCorrectAnswerOne) {
            totalMarksCount += 1;

        }
        if (questionFourCorrectAnswerTwo) {
            totalMarksCount += 1;

        }
        if (questionFiveCorrectAnswerOne) {
            totalMarksCount += 1;

        }
        if (questionFiveCorrectAnswerTwo) {
            totalMarksCount += 1;

        }
        if (answerSixEditText.equalsIgnoreCase("Write once run anywhere")) {
            totalMarksCount += 1;

        }
        if (answerSevenEditText.equalsIgnoreCase("Object oriented programming")) {
            totalMarksCount += 1;

        }

        //Show Result on Pop Up
        Toast.makeText(this, "Your Result is " + totalMarksCount + "/9", Toast.LENGTH_SHORT).show();

        //Reset all Views After Showing Result
        doResetAllViews();


    }

    public void doResetAllViews(){

        //Clear First Radio Button Of Question One
        RadioButton resetValueOfQuestionOneGuessOne = (RadioButton) findViewById(R.id.questionOneGuessOne);
        resetValueOfQuestionOneGuessOne.setChecked(false);
        //Clear Second Radio Button Of Question One
        RadioButton resetValueOfQuestionOneGuessTwo = (RadioButton) findViewById(R.id.questionOneCorrectAnswer);
        resetValueOfQuestionOneGuessTwo.setChecked(false);
        //Clear Third Radio Button Of Question One
        RadioButton resetValueOfQuestionOneGuessThree = (RadioButton) findViewById(R.id.questionOneGuessThree);
        resetValueOfQuestionOneGuessThree.setChecked(false);
        //Clear Fourth Radio Button Of Question One
        RadioButton resetValueOfQuestionOneGuessFour = (RadioButton) findViewById(R.id.questionOneGuessFour);
        resetValueOfQuestionOneGuessFour.setChecked(false);


        //Clear First Radio Button Of Question Two
        RadioButton resetValueOfQuestionTwoGuessOne = (RadioButton) findViewById(R.id.questionTwoGuessOne);
        resetValueOfQuestionTwoGuessOne.setChecked(false);
        //Clear Second Radio Button Of Question Two
        RadioButton resetValueOfQuestionTwoGuessTwo = (RadioButton) findViewById(R.id.questionTwoCorrectAnswer);
        resetValueOfQuestionTwoGuessTwo.setChecked(false);
        //Clear Third Radio Button Of Question Two
        RadioButton resetValueOfQuestionTwoGuessThree = (RadioButton) findViewById(R.id.questionTwoGuessTwo);
        resetValueOfQuestionTwoGuessThree.setChecked(false);
        //Clear Fourth Radio Button Of Question Two
        RadioButton resetValueOfQuestionTwoGuessFour = (RadioButton) findViewById(R.id.questionTwoGuessThree);
        resetValueOfQuestionTwoGuessFour.setChecked(false);


        //Clear First Radio Button Of Question Three
        RadioButton resetValueOfQuestionThreeGuessOne = (RadioButton) findViewById(R.id.questionThreeGuessOne);
        resetValueOfQuestionThreeGuessOne.setChecked(false);
        //Clear Second Radio Button Of Question Three
        RadioButton resetValueOfQuestionThreeGuessTwo = (RadioButton) findViewById(R.id.questionThreeCorrectAnswer);
        resetValueOfQuestionThreeGuessTwo.setChecked(false);
        //Clear Third Radio Button Of Question Three
        RadioButton resetValueOfQuestionThreeGuessThree = (RadioButton) findViewById(R.id.questionThreeGuessTwo);
        resetValueOfQuestionThreeGuessThree.setChecked(false);
        //Clear Fourth Radio Button Of Question Three
        RadioButton resetValueOfQuestionThreeGuessFour = (RadioButton) findViewById(R.id.questionThreeGuessThree);
        resetValueOfQuestionThreeGuessFour.setChecked(false);


        //Clear First CheckBox Of Question Four
        CheckBox resetValueOfQuestionFourGuessOne = (CheckBox) findViewById(R.id.questionFourCorrectAnswerOne);
        resetValueOfQuestionFourGuessOne.setChecked(false);
        //Clear Second CheckBox Of Question Four
        CheckBox resetValueOfQuestionFourGuessTwo = (CheckBox) findViewById(R.id.questionFourCorrectAnswerTwo);
        resetValueOfQuestionFourGuessTwo.setChecked(false);
        //Clear Third CheckBox Of Question Four
        CheckBox resetValueOfQuestionFourGuessThree = (CheckBox) findViewById(R.id.questionFourGuessThree);
        resetValueOfQuestionFourGuessThree.setChecked(false);
        //Clear Fourth CheckBox Of Question Four
        CheckBox resetValueOfQuestionFourGuessFour = (CheckBox) findViewById(R.id.questionFourGuessFour);
        resetValueOfQuestionFourGuessFour.setChecked(false);


        //Clear First CheckBox Of Question Five
        CheckBox resetValueOfQuestionFiveGuessOne = (CheckBox) findViewById(R.id.questionFiveCorrectAnswerOne);
        resetValueOfQuestionFiveGuessOne.setChecked(false);
        //Clear Second CheckBox Of Question Five
        CheckBox resetValueOfQuestionFiveGuessTwo = (CheckBox) findViewById(R.id.questionFiveCorrectAnswerTwo);
        resetValueOfQuestionFiveGuessTwo.setChecked(false);
        //Clear Third CheckBox Of Question Five
        CheckBox resetValueOfQuestionFiveGuessThree = (CheckBox) findViewById(R.id.questionFiveGuessThree);
        resetValueOfQuestionFiveGuessThree.setChecked(false);
        //Clear Fourth CheckBox Of Question Five
        CheckBox resetValueOfQuestionFiveGuessFour = (CheckBox) findViewById(R.id.questionFiveGuessFour);
        resetValueOfQuestionFiveGuessFour.setChecked(false);


        //Clear Edit Text Of Question Six
        EditText resetEditTextValueOfQuestionSix = (EditText) findViewById(R.id.answerSixEditText);
        resetEditTextValueOfQuestionSix.setText("");

        //Clear Edit Text Of Question Seven
        EditText resetEditTextValueOfQuestionSeven = (EditText) findViewById(R.id.answerSevenEditText);
        resetEditTextValueOfQuestionSeven.setText("");

        totalMarksCount = 0;

    }


}
