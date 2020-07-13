package br.com.beer;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.beer.activity.DetalhesActivity;
import br.com.beer.adapter.CervejaAdapter;
import br.com.beer.config.RetrofitConfig;
import br.com.beer.model.Cerveja;
import br.com.beer.util.RecyclerItemClickListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private CervejaAdapter cervejaAdapter;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(isConnected()){
            setContentView(R.layout.activity_main);
            requisitarDadosApi();
        } else {
            ImageView imageRefresh;
            setContentView(R.layout.cerveja_conexao);
            imageRefresh = findViewById(R.id.imageRefresh);
            imageRefresh.setOnClickListener(
                    view -> {
                        if(isConnected()){
                            Intent i = new Intent(this, MainActivity.class);
                            startActivity(i);
                            finish();
                        }
                    }
            );

        }

    }

    private void requisitarDadosApi() {
        Call<List<Cerveja>> call = new RetrofitConfig().getAllBeer().getAllBeer();
        call.enqueue(new Callback<List<Cerveja>>() {
            @Override
            public void onResponse(Call<List<Cerveja>> call, Response<List<Cerveja>> response) {

                //aqui eu vou verificar se tem conexão?
                System.out.println("DESC"+response.message());
                cervejaAdapter = new CervejaAdapter(response.body());
                RecyclerView recyclerView = findViewById(R.id.recycler_view_main);
                recyclerView.setAdapter(cervejaAdapter);
                recyclerView.addOnItemTouchListener(
                        new RecyclerItemClickListener(
                                getApplicationContext(),
                                recyclerView,
                                new RecyclerItemClickListener.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(View view, int position) {
                                        Toast.makeText(getApplicationContext(), "1 clique logo para abrir detalhes. \n2 cliques na estrela para favoritar.", Toast.LENGTH_LONG).show();
                                    }

                                    @Override
                                    public void onLongItemClick(View view, int position) {
                                        Cerveja cerveja = cervejaAdapter.getCervejas().get(position);

                                        Intent intent = new Intent(getApplicationContext(), DetalhesActivity.class);
                                        intent.putExtra("objeto", cerveja);

                                        startActivity(intent);
                                    }

                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                    }
                                }
                        )
                );

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

    private Boolean isConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

}
