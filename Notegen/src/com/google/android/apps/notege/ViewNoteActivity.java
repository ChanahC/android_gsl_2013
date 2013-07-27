package com.google.android.apps.notege;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewNoteActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_note);
		// Get pointer to the the drawable image to show.
		int nextNoteImage = getIntent().getExtras().getInt("nextNote");
		// Grab the view that we want to set.
		ImageView viewNoteImageView = (ImageView) findViewById(R.id.meme_image);
		viewNoteImageView.setImageResource(nextNoteImage);
		// Do the same for the Note text.
		String nextNoteText = getIntent().getExtras().getString("nextNoteData");
		TextView noteTextView = (TextView) findViewById(R.id.note_text);
		noteTextView.setText(nextNoteText);
		// Hide the button!
		Button viewButton = (Button) findViewById(R.id.view_note_button);
		viewButton.setVisibility(View.GONE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_note, menu);
		return true;
	}

}
