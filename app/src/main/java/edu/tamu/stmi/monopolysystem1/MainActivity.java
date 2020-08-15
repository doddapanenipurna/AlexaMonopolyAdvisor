package edu.tamu.stmi.monopolysystem1;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.lambdainvoker.LambdaFunction;
import com.amazonaws.mobileconnectors.lambdainvoker.LambdaFunctionException;
import com.amazonaws.mobileconnectors.lambdainvoker.LambdaInvokerFactory;
import com.amazonaws.regions.Regions;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button startGame;
    EditText inputGameId;
    String gameId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputGameId = (EditText) findViewById(R.id.gameId);
        startGame = (Button) findViewById(R.id.startButton);
        startGame.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this,Main2Activity.class);
        gameId= inputGameId.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,gameId);
        startActivity(intent);
    }

    public interface MyInterface {

        /**
         * Invoke the Lambda function "AndroidBackendLambdaFunction".
         * The function name is the method name.
         */
        @LambdaFunction
        ResponseClass monopolyCSCE656(RequestClass request);

    }

}
