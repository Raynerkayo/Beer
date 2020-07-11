package br.com.beer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
public class Cerveja {

    @NonNull
    private int id;

    private String name;
    @NonNull
    private String tagline;
    @NonNull
    private String description;

}
