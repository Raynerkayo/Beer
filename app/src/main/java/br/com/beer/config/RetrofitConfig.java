package br.com.beer.config;

import br.com.beer.config.client.CervejaServiceClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private final Retrofit retrofit;

    public RetrofitConfig(){
        this.retrofit = new Retrofit.Builder().baseUrl("https://api.punkapi.com/v2/")
                .addConverterFactory(JacksonConverterFactory.create()).build();
    }

    public CervejaServiceClient getAllBeer(){
        return  this.retrofit.create(CervejaServiceClient.class);
    }

}
