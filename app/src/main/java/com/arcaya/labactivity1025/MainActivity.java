package com.arcaya.labactivity1025;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] verNames, relDates;
    int[] logos = {R.drawable.cupcake,R.drawable.donut,R.drawable.eclair,R.drawable.froyo,R.drawable.gingerbread,
            R.drawable.honeycomb,R.drawable.icecreamsandwich,R.drawable.jellybean,R.drawable.kitkat};
    ArrayList<AndroidVersions> versions = new ArrayList<>();

    ListView listVersions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verNames = getResources().getStringArray(R.array.verName);
        relDates = getResources().getStringArray(R.array.relDate);
        for (int i=0; i < verNames.length; i++){
            versions.add(i, new AndroidVersions(logos[i], verNames[i], relDates[i]));
        }

        AndroidAdapter adapter = new AndroidAdapter(this, R.layout.item,versions);

        listVersions = findViewById(R.id.lvAndroid);
        listVersions.setAdapter(adapter);
        listVersions.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, final int i, long id) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setIcon(logos[i]);
        dialog.setTitle(verNames[i]);
        dialog.setMessage(verNames[i] + " was released on " + relDates[i] + ".");
        dialog.setNeutralButton("CLOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, verNames[i],Toast.LENGTH_LONG).show();
            }
        });
        dialog.create().show();
    }
}
