package gisclace.echelle;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Menu2 extends Activity {
    EditText in;
    EditText out;
    TextView rt;
    Button cal;

    int v=0;
    int w=0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_2);
        initControls();
    }
    private void initControls()
    {
        in=(EditText)findViewById(R.id.in);
        out=(EditText)findViewById(R.id.out);
        rt=(TextView)findViewById(R.id.rt);
        cal=(Button)findViewById(R.id.cal);

        cal.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick (View  v)
            {
                calculate();
            }
        });
    }
    private void calculate()
    {
        final String inTxt = in.getText().toString();
        final String outTxt = out.getText().toString();

        if (inTxt.equals("") || outTxt.equals("")) {
            rt.setText("Veuillez remplir tous les champs");
            return;
        }
        float v = Float.parseFloat(in.getText().toString());
        float w = Float.parseFloat(out.getText().toString());


        rt.setText(String.valueOf("L'échelle est de 1/"+w/v+"°"));

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