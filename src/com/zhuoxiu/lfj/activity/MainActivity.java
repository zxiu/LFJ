package com.zhuoxiu.lfj.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import angel.zhuoxiu.library.mail.MailHelper;
import com.zhuoxiu.lfj.R;
import com.zhuoxiu.lfj.webkit.LFJWebView;

/**
 * Created by zxui on 23/07/14.
 */
public class MainActivity extends FragmentActivity {
	LFJWebView wv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button addImage = (Button) findViewById(R.id.send_email);
		addImage.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				new SendEmailTask().execute();
			}
		});
//		wv = new LFJWebView(this);
//		wv.loadUrl(Stepstone.getInstance().getSearchUrl("kaiserslautern", "android"));
//		setContentView(wv);
	}

	class SendEmailTask extends AsyncTask<Void, Void, Boolean> {

		@Override
		protected Boolean doInBackground(Void... params) {
			MailHelper mHelper = new MailHelper("xiuzhuo2012@gmail.com", "mpudytnsjtjyfejf");

			String[] toArr = { "xiuzhuo@outlook.com" };
			mHelper.setTo(toArr);
			mHelper.setFrom("xiuzhuo2012@gmail.com");
			mHelper.setSubject("This is an email sent using my Mail JavaMail wrapper from an Android device.");
			mHelper.setBody("Email body.");
			boolean result = false;
			try {
				result = mHelper.send();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}

		@Override
		protected void onPostExecute(Boolean result) {
			if (result) {
				Toast.makeText(MainActivity.this, "Email was sent successfully.", Toast.LENGTH_LONG).show();
			} else {
				Toast.makeText(MainActivity.this, "Email was not sent.", Toast.LENGTH_LONG).show();
			}
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_BACK:
			if (wv.canGoBack()) {
				wv.goBack();
			} else {
				finish();
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
