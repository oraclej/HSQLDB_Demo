import ir.oraclej.hsqlDemo.HSQLConnection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test1 {
    @Test
    public void dbTest(){
        Assertions.assertNotNull(HSQLConnection.getConnection());
    }
}
