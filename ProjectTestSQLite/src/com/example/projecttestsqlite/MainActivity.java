package com.example.projecttestsqlite;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MainActivity extends Activity {

	private Button		submit = null;
	private	Button		show = null;
	private Button		raz = null;
	private	EditText	id = null;
	private	EditText	title = null;
	private	EditText	content = null;
	private	SubjectDB	sdb;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		sdb = new SubjectDB(this);
		try {
		 		sdb.open();
		 
		}catch(SQLException sqle){
		 
		 		throw sqle;
		}
		
		submit = (Button) findViewById(R.id.submit);
		show = (Button) findViewById(R.id.show);
		raz = (Button) findViewById(R.id.raz);
		id = (EditText) findViewById(R.id.ident);
		title = (EditText) findViewById(R.id.title);
		content = (EditText) findViewById(R.id.content);
		
		raz.setOnClickListener(razListener);
		submit.setOnClickListener(subListener);
		show.setOnClickListener(showListener);
	}
	

	@Override
    public void onDestroy()
    {
        super.onDestroy();
        sdb.close();
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
			if (id.getText().toString().isEmpty() || title.getText().toString().isEmpty() || content.getText().toString().isEmpty())
			{
				Toast.makeText(MainActivity.this, "empty field !", Toast.LENGTH_SHORT).show();
				return;
			}
			
			Subject sub = new Subject(id.getText().toString(), title.getText().toString(), content.getText().toString());
			try {
				sdb.insertSubject(sub, MainActivity.this);
			} catch (Exception e) {
				Toast.makeText(MainActivity.this, "Insertion failed !", Toast.LENGTH_SHORT).show();
			}
		}
	};
	
	private OnClickListener	showListener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v)
		{
			try {
				boolean check = sdb.getAllSubject(MainActivity.this);
				if (!check)
					Toast.makeText(MainActivity.this, "This DataBase is Empty", Toast.LENGTH_SHORT).show();
			} catch (Exception e) {
				e.printStackTrace();
				Toast.makeText(MainActivity.this, "show failed !", Toast.LENGTH_SHORT).show();
			}
		}
	};

}