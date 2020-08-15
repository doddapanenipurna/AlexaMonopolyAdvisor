package edu.tamu.stmi.monopolysystem1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Update extends AppCompatActivity implements View.OnClickListener,SeekBar.OnSeekBarChangeListener{

    TextView ownerDisplay, nameDisplay;
    String ownerString, nameString, propertyIndex,mortageString,houseCountString;
    Boolean mortaged;
    Button Player1, Player2, Player3, Player4, Player5, Player6, Bank, update;
    Switch mortagedSwitch;
    int houseCount=4;
    SeekBar houseCounter;
    String colorHexVal;
    String colorString;
    String newOwner,houseTemp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // ownerDisplay = (TextView) findViewById(R.id.ownerView);
        nameDisplay = (TextView) findViewById(R.id.nameView);

        Player1 = (Button) findViewById(R.id.UpdateTo1);
        Player1.setOnClickListener(this);
        Player2 = (Button) findViewById(R.id.UpdateTo2);
        Player2.setOnClickListener(this);
        Player3 = (Button) findViewById(R.id.UpdateTo3);
        Player3.setOnClickListener(this);
        Player4 = (Button) findViewById(R.id.UpdateTo4);
        Player4.setOnClickListener(this);
        Player5 = (Button) findViewById(R.id.UpdateTo5);
        Player5.setOnClickListener(this);
        Player6 = (Button) findViewById(R.id.UpdateTo6);
        Player6.setOnClickListener(this);
        Bank = (Button) findViewById(R.id.BankButton);
        Bank.setOnClickListener(this);
        update = (Button) findViewById(R.id.updateButton);
        update.setOnClickListener(this);
        mortagedSwitch = (Switch) findViewById(R.id.mortageSwitch);
        houseCounter= findViewById(R.id.houseBar);
        houseCounter.setOnSeekBarChangeListener(this);


        Intent intent = getIntent();
        ownerString = intent.getStringExtra("propertyOwner");

        colorString = intent.getStringExtra("propertyColor");
        nameString = intent.getStringExtra("propertyName");
        //propertyIndex = intent.getStringExtra("propertyIndex");
        houseCountString = intent.getStringExtra("housingCounter");
        if (houseCountString != null && !houseCountString.isEmpty()) {
            houseCount = Integer.parseInt(houseCountString);
        }
        //houseCount = 5;
        mortaged = Boolean.valueOf(intent.getStringExtra("propertyMortaged"));
        nameDisplay.setText(nameString);
        mortagedSwitch.setChecked(mortaged);
        initButton();
        newOwner = ownerString;
        houseCounter.setProgress(houseCount);
        setBackgroundColorTextView();
        mortagedSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mortaged = true;
                } else {
                    mortaged = false;
                }
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void initButton(){
        switch(ownerString){
            case "Player1":
                Player1.setBackgroundColor(0x880000FF);
                break;
            case "Player2":
                Player2.setBackgroundColor(0x880000FF);
                break;
            case "Player3":
                Player3.setBackgroundColor(0x880000FF);
                break;
            case "Player4":
                Player4.setBackgroundColor(0x880000FF);
                break;
            case "Player5":
                Player5.setBackgroundColor(0x880000FF);
                break;
            case "Player6":
                Player6.setBackgroundColor(0x880000FF);
                break;
            case "Bank" :
                Bank.setBackgroundColor(0x880000FF);
                break;
            default:
                resetColor();
        }
    }

    public void setBackgroundColorTextView(){
        switch(colorString) {
            case "Brown":
                colorHexVal = "#A08B4513";
                break;
            case "Teal":
                colorHexVal = "#A037FDFC";
                break;
            case "Purple":
                colorHexVal = "#A0FF00FF";
                break;
            case "Orange":
                colorHexVal = "#A0ffa500";
                break;
            case "Red":
                colorHexVal="#A0FF0000";
                break;
            case "Yellow":
                colorHexVal="#A0ffff00";
                break;
            case "Green":
                colorHexVal="#A0228B22";
                break;
            case "Blue":
                colorHexVal="#A00000FF";
                break;
                default:
                colorHexVal = "#A0a29725";
        }
        nameDisplay.setBackgroundColor(Color.parseColor(colorHexVal));
    }
    public void resetColor(){
       // Button11.setBackgroundColor(Color.RED); // From android.graphics.Color
        Player1.setBackgroundResource(android.R.drawable.btn_default);
        Player2.setBackgroundResource(android.R.drawable.btn_default);
        Player3.setBackgroundResource(android.R.drawable.btn_default);
        Player4.setBackgroundResource(android.R.drawable.btn_default);
        Player5.setBackgroundResource(android.R.drawable.btn_default);
        Player6.setBackgroundResource(android.R.drawable.btn_default);
        Bank.setBackgroundResource(android.R.drawable.btn_default);

    }

    @Override
    public void onClick(View view) {
    resetColor();
        switch(view.getId()){
            case R.id.UpdateTo1:
                newOwner = "Player1";
                Player1.setBackgroundColor(0x880000FF);
                break;
            case R.id.UpdateTo2:
                newOwner = "Player2";
                Player2.setBackgroundColor(0x880000FF);
                break;
            case R.id.UpdateTo3:
                newOwner = "Player3";
                Player3.setBackgroundColor(0x880000FF);
                break;
            case R.id.UpdateTo4:
                newOwner= "Player4";
                Player4.setBackgroundColor(0x880000FF);
                break;
            case R.id.UpdateTo5:
                newOwner= "Player5";
                Player5.setBackgroundColor(0x880000FF);
                break;
            case R.id.UpdateTo6:
                newOwner= "Player6";
                Player6.setBackgroundColor(0x880000FF);
                break;
            case R.id.BankButton:
                newOwner= "Bank";
                Bank.setBackgroundColor(0x880000FF);
                break;
            case R.id.updateButton:

                Intent returnIntent = new Intent();
                returnIntent.putExtra("updatedOwner", newOwner);
                returnIntent.putExtra("propertyIndex", propertyIndex);
                mortageString = Boolean.toString(mortaged);
                returnIntent.putExtra("propertyMortaged",mortageString);
                returnIntent.putExtra("houseCount",Integer.toString(houseCount));
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
                break;


            default:

        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        houseCount = i;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
