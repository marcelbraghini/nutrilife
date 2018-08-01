package com.marcel.nutrilife.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.marcel.nutrilife.JSONParser;
import com.marcel.nutrilife.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Marcel on 31/05/2016.
 */
public class DietaFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Inflando a Fragment
        final View rootView = inflater.inflate(R.layout.fragment_dieta, container, false);

        //Setando o WebServer pela variável criada no strings.xml
        String url = getString(R.string.WebServerDieta);

        //Nome dos atributos do banco para o Json acessar
        final String TAG_DIETA= "dieta";
        final String TAG_DESCRICAO = "descricao";
        final String TAG_HORA = "hora";
        final String TAG_DATA = "data";
        final String TAG_TIPODIETA = "tipodieta";
        final String TAG_TIPOREFEICAO = "tiporefeicao";
        final String TAG_ALIMENTO = "alimento";
        final String TAG_CATEGORIA = "categoria";
        final String TAG_QUANT = "quant";

        //Crio um array de dietas
        JSONArray dietas;

        //Crio a comunicação do Banco
        JSONParser jParser = new JSONParser();
        JSONObject json = jParser.getJSONFromUrl(url);
        JSONObject objeto;

        //Crio uma listview para mostrar os dados
        ListView lvDieta = (ListView) rootView.findViewById(R.id.ListaDieta);

        //Crio um arraylist para armazenar os dados do Json
        ArrayList arrayDeta = new ArrayList();

        try {
            dietas = json.getJSONArray(TAG_DIETA);
            for(int i = 0; i < dietas.length(); i++){
                //Pego cada atributo e o seto em sua classe
                objeto = dietas.getJSONObject(i);
                objeto.getString(TAG_DESCRICAO);
                objeto.getString(TAG_HORA);
                objeto.getString(TAG_DATA);
                objeto.getString(TAG_TIPODIETA);
                objeto.getString(TAG_TIPOREFEICAO);
                objeto.getString(TAG_ALIMENTO);
                objeto.getString(TAG_CATEGORIA);
                objeto.getString(TAG_QUANT);

                //Mostro o dados do Json
                arrayDeta.add(objeto.getString(TAG_DATA) + "          " + objeto.getString(TAG_HORA) + "          " + objeto.getString(TAG_DESCRICAO) + "          " + objeto.getString(TAG_TIPOREFEICAO) + "                    " + objeto.getString(TAG_QUANT) + "                    " + objeto.getString(TAG_ALIMENTO) );
                //arrayDeta.add(objeto.getString(TAG_TIPOREFEICAO) + " - " + objeto.getString(TAG_QUANT) + " - " + objeto.getString(TAG_ALIMENTO));

                }
            }catch (JSONException e) {
            e.printStackTrace();
        }

        //Crio a lista de array e seto os valores do Json na mesma
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, android.R.id.text1, arrayDeta);
        lvDieta.setAdapter(adapter);

        return rootView;
    }
}





