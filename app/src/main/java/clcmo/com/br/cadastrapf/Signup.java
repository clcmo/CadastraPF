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
//import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Signup extends AppCompatActivity {
    //private Button su_buttonback, su_buttonList, su_buttonSave;
    private EditText et_su_name, et_su_nd, et_su_age, et_su_phone, et_su_mail;
    private String name, nd, age, phone, mail;
    private ListView list_users;
    //private List<String> users;
    private Intent i;
    public static final String EXTRA_MESSAGE = "br.com.clcmo.cadastrapf.List";
    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        BackButton(v);
        SaveButton(v);
        ListButton(v);
    }

    // VOLTAR A TELA INICIAL

    public void BackButton(View v) {
        //aqui, é apenas o retorno a página inicial
        i = new Intent(this, MainActivity.class);
        startActivity(i);
    }


    // SALVAR OS DADOS NO REGISTRO E ENCAMINHA-LOS AO BANCO DE DADOS

    public void SaveButton(View v){
        //preciso acrescentar aqui as informações para a List.class
        i = new Intent(this, List.class);

        et_su_name = (EditText) findViewById(R.id.et_su_name);
        et_su_nd = (EditText) findViewById(R.id.et_su_nd);
        et_su_age = (EditText) findViewById(R.id.et_su_age);
        et_su_phone = (EditText) findViewById(R.id.et_su_phone);
        et_su_mail = (EditText) findViewById(R.id.et_su_mail);

        name  = et_su_name.getText().toString();
        nd  = et_su_nd.getText().toString();
        age  = et_su_age.getText().toString();
        phone  = et_su_phone.getText().toString();
        mail = et_su_mail.getText().toString();

        i.putExtra(EXTRA_MESSAGE, name);
        i.putExtra(EXTRA_MESSAGE, nd);
        i.putExtra(EXTRA_MESSAGE, age);
        i.putExtra(EXTRA_MESSAGE, phone);
        i.putExtra(EXTRA_MESSAGE, mail);

        startActivity(i);
    }

    // IR PARA A LISTA DE DADOS REGISTRADOS

    public void ListButton(View v) {
        //aqui, ele só clica para a acessar a lista e nada mais
        i = new Intent(this, List.class);
        startActivity(i);
    }
}
