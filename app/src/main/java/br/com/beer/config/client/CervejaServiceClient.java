package br.com.beer.config.client;

import java.util.List;
import java.util.Optional;

import br.com.beer.model.Cerveja;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CervejaServiceClient {

    @GET("beers")
    Call<List<Cerveja>> getAllBeer();

    @GET("/beers")
    Call<Cerveja> getBeerByName(@Query("beer_name") String name);

}
