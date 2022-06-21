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

        mStringList.add("A1-Lectores-Soraya Velazques");
        mStringList.add("A1-Lectores-Sandra Medina");
        mStringList.add("A1-Lectores-Janeth Molina");
        mStringList.add("A1-Lectores-Vannesa Castillo");
        mStringList.add("A2-MEJ-John Izaguirre");
        mStringList.add("A2-MEJ-Aynoha Santos");
        mStringList.add("A2-Catequistas-María Bone");
        mStringList.add("A2-Catequistas-Wilmer Tipan");
        mStringList.add("B1-Reservados 3era Edad");
        mStringList.add("B2-Ministros-Carlos Torres");
        mStringList.add("B2-Ministros-Cecilia Sanchez");
        mStringList.add("B2-Invitados(Padre)-Ney Segura");
        mStringList.add("B2-Invitados(Padre)-Rina Alvarez");
        mStringList.add("B3-San José-Johan Andrade");
        mStringList.add("B3-San José-Vanessa Lua");
        mStringList.add("B3-Reservados-Mariuxi Pazminño");
        mStringList.add("B4-Divina Misericordia-Fanny Quinde");
        mStringList.add("B4-Divina Misericordia-Lency Olvera");
        mStringList.add("B4-Lectores-Dora Diaz");
        mStringList.add("B4-Lectores-Narcisa Calle");
        mStringList.add("B5-Ora. Barcelona-Marisol Romero");
        mStringList.add("B5-Ora. Sevilla-Gricelda Cabrera");
        mStringList.add("B5-Ora. Sevilla-Zully Vergara");
        mStringList.add("B6-Ora. Victoria-Elsie Soledispa");
        mStringList.add("B6-Ora. Victoria-Nancy Villon");
        mStringList.add("B6-Ora. Toledo-Ana Mite");
        mStringList.add("B6-Ora. Toledo-Tateana Palacios");
        mStringList.add("B7-Ora. Colina-Gloria Zambrano");
        mStringList.add("B7-Ora. Colina-Monica Santa Cruz");
        mStringList.add("B7-Ora. Geranios-Maria Fernanda Briones");
        mStringList.add("B7-Ora. Geranios-Margarita Mera");
        mStringList.add("B8-Ofrendas");
        mStringList.add("C1-Reservados 3era Edad");
        mStringList.add("C2-Monaguillos Servidores-Sara Moreno");
        mStringList.add("C2-Monaguillos Servidores-Bianca Montero");
        mStringList.add("C2-Monaguillos Servidores-Luna Macías");
        mStringList.add("C2-Monaguillos Servidores-Pedro Diaz");
        mStringList.add("C3-Monaguillos Altar-Josue Burgos");
        mStringList.add("C3-Monaguillos Altar-Kevin Martinez");
        mStringList.add("C4-Altar");
        mStringList.add("C5-Málaga-Maria Elena Sandoya");
        mStringList.add("C5-Málaga-Monica Flores Ledesma");
        mStringList.add("C5-Valencia-Amalia Montoya");
        mStringList.add("C5-Valencia-Anita Sandoya");
        mStringList.add("C6-Madrid-Mayra Córdova");
        mStringList.add("C6-Madrid-Martha Mueses");
        mStringList.add("C6-Mallorca-Marivel Anastacio");
        mStringList.add("C6-Mallorca-Bella Barreiro");
        mStringList.add("C7-FMC-Familia Duran Jimenez");
        mStringList.add("C8-Ofrendas");
        mStringList.add("D1-Vacio");
        mStringList.add("D2-Firmantes-Narcisa Bonilla");
        mStringList.add("D2-Firmantes-Ana Chuchuca");
        mStringList.add("D2-Firmantes-Nora Alvarez");
        mStringList.add("D2-Firmantes-Esperanza Peñafiel");
        mStringList.add("D3-Firmantes-Jacinto Vera");
        mStringList.add("D3-Pro Vida-Mercedes Hernandez");
        mStringList.add("D3-Pro Salud-Patricia Encalada");
        mStringList.add("D4-Legión de María-Gladys Parra");
        mStringList.add("D4-Legión de María-Narcisa Vera");
        mStringList.add("D4-Carismáticos");
        mStringList.add("D4-Cofradía del Corazón de Jesús-Elizabeth Calle");

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