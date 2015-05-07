package com.example.projecttestsqlite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.exampled.mergesqlitelistview.DataBase;
import com.exampled.mergesqlitelistview.MainActivity;
import com.exampled.mergesqlitelistview.R;

public class AddSubject extends Activity {

	private Button		submit = null;
	private Button		raz = null;
	private	EditText	id = null;
	private	EditText	title = null;
	private EditText	tags = null;
	private	EditText	content = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_subject);

		submit = (Button) findViewById(R.id.submit);
		raz = (Button) findViewById(R.id.raz);
		id = (EditText) findViewById(R.id.ident);
		title = (EditText) findViewById(R.id.title);
		content = (EditText) findViewById(R.id.content);
		tags = (EditText) findViewById(R.id.tags);
		
		raz.setOnClickListener(razListener);
		submit.setOnClickListener(subListener);
	}

	@Override
    public void onDestroy()
    {
        super.onDestroy();
    }

	private OnClickListener	razListener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			id.getText().clear();
			title.getText().clear();
			content.getText().clear();
		}
	};

	private OnClickListener	subListener = new View.OnClickListener() {
						
		@Override
		public void onClick(View v)
		{
			if (id.getText().toString().isEmpty() || title.getText().toString().isEmpty() || content.getText().toString().isEmpty() || tags.getText().toString().isEmpty())
			{
				Toast.makeText(AddSubject.this, "empty field !", Toast.LENGTH_SHORT).show();
				return;
			}
			
			Subject sub = new Subject(id.getText().toString(), title.getText().toString(), content.getText().toString(), tags.getText().toString());
			try {
				SubjectDB sdb = DataBase.getDb();
				sdb.insertSubject(sub, AddSubject.this);
			} catch (Exception e) {
				Toast.makeText(AddSubject.this, "Insertion failed !", Toast.LENGTH_SHORT).show();
			}
			
			Intent intent = new Intent(AddSubject.this, MainActivity.class);
        	try {
        		startActivity(intent);
        	} catch (Exception e) {
        		Toast.makeText(AddSubject.this, "intent failed", Toast.LENGTH_SHORT).show();
        	}
			
		}
	};

}