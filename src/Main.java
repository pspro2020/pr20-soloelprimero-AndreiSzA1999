import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {


    public static void main(String[] args) {

        ThreadPoolExecutor fixedThreadPool =
                (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<Tarea> tareas = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            tareas.add(new Tarea(i));

        }


        System.out.printf("Resultados\n");


        try {

            List<Future<Integer>> futureList =
                    fixedThreadPool.invokeAll(tareas, 2, TimeUnit.SECONDS);
            for (int i = 0; i < futureList.size(); i++) {

                Future<Integer> future = futureList.get(i);

                try {
                    Integer resultado = future.get();
                    System.out.printf("El resultado de la fila %d es %d\n", i + 1, resultado);


                } catch (ExecutionException e) {

                    System.out.printf("Error");
                }


            }


        } catch (InterruptedException ignored) {
        } finally {
            fixedThreadPool.shutdown();
        }


    }
}
