package br.com.beer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.beer.adapter.CervejaAdapter;
import br.com.beer.config.RetrofitConfig;
import br.com.beer.model.Cerveja;
import br.com.beer.model.Cervejas;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private CervejaAdapter cervejaAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Call<List<Cerveja>> call = new RetrofitConfig().getAllBeer().getAllBeer();
        call.enqueue(new Callback<List<Cerveja>>() {
            @Override
            public void onResponse(Call<List<Cerveja>> call, Response<List<Cerveja>> response) {

                //aqui eu vou verificar se tem conexão?
                System.out.println("DESC"+response.message());
                cervejaAdapter = new CervejaAdapter(response.body());
                RecyclerView recyclerView = findViewById(R.id.recycler_view_main);
                recyclerView.setAdapter(cervejaAdapter);



            }

            @Override
            public void onFailure(Call<List<Cerveja>> call, Throwable t) {

                //Aqui eu faço o caso de quando não tem internet?
                Log.d("CDESCRICAO", "FALHFOU" + t.getMessage());
                System.out.println("MSG"+t.getMessage());
                System.out.println("CAUSE"+t.getCause());
            }
        });


    }

    private void configRecycler(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        //adiciona um layout
        recyclerView.setLayoutManager(layoutManager);

        //adiciona um divisor, entra as linhas
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }

}
