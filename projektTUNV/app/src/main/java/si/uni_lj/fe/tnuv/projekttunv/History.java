package si.uni_lj.fe.tnuv.projekttunv;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class History extends AppCompatActivity {

    private String name = ReceiveSms.getName();
    private String number = ReceiveSms.getNumber();
    private String location = ReceiveSms.getLocation();
    private String type = ReceiveSms.getType();
    private ArrayList names;
    private ListView lv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        names = ReceiveSms.getNames();

        lv = (ListView) findViewById(R.id.listView);
        lv.setOnItemClickListener((parent, view, position, id) ->
                Toast.makeText(this, "Izbral si zgodovino za: " + names.get(position), Toast.LENGTH_SHORT).show());
                Intent intent = new Intent(si.uni_lj.fe.tnuv.projekttunv.History.this, PatientHistory.class);
                startActivity(intent);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                names);

        lv.setAdapter(arrayAdapter);
    }

}