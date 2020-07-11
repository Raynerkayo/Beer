package br.com.beer.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.beer.R;
import br.com.beer.model.Cerveja;

public class CervejaAdapter extends RecyclerView.Adapter<CervejaAdapter.CervejaViewHolder>{
    private final List<Cerveja> cervejas;

    public CervejaAdapter(ArrayList<Cerveja> cervejas) {

        this.cervejas = cervejas;

    }

    //serve para carregar a view para o mostrar o usuário.
    @NonNull
    @Override
    public CervejaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
          R.layout.cerveja_item, parent, false
        );

        return new CervejaViewHolder(view);
    }

    //Quando é preciso reciclar uma view. No caso, quando ultrapassa o tamanho da tela na qtd
    //e o usuário rola a tela para ver mais dados.
    @Override
    public void onBindViewHolder(@NonNull CervejaViewHolder holder, int position) {
        //definir já uma cerveja para ser mostrada
        Cerveja cerveja = cervejas.get(position);
        holder.bind(cerveja);
    }

    //saber a quantidade de elementos que a lista tem. Quantas linhas ele vai "construir".
    @Override
    public int getItemCount() {
        return cervejas.size();
    }

    class CervejaViewHolder extends RecyclerView.ViewHolder{

        TextView textName;
        TextView textDescricao;

        //aqui ele vai receber a view, vinda do adapater.
        public CervejaViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.txt_cerveja);
            textDescricao = itemView.findViewById(R.id.txt_descricao);
        }

        public void bind(Cerveja cerveja) {
            textName.setText(cerveja.getName());
            textDescricao.setText(cerveja.getDescription());
        }
    }

}
