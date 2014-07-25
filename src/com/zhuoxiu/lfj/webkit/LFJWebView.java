package com.zhuoxiu.lfj.webkit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

/**
 * Created by zxui on 24/07/14.
 */
public class LFJWebView extends WebView {
	public LFJWebViewClient webViewClient;
	public LFJWebChromeClient webChromeCLient;
	
	public LFJWebView(Context context) {
		this(context, null);
	}

	public LFJWebView(Context context, AttributeSet attrs) {
		this(context, null, 0);
	}

	@SuppressLint("SetJavaScriptEnabled")
	public LFJWebView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		webViewClient = new LFJWebViewClient();
		webChromeCLient = new LFJWebChromeClient();
		setWebViewClient(webViewClient);
		setWebChromeClient(webChromeCLient);
		getSettings().setJavaScriptEnabled(true);
	}
}
