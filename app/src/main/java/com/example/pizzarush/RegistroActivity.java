package com.example.pizzarush;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegistroActivity extends AppCompatActivity {

    private EditText etNombreRestaurante, etRubro, etNombreCliente;
    private Button   btnContinuar;
    private String   usuarioRecibido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        // Recibir el usuario del login
        usuarioRecibido = getIntent().getStringExtra("usuario");

        // Vincular vistas
        etNombreRestaurante = findViewById(R.id.etNombreRestaurante);
        etRubro             = findViewById(R.id.etRubro);
        etNombreCliente     = findViewById(R.id.etNombreCliente);
        btnContinuar        = findViewById(R.id.btnContinuar);

        // Pre-llenar con datos del restaurante (opcional — puedes borrar esto)
        etNombreRestaurante.setText("PizzaRush");
        etRubro.setText("Pizzería al paso");

        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                procesarFormulario();
            }
        });
    }

    private void procesarFormulario() {
        String nombreRestaurante = etNombreRestaurante.getText().toString().trim();
        String rubro             = etRubro.getText().toString().trim();
        String nombreCliente     = etNombreCliente.getText().toString().trim();

        // Validar campos
        if (nombreRestaurante.isEmpty() || rubro.isEmpty() || nombreCliente.isEmpty()) {
            Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Enviar datos a la siguiente Activity
        Intent intent = new Intent(RegistroActivity.this, ResumenActivity.class);
        intent.putExtra("restaurante", nombreRestaurante);
        intent.putExtra("rubro",       rubro);
        intent.putExtra("cliente",     nombreCliente);
        intent.putExtra("usuario",     usuarioRecibido);

        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
