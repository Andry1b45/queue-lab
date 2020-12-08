package boilerplate;

import com.google.gson.Gson;
import model.entity.Student;
import model.entity.Subject;
import model.service.*;
import spark.Response;
import spark.ResponseTransformer;
import spark.resource.Resource;

import javax.servlet.http.Cookie;
import java.lang.Enum;
import static spark.Spark.after;
import static spark.Spark.get;


//todo return response
//todo authorization
//todo cookie
//todo verify

public class Application {

    private static ResponseTransformer toJson = new Gson()::toJson;

    public static void main(String... args) {

        //todo сделать  auth

        get("/verify", (request, response) -> {     //todo проверк пользвателя в бд, возвращаем айдишник
            //response.cookie("verify", new Student(null);
            return new SubjectService().getSubject(new Student("1", "Анастасія", "Лапа",
                    "is8113"));}, toJson);


        get("/auth/:name:surname:password", (req,res)->{
            Cookie result = new Cookie("SUCCESS", String.valueOf(new Student("1", req.params(":name"),
                    req.params(":surname"), req.params(":password"))));
            return result;
        });


        get("/account/api/subjects", (request, response) -> {
            return new SubjectService().getSubject(new Student("1", "Анастасія", "Лапа",
                    "is8113"));}, toJson);

        get("/info/bars", (request, response) -> {
            return new BarService().getBars();
        }, toJson);

        get("/info/developers", (request, response) -> {
            return new DeveloperService().getDevelopers();
        }, toJson);

        get("/queue/api/queue", (request, response) -> {
            return new QueueService().getQueue(new Student("1", "Анастасія", "Лапа",
                    "is8113"), new Subject("Групова динаміка і комунікації"));
            }, toJson);

        get("/subjects/api/options", (request, response) -> {
            return new OptionService().getOptions();
            }, toJson);

        get("/info/api/info", (request, response) -> {
            return new InfoService().getInfo(new Student("1", "Анастасія", "Лапа",
                    "is8113"));
        }, toJson);

        get("/verify", (request, response) -> {
            return new InfoService().getInfo(new Student("1", "Анастасія", "Лапа",
                    "is8113"));
        }, toJson);

        after((request, response) -> {
            // For security reasons do not forget to change "*" to url
            response.header("Access-Control-Allow-Origin", "*");
            response.type("application/json");
        });
    }

}


