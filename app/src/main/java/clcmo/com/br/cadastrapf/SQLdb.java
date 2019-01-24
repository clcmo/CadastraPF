//******************************************************

//Instituto Federal de São Paulo - Campus Sertãozinho

//Disciplina......: M4DADM

//Programação de Computadores e Dispositivos Móveis

//Aluno...........: CAMILA LEITE COURA MARIANO DE OLIVEIRA

//******************************************************

package clcmo.com.br.cadastrapf;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class SQLdb {

    public class CreateDB extends SQLiteOpenHelper {
        private static final String NOME_BANCO = "pessoas.db";
        private static final String TABELA = "pessoas";
        private static final String ID = "id_pes";
        private static final String NOME = "nome";
        private static final String CPF = "cpf";
        private static final String IDADE = "idade";
        private static final String TELEFONE = "telefone";
        private static final String EMAIL = "email";
        private static final int VERSAO = 1;

        //1- CRIAR BANCO DE DADOS

        public CreateDB(Context context) {
            super(context, NOME_BANCO,null, VERSAO);
        }

        //2 - INSERIR DADOS NO REGISTRO
        @Override
        public void onCreate(SQLiteDatabase db) {
            String sql = "CREATE TABLE "+ TABELA + "("
                    + ID + " integer primary key autoincrement,"
                    + NOME + " text,"
                    + CPF + " text,"
                    + IDADE + " text,"
                    + TELEFONE + " text,"
                    + EMAIL + " text"
                    +")";
            db.execSQL(sql);

        }

        //2.1 - ATUALIZAR DADOS NO REGISTRO

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABELA);
            onCreate(db);
        }
    }

    //3 - CARREGAR DADOS
    public class ControllerDb {

        private SQLiteDatabase db;
        private CreateDB banco;

        public ControllerDb(Context context){
            banco = new CreateDB(context);
        }

        public String insertData(String nome, String cpf, String idade, String telefone, String email){
            ContentValues valores;
            long resultado;

            db = banco.getWritableDatabase();
            valores = new ContentValues();
            valores.put(CreateDB.NOME, nome);
            valores.put(CreateDB.CPF, cpf);
            valores.put(CreateDB.IDADE, idade);
            valores.put(CreateDB.TELEFONE, telefone);
            valores.put(CreateDB.EMAIL, email);

            resultado = db.insert(CreateDB.TABELA, null, valores);
            db.close();

            if (resultado ==-1)
                return "Erro ao inserir registro";
            else
                return "Registro Inserido com sucesso";
        }

        public Cursor LoadData(){
            Cursor cursor;
            String[] campos = {banco.ID, banco.NOME, banco.CPF, banco.IDADE, banco.TELEFONE, banco.EMAIL};
            db = banco.getReadableDatabase();
            cursor = db.query(banco.TABELA, campos, null, null, null, null, null, null);

            if(cursor != null){
                cursor.moveToFirst();
            }
            db.close();
            return cursor;
        }
    }

    public class InsertData extends Activity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_signup);

            Button savebutton = (Button)findViewById(R.id.su_buttonSave);

            savebutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ControllerDb crud = new ControllerDb(getBaseContext());

                    EditText et_su_name = (EditText) findViewById(R.id.et_su_name);
                    EditText et_su_nd = (EditText) findViewById(R.id.et_su_nd);
                    EditText et_su_age = (EditText) findViewById(R.id.et_su_age);
                    EditText et_su_phone = (EditText) findViewById(R.id.et_su_phone);
                    EditText et_su_mail = (EditText) findViewById(R.id.et_su_mail);

                    String name  = et_su_name.getText().toString();
                    String nd  = et_su_nd.getText().toString();
                    String age  = et_su_age.getText().toString();
                    String phone  = et_su_phone.getText().toString();
                    String mail = et_su_mail.getText().toString();

                    String resultado;

                    resultado = crud.insertData(name, nd, age, phone, mail);

                    Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    //3.2 - LISTAR DADOS

    public class ListData extends Activity {
        private ListView lista;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list);

            ControllerDb crud = new ControllerDb(getBaseContext());
            Cursor cursor = crud.LoadData();

            String[] nomeCampos = new String[] {
                    CreateDB.ID, CreateDB.NOME, CreateDB.CPF,
                    CreateDB.IDADE, CreateDB.TELEFONE, CreateDB.EMAIL
            };
            int[] idViews = new int[] {
                    R.id.lv_id_person, R.id.lv_name_person, R.id.lv_nd_person, R.id.lv_age_person,
                    R.id.lv_phone_person, R.id.lv_mail_person
            };

            SimpleCursorAdapter adaptador = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
                adaptador = new SimpleCursorAdapter(getBaseContext(),
                        R.layout.activity_list,cursor,nomeCampos,idViews, 0);
            }
            lista = (ListView)findViewById(R.id.lv_dynamic);
            lista.setAdapter(adaptador);
        }
    }
}
