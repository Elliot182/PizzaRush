package com.example.pizzarush;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

public class PlatilloAdapter extends ArrayAdapter<Platillo> {

    private Context  context;
    private List<Platillo> platillos;

    public PlatilloAdapter(@NonNull Context context, @NonNull List<Platillo> platillos) {
        super(context, 0, platillos);
        this.context   = context;
        this.platillos = platillos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Reutilizar vista para rendimiento
        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.item_platillo, parent, false);
        }

        Platillo platillo = platillos.get(position);

        TextView tvEmoji       = convertView.findViewById(R.id.tvEmoji);
        TextView tvNombre      = convertView.findViewById(R.id.tvNombrePlatillo);
        TextView tvDescripcion = convertView.findViewById(R.id.tvDescripcion);
        TextView tvPrecio      = convertView.findViewById(R.id.tvPrecio);

        tvEmoji.setText(platillo.getEmoji());
        tvNombre.setText(platillo.getNombre());
        tvDescripcion.setText(platillo.getDescripcion());
        tvPrecio.setText(platillo.getPrecio());

        return convertView;
    }
}
