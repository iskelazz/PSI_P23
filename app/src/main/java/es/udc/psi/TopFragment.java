package es.udc.psi;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.net.MalformedURLException;
import java.net.URL;


public class TopFragment extends Fragment implements  View.OnClickListener {

    Button but_A, but_B,but_C,but_D;
    EditText editT;
    public interface OnTopFragmlistener{
        public void onTextSelected(String text);
        public void onUriSelected(URL url);
        public void onClearSelected();
    }

    //Attach, copiarlo de los apuntes, usarlo con OnTopFragmlistener

    OnTopFragmlistener listener;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (OnTopFragmlistener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " implement OnArticleSelectedListener");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top, container, false);

        editT =view.findViewById(R.id.editT);

        but_A =view.findViewById(R.id.but_A);
        but_A.setOnClickListener(this);
        but_B =view.findViewById(R.id.but_B);
        but_B.setOnClickListener(this);
        but_C =view.findViewById(R.id.but_C);
        but_C.setOnClickListener(this);
        but_D =view.findViewById(R.id.but_D);
        but_D.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
    if (v== but_A || v== but_B){
        Button but = (Button) v;
        listener.onTextSelected(but.getText().toString());
    }
    if (v == but_C){
        String inputText = editT.getText().toString().trim();
        try {
            URL url = new URL(inputText);
            listener.onUriSelected(url);
        } catch (MalformedURLException e) {
            // La entrada no es una URL válida
        }
    }
    if (v == but_D){
        listener.onClearSelected();
    }
}
}