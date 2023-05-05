import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VenditaScontataTest {

    @ParameterizedTest
    @DisplayName("metodo che testa i valori ammissibili di setSconto")
    @ValueSource( doubles = { 2, 11, 14.5,0,100, Double.MAX_VALUE, Double.MIN_VALUE} )
    void test1SetSconto(double n) {
        VenditaScontata prodotto = new VenditaScontata();
        Assertions.assertEquals(true, prodotto.setSconto(n));

    }

    @Test
    @DisplayName("metodo che testa i valori non ammissibili di setSconto (-8, 120, null(?), empty(?))")
    void test2SetSconto() {
        VenditaScontata prodotto = new VenditaScontata();
        /*Double prezzonullo = null;*/
        /*Double prezzovuoto = new Double();*/
        Assertions.assertAll(() -> assertEquals(false, prodotto.setSconto(-9.5)),
                             () -> assertEquals(false, prodotto.setSconto(120))
                /*() -> assertEquals(false, list.get(1).setSconto(prezzonullo))*/
                /*() -> assertEquals(false, list.get(2).setSconto(prezzovuoto))*/);

    }


    @Test
    @DisplayName("test equals")
    void testEquals() {
        VenditaScontata prodotto = new VenditaScontata("penna", 21.50, 10);
        Assertions.assertAll(() -> assertEquals(false, prodotto.equals(new VenditaScontata())),
                () -> assertEquals(false, prodotto.equals(null)),
                () -> assertEquals(false, prodotto.equals(new String())),
                () -> assertEquals(true, prodotto.equals(new VenditaScontata("penna", 21.50, 10))),
                () -> assertEquals(false, prodotto.equals(new VenditaScontata("penna", 11.05, 10))),
                () -> assertEquals(false, prodotto.equals(new VenditaScontata("matita", 21.50, 10))),
                () -> assertEquals(false, prodotto.equals(new VenditaScontata("cancellino", 7.49, 30))),
                () -> assertEquals(false, prodotto.equals(new VenditaScontata("penna", 21.5, 17.40))));

    }
}
