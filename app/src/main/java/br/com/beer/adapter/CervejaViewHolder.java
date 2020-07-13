package br.com.beer.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import br.com.beer.R;
import br.com.beer.model.Cerveja;

public class CervejaViewHolder extends RecyclerView.ViewHolder {

    TextView textName;
    ImageView imageFavorite;
    ImageView imageBeer;
    TextView textTagline;


    //aqui ele vai receber a view, vinda do adapater.
    public CervejaViewHolder(View itemView) {
        super(itemView);
        textName = itemView.findViewById(R.id.txt_cerveja);
        textTagline = itemView.findViewById(R.id.txt_tagline);
        imageFavorite = itemView.findViewById(R.id.icon_favorite);
        imageBeer = itemView.findViewById(R.id.icon_placeholder);
    }

    //no clique da imagem, é que vai ser setado o valor de favorite
    public void bind(Cerveja cerveja) {

        textName.setText(cerveja.getName());
        textTagline.setText(cerveja.getTagline());

        imageFavorite.setImageResource(cerveja.getFavorite() ? R.drawable.staron : R.drawable.staroff);
        Picasso.get().load(cerveja.getImage_url()).into(imageBeer);
    }
}
