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
public class SobreFragment extends Fragment {

    //Criação de variáveis que guardarão os dados
    private TextView SobreTexto;
    private TextView ContatoTexto;
    private TextView SiteTexto;

    //Passo valores as variaveis
    String sobre = "O NUTRILIFE PODE AJUDAR VOCÊ A CONTROLAR SUA DIETA DE ACORDO COM SUA NECESSIDADE NUTRICIONAL CADASTRADA PELO SEU NUTRICIONISTA. ";
    String contato = "TELEFONE: (49) 8807 3736";
    String site = "www.nutrilife.com.br";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Inflando a Fragment
        View rootView = inflater.inflate(R.layout.fragment_sobre,container,false);

        //Passando os valores das variaveis para a tela
        SobreTexto = (TextView) rootView.findViewById(R.id.txtSobre);
        SobreTexto.setText(sobre);
        ContatoTexto = (TextView) rootView.findViewById(R.id.txtContato);
        ContatoTexto.setText(contato);
        SiteTexto = (TextView) rootView.findViewById(R.id.txtSite);
        SiteTexto.setText(site);

        return rootView;
    }
}
