import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VenditaTest {
    @ParameterizedTest
    @DisplayName("metodo che testa i valori ammissibili di setPrezzo")
    @ValueSource ( doubles = { 9, 12, 14.5, 124.75} )
    void test1SetPrezzo(double n) {
        Vendita tmp = new Vendita();
        Assertions.assertEquals(true, tmp.setPrezzo(n));

    }

    @Test
    @DisplayName("metodo che testa i valori non ammissibili di setPrezzo (-8, 0, null, empty)")
    void test2SetPrezzo(double n) {
        List<Vendita> list = List.of(new Vendita(),new Vendita(), new Vendita());

        Assertions.assertAll(() -> assertEquals(false, list.get(0).setPrezzo(-8)),
                             () -> assertEquals(false, list.get(1).setPrezzo(0)),
                             () -> assertEquals(false, list.get(2).setPrezzo(null));

    }
}
