package webserver;
import java.io.*;

public class HttpRequestReader {

    private final BufferedReader bufferedReader;

    private HttpRequestReader(InputStream inputStream) throws IOException {
        this.bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
    }

    public static HttpRequestReader from(InputStream inputStream) throws IOException {
        return new HttpRequestReader(inputStream);
    }

    // URL을 반환하는 메서드
    public String getUrl() throws IOException {
        String line = bufferedReader.readLine();

        return line.split(" ")[1];
    }

    // HTTP 요청 전체를 반환하는 메서드
    public String getHttpRequest() throws IOException {
        StringBuilder requestBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
            requestBuilder.append(line).append("\n");
        }
        return requestBuilder.toString();
    }
}