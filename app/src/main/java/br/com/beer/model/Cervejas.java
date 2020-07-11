package br.com.beer.model;

import java.util.Arrays;
import java.util.List;

public class Cervejas {

    public static List<Cerveja> fakeCervejas(){
        return Arrays.asList(
                Cerveja.builder().id(1).name("Nome").description("Descrição da cerveja").tagline("Não sei o que é.").favorite(true).build(),
                Cerveja.builder().id(2).name("Nome").description("Descrição da cerveja").tagline("Não sei o que é.").favorite(false).build(),
                Cerveja.builder().id(3).name("Nome").description("Descrição da cerveja").tagline("Não sei o que é.").favorite(true).build(),
                Cerveja.builder().id(4).name("Nome").description("Descrição da cerveja").tagline("Não sei o que é.").favorite(false).build(),
                Cerveja.builder().id(5).name("Nome").description("Descrição da cerveja").tagline("Não sei o que é.").favorite(true).build(),
                Cerveja.builder().id(6).name("Nome").description("Descrição da cerveja").tagline("Não sei o que é.").favorite(false).build(),
                Cerveja.builder().id(7).name("Nome").description("Descrição da cerveja").tagline("Não sei o que é.").favorite(true).build(),
                Cerveja.builder().id(8).name("Nome").description("Descrição da cerveja").tagline("Não sei o que é.").favorite(false).build(),
                Cerveja.builder().id(9).name("Nome").description("Descrição da cerveja").tagline("Não sei o que é.").favorite(true).build(),
                Cerveja.builder().id(10).name("Nome").description("Descrição da cerveja").tagline("Não sei o que é.").favorite(false).build(),
                Cerveja.builder().id(11).name("Nome").description("Descrição da cerveja").tagline("Não sei o que é.").favorite(false).build(),
                Cerveja.builder().id(12).name("Nome").description("Descrição da cerveja").tagline("Não sei o que é.").favorite(true).build()
        );
    }

}
