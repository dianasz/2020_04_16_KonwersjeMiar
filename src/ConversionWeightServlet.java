import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/conversionWeight")
public class ConversionWeightServlet extends HttpServlet {
    private static final String MIME_TYPE_TEXT_HTML = "text/html";
    private static final String CHARACTER_ENCODING = "UTF-8";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding(CHARACTER_ENCODING);
        response.setContentType(MIME_TYPE_TEXT_HTML);
        response.setCharacterEncoding(CHARACTER_ENCODING);

        String kilogramString = request.getParameter("kilogram");
        String gramString = request.getParameter("gram");
        String milligramString = request.getParameter("milligram");

        if (checkIfAgreedWithConditions(kilogramString, gramString, milligramString)){
            Weight weight = new Weight(kilogramString, gramString, milligramString);
            response.getWriter().println("<h2>Podana wartość w przeliczeniu na: </h2>");
            response.getWriter().println(String.format("kilogramy %.2f", weight.getKilogram()));
            response.getWriter().println(String.format("<br/>gramy %.2f", weight.getGram()));
            response.getWriter().println(String.format("<br/>miligramy %.2f", weight.getMilligram()));
        }
        else if (kilogramString.isEmpty() && gramString.isEmpty() && milligramString.isEmpty())
            response.getWriter().println("Nie podałeś żadnej wartości...");
        else
            response.getWriter().print("Oczekiwana tylko jedna wartość!");
    }

    private boolean checkIfAgreedWithConditions(String kilogramString, String gramString, String milligramString) {
        return !kilogramString.isEmpty() && gramString.isEmpty() && milligramString.isEmpty() || !gramString.isEmpty() && milligramString.isEmpty() &&kilogramString.isEmpty() || !milligramString.isEmpty() && gramString.isEmpty() && kilogramString.isEmpty();
    }
}
