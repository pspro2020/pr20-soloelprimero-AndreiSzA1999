import java.util.concurrent.Callable;

public class Tarea implements Callable<Integer> {

    GeneradorMatriz matriz = new GeneradorMatriz();
    private final int fila;
    private final int numero;
    int[][] matrizabuscar = matriz.getMatriz();

    public Tarea(int fila,int numero) {
        this.fila = fila;
        this.numero=numero;
    }


    @Override
    public Integer call() throws Exception {
        return buscar(fila,numero);
    }




    private int buscar(int fila,int numero){

        Integer columnaencontrada = -1;


        for (int i = 0; i < matrizabuscar.length; i++) {
            if(numero == matrizabuscar[fila][i]){
                return columnaencontrada;
            }

        }

        return columnaencontrada;
    }
}