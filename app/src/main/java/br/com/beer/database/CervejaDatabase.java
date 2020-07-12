package br.com.beer.database;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.com.beer.model.Cerveja;

public class CervejaDatabase {

    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

    public void salvar(Cerveja c){
        System.out.println("SALVANDO NO BANCO");
        DatabaseReference favoritas = reference.child("cervejas");
        favoritas.child(String.valueOf(c.getId())).setValue(c);
    }

}
