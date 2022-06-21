package ec.fede.demo.recepcion;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import ec.fede.demo.recepcion.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    private ListView mSearchNFilterLv;
    private EditText mSearchEdt;
    private ArrayList<String> mStringList;
    private ValueAdapter valueAdapter;
    private TextWatcher mSearchTw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //setSupportActionBar(binding.toolbar);

        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        //appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        //binding.fab.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //                .setAction("Action", null).show();
        //    }
        //});

        initUI();

        initData();

        valueAdapter=new ValueAdapter(mStringList,this);

        mSearchNFilterLv.setAdapter(valueAdapter);

        mSearchEdt.addTextChangedListener(mSearchTw);
    }

    private void initData() {

        mStringList=new ArrayList<String>();

        mStringList.add("A1-Lectores y Salmistas");
        mStringList.add("A2-Lectores y Salmistas");

        mStringList.add("A4-Tercera Edad y Discapacitados");
        mStringList.add("A5-Tercera Edad y Discapacitados");
        mStringList.add("A6-Tercera Edad y Discapacitados");
        mStringList.add("A7-Tercera Edad y Discapacitados");

        mStringList.add("A8-Oratorios");
        mStringList.add("A9-Oratorios");
        mStringList.add("B8-Oratorios");
        mStringList.add("B9-Oratorios");

        mStringList.add("B2-Legión de María");
        mStringList.add("C1-Legión de María");
        mStringList.add("C2-Legión de María");

        mStringList.add("B3-Monaguillos");

        mStringList.add("B4-Cofradía San José");
        mStringList.add("B5-Catequistas");
        mStringList.add("B6-Catequistas");

        mStringList.add("B7-Renovación Carismática");
        mStringList.add("C3-Movimiento Eucarístico Juvenil");
        mStringList.add("C4-Movimiento Eucarístico Juvenil");

        mStringList.add("C5-Divina Misericordia");

        mStringList.add("C6-Familias Misioneras de Cristo");
        mStringList.add("C7-Familias Misioneras de Cristo");


        mSearchTw=new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                valueAdapter.getFilter().filter(s);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

    }

    private void initUI() {

        mSearchNFilterLv=(ListView) findViewById(R.id.list_view);

        mSearchEdt=(EditText) findViewById(R.id.txt_search);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}