package clcmo.com.br.cadastrapf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Signup extends AppCompatActivity {
    private Button su_buttonback, su_buttonList, su_buttonSave;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Backbutton();
        Savebutton();
        Listbutton();
    }

    private void Backbutton() {
        su_buttonback = (Button) findViewById(R.id.su_buttonback);
        su_buttonback.setOnClickListener((View.OnClickListener) this);
    }

    private void Savebutton() {
        su_buttonSave = (Button) findViewById(R.id.su_buttonSave);
        su_buttonSave.setOnClickListener((View.OnClickListener) this);
    }

    private void Listbutton() {
        su_buttonList = (Button) findViewById(R.id.su_buttonList);
        su_buttonList.setOnClickListener((View.OnClickListener) this);
    }

    public void onClickList (View v){
        //aqui, ele só clica para a acessar a lista e nada mais
        i = new Intent(Signup.this, List.class);
        startActivity(i);
    }

    public void onClickSave (View v){
        //preciso acrescentar aqui as informações para a List.class
        i = new Intent(Signup.this, List.class);
        startActivity(i);
    }

    public void onClickBack (View v){
        //aqui, é apenas o retorno a página inicial
        i = new Intent(Signup.this, MainActivity.class);
        startActivity(i);
    }
}
