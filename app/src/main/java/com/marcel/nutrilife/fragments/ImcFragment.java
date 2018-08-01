package com.marcel.nutrilife.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.marcel.nutrilife.JSONParser;
import com.marcel.nutrilife.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.NumberFormat;

/**
 * Created by Marcel on 31/05/2016.
 */
public class ImcFragment extends Fragment implements View.OnClickListener{

    //Variáveis que armazenarão os dados
    private EditText Peso;
    private EditText Altura;
    private TextView Resultado;
    private TextView Situacao;
    private Button Calcular;
    private Button Limpar;
    private String pesoGravado;
    private String alturaGravada;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Inflando a Fragment
        View rootView = inflater.inflate(R.layout.fragment_imc,container,false);

        //Fazendo a ligação do campo XML com o JAVA
        Peso = (EditText) rootView.findViewById(R.id.edtPeso);
        Altura = (EditText) rootView.findViewById(R.id.edtAltura);
        Resultado = (TextView) rootView.findViewById(R.id.txtResultado);
        Situacao = (TextView) rootView.findViewById(R.id.txtSituacao);
        Calcular = (Button) rootView.findViewById(R.id.btnCalcular);
        Limpar = (Button) rootView.findViewById(R.id.btnLimpar);

        //Declarando os Botões
        Calcular.setOnClickListener(this);
        Limpar.setOnClickListener(this);

        //Setando o WebServer pela variável criada no strings.xml
        String url = getString(R.string.WebServerPessoa);

        //Nome dos atributos do banco para o Json acessar
        final String TAG_PESSOA= "pessoa";
        final String TAG_PESO = "peso";
        final String TAG_ALTURA = "altura";

        //Crio um array de imc
        JSONArray imcs = null;

        //Crio a comunicação do Banco
        JSONParser jParser = new JSONParser();
        JSONObject json = jParser.getJSONFromUrl(url);
        JSONObject objeto;

        try {
            imcs = json.getJSONArray(TAG_PESSOA);
            for(int i = 0; i < imcs.length(); i++){
                objeto = imcs.getJSONObject(i);
                //Pego cada atributo e o seto em sua campo na tela
                pesoGravado = objeto.getString(TAG_PESO);
                alturaGravada = objeto.getString(TAG_ALTURA);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //Jogo na tela os dados vindos do Json
        Peso.setText(pesoGravado);
        Altura.setText(alturaGravada);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCalcular:
                //Crio variáveis para calculo
                float res, pes, alt;

                //Passando de STRING -> FLOAT
                pes = Float.parseFloat(Peso.getText().toString());
                alt = Float.parseFloat(Altura.getText().toString());

                //Calculo do IMC
                res = (pes/(alt * alt));

                //Testando no que se enquadra a resultado do peso:
                if (res < 18.5){
                //Abaixo do Peso
                    Situacao.setText("Você está abaixo do Peso!");
                    }else if (res < 25 && res >= 18.5){
                        //Saudável
                            Situacao.setText("Sua situação é Saudável!");
                    }else if (res >= 25 && res <= 30){
                            //Sobrepeso
                            Situacao.setText("Você esta com Sobrepeso!");
                    }else if (res > 30){
                            //Obeso
                            Situacao.setText("Você pode estar Obeso!");
                    }

                //Codigo que deixa aparecer somente duas casas decimais apos a virgula
                float f = res;
                NumberFormat formatter = NumberFormat.getNumberInstance();
                formatter.setMinimumFractionDigits(2);
                formatter.setMaximumFractionDigits(2);
                String output = formatter.format(f);

                //Passando de FlOAT -> STRING
                Resultado.setText(output);
                break;

            case R.id.btnLimpar:
                //Limpando os dados da tela
                Altura.setText("");
                Peso.setText("");
                Resultado.setText("");
                Situacao.setText("");
                break;
        }
    }
}
