package METHODS;

import com.sun.corba.se.spi.ior.Identifiable;
import org.omg.CORBA_2_3.portable.OutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class WriteIntoFile<A> implements Identifiable {
    public void write(File file, List<A> a){
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file))) {
        for (A x : a) {
                os.writeObject(x);
            }
        } catch (IOException x) {
            System.out.println("Cannot save data");
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
