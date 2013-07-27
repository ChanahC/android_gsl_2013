package com.parse.starter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

import com.parse.ParseAnalytics;
import com.parse.ParseObject;
import com.parse.ParseQueryAdapter;

public class ParseStarterProjectActivity extends Activity implements OnItemClickListener{
	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ParseAnalytics.trackAppOpened(getIntent());
		ListView listView = (ListView) findViewById(R.id.shoppingList);
		//String[] shopping = getResources().getStringArray(R.array.shopping_array);
		//listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, shopping));
		final ParseQueryAdapter adapter = new ParseQueryAdapter(this, "ShoppingList");
		adapter.setTextKey("item");
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
		EditText editText = (EditText) findViewById(R.id.addShoppingItem);
		editText.setOnEditorActionListener(new OnEditorActionListener() {
		@Override
		public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
			boolean handled = false;
			if (actionId == EditorInfo.IME_ACTION_SEND) {
				InputMethodManager inputManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
				inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
				String value = v.getText().toString();
				ParseObject shoppingList = new ParseObject("ShoppingList");
				shoppingList.put("item", value);
				shoppingList.put("purchased", false);
				shoppingList.saveInBackground();
				Toast.makeText(getApplicationContext(), value+" added to your list",Toast.LENGTH_SHORT).show();
				v.setText("");
				handled = true;
			}
				adapter.loadObjects();
				return handled;
			}
		});
	}
	public void onItemClick(AdapterView<?> adapter, View view,int position, long id) {
		Toast.makeText(getApplicationContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
	}
}
