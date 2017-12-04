package com.inventivestack.androidspinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Spinner spinner1, spinner2;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        itemsAddOnSpinner2();// adding item on spinner 2

        spinner1.setOnItemSelectedListener(new ItemListener());
        spinner2.setOnItemSelectedListener(new ItemListener());

        button.setOnClickListener(this);
    }

    // add items into spinner 2 dynamically
    private void itemsAddOnSpinner2() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add("Item " + i);
        }
        //Creating array adapter for spinner 2
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View view) {
        // geating the selected dropdown list value on button click
        textView.setText("OnClickListener : " +
                "\nSpinner 1 : " + String.valueOf(spinner1.getSelectedItem()) +
                "\nSpinner 2 : " + String.valueOf(spinner2.getSelectedItem()));
    }

    //Creating custom class for spinner item select listener
    public class ItemListener implements OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            Toast.makeText(parent.getContext(),
                    "Item Selected : " + parent.getItemAtPosition(pos).toString(),
                    Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }

    }
}
