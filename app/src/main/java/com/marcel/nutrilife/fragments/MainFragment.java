package com.marcel.nutrilife.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.marcel.nutrilife.R;

/**
 * Created by Marcel on 31/05/2016.
 */
public class MainFragment extends Fragment {

    //Criação das variáveis que guardarão dados
    private TextView texto, texto2;

    String assunto = "Com ele, você pode acompanhar sua dieta, visualizar dicas e acompanhar seu IMC.";
    String assunto2 = "Inicie acessando no menu superior a esquerda...";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Inflando a nova fragment
        View rootView = inflater.inflate(R.layout.fragment_main,container,false);

        //Setando os valores nos campos do XML
        texto = (TextView) rootView.findViewById(R.id.txtTexto);
        texto.setText(assunto);

        texto2 = (TextView) rootView.findViewById(R.id.txtTexto2);
        texto2.setText(assunto2);

        return rootView;
    }
}
