import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/conversionLength")
public class ConversionLenghtServlet extends HttpServlet {
    private static final String MIME_TYPE_TEXT_HTML = "text/html";
    private static final String CHARACTER_ENCODING = "UTF-8";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding(CHARACTER_ENCODING);
        response.setContentType(MIME_TYPE_TEXT_HTML);
        response.setCharacterEncoding(CHARACTER_ENCODING);

        String meterString = request.getParameter("meter");
        String centimeterString = request.getParameter("centimeter");
        String millimeterString = request.getParameter("millimeter");

       if (checkIfAgreedWithConditions(meterString, centimeterString, millimeterString)){
           Lenght lenght = new Lenght(meterString, centimeterString, millimeterString);
           response.getWriter().println("<h2>Podana wartość w przeliczeniu na: </h2>");
           response.getWriter().println(String.format("metry %.2f", lenght.getMeter()));
           response.getWriter().println(String.format("<br/>centymetry %.2f", lenght.getCentimeter()));
           response.getWriter().println(String.format("<br/>milimetry %.2f", lenght.getMillimeter()));
        }
       else if (meterString.isEmpty() && centimeterString.isEmpty() && millimeterString.isEmpty())
           response.getWriter().println("Nie podałeś żadnej wartości...");
       else
           response.getWriter().print("Oczekiwana tylko jedna wartość!");
    }

    private boolean checkIfAgreedWithConditions(String meterString, String centimeterString, String millimeterString) {
        return !meterString.isEmpty() && centimeterString.isEmpty() && millimeterString.isEmpty() || !centimeterString.isEmpty() && millimeterString.isEmpty() &&meterString.isEmpty() || !millimeterString.isEmpty() && centimeterString.isEmpty() && meterString.isEmpty();
    }

}
