package dataBase;

import java.util.List;

public interface CRUD {

    //Create
    public Object insert(Object obj);
    public List<Object> findAll();

    public boolean update(Object obj);

    public boolean delete(Object obj);


    //
}
