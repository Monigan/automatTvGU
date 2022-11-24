package Storage;

import Entity.TovarEntity;

import java.util.ArrayList;
import java.util.List;

public class TovarStorage {
    List<TovarEntity> list = new ArrayList<>();

    public TovarStorage() {
        makeTestTovar();
    }

    TovarStorage(List<TovarEntity> list){
        this.list = list;
    }

    public List<TovarEntity> getList() {
        return list;
    }

    private void makeTestTovar(){
        list.add(new TovarEntity("Батончик", 10, 20.0));
        list.add(new TovarEntity("Кола", 15, 89.0));
        list.add(new TovarEntity("Чипсы", 0, 49.0));
        list.add(new TovarEntity("Сухарики", 12, 34.0));
        list.add(new TovarEntity("Колбаски", 1, 100.0));
    }
}
