import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/conversionLength")
public class ConversionLenghtServlet extends HttpServlet {
    private static final String MIME_TYPE_TEXT_HTML = "text/html";
    private static final String CHARACTER_ENCODING = "UTF-8";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(CHARACTER_ENCODING);
        response.setContentType(MIME_TYPE_TEXT_HTML);

        String meterString = request.getParameter("meter");
        String centimeterString = request.getParameter("centimeter");
        String millimeterString = request.getParameter("millimeter");

        Double meter = Double.valueOf(meterString);
        Double centimeter = Double.valueOf(centimeterString);
        Double millimeter = Double.valueOf(millimeterString);

        response.getWriter().println(String.format("<h2>Podana wartość w przeliczeniu na: </h2><br/>metry %s<br/>centymetry: %s<br/>milimetry: %s", meter, centimeter, millimeter));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
