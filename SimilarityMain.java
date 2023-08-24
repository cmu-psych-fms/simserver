import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.EOFException;
import edu.umbc.dbpedia.model.SimilarityModel;

public class SimilarityMain {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        SimilarityModel model = new SimilarityModel();
        System.out.println("--ready--");
        while (true) {
            String arg1 = in.readLine();
            if (arg1 == null) {
                System.exit(0);
            }
            String arg2 = in.readLine();
            if (arg2 == null) {
                throw new EOFException("Single argument read before EOF");
            }
            System.out.println(model.getPhraseSimilarity(arg1, arg2));
        }
    }

}
