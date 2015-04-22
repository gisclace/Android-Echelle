package gisclace.echelle;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class Menu1 extends Activity {

    EditText fac;
    EditText cote;
    TextView tt;
    Button calculate;
    int v=0;

    private ListView maListViewPerso;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_1);
        initControls();
        maListViewPerso = (ListView) findViewById(R.id.listviewperso);
        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();

        HashMap<String, String> map;

        map = new HashMap<String, String>();
        map.put("nom", "1/2°");
        map.put("facteur", "2");
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("nom", "1/5°");
        map.put("facteur", "5");
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("nom", "1/10°");
        map.put("facteur", "10");
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("nom", "1/15°");
        map.put("facteur", "15");
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("nom", "1/20°");
        map.put("facteur", "20");
        listItem.add(map);


        map = new HashMap<String, String>();
        map.put("nom", "1/25°");
        map.put("facteur", "25");
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("nom", "1/50°");
        map.put("facteur", "50");
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("nom", "1/100°");
        map.put("facteur", "100");
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("nom", "1/500°");
        map.put("facteur", "500");
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("nom", "1/1000°");
        map.put("facteur", "1000");
        listItem.add(map);

        //Création d'un SimpleAdapter qui se chargera de mettre les items présent dans notre list (listItem) dans la vue affichageitem
        SimpleAdapter mSchedule = new SimpleAdapter (this.getBaseContext(), listItem, R.layout.affichageitems,
                new String[] { "nom"}, new int[] { R.id.nom});

        maListViewPerso.setAdapter(mSchedule);

        //Enfin on met un écouteur d'évènement sur notre listView
        maListViewPerso.setOnItemClickListener(new OnItemClickListener() {
            @Override
            @SuppressWarnings("unchecked")
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                HashMap<String, String> map = (HashMap<String, String>) maListViewPerso.getItemAtPosition(position);
                fac.setText(map.get("facteur"));

            }
        });
    }
    private void initControls()
    {
        fac=(EditText)findViewById(R.id.fac);
        cote=(EditText)findViewById(R.id.cote);
        tt=(TextView)findViewById(R.id.tt);
        calculate=(Button)findViewById(R.id.calculate);

        calculate.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick (View  v)
            {
                calculate();
            }
        });
    }

    private void calculate()
    {
        final String loginTxt = fac.getText().toString();
        final String passTxt = cote.getText().toString();

        if (loginTxt.equals("") || passTxt.equals("")) {
            tt.setText("Veuillez remplir tous les champs");
            return;
        }
        float v = Float.parseFloat(fac.getText().toString());
        float w = Float.parseFloat(cote.getText().toString());

            tt.setText(String.valueOf( v * w ));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}