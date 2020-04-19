import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/conversionWeight")
public class ConversionWeightServlet extends HttpServlet {
    private static final String MIME_TYPE_TEXT_HTML = "text/html";
    private static final String CHARACTER_ENCODING = "UTF-8";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(CHARACTER_ENCODING);
        response.setContentType(MIME_TYPE_TEXT_HTML);

        String kilogramString = request.getParameter("kilogram");
        String gramString = request.getParameter("gram");
        String milligramString = request.getParameter("milligram");

        Double kilogram = Double.valueOf(kilogramString);
        Double gram = Double.valueOf(gramString);
        Double milligram = Double.valueOf(milligramString);

        response.getWriter().println(String.format("<h2>Podana wartość w przeliczeniu na:</h2><br/>kilogramy %s<br/>gramy: %s<br/>miligramy: %s", kilogram, gram, milligram));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
