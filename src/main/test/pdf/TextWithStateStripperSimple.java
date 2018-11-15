package pdf;

import org.apache.pdfbox.text.PDFTextStripper;

import java.io.IOException;

/**
 * Created by jiuyuan4 on 2018/8/10.
 */
public class TextWithStateStripperSimple extends PDFTextStripper {
    public TextWithStateStripperSimple() throws IOException {
        super();
        setSuppressDuplicateOverlappingText(false);

    }
}
