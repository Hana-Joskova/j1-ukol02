package cz.czechitas.turtle;

import cz.czechitas.turtle.engine.*;

import static java.lang.Math.sin;
import static java.lang.Math.sqrt;

public class HlavniProgram {
    private Turtle zofka = new Turtle();

    public void start() {

    }

    private void nakresliRovnostrannyTrojuhelnik(double strana_trojuhelniku) {
        for (int i = 0; i < 3; i++) {
            zofka.move(strana_trojuhelniku);
            zofka.turnRight(120);
        }
    }

    private void nakresliRovnoramennyTrojuhelnik(double predpona) {
        double odvesna = sqrt(predpona * predpona / 2);
        zofka.turnRight(45);
        zofka.move(odvesna);
        zofka.turnRight(90);
        zofka.move(odvesna);
        zofka.turnRight(135);
        zofka.move(predpona);
        zofka.turnRight(90);
    }

    private void nakresliCtverec(double strana_ctverce) {
        for (int i = 0; i < 4; i++) {
            zofka.turnRight(90);
            zofka.move(strana_ctverce);
        }
    }

    private void nakresliObdelnik(double kratsi_strana, double delsi_strana) {
        for (int i = 0; i < 2; i++) {
            zofka.turnRight(90);
            zofka.move(kratsi_strana);
            zofka.turnRight(90);
            zofka.move(delsi_strana);
        }
    }

    private void nakresliKolecko(double polomer, double uhel) {
        double delka_strany = 2 * (polomer * sin((uhel * (Math.PI / 180)/2)));
        for (int n = 0; n < 360/uhel; n++) {
            zofka.move(delka_strany);
            zofka.turnRight(uhel);
        }
    }

    public static void main(String[] args) {
        new HlavniProgram().start();
    }
}
