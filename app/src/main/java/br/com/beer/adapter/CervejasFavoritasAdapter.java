package br.com.beer.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.beer.R;
import br.com.beer.dao.CervejasDAO;
import br.com.beer.database.CervejaDatabaseROOM;
import br.com.beer.model.Cerveja;

public class CervejasFavoritasAdapter extends RecyclerView.Adapter<CervejaViewHolder> {
    private final CervejasDAO cervejas;

    public CervejasFavoritasAdapter(CervejasDAO cervejas) {

        this.cervejas = cervejas;
    }

    @NonNull
    @Override
    public CervejaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflateCervejasFavoritadas = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cerveja_item, parent, false);

        return new CervejaViewHolder(inflateCervejasFavoritadas);
    }

    @Override
    public void onBindViewHolder(@NonNull CervejaViewHolder holder, int position) {
        final Cerveja cerveja = cervejas.getAll().get(position);
        holder.bind(cerveja);
    }

    @Override
    public int getItemCount() {
        return cervejas != null ? cervejas.getAll().size()  : 0;
    }
}
