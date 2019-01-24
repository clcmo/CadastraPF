//******************************************************

//Instituto Federal de São Paulo - Campus Sertãozinho

//Disciplina......: M4DADM

//Programação de Computadores e Dispositivos Móveis

//Aluno...........: CAMILA LEITE COURA MARIANO DE OLIVEIRA

//******************************************************

package clcmo.com.br.cadastrapf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
/*import android.view.View.OnClickListener;
import android.widget.Button;*/

public class MainActivity extends AppCompatActivity {
    //private Button gotoSignup;
    private View v;
    private Intent i;

    // IR PARA A TELA DE CADASTRO
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gotoButton(v);
    }

    public void gotoButton(View v) {
        i = new Intent(this, Signup.class);
        startActivity(i);
    }
}
