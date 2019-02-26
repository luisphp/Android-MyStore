package com.example.luishurtado.mystore;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by luis.hurtado on 28/05/2018.
 */
public class FragmentMiCuenta extends Fragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_mi_cuenta, container, false);

        TextView texto1 = (TextView) view.findViewById(R.id.MiCuentatxt);

        texto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getActivity(),"Hola Mundo",Toast.LENGTH_SHORT).show();


            }
        });

        return view;
    }
}
