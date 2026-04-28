package Java.JavaCollections.map;

import javax.swing.text.html.parser.Entity;

public class MapUsingHash {
    private Entity[] entities;

    public MapUsingHash(){
        entities  = new Entity[10];
    }

    public void put(String key, String value){
        int hash = Math.abs(key.hashCode() % entities.length);
        entities[hash] = new Entity(key, value); // overriding
    }

    public String get(String key){
        int hash = Math.abs(key.hashCode() % entities.length);

        if (entities[hash] != null && entities[hash].key == key){
            return entities[hash].value;
        }
        return null;
    }

    public void remove(String key){
        int hash = Math.abs(key.hashCode() % entities.length);
        if (entities[hash] != null && entities[hash].key.equals(key)){
            entities[hash] = null;
        }
    }
    private class Entity{
        String key;
        String value;

        public Entity(String key, String value){
            this.key = key;
            this.value = value;

        }
    }
}
