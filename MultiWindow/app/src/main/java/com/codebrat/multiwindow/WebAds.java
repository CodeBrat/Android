package com.codebrat.multiwindow;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

/**
 * Created by Bharath on 5/3/2017.
 */

public class WebAds extends Fragment {

    WebView adView;
    ImageButton close;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ad_fragment, container, false);

        close = (ImageButton) view.findViewById(R.id.imageView_close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("####", String.valueOf(getActivity()));
                Fragment current = getActivity().getSupportFragmentManager().findFragmentByTag("fragmentTag");
//                getActivity().getSupportFragmentManager().getFragment("WEBADS").finish();
                getActivity().getSupportFragmentManager().beginTransaction().remove(WebAds.this).commit();
            }
        });
        adView = (WebView) view.findViewById(R.id.adPage);
        adView.setWebViewClient(new WebViewClient());
        adView.getSettings().setJavaScriptEnabled(true);
        String website = getArguments().getString("website");
        adView.loadUrl(website);
        return view;

    }

}
