package com.example.eva1;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.ProductoViewHolder> {

    private Context context;
    private List<Producto> listaProductos;

    public ProductosAdapter(Context context, List<Producto> listaProductos) {
        this.context = context;
        this.listaProductos = listaProductos;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_producto, parent, false);
        return new ProductoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        Producto producto = listaProductos.get(position);
        holder.nombreProducto.setText(producto.getNombre());
        holder.precioProducto.setText(String.valueOf(producto.getPrecio()));
        holder.fechaVencimientoProducto.setText(producto.getFechaVencimiento());
        holder.cantidadProducto.setText(String.valueOf(producto.getCantidad()));
        holder.idProducto = producto.getId();
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public static class ProductoViewHolder extends RecyclerView.ViewHolder {
        public TextView nombreProducto, precioProducto, fechaVencimientoProducto, cantidadProducto;
        public int idProducto;

        public ProductoViewHolder(View itemView) {
            super(itemView);
            nombreProducto = itemView.findViewById(R.id.nombre_producto);
            precioProducto = itemView.findViewById(R.id.precio_producto);
            fechaVencimientoProducto = itemView.findViewById(R.id.fecha_vencimiento_producto);
            cantidadProducto = itemView.findViewById(R.id.cantidad_producto);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context,modificar.class);
                    intent.putExtra("ID", idProducto);
                    context.startActivity(intent);

                }
            });
        }
    }
}
