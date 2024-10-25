import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.RejectedExecutionException;

public class OpcionCambio {
    public Cambio buscaCambio(int opcion) throws IOException, InterruptedException {

        String baseCode = "USD";
        String targetCode = "ARS";
        switch (opcion){
            case 1:
                baseCode = "USD";
                targetCode = "ARS";
                break;

            case 2:
                baseCode = "ARS";
                targetCode = "USD";
                break;

            case 3:
                baseCode = "USD";
                targetCode = "BRL";
                break;

            case 4:
                baseCode = "BRL";
                targetCode = "USD";
                break;

            case 5:
                baseCode = "USD";
                targetCode = "COP";
                break;

            case 6:
                baseCode = "COP";
                targetCode = "USD";
                break;

        }

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" +
                "aee4c5eec215b9726a14c0aa/pair/" + baseCode +"/" + targetCode);
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try{
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Cambio.class);
        }catch (Exception e){
            throw new RuntimeException("No fue posible acceder a la API");
        }

    }
}
