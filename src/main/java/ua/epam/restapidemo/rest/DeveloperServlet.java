package ua.epam.restapidemo.rest;

import com.google.gson.Gson;
import ua.epam.restapidemo.model.Developer;
import ua.epam.restapidemo.respository.DeveloperRepository;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "DeveloperServlet", urlPatterns = "/api/v1/developers")
public class DeveloperServlet extends HttpServlet {

    private DeveloperRepository developerRepository = new DeveloperRepository();

    private Gson gson = new Gson();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        try {
            List<Developer> developers = developerRepository.getAll();
            String developerJsonString = this.gson.toJson(developers);

            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(developerJsonString);
            out.flush();
        } catch (SQLException e) {
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.sendError(500);
            out.flush();
        }
    }
}
