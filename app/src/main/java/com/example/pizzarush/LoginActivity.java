package com.example.pizzarush;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    // ─────────────────────────────────────────────────
    //  CREDENCIALES
    // ─────────────────────────────────────────────────
    private static final String USUARIO_VALIDO   = "ebaudriz";
    private static final String PASSWORD_VALIDA  = "pizza123";

    private EditText etUsuario, etPassword;
    private Button   btnIngresar;
    private TextView tvOlvide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Vincular vistas
        etUsuario   = findViewById(R.id.etUsuario);
        etPassword  = findViewById(R.id.etPassword);
        btnIngresar = findViewById(R.id.btnIngresar);


        // Listener botón Ingresar
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarLogin();
            }
        });

        // Listener enlace olvidé contraseña

    }

    private void validarLogin() {
        String usuario  = etUsuario.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        // Regla 1: campos vacíos
        if (usuario.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Complete los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Regla 2: credenciales correctas
        if (usuario.equals(USUARIO_VALIDO) && password.equals(PASSWORD_VALIDA)) {
            // Pasar el usuario a la siguiente pantalla
            Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
            intent.putExtra("usuario", usuario);
            startActivity(intent);
            // Animación de transición suave
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        } else {
            Toast.makeText(this, "Usuario o contraseña incorrectos ", Toast.LENGTH_SHORT).show();
        }
    }
}
