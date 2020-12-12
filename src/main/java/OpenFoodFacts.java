import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class OpenFoodFacts {
    @Override
    public String toString() {
        return "OpenFoodFacts{" +
                "codeProvider=" + codeProvider +
                '}';
    }

    CodeProvider codeProvider=new CodeProvider();

    public String openFoodFacts(CodeProvider codeProvider) throws IOException {
        String uri="https://world.openfoodfacts.org/api/v0/product/"+codeProvider + ".json";
        System.out.println(uri);
    return get(uri);

    }
    private String get (String uri) throws IOException {
        URL url=new URL(uri);
        HttpURLConnection connection=(HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader in=new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder stringBuilder=new StringBuilder();

        while((line=in.readLine())!=null){
            stringBuilder.append(line);
        }
        in.close();

        if (stringBuilder.toString().equals("")){
            throw new IllegalArgumentException("Bład krytyczny");
        }
        return stringBuilder.toString();


    }
}
