package com.marcel.nutrilife.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.marcel.nutrilife.JSONParser;
import com.marcel.nutrilife.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Marcel on 31/05/2016.
 */
public class NutricionistaFragment extends Fragment {

    //Criação de variáveis que guardarão os dados
    private String nomeGravado;
    private String telefoneGravado;
    private String emailGravado;
    private String enderecoGravado;
    private String cidadeGravada;
    private TextView nome;
    private TextView telefone;
    private TextView email;
    private TextView endereco;
    private TextView cidade;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Inflando a Fragment
        View rootView = inflater.inflate(R.layout.fragment_nutricionista,container,false);

        //Setando o WebServer pela variável criada no strings.xml
        String url = getString(R.string.WebServerNutricionista);

        //Nome dos atributos do banco para o Json acessar
        final String TAG_NUTRICIONISTA = "nutricionista";
        final String TAG_NOME = "nome";
        final String TAG_TELEFONE = "telefone";
        final String TAG_EMAIL = "email";
        final String TAG_ENDERECO = "endereco";
        final String TAG_CIDADE = "cidade";

        //Crio um array de nutricionista
        JSONArray nutricionistas = null;

        //Crio a comunicação do Banco
        JSONParser jParser = new JSONParser();
        JSONObject json = jParser.getJSONFromUrl(url);
        JSONObject c;

        try {
            nutricionistas = json.getJSONArray(TAG_NUTRICIONISTA);
            for(int i = 0; i < nutricionistas.length(); i++){
                c = nutricionistas.getJSONObject(i);

                //Pego cada atributo e o seto em sua campo na tela
                nomeGravado = c.getString(TAG_NOME);
                telefoneGravado = c.getString(TAG_TELEFONE);
                emailGravado = c.getString(TAG_EMAIL);
                enderecoGravado = c.getString(TAG_ENDERECO);
                cidadeGravada = c.getString(TAG_CIDADE);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //Seto os valores do Json para os campos na tela
        nome = (TextView) rootView.findViewById(R.id.txtNome);
        telefone = (TextView) rootView.findViewById(R.id.txtTelefone);
        email = (TextView) rootView.findViewById(R.id.txtEmail);
        endereco = (TextView) rootView.findViewById(R.id.txtEndereco);
        cidade = (TextView) rootView.findViewById(R.id.txtCidade);
        nome.setText(nomeGravado);
        telefone.setText(telefoneGravado);
        email.setText(emailGravado);
        endereco.setText(enderecoGravado);
        cidade.setText(cidadeGravada);

        return rootView;
    }
}
