import java.math.BigInteger;
import java.util.Scanner;

public class CodeProvider {
    private BigInteger productCode;

    public CodeProvider() {
        Scanner ean= new Scanner(System.in);
        BigInteger productCode = ean.nextBigInteger();
    }
}
