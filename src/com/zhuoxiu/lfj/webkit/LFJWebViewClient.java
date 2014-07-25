package com.zhuoxiu.lfj.webkit;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by zxui on 24/07/14.
 */
public class LFJWebViewClient extends WebViewClient{
	
	
	
    public LFJWebViewClient() {

    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return super.shouldOverrideUrlLoading(view, url);
    }
}
