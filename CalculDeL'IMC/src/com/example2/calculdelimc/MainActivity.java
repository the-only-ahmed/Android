package com.example2.calculdelimc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MainActivity extends Activity {
	private Button			imc = null;
	private Button			raz = null;
	private EditText		poid = null;
	private	EditText		taille = null;
	private	TextView		result = null;
	private	RadioGroup		radio = null;
	private	CheckBox		box = null;
	private static String	text = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		if (text.isEmpty() == true)
			text = getResources().getString(R.string.result);
		
		imc = (Button) findViewById(R.id.imc);
		raz = (Button) findViewById(R.id.raz);
		poid = (EditText) findViewById(R.id.weight);
		taille = (EditText) findViewById(R.id.height);
		result = (TextView) findViewById(R.id.result);
		radio = (RadioGroup) findViewById(R.id.radio);
		box = (CheckBox) findViewById(R.id.check);
		
		poid.addTextChangedListener(watcher);
		taille.addTextChangedListener(watcher);
		
		imc.setOnClickListener(imcListener);
		raz.setOnClickListener(razListener);
	}
	
	private OnClickListener	imcListener = new View.OnClickListener() {
		private float		w, h;
		
		@Override
		public void onClick(View v) {
			if (poid.getText().toString().isEmpty() || taille.getText().toString().isEmpty())
			{
				Toast.makeText(MainActivity.this, "empty field !", Toast.LENGTH_SHORT).show();
				return;
			}
			
			w = Integer.valueOf(poid.getText().toString()).floatValue();
			h = Integer.valueOf(taille.getText().toString()).floatValue();
			
			if (w <= 0 || h <= 0)
			{
				Toast.makeText(MainActivity.this, "height or weight null or negative !", Toast.LENGTH_SHORT).show();
				return;
			}
			
			if (box.isChecked())
				Toast.makeText(MainActivity.this, "Fuck You Bastard!", Toast.LENGTH_SHORT).show();
			
			if (radio.getCheckedRadioButtonId() == R.id.cent)
				h /= 100;
			result.setText(String.valueOf(w / h));
		}
	};
	
	private OnClickListener	razListener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			poid.getText().clear();
			taille.getText().clear();
			result.setText(text);
		}
	};
	
	private TextWatcher watcher = new TextWatcher() {
		
		@Override
		public void	onTextChanged(CharSequence s, int start, int count, int after) {
			result.setText(text);
		}
		
		@Override
		public void	afterTextChanged(Editable s) {
			
		}
		
		@Override
		public void beforeTextChanged(CharSequence s, int start, int before, int count) {
			
		}
	};

}
