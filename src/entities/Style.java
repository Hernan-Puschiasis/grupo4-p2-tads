package entities;

import uy.edu.um.prog2.adt.LinkedList.LinkedList;

public class Style {
    String name;
    LinkedList<Long> beers = new LinkedList<>();
    //TODO: Agregar reviews agregada a cada estilo
    public Style(String name){
        this.name = name;
    }

    public void addBeer(long beerID){
        beers.add(beerID);
    }
}
