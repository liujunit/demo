package pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.state.RenderingMode;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PrintTextLocations extends PDFTextStripper {

    public PrintTextLocations() throws IOException {
        super();
        setSuppressDuplicateOverlappingText(false);
//        registerOperatorProcessor("K", new org.apache.pdfbox.util.operator.SetStrokingCMYKColor());
//        registerOperatorProcessor("k", new org.apache.pdfbox.util.operator.SetNonStrokingCMYKColor());
    }




    public static void main(String[] args) throws Exception {

        PDDocument document = null;
        try {
            File input = new File("C:\\Users\\jiuyuan4\\Desktop\\西安\\title size.pdf");
            document = PDDocument.load(input);
            PrintTextLocations printer = new PrintTextLocations();
            String text = printer.getText(document);
            System.out.println(text);
//            System.out.println(text);
        } finally {
            if (document != null) {
                document.close();
            }
        }
    }

    @Override
    protected void writeString(String text, List<TextPosition> textPositions) throws IOException
    {
        writeString(text + '\n');

        for (TextPosition textPosition: textPositions)
        {
            StringBuilder textBuilder = new StringBuilder();
            textBuilder.append(textPosition)
                    .append(" - shear by ")
                    .append(" - ")
                    .append(renderingMode.get(textPosition))
                    .append('\n');
            writeString(textBuilder.toString());
        }
    }

    private String toString(PDColor pdColor) {
        if (pdColor == null)
            return "null";
        StringBuilder builder = new StringBuilder();
        for (float f: pdColor.getComponents())
        {
            builder.append(' ')
                    .append(f);
        }
        return builder.toString();
    }

    Map<TextPosition, Integer> renderingMode = new HashMap<TextPosition, Integer>();

    /**
     * @param text The text to be processed
     */
    @Override /* this is questionable, not sure if needed... */
    protected void processTextPosition(TextPosition text) {
        this.renderingMode.put(text, getGraphicsState().getTextState().getRenderingMode().intValue());
        super.processTextPosition(text);
    }



}
