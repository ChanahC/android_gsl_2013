package com.google.android.apps.notege;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CreateNoteActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_note);
		final Button viewNoteButton = (Button) findViewById(R.id.view_note_button);
		viewNoteButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Toast.makeText(CreateNoteActivity.this,
				// "You clicked a button!", Toast.LENGTH_LONG).show();
				// Ship the user to view-note screen via EXPLICIT intent.
				Intent viewNoteActivityIntent = new Intent(
						CreateNoteActivity.this, ViewNoteActivity.class);
				viewNoteActivityIntent.putExtra("nextNote", R.drawable.fun);
				viewNoteActivityIntent.putExtra("nextNoteData",
						"Let's have fun!");
				startActivity(viewNoteActivityIntent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_note, menu);
		return true;
	}

}
