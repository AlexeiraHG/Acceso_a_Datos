package Empleados;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpresionesRegular {

    public void run() {
        patronExacto("abc");
        contieneCadena("sdvsabcse");
        empiezaporCadena("sdvsabcse");
        empiezaporCadena2("sdvsabcse");
        cadenaConLongitud("wwwww");
        SoloTieneAoB("AAABBBBA");
        CadenaSoloTiene1yNoSeguidoDe2("1111111133443132221");
    }

    private void CadenaSoloTiene1yNoSeguidoDe2(String cadena) {
        Pattern pat = Pattern.compile(".*1(?!2).*");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            System.out.println("Sí");
        } else System.out.println("No");
    }

    private void SoloTieneAoB(String cadena) {
        Pattern pat = Pattern.compile("(a|b)+");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            System.out.println("Sí");
        } else System.out.println("No");
    }

    private void cadenaConLongitud(String cadena) {
        Pattern pat = Pattern.compile("[a-zA-Z]{5,10}");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            System.out.println("Sí");
        } else System.out.println("No");
    }

    private void empiezaporCadena(String cadena) {
        Pattern pat = Pattern.compile("^abc*.");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            System.out.println("Sí");
        } else System.out.println("No");
    }

    private void empiezaporCadena2(String cadena) {
        Pattern pat = Pattern.compile("^[aA]bc*.");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            System.out.println("Sí");
        } else System.out.println("No");
    }

    private void patronExacto(String cadena) {
        Pattern pat = Pattern.compile("abc");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            System.out.println("Sí");
        } else System.out.println("No");
    }

    private void contieneCadena(String cadena) {
        Pattern pat = Pattern.compile(".*abc*.");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            System.out.println("Sí");
        } else System.out.println("No");

    }
}
