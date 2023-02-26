package cz.czechitas.turtle;

import cz.czechitas.turtle.engine.*;

import java.awt.*;

import static java.lang.Math.*;

public class HlavniProgram {
    private final Turtle zmrzlina = new Turtle();
    private final Turtle snehulak = new Turtle();
    private final Turtle masinka = new Turtle();
    static final double polomer_kopecek = 40;
    static final double polomer_hlava = 40;
    static final double polomer_telo = polomer_hlava * 1.5;
    static final double polomer_nohy = polomer_hlava * 2;
    static final double polomer_ruce = polomer_hlava / 2;
    static final double polomer_zadni_kolo = 60;
    int uhel = 10;

    public void start() {
        presunZelvyZmrzliny(zmrzlina);
        presunZelvyMasinky(masinka);
        presunZelvySnehulaka(snehulak);
        zmrzlina(zmrzlina);
        snehulak(snehulak);
        masinka(masinka);
    }

    public static void main(String[] args) {
        new HlavniProgram().start();
    }

    private void nakresliRovnostrannyTrojuhelnik(Turtle turtle, double strana_trojuhelniku) {
        for (int i = 0; i < 3; i++) {
            turtle.move(strana_trojuhelniku);
            turtle.turnRight(120);
        }
    }

    private void nakresliRovnoramennyTrojuhelnik(Turtle turtle, double predpona) {
        double odvesna = sqrt(predpona * predpona / 2);
        turtle.turnRight(90);
        turtle.move(odvesna);
        turtle.turnRight(135);
        turtle.move(predpona);
        turtle.turnRight(135);
        turtle.move(odvesna);
    }

    private void nakresliCtverec(Turtle turtle, double strana_ctverce) {
        for (int i = 0; i < 4; i++) {
            turtle.turnRight(90);
            turtle.move(strana_ctverce);
        }
    }

    private void nakresliObdelnik(Turtle turtle, double kratsi_strana, double delsi_strana) {
        for (int i = 0; i < 2; i++) {
            turtle.move(delsi_strana);
            turtle.turnRight(90);
            turtle.move(kratsi_strana);
            turtle.turnRight(90);
        }
    }

    private void nakresliKolecko(Turtle turtle, double polomer, double uhel) {
        double delka_strany = 2 * (polomer * sin((uhel * (Math.PI / 180) / 2)));
        for (int n = 0; n < 360 / uhel; n++) {
            turtle.move(delka_strany);
            turtle.turnRight(uhel);
        }
    }

    private void nakresliKornoutek(Turtle turtle, double predpona) {
        turtle.setPenColor(Color.gray);
        double odvesna = 2 * (predpona * cos((15 * (Math.PI / 180) / 2)));
        turtle.turnRight(90);
        turtle.move(predpona);
        turtle.turnRight(105);
        turtle.move(odvesna);
        turtle.turnRight(150);
        turtle.move(odvesna);
        turtle.turnRight(75);
    }

    private void presunZelvyZmrzliny(Turtle turtle) {
        turtle.penUp();
        turtle.turnLeft(90);
        turtle.move(400);
        turtle.turnRight(90);
        turtle.move(150);
        turtle.penDown();
    }

    private void presunZelvySnehulaka(Turtle turtle) {
        turtle.penUp();
        turtle.move(150);
        turtle.setPenColor(Color.blue);
        turtle.penDown();
    }

    private void presunZelvyMasinky(Turtle turtle) {
        turtle.penUp();
        turtle.turnRight(90);
        turtle.move(400);
        turtle.turnLeft(90);
        turtle.penDown();
    }

    private void zmrzlina(Turtle turtle) {
        turtle.setPenColor(Color.orange);
        nakresliKolecko(turtle, polomer_kopecek, uhel);
        turtle.turnLeft(180);
        turtle.penUp();
        turtle.move(polomer_kopecek / 2);
        turtle.turnRight(180);
        turtle.penDown();
        nakresliKornoutek(turtle, (polomer_kopecek * 2));
    }

    private void snehulak(Turtle turtle) {
        turtle.turnLeft(90);
        nakresliKolecko(turtle, polomer_hlava, uhel);
        turtle.turnRight(180);
        nakresliKolecko(turtle, polomer_telo, uhel);
        turtle.penUp();
        for (int i = 0; i < 2; i++) {
            turtle.turnRight(90);
            turtle.move(polomer_telo);
        }
        turtle.turnLeft(90);
        turtle.penDown();
        nakresliKolecko(turtle, polomer_ruce, uhel);
        turtle.penUp();
        turtle.turnLeft(90);
        turtle.move(polomer_telo * 2);
        turtle.turnLeft(90);
        turtle.penDown();
        nakresliKolecko(turtle, polomer_ruce, uhel);
        turtle.penUp();
        for (int i = 0; i < 2; i++) {
            turtle.turnLeft(90);
            turtle.move(polomer_telo);
        }
        turtle.turnLeft(90);
        turtle.penDown();
        nakresliKolecko(turtle, polomer_nohy, uhel);
    }

    private void masinka(Turtle turtle) {
        turtle.setPenColor(Color.red);
        nakresliKolecko(turtle, polomer_zadni_kolo, uhel);
        nakresliObdelnik(turtle, polomer_zadni_kolo * 2, polomer_zadni_kolo * 2.6);
        turtle.turnLeft(90);
        nakresliObdelnik(turtle, polomer_zadni_kolo * 1.6, polomer_zadni_kolo * 2.8);
        turtle.penUp();
        turtle.move(polomer_zadni_kolo * 0.9);
        turtle.turnLeft(180);
        turtle.penDown();
        nakresliKolecko(turtle, polomer_zadni_kolo * 0.4, uhel);
        turtle.penUp();
        turtle.turnLeft(180);
        turtle.move(polomer_zadni_kolo * 0.9);
        turtle.turnLeft(180);
        turtle.penDown();
        nakresliKolecko(turtle, polomer_zadni_kolo * 0.4, uhel);
        turtle.penUp();
        turtle.turnLeft(180);
        turtle.move(polomer_zadni_kolo * 1.1);
        turtle.turnLeft(90);
        turtle.move(polomer_zadni_kolo * 0.4);
        turtle.penDown();
        nakresliRovnoramennyTrojuhelnik(turtle, polomer_zadni_kolo * 2);
    }
}
