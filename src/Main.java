import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.searchcep.models.SearchWeb;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        SearchWeb url = new SearchWeb();
        String search = "";
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        String end;

        do {
            System.out.println("Qual CEP quer pesquisar procurar?");
            search = scan.nextLine();

            String uri = "https://viacep.com.br/ws/" + search + "/json/";
            String json = url.search(uri);
            System.out.println(json);

            System.out.println("Digite 0 para encerrar");
            end = scan.nextLine();
        } while (!end.equals("0"));
    }
}