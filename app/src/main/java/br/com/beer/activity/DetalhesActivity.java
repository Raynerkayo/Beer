package br.com.beer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.beer.R;
import br.com.beer.model.Cerveja;

public class DetalhesActivity extends AppCompatActivity {

    private TextView textName;
    private TextView textTagline;
    private TextView textDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        textName = findViewById(R.id.txt_nome);
        textTagline = findViewById(R.id.txt_tagline);
        textDescription = findViewById(R.id.txt_description);
        Bundle dados = getIntent().getExtras();

        //lembrar de fazer o cast de serial... para cerveja.
        Cerveja cerveja = (Cerveja) dados.getSerializable("objeto");
        textName.setText(cerveja.getName());
        textTagline.setText(cerveja.getTagline());
        textDescription.setText(cerveja.getDescription());

    }
}
