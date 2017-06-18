package com.gjf.healthmanager.onlinesearch;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.gjf.healthmanager.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by BlackBeard丶 on 2017/04/10.
 */

public class OnlinSearcherFragment extends Fragment {

    Unbinder unbinder;
    @BindView(R.id.online_search_fragment_webview)
    WebView onlineSearchFragmentWebview;
    private View view;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.online_search_fragment, container, false);


        unbinder = ButterKnife.bind(this, view);

        onlineSearchFragmentWebview.loadUrl("https://wapbaike.baidu.com");
        WebSettings webSettings = onlineSearchFragmentWebview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        onlineSearchFragmentWebview.setWebViewClient(new WebViewClient());
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
