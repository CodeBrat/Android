package com.codebrat.calculator;

import android.content.Context;
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
import android.widget.TextView;

/**
 * Created by Bharath on 5/3/2017.
 */

public class WebAds extends Fragment {


    TextView adView;
    ImageButton close;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ad_fragment, container, false);

        close = (ImageButton) view.findViewById(R.id.imageView_close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("####", String.valueOf(getActivity()));
                getActivity().finish();
                //getActivity().getSupportFragmentManager().beginTransaction().remove(WebAds.this).commit();
            }
        });
        adView = (TextView) view.findViewById(R.id.adPage);
        return view;

    }

}
