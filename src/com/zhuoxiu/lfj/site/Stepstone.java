package com.zhuoxiu.lfj.site;

import com.zhuoxiu.lfj.bean.Parameter;

/**
   http://www.stepstone.de/5/job-ergebnisse.html?&li=500&ws=Stuttgart&ke=android
 
 * Created by zxui on 24/07/14.
 */
public class Stepstone {
	static String scheme = "http";
	static String domain = "www.stepstone.de";
	static String path_search = "/5/job-ergebnisse.html?";
	static int port = 80;
	Parameter ws = new Parameter("ws", "location");
	Parameter ke = new Parameter("ke", "keyword");
	Parameter li = new Parameter("li", "count per page").setValue("500");

	public static Stepstone getInstance() {
		return new Stepstone();
	}

	private Stepstone() {

	}

	public String getSearchUrl(String location, String keyword) {
		return scheme + "://" + domain + path_search + ws.setValue(location) + ke.setValue(keyword) + li;
	}
}
