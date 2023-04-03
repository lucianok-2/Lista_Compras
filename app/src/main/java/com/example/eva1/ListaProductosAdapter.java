package com.example.eva1;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListaProductosAdapter extends ArrayAdapter<String> {

    public ListaProductosAdapter(Context context, ArrayList<String> productos) {
        super(context, 0, productos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtener el producto para esta posición
        String producto = getItem(position);

        // Verificar si una vista existente está siendo reutilizada, de lo contrario, inflar la vista
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_producto, parent, false);
        }

        // Obtener referencias a los elementos en el layout de la vista
        TextView nombreProducto = (TextView) convertView.findViewById(R.id.nombre_producto);

        // Actualizar los valores de los elementos en la vista
        nombreProducto.setText(producto);

        // Devolver la vista lista para mostrar en la lista
        return convertView;
    }
}

