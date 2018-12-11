package clcmo.com.br.cadastrapf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    private Button gotoSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createbutton();
    }

    private void createbutton() {
        gotoSignup = (Button) findViewById(R.id.gotoSignup);
        gotoSignup.setOnClickListener((OnClickListener) this);
    }

    public void onClick (View v){
        Intent intent = new Intent(MainActivity.this, Signup.class);
        startActivity(intent);
    }
}
