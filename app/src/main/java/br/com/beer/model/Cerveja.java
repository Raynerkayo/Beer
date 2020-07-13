package br.com.beer.model;

import android.media.Image;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

//indices, pq sabemos que será pesquisado bastante por nome da cerveja. Só para melhorar na performance, com grandes dados.
@Entity(indices = {@Index("name")})
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
@ToString(exclude = {"id"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cerveja {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cod_local")
    private int codLocal;

    @NonNull
    @Ignore
    private int id;

    @NonNull
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
