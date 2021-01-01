package contactmanagementsoftware;

import java.io.*;

/**
 * SerializationUtil is the utility class to serialize and deserialize data
 */
public class SerializationUtil implements Serializable {

    /**
     * deserialize file
     *
     * @param file file to deserialize
     * @return deserialized object
     * @throws IOException            io exception
     * @throws ClassNotFoundException class not found exception
     */
    public static Object deserialize(File file) throws IOException,
            ClassNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object obj = ois.readObject();
        ois.close();
        return obj;
    }

    /**
     * serialize the given object and save it to file
     *
     * @param obj      object to serialize
     * @param fileName file name to save
     * @throws IOException io exception
     */
    public static void serialize(Object obj, String fileName)
            throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
        fos.close();
    }

}
