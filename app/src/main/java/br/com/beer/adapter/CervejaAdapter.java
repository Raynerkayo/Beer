package br.com.beer.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.beer.R;
import br.com.beer.database.CervejaDatabase;
import br.com.beer.model.Cerveja;

public class CervejaAdapter extends RecyclerView.Adapter<CervejaViewHolder> {

    private final List<Cerveja> cervejas;
    private final CervejaDatabase db;

    public CervejaAdapter(List<Cerveja> cervejas) {
        this.cervejas = cervejas;
        db = new CervejaDatabase();
    }

    //serve para carregar a view para o mostrar o usuário.
    @Override
    public CervejaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.cerveja_item, parent, false
        );

        return new CervejaViewHolder(view);
    }

    //Quando é preciso reciclar uma view. No caso, quando ultrapassa o tamanho da tela na qtd
    //e o usuário rola a tela para ver mais dados.
    @Override
    public void onBindViewHolder(@NonNull CervejaViewHolder holder, final int position) {
        //definir já uma cerveja para ser mostrada
        final Cerveja cerveja = cervejas.get(position);
        holder.imageFavorite.setOnClickListener(
                view -> {
                    notifyItemChanged(position);
                    if (cerveja.getFavorite()){
                        cerveja.setFavorite(false);
                        addFavorite(cerveja, position);
                        System.out.println("FALSE ***" + cerveja.getFavorite());
                    } else{
                        cerveja.setFavorite(true);
                        addFavorite(cerveja, position);
                        System.out.println("TRUE ***" + cerveja.getFavorite());
                    }
                });
        holder.bind(cerveja);
    }

    private void addFavorite(Cerveja cerveja, int position) {
        notifyItemChanged(position);

        List<Cerveja> cervejasFavoritas = new ArrayList<>();
        if(!cervejasFavoritas.contains(cerveja) && cerveja.getFavorite()){
            cervejasFavoritas.add(cerveja);
            db.salvar(cerveja);
        } else {
            cervejasFavoritas.remove(cerveja);
            db.salvar(cerveja);
        }

        System.out.println("ADICIONADA AOS FAVORITOS ***" + cerveja.getName());
    }

    //saber a quantidade de elementos que a lista tem. Quantas linhas ele vai "construir".
    @Override
    public int getItemCount() {
        return cervejas != null ? cervejas.size() : 0;
    }

    public List<Cerveja> getCervejas() {
        return cervejas;
    }
}
