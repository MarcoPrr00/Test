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
    @DisplayName("metodo che testa i valori non ammissibili di setSconto (-8, null, empty)")
    void test2SetSconto() {
        VenditaScontata prodotto = new VenditaScontata();
        /*Double prezzonullo = null;*/
        /*Double prezzovuoto = new Double();*/
        Assertions.assertAll(() -> assertEquals(false, prodotto.setSconto(-9.5))
                /*() -> assertEquals(false, list.get(1).setSconto(prezzonullo))*/
                /*() -> assertEquals(false, list.get(2).setSconto(prezzovuoto))*/);

    }

    @ParameterizedTest
    @DisplayName("metodo che testa i valori non ammissibili di setSconto con correzzione per valori maggiori di 100")
    @ValueSource( doubles = { -9.5, 101, Double.MAX_VALUE} )
    void test3SetSconto(double n) {
        VenditaScontata prodotto = new VenditaScontata();
        Assertions.assertEquals(false, prodotto.setSconto2(n));

    }
}
