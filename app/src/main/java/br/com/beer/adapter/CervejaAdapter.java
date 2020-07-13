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

public class CervejaAdapter extends RecyclerView.Adapter<CervejaViewHolder> {

    private final List<Cerveja> cervejas;

    public CervejaAdapter(List<Cerveja> cervejas) {
        this.cervejas = cervejas;
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
                    System.out.println("CERVEJA FAVORITA ANTES " + cerveja.getFavorite());
                    favorite(view, position, cerveja);
                    System.out.println("CERVEJA FAVORITA DEPOIS " + cerveja.getFavorite());
                }
        );
        holder.bind(cerveja);
    }

    private void favorite(View view, int position, Cerveja cerveja) {
        CervejasDAO dao = CervejaDatabaseROOM.getInstance(view.getContext()).createCervejaDAO();
        if(cerveja.getFavorite()){
            if(!dao.getByName(cerveja.getName()).isEmpty()){
                notifyItemChanged(position);
                cerveja.setFavorite(false);
                dao.delete(cerveja);
                System.out.println("CERVEJA FAVORITA DELETADO");
            }
        } else {
            notifyItemChanged(position);
            dao.insert(cerveja);
            cerveja.setFavorite(true);
            System.out.println("INSERIR CERVEJA FAVORITA");
        }

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
