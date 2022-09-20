package DAO;

import com.sun.corba.se.spi.ior.Identifiable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface DAO<A extends Identifiable>{
    void save(A a);
    Optional<A> load(String id);
    boolean delete(A a);
    boolean delete(String series);
    List<A> getAll();

}
