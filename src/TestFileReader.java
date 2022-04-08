import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestFileReader {
    public static void main(String[] args) {
        FileReader fr = null;
        try {
            fr = new FileReader("aabc");
            char[] chars = new char[4];
            int readCount = 0;
            while((readCount = fr.read(chars)) != -1){
                System.out.println(new String(chars,0,readCount));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
