import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        //Retirar senha de acesso da API
        //String imdKey = System.getenv("IMDB_API_KEY");
        //acrescentar concatenação da url + imdbKey;

        // fazer uma conexão HTTP e buscar os tops 250 filmes
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();

        HttpResponse<String> response= client.send(request, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);

        //extrair os dados (Titulo, Post (img), classificação)
        var parser = new JsonParser();
        List<Map<String, String >> listaDeFilmes = parser.parse(body);
       // System.out.println(listaDeFilmes.size()); Ex de busca
       // System.out.println(listaDeFilmes.get(0)); Ex de busca
        //exibir e manipular os dados

        for (int i = 0; i < 4; i++){
            Map<String, String> filme = listaDeFilmes.get(i); 
                System.out.println(" \u001b[33m \u001b[40m \u001b[3mTitulo\u001b[m : " +filme.get("title"));
                System.out.println(filme.get("image"));
                System.out.println(" \u001b[31m \u001b[47m \u001b[1m Classificação\u001b[m :  " +filme.get("imDbRating"));
                double classificacao = Double.parseDouble(filme.get("imDbRating"));
                int numeroEstrelas = (int) classificacao;
                for (int n = 1; n <= 1; n++) {
                    System.out.print("👍");

                }
                for (int n  = 0; n > 6; n--) {
                    System.out.println("👎");
                }

               System.out.println("\n");
        }
        
           }
    }


