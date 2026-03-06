package com.example.pizzarush;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    private ListView lvMenu;
    private Button   btnVolverMenu;
    private String   nombreRestaurante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Recibir nombre del restaurante
        nombreRestaurante = getIntent().getStringExtra("restaurante");
        if (nombreRestaurante == null) nombreRestaurante = "PizzaRush";

        lvMenu       = findViewById(R.id.lvMenu);
        btnVolverMenu = findViewById(R.id.btnVolverMenu);

        // ─── Crear el menú de platillos ───
        List<Platillo> menu = crearMenu();

        // ─── Configurar el Adapter personalizado ───
        PlatilloAdapter adapter = new PlatilloAdapter(this, menu);
        lvMenu.setAdapter(adapter);

        // ─── Listener al seleccionar platillo ───
        final String restauranteFinal = nombreRestaurante;
        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Platillo platillo = (Platillo) parent.getItemAtPosition(position);
                String mensaje = "Seleccionaste " + platillo.getNombre() + " – " + restauranteFinal;
                Toast.makeText(MenuActivity.this, mensaje, Toast.LENGTH_SHORT).show();
            }
        });

        // ─── Botón volver ───
        btnVolverMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }

    //emojis sacados de https://emojipedia.org/es para un menu mas vistoso
    private List<Platillo> crearMenu() {
        List<Platillo> menu = new ArrayList<>();
        menu.add(new Platillo("🍕", "Pizza Margherita",    "Tomate, mozzarella, albahaca",      "$8.50"));
        menu.add(new Platillo("🔥", "Pizza Diavola",       "Pepperoni, jalapeños, salsa roja",  "$9.50"));
        menu.add(new Platillo("🧀", "Pizza 4 Quesos",      "Mozzarella, gouda, brie, parmesano","$10.00"));
        menu.add(new Platillo("🍄", "Pizza Funghi",        "Champiñones, cebolla, orégano",     "$8.75"));
        menu.add(new Platillo("🥓", "Pizza BBQ Bacon",     "Tocino, pollo, salsa BBQ",          "$11.00"));
        menu.add(new Platillo("🌿", "Pizza Vegetariana",   "Pimientos, tomate cherry, espinaca","$8.00"));
        menu.add(new Platillo("⭐", "Pizza Rush Especial", "Receta secreta de la casa",         "$12.50"));
        return menu;
    }
}
