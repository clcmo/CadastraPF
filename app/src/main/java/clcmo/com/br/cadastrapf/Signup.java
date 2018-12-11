package clcmo.com.br.cadastrapf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Signup extends AppCompatActivity {
    private Button su_buttonback, su_buttonList, su_buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        createBackbutton();
        createSavebutton();
        createListbutton();

    }

    private void createBackbutton() {
        su_buttonback = (Button) findViewById(R.id.su_buttonback);
        su_buttonback.setOnClickListener((View.OnClickListener) this);
    }

    private void createSavebutton() {
        su_buttonSave = (Button) findViewById(R.id.su_buttonSave);
        su_buttonSave.setOnClickListener((View.OnClickListener) this);
    }

    private void createListbutton() {
        su_buttonList = (Button) findViewById(R.id.gotoSignup);
        su_buttonList.setOnClickListener((View.OnClickListener) this);
    }

    public void onClick (View v){
        Intent intent = new Intent(Signup.this, List.class);
        startActivity(intent);
    }


}
