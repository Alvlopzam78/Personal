public class App {
    
    //Método recursivo para que dada una cadena de símbolos encuentre todas sus permutaciones
    public static void permutaciones(String cadena){
        String res = "";
        permutaciones(cadena, res);
    }

    private static void permutaciones(String cadena, String res){
        if(cadena==null)
            return;
        if(cadena.length()==0)
            System.out.println(res);
        for(int i = 0; i<cadena.length(); i++){
            String res2 = res + cadena.charAt(i);
            String cadena2 = cadena.substring(0, i) + cadena.substring(i+1);
            permutaciones(cadena2, res2);
        }
    }

    public static int levenshtein(String s1, String s2){
        int cont = 0;
        return levenshtein(s1, s2, cont);
    }

    private static int levenshtein(String s1, String s2, int cont){
        if(s1 == null || s2 == null)
            return -1;
        if(s1.length()==0 || s2.length()==0)
            return cont + s1.length() + s2.length();
        if(s1.charAt(0)==s2.charAt(0)){
            return levenshtein(s1.substring(1), s2.substring(1), cont);
        }
        int sus = levenshtein(s1.substring(1), s2.substring(1), cont+1);
        int ins = levenshtein(s1.substring(1), s2, cont + 1);
        int bor = levenshtein(s1, s2.substring(1), cont + 1);
        if(sus<ins)
            if(sus<bor)
                return sus;
            else
                return bor;
        else
            return ins;
    }
    
    /**
     * @param args
     * @throws Exception
     */

    public static void main(String[] args) throws Exception {
        permutaciones("123");
        System.out.println(levenshtein("fer", "fasr"));
        System.out.println(levenshtein("jugar", "tragar"));
        System.out.println(levenshtein("computer", "disputer"));
        System.out.println(levenshtein("Celular", "Trabajar"));
    }
}