package br.com.beer.model;

import android.media.Image;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
@ToString(exclude = {"id"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cerveja {

    @NonNull
    private int id;

    private String name;

    @NonNull
    private String tagline;

    @NonNull
    private String description;

    @NonNull
    private Boolean favorite = false;

    @NonNull
    private String image_url;

}
