package clcmo.com.br.cadastrapf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    private Button gotoSignup;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gotoButton();
    }

    private void gotoButton() {
        gotoSignup = (Button) findViewById(R.id.gotoSignup);
        gotoSignup.setOnClickListener((OnClickListener) this);
    }

    public void onClick (View v){
        i = new Intent(MainActivity.this, Signup.class);
        startActivity(i);
    }
}
