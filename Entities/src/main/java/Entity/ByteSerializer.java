package Entity;


import java.io.*;

public class ByteSerializer {
    private static byte[] byteArray = new byte[2000000000];
    private static ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private static ObjectInputStream in;
    private static ObjectOutputStream out;
    static {
        try {
            out = new ObjectOutputStream(outputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] serialize(Object object) {
        synchronized (ByteSerializer.class) {
            try {
                outputStream.flush();
                out.writeObject(object);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return outputStream.toByteArray();
        }
    }

    public static Object deserialize(byte[] input) {
        synchronized (ByteSerializer.class) {
            Object o;
            try {
                in = new ObjectInputStream(new ByteArrayInputStream(input));
                o = in.readObject();
                in.close();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            return o;
        }
    }
}
