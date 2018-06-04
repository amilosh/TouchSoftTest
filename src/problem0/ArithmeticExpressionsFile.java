package problem0;

import java.io.IOException;

public interface ArithmeticExpressionsFile {
    /**
     * This method finds all lines, that have even number
     * using Java language capabilities.
     * @param fullPathTiFile this file contains checking lines
     */
    void checkUsingJava(String fullPathTiFile) throws IOException;

    /**
     * This method finds all lines, that have even number
     * using Java language capabilities and regular expressions.
     * @param fullPathTiFile this file contains checking lines
     */
    void checkUsingJavaAndRegExp(String fullPathTiFile) throws IOException;
}
