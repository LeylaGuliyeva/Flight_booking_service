package METHODS;

import com.sun.corba.se.spi.ior.Identifiable;
import org.omg.CORBA_2_3.portable.OutputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GetFromFile<A> implements Identifiable{
    public Optional<List<A>> getFromFile(File file){
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(file))){
            List<A> a = new ArrayList<>();
            try {
                while(true) {
                    A x=(A) is.readObject();
                    a.add(x);
                }
            } catch (EOFException e) {
                return Optional.of(a);
            }
        } catch (FileNotFoundException x) {
            System.out.println("File is not found");
            return Optional.empty();
        } catch (IOException x) {
            System.out.println("Error occured");
            return Optional.empty();
        } catch (ClassNotFoundException e) {
            System.out.println("Class is not found");
            return Optional.empty();
        }
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void write(OutputStream arg0) {

    }
}
