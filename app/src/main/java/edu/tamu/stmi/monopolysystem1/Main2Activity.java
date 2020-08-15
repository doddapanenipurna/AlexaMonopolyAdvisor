package edu.tamu.stmi.monopolysystem1;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.lambdainvoker.LambdaFunctionException;
import com.amazonaws.mobileconnectors.lambdainvoker.LambdaInvokerFactory;
import com.amazonaws.regions.Regions;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "MyActivity";
    PropertyClass[] gameProperties = new PropertyClass[40];
    Button medAve, balAve, oriAve, verAve,conAve,stcPla,staAve,virAve,stjPla,tenAve,newAve, kenAve, indAve, illAve, atlAve,venAve,marGar;
    Button pacAve, norAve,penAve, parPla, boaWal;
    Button reaRail,penRail,baoRail,shoRail;
    String result, mortageResult;
    Button eleCom, watCom;
    Boolean mortageResultBool;
    int currentPropertyIndex;
    int tempPropertyIndex;

    String[] propertyNameArray = new String[]{  "Go",
                                                "Mediterranean Avenue",
                                                "Community Chest",
                                                "Baltic Avenue",
                                                "Income",
                                                "Reading Railroad",
                                                "Oriental Avenue",
                                                "Chance",
                                                "Vermont Avenue",
                                                "Connecticut Avenue",
                                                "Jail",
                                                "St.Charles Place",
                                                "Electric Company",
                                                "States Avenue",
                                                "Virginia Avenue",
                                                "Pennsylvania Avenue",
                                                "St.James Place",
                                                "Community Chest",
                                                "Tennessee Avenue",
                                                "New York Avenue",
                                                "Free Parking",
                                                "Kentucky Avenue",
                                                "Chance",
                                                "Indiana Avenue",
                                                "Illinois Avenue",
                                                "B&O Avenue",
                                                "Atlantic Avenue",
                                                "Ventnor Avenue",
                                                "Water Works",
                                                "Marvin Gardens",
                                                "Go to Jail",
                                                "Pacific Avenue",
                                                "North Carolina Avenue",
                                                "Community Chest",
                                                "Pennsylvania Avenue",
                                                "Short Line",
                                                "Chance",
                                                "Park Place",
                                                "Luxury Tax",
                                                "Boardwalk"};
    String[] propertyColorArray = new String[]{ "White",
                                                "Brown",
                                                "White",
                                                "Brown",
                                                "White",
                                                "Grey",
                                                "Teal",
                                                "White",
                                                "Teal",
                                                "Teal",
                                                "White",
                                                "Purple",
                                                "Grey2",
                                                "Purple",
                                                "Purple",
                                                "Grey",
                                                "Orange",
                                                "White",
                                                "Orange",
                                                "Orange",
                                                "White",
                                                "Red",
                                                "White",
                                                "Red",
                                                "Red",
                                                "Grey",
                                                "Yellow",
                                                "Yellow",
                                                "Grey2",
                                                "Yellow",
                                                "White",
                                                "Green",
                                                "Green",
                                                "White",
                                                "Green",
                                                "Grey",
                                                "White",
                                                "Blue",
                                                "White",
                                                "Blue"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        medAve = (Button) findViewById(R.id.mediAve);
        medAve.setOnClickListener(this);

        balAve = (Button) findViewById(R.id.baltAve);
        balAve.setOnClickListener(this);

        oriAve = (Button) findViewById(R.id.orieAve);
        oriAve.setOnClickListener(this);

        verAve = (Button) findViewById(R.id.vermAve);
        verAve.setOnClickListener(this);

        conAve = (Button) findViewById(R.id.connAve);
        conAve.setOnClickListener(this);

        stcPla = (Button) findViewById(R.id.stchPla);
        stcPla.setOnClickListener(this);

        staAve = (Button) findViewById(R.id.statAve);
        staAve.setOnClickListener(this);

        virAve = (Button) findViewById(R.id.virgAve);
        virAve.setOnClickListener(this);

        stjPla = (Button) findViewById(R.id.stjaPla);
        stjPla.setOnClickListener(this);

        tenAve = (Button) findViewById(R.id.tennAve);
        tenAve.setOnClickListener(this);

        newAve = (Button) findViewById(R.id.newyAve);
        newAve.setOnClickListener(this);
        //kenAve, indAve, illAve
        kenAve = (Button) findViewById(R.id.kentAve);
        kenAve.setOnClickListener(this);

        indAve = (Button) findViewById(R.id.indiAve);
        indAve.setOnClickListener(this);

        illAve = (Button) findViewById(R.id.illiAve);
        illAve.setOnClickListener(this);
        //atlAve,venAve,marGar
        atlAve = (Button) findViewById(R.id.atlaAve);
        atlAve.setOnClickListener(this);

        venAve = (Button) findViewById(R.id.ventAve);
        venAve.setOnClickListener(this);

        marGar = (Button) findViewById(R.id.marvGar);
        marGar.setOnClickListener(this);

        pacAve = (Button) findViewById(R.id.paciAve);
        pacAve.setOnClickListener(this);

        norAve = (Button) findViewById(R.id.nortAve);
        norAve.setOnClickListener(this);

        penAve = (Button) findViewById(R.id.pennAve);
        penAve.setOnClickListener(this);

        parPla = (Button) findViewById(R.id.parkPla);
        parPla.setOnClickListener(this);

        boaWal = (Button) findViewById(R.id.boarWal);
        boaWal.setOnClickListener(this);

        reaRail = findViewById(R.id.readRail);
        reaRail.setOnClickListener(this);

        penRail = findViewById(R.id.pennRail);
        penRail.setOnClickListener(this);

        baoRail = findViewById(R.id.boarRail);
        baoRail.setOnClickListener(this);

        shoRail = findViewById(R.id.shorLine);
        shoRail.setOnClickListener(this);

        eleCom = findViewById(R.id.elecCom);
        eleCom.setOnClickListener(this);

        watCom = findViewById(R.id.watWork);
        watCom.setOnClickListener(this);
        init();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    void init(){
        for(int i=0;i<40;i++){
            String tempName = propertyNameArray[i];
            String tempColor = propertyColorArray[i];
            gameProperties[i] = new PropertyClass(tempName,tempColor,"Bank",1,false,false);
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.mediAve:
                currentPropertyIndex =1;
                break;

            case R.id.baltAve:
                currentPropertyIndex = 3;
                break;

            case R.id.orieAve:
                currentPropertyIndex = 6;
                break;

            case R.id.vermAve:
                currentPropertyIndex = 8;
                break;

            case R.id.connAve:
                currentPropertyIndex = 9;
                break;
            case R.id.stchPla:
                currentPropertyIndex = 11;
                break;
            case R.id.statAve:
                currentPropertyIndex = 13;
                break;
            case R.id.virgAve:
                currentPropertyIndex = 14;
                break;
            case R.id.stjaPla:
                currentPropertyIndex = 16;
                break;
            case R.id.tennAve:
                currentPropertyIndex = 18;
                break;
            case R.id.newyAve:
                currentPropertyIndex = 19;
                break;
            case R.id.kentAve:
                currentPropertyIndex = 21;
                break;
            case R.id.indiAve:
                currentPropertyIndex = 23;
                break;
            case R.id.illiAve:
                currentPropertyIndex = 24;
                break;
            case R.id.atlaAve:
                currentPropertyIndex = 26;
                break;
            case R.id.ventAve:
                currentPropertyIndex = 27;
                break;
            case R.id.marvGar:
                currentPropertyIndex = 29;
                break;
            case R.id.paciAve:
                currentPropertyIndex = 31;
                break;
            case R.id.nortAve:
                currentPropertyIndex = 32;
                break;
            case R.id.pennAve:
                currentPropertyIndex = 34;
                break;
            case R.id.parkPla:
                currentPropertyIndex = 37;
                break;
            case R.id.boarWal:
                currentPropertyIndex = 39;
                break;
            case R.id.readRail:
                currentPropertyIndex =5;
                break;
            case R.id.pennRail:
                currentPropertyIndex = 15;
                break;
            case R.id.boarRail:
                currentPropertyIndex = 25;
                break;
            case R.id.shorLine:
                currentPropertyIndex =35;
               break;

            case R.id.elecCom:
                currentPropertyIndex=12;
                break;

            case R.id.watWork:
                currentPropertyIndex = 28;
                break;

            default:

        }
        createIntent(currentPropertyIndex);
    }
    String a3 ="Player1" ,a1 = "0",a2 = "false";
    public void createIntent(int propertyIndex){
        tempPropertyIndex = propertyIndex;
        Log.v(TAG,"HELLLLOoooooooooooooooooooooHELLLLOoooooooooooooooooooooHELLLLOooooooooooooooooooooo");
        CognitoCachingCredentialsProvider cognitoProvider = new CognitoCachingCredentialsProvider(
                this.getApplicationContext(), "us-west-2:31343095-5334-47e9-8a87-c22b44205066", Regions.US_WEST_2);

        LambdaInvokerFactory factory = new LambdaInvokerFactory(this.getApplicationContext(),
                Regions.US_WEST_2, cognitoProvider);

        final MyInterface myInterface = factory.build(MyInterface.class);
        Log.v(TAG,"LLLLOoooooooooooooooooooooHELLLLOoooooooooooooooooooooHELLLLOooooooooooooooooooooo");
        final RequestClass request = new RequestClass(propertyIndex,"riot");
        new AsyncTask<RequestClass, Void, ResponseClass>() {
            @Override
            protected ResponseClass doInBackground(RequestClass... params) {
                // invoke "echo" method. In case it fails, it will throw a
                // LambdaFunctionException.
                try {
                    Log.v(TAG,"ELLLLOoooooooooooooooooooooHELLLLOoooooooooooooooooooooHELLLLOooooooooooooooooooooo");
                    return myInterface.monopolyCSCE656(params[0]);
                } catch (LambdaFunctionException lfe) {
                    Log.v(TAG,"HELLLLOoooooooooooooooooooooo");
                    Log.e("Tag", "Failed to invoke echo", lfe);
                    return null;
                }
            }

            @Override
            protected void onPostExecute(ResponseClass result) {
                Log.v(TAG," beign bnullLLLOoooooooooooooooooooooHELLLLOooooooooooooooooooooo");
                if (result == null) {
                    Log.v(TAG,"HELLLLOoooooooooooooooooooooHELLLLOoooooooooooooooooooooHELLLLOooooooooooooooooooooo");
                    return;


                }
                Log.v(TAG," Outside bnullLLLOoooooooooooooooooooooHELLLLOooooooooooooooooooooo");
                a1=result.getHouses();
                a2=result.getMortage();
                a3=result.getOwner();
                Log.v(TAG,result.toString());
                Intent intent = new Intent(Main2Activity.this, Update.class);
                int temp= gameProperties[tempPropertyIndex].getHousesBuilt();
                String tempString = Integer.toString(temp);
                intent.putExtra("propertyIndex", tempPropertyIndex);
                intent.putExtra("propertyName", gameProperties[tempPropertyIndex].getName());
                intent.putExtra("propertyOwner",a3);
                intent.putExtra("housingCounter",a1);
                intent.putExtra("propertyColor",gameProperties[tempPropertyIndex].getPropertyColor());
                //String mortageStringTemp = Boolean.toString(gameProperties[propertyIndex].isPropertyMortaged());
                intent.putExtra("propertyMortaged",a2);
                startActivityForResult(intent,1);

            }
        }.execute(request);



    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                result = data.getStringExtra("updatedOwner");
                mortageResult = data.getStringExtra("propertyMortaged");
                mortageResultBool = Boolean.parseBoolean(mortageResult);
                gameProperties[currentPropertyIndex].setPropertyOwner(result);
                gameProperties[currentPropertyIndex].setMortage(mortageResultBool);
                gameProperties[currentPropertyIndex].setHousesBuilt(Integer.parseInt(data.getStringExtra("houseCount")));
                CognitoCachingCredentialsProvider cognitoProvider = new CognitoCachingCredentialsProvider(
                        this.getApplicationContext(), "us-west-2:31343095-5334-47e9-8a87-c22b44205066", Regions.US_WEST_2);

                LambdaInvokerFactory factory = new LambdaInvokerFactory(this.getApplicationContext(),
                        Regions.US_WEST_2, cognitoProvider);

                final MyInterface myInterface = factory.build(MyInterface.class);
                final RequestClass request = new RequestClass(data.getStringExtra("houseCount"), result, mortageResultBool,"riot",currentPropertyIndex);
                new AsyncTask<RequestClass, Void, ResponseClass>() {
                    @Override
                    protected ResponseClass doInBackground(RequestClass... params) {
                        // invoke "echo" method. In case it fails, it will throw a
                        // LambdaFunctionException.
                        try {

                            return myInterface.monopolyCSCE656(params[0]);
                        } catch (LambdaFunctionException lfe) {
                            Log.v(TAG,"Success");
                            Log.e("Tag", "Failed to invoke echo", lfe);
                            return null;
                        }
                    }

                    @Override
                    protected void onPostExecute(ResponseClass result) {
                        Log.v(TAG,"Successfully Posted");
                        if (result == null) {
                            Log.v(TAG,"Result Null");
                            return;


                        }
                        Log.v(TAG,result.getResponseText());

                    }
                }.execute(request);

            }
        }
    }
}
