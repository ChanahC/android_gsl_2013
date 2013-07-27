package com.parse.starter;

import android.app.Application;
import android.widget.ListView;
import android.content.Intent;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseAnalytics;
import com.parse.ParseObject;
import com.parse.ParseUser;

public class ParseApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		// Add your initialization code here
		Parse.initialize(this, "sX26oCSETYpUSGZtbF1ufihQHG5jwc2aWbZPPJWh", "XavwYK0P7nCJ2N2y2pdE4yzp2A3UGKVuxnEus47u");


		ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();
	    
		// If you would like all objects to be private by default, remove this line.
		defaultACL.setPublicReadAccess(true);
		
		ParseACL.setDefaultACL(defaultACL, true);
		
		ParseObject testObject = new ParseObject("TestObject");
		testObject.put("cs197", "is the greatest");
		testObject.saveInBackground();
		
	}

}
