
import java.util.concurrent.ThreadLocalRandom;

public class GeneradorMatriz {

    int[][] matriz = new int[5][5];


    public int[][] getMatriz() {


        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = ThreadLocalRandom.current().nextInt(10) + 1;
            }
        }

        return matriz;
    }
}



