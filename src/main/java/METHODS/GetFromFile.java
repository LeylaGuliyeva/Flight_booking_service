package METHODS;

import com.sun.corba.se.spi.ior.Identifiable;
import org.omg.CORBA_2_3.portable.OutputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GetFromFile<A> implements Identifiable{
    public List<A> getFromFile(File file){
        List<A> a = new ArrayList<>();
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(file))){
            try {
                while(true) {
                    A x=(A) is.readObject();
                    a.add(x);
                }
            } catch (EOFException e) {
                return a;
            }
        } catch (FileNotFoundException x) {
            System.out.println("File is not found");
            return a;
        } catch (IOException x) {
            return a;
        } catch (ClassNotFoundException e) {
            System.out.println("Class is not found");
            return a;
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
