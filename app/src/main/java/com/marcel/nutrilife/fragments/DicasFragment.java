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
public class DicasFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Inflando a Fragment
        View rootView = inflater.inflate(R.layout.fragment_dicas,container,false);

        //Setando o WebServer pela variável criada no strings.xml
        String url = getString(R.string.WebServerDica);

        //Nome dos atributos do banco para o Json acessar
        final String TAG_DICAS= "dicas";
        final String TAG_DESCRICAO = "descricao";
        final String TAG_TIPO = "tipo";

        //Crio um array de dicas
        JSONArray dicas;

        //Crio a comunicação do Banco
        JSONParser jParser = new JSONParser();
        JSONObject json = jParser.getJSONFromUrl(url);
        JSONObject objeto;

        //Crio uma listview para mostrar os dados
        ListView lvDicas = (ListView) rootView.findViewById(R.id.listView);

        //Crio um arraylist para armazenar os dados do Json
        ArrayList arrayDicas = new ArrayList();

        try {
            dicas = json.getJSONArray(TAG_DICAS);
            //arrayDicas.add("Tipo de Dieta                    Dicas");
            for(int i = 0; i < dicas.length(); i++){
                //Pego cada atributo e o seto em sua classe
                objeto = dicas.getJSONObject(i);
                objeto.getString(TAG_TIPO);
                objeto.getString(TAG_DESCRICAO);
                //Mostro o dados do Json
                arrayDicas.add(objeto.getString(TAG_TIPO) + " -> " + objeto.getString(TAG_DESCRICAO));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //Crio a lista de array e seto os valores do Json na mesma
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, android.R.id.text1, arrayDicas);
        lvDicas.setAdapter(adapter);

        return rootView;
    }
}
