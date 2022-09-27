package DAO;

import com.sun.corba.se.spi.ior.Identifiable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import Exception.UnacceptableInputError;import Exception.UnacceptableInputError;

public interface DAO<A extends Identifiable>{
    void save(A a);
    Optional<A> load(String id);
    boolean delete(A a) throws UnacceptableInputError;
    boolean delete(String series) throws UnacceptableInputError;
    List<A> getAll();

}
