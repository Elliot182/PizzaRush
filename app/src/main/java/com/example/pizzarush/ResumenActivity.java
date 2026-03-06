package com.example.pizzarush;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResumenActivity extends AppCompatActivity {

    private TextView tvRestaurante, tvRubro, tvCliente, tvUsuario;
    private Button   btnVerMenu, btnRegresar, btnSalir;

    // Guardar los datos para pasarlos al menú
    private String restaurante, rubro, cliente, usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);

        // ─── Recibir datos con Bundle / getIntent().getStringExtra() ───
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            restaurante = bundle.getString("restaurante", "—");
            rubro       = bundle.getString("rubro",       "—");
            cliente     = bundle.getString("cliente",     "—");
            usuario     = bundle.getString("usuario",     "—");
        }

        // Vincular vistas
        tvRestaurante = findViewById(R.id.tvRestaurante);
        tvRubro       = findViewById(R.id.tvRubro);
        tvCliente     = findViewById(R.id.tvCliente);
        tvUsuario     = findViewById(R.id.tvUsuario);
        btnVerMenu    = findViewById(R.id.btnVerMenu);
        btnRegresar   = findViewById(R.id.btnRegresar);
        btnSalir      = findViewById(R.id.btnSalir);

        // Mostrar datos en pantalla
        tvRestaurante.setText(restaurante);
        tvRubro.setText(rubro);
        tvCliente.setText(cliente);
        tvUsuario.setText(usuario);

        // ─── Botón Ver Menú ───
        btnVerMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResumenActivity.this, MenuActivity.class);
                intent.putExtra("restaurante", restaurante);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        // ─── Botón Regresar ───
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Vuelve a RegistroActivity
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        // ─── Botón Salir ───
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cierra todas las Activities y sale de la app
                Intent intent = new Intent(ResumenActivity.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finishAffinity();
            }
        });
    }
}
