package com.example.android.testbiblequiz;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import android.app.Activity;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    int score = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * Increase the score for Team B by 1 point.
     */
    public void addOneForTeamB(View v) {
        // Figure out if the user picked Rachel
        CheckBox rachelCheckBox = (CheckBox) findViewById(R.id.rachel_checkbox);
        boolean rachelCheckBoxChecked = rachelCheckBox.isChecked();

        // Figure out if the user picked Leah
        CheckBox leahCheckBox = (CheckBox) findViewById(R.id.leah_checkbox);
        boolean leahCheckBoxChecked = leahCheckBox.isChecked();
        score = 0;
        if (rachelCheckBoxChecked && !leahCheckBoxChecked) {
            score = score + 1;
        }
        // Figure out if the user picked Disciple Peter
        CheckBox peterCheckBox = (CheckBox) findViewById(R.id.peter_checkbox);
        boolean peterCheckBoxChecked = peterCheckBox.isChecked();

        // Figure out if the user picked !Disciple Paul
        CheckBox paulCheckBox = (CheckBox) findViewById(R.id.paul_checkbox);
        boolean paulCheckBoxChecked = paulCheckBox.isChecked();

        // Figure out if the user picked Disciple John
        CheckBox johnCheckBox = (CheckBox) findViewById(R.id.john_checkbox);
        boolean johnCheckBoxChecked = johnCheckBox.isChecked();

        if (peterCheckBoxChecked && johnCheckBoxChecked && !paulCheckBoxChecked) {
            score = score + 1;
        }
        // Get user's answer to meaning of Sarah
        EditText nameField = (EditText) findViewById(R.id.sarah_field);
        Editable nameEditable = nameField.getText();
        String name = nameEditable.toString();
        if (name.equals("PRINCESS")) {
            score = score + 1;
        }
        // Get user's answer to who killed Abel
        EditText killerField = (EditText) findViewById(R.id.abel_field);
        Editable killerEditable = killerField.getText();
        String killer = killerEditable.toString();
        if (killer.equals("CAIN")) {
            score = score + 1;
        }

        //Get answer to the yes no question on animal speaking
        //to get selected RadioButton Text on RadioGroup
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        // get selected radio button from radioGroup
        int selectedId = radioGroup.getCheckedRadioButtonId();
        // find the radiobutton by returned id
        RadioButton radioButton = (RadioButton) findViewById(selectedId);
        int idx = radioGroup.indexOfChild(radioButton);
        RadioButton r = (RadioButton) radioGroup.getChildAt(idx);
        String selectedtext = r.getText().toString();
        if (selectedtext.equals("YES")) {
            score = score + 1;
        }

        Context context = getApplicationContext();
        CharSequence text = "Good Effort!Your score is " + score + " out of 5";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    /**
     * Reset the score for Team B to zero
     */
    public void setToZero(View v) {
        score = 0;
        //clear all checked boxes//

        CheckBox rachelCheckBox = (CheckBox) findViewById(R.id.rachel_checkbox);
        rachelCheckBox.setChecked(false);
        CheckBox leahCheckBox = (CheckBox) findViewById(R.id.leah_checkbox);
        leahCheckBox.setChecked(false);

        CheckBox peterCheckBox = (CheckBox) findViewById(R.id.peter_checkbox);
        peterCheckBox.setChecked(false);
        CheckBox paulCheckBox = (CheckBox) findViewById(R.id.paul_checkbox);
        paulCheckBox.setChecked(false);
        CheckBox johnCheckBox = (CheckBox) findViewById(R.id.john_checkbox);
        johnCheckBox.setChecked(false);
        //clear group button//
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        radioGroup.clearCheck();
        //clear Text//
        EditText nameField = (EditText) findViewById(R.id.sarah_field);
        nameField.setText("");
        EditText killerField = (EditText) findViewById(R.id.abel_field);
        killerField.setText("");
        EditText yourName = findViewById(R.id.name_field);
        yourName.setText("");
    }

}

