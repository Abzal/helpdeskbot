import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Reqtest {

    public static void main(String[] args) {

        try {
            String result = sendPOST("http://127.0.0.1:8000/api/handbook");
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String sendPOST(String url) throws IOException {

        String result = "";
        HttpPost post = new HttpPost(url);
        post.setHeader(HttpHeaders.CONTENT_TYPE,"application/json");
        post.setHeader(HttpHeaders.AUTHORIZATION, "Bearer 1|1nP8OJCOobEVVkZ1nuAoECBsK6l0K7LF6gPNrTqC");

        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"name\":\"mkyong\",");
        json.append("\"notes\":\"hello\"");
        json.append("}");

        // send a JSON data
        post.setEntity(new StringEntity(json.toString()));

        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(post);
            result = EntityUtils.toString(response.getEntity());
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

}