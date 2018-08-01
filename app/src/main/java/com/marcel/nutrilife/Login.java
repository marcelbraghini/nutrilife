package com.marcel.nutrilife;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {
    //Criando variáveis para armazenar dados gravados
    String loginGravado;
    String senhaGravada;

    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Chamando os campos do XML
        final EditText login = (EditText) findViewById(R.id.edtLogin);
        final EditText senha = (EditText) findViewById(R.id.edtSenha);

        Button entrar = (Button) findViewById(R.id.btnEntrar);
        Button limpar = (Button) findViewById(R.id.btnLimpar);

        //Criando ação aos botões
        assert entrar != null;
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Setando o WebServer pela variável criada no strings.xml
                String url = getApplicationContext().getString(R.string.WebServerPessoa);

                //Nome dos atributos do banco para o Json acessar
                final String TAG_PESSOA = "pessoa";
                final String TAG_USUARIO = "usuario";
                final String TAG_SENHA = "senha";

                //Crio um array de imc
                JSONArray pessoas = null;

                //Crio a comunicação do Banco
                JSONParser jParser = new JSONParser();
                JSONObject json = jParser.getJSONFromUrl(url);
                JSONObject objeto;

                try {
                    pessoas = json.getJSONArray(TAG_PESSOA);
                    for(int i = 0; i < pessoas.length(); i++){
                        objeto = pessoas.getJSONObject(i);

                        //Pego cada atributo e o seto em sua campo na tela
                        loginGravado = objeto.getString(TAG_USUARIO);
                        senhaGravada = objeto.getString(TAG_SENHA);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                //Salvo os dados do Json em variável
                String strLogin = login.getText().toString();
                String strSenha = senha.getText().toString();

                //Valido se os dados são compativeis
                if (strLogin.equals(loginGravado) && strSenha.equals(senhaGravada)) {
                    //Toast.makeText(Login.this, "Seja Bem Vindo!!!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                } else {
                    Toast.makeText(Login.this, "Login ou Senha estão Incorretos!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Limpo os campos da tela
        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login.setText("");
                senha.setText("");
                Toast.makeText(Login.this, "Limpeza Concluida!", Toast.LENGTH_SHORT).show();
            }
        });
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Login Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.marcel.nutrilife/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Login Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.marcel.nutrilife/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
} //FIM DE CODIGO
