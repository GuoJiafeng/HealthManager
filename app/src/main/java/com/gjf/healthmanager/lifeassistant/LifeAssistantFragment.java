package com.gjf.healthmanager.lifeassistant;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.gjf.healthmanager.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by BlackBeard丶 on 2017/04/10.
 */

public class LifeAssistantFragment extends Fragment {
    @BindView(R.id.life_assistant_fragment_webview)
    WebView lifeAssistantFragmentWebview;
    Unbinder unbinder;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.life_assistant_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);

        lifeAssistantFragmentWebview.loadUrl("http://m.meishichina.com");
        WebSettings webSettings = lifeAssistantFragmentWebview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        lifeAssistantFragmentWebview.setWebChromeClient(new WebChromeClient());
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
