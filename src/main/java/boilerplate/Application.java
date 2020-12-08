package boilerplate;

import api.StandardResponse;
import api.StatusResponse;
import com.google.gson.Gson;
import model.entity.Student;
import model.entity.Subject;
import model.service.*;
import spark.ResponseTransformer;

import javax.servlet.http.Cookie;
import static spark.Spark.after;
import static spark.Spark.get;
import static spark.route.HttpMethod.post;

import java.sql.SQLException;

//todo return response
//todo authorization
//todo cookie
//todo verify

public class Application {

    private static ResponseTransformer toJson = new Gson()::toJson;

    public static void main(String... args) throws SQLException {
        StudentService studentService = new StudentService();
        //todo сделать  auth

        /*
        post("/verify/:id", (request, response) -> {
            request.getCookies();
            response.type("application/json");
            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS, new
                            Gson().toJsonTree((studentService.getStudentById(request.params(":id"))))));
        });



        get("/auth/:name:surname:password", (req,res)->{
            Cookie result = new Cookie("SUCCESS", String.valueOf(new Student("1", req.params(":name"),
                    req.params(":surname"), req.params(":password"))));
            return result;
        });
        */


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


