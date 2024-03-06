import java.util.*;

public class Ejecutor {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.printf("Son las %1$tH:%1$tM del %tA %1$td de %1$tB de %1$tY", c);// te imprime el dia, la hora y
                                                                                    // fecha actual
        Algomas cl = new Algomas();
        cl.menu();
    }
}
