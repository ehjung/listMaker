package com.example.listmaker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	public final static String EXTRA_MESSAGE = ".com.example.listMaker.MESSAGE";
	ListView listView;
	
	// Called when the user clicks the add button
	public void addItem(View view) {		
		//Intent intent = new Intent(this, DisplayListActivity.class);
		EditText editText = (EditText) findViewById(R.id.add_item);
		String message = editText.getText().toString();
		//intent.putExtra(EXTRA_MESSAGE, message);
		//startActivity(intent);
		addToView(view, message);
	}
	
	// Add the item to the view
	public void addToView(View view, String message) {
		TextView textView = new TextView(this);
		textView.setTextSize(40);
		textView.setText(message);	
		
		// set the text view as the activity layout
		setContentView(textView);
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.list);
        String[] values = new String[] {"Test 1", "Test 2"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, values);
     // Assign adapter to ListView
        listView.setAdapter(adapter); 
        
        // ListView Item Click Listener
        listView.setOnItemClickListener(new OnItemClickListener() {

              @Override
              public void onItemClick(AdapterView<?> parent, View view,
                 int position, long id) {
                
               // ListView Clicked item index
               int itemPosition     = position;
               
               // ListView Clicked item value
               String  itemValue    = (String) listView.getItemAtPosition(position);
                  
                // Show Alert 
                Toast.makeText(getApplicationContext(),
                  "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                  .show();
             
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
