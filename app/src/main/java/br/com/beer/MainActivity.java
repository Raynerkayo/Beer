package br.com.beer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import br.com.beer.adapter.CervejaAdapter;
import br.com.beer.model.Cerveja;
import br.com.beer.model.Cervejas;

public class MainActivity extends AppCompatActivity {

    private CervejaAdapter cervejaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cervejaAdapter = new CervejaAdapter(new ArrayList<>(Cervejas.fakeCervejas()));

        RecyclerView recyclerView = findViewById(R.id.recycler_view_main);
        recyclerView.setAdapter(cervejaAdapter);

    }
}
