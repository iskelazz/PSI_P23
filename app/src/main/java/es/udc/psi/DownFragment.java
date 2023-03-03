package es.udc.psi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class DownFragment extends Fragment {
    private TextView textView;
    private WebView mWebView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_down, container, false);

        //Get the string from the bundle provided by MainActivity
        textView = view.findViewById(R.id.text_view);
        mWebView = view.findViewById(R.id.webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        return  view;
    }

    public void setText(String text) {
        textView.setText(text);
    }

    public void loadUrl(String url) {
        mWebView.loadUrl(url);
    }
}
