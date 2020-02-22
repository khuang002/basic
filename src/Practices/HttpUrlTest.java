package Practices;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;

public class HttpUrlTest {
    public static void main(String[] args){
        try {
            URL shiyanlou = new URL("https://www.shiyanlou.com");
            HttpURLConnection urlConnection = (HttpURLConnection)shiyanlou.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setConnectTimeout(1000);
            InputStream inputStream = urlConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//            bufferedReader.lines().forEach(System.out::println);
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Local host: "+localHost);
            System.out.println("Local host name: "+localHost.getHostName());
            System.out.println("Local host Address: "+localHost.getHostAddress());
            InetAddress shiyanlou2 = InetAddress.getByName("www.shiyanlou.com");
            System.out.println(shiyanlou2.toString());
//            String ip = shiyanlou2.toString().split("/")[1];
            String ip = shiyanlou2.getHostAddress();
            InetAddress byAddress = InetAddress.getByName(ip);
            System.out.println("get hostname by IP address: "+byAddress.getHostName());

            inputStream.close();
            bufferedReader.close();
            urlConnection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
