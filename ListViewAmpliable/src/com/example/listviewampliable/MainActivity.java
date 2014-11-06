package com.example.listviewampliable;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.*;


public class MainActivity extends Activity {

	//Hello world!

	public EditText ETNombre,ETControl;
	public TextView LblControl;
	public ListView LVDatos;
	public Button BtnAdd;
	
	public String[] nocontrol;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		BtnAdd=(Button)findViewById(R.id.button1);
		ETNombre=(EditText)findViewById(R.id.txtNombre);
		LblControl=(TextView)findViewById(R.id.lblControl);
		ETControl=(EditText)findViewById(R.id.txtControl);
		LVDatos=(ListView)findViewById(R.id.listView1);
		
		final ArrayList<String> ListaDatos=new ArrayList<String>();
		final ArrayList<String> ControlDatos=new ArrayList<String>();
		final ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ListaDatos);
		LVDatos.setAdapter(mAdapter);
		
		LVDatos.setOnItemClickListener(new AdapterView.OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
				LblControl.setText(ControlDatos.get(pos));
			
				
			}
		});
		BtnAdd.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ListaDatos.add(ETNombre.getText().toString());
				ControlDatos.add(ETControl.getText().toString());
				mAdapter.notifyDataSetChanged();
				ETNombre.setText("");
				ETControl.setText("");
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
}
