package cf.mindaugas.pagalbadovilei.spark_backend;

import java.net.URLDecoder;

import static spark.Spark.get;
import static spark.Spark.post;

public class Api {
    public static void main(String[] args) {
        // 0. Generating simple HTML
        get("/hw", (request, response) -> {
            return "<h1>Hello world!</h1>";
        });

        post("/submit-form", (request, response) -> {
            System.out.println(request.body());
            String[] userinfo = URLDecoder
                    .decode(request.body(), "UTF-8")
                    .split("&");
            String ulopen = "<ul>";
            String ulclose = "</ul>";
            for (String pieceOfInfo: userinfo) {
                ulopen += "<li>" + pieceOfInfo.split("=")[1] + "</li>";
            }
            return ulopen + ulclose;
        });
    }
}