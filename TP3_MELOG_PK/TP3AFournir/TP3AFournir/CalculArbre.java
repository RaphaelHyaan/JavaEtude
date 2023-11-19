
import java.util.*;

public class CalculArbre {
    Arbre<String> racine;

    public CalculArbre(){}

    public void genCalculArbre(String expression){
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i<expression.length();i++){
            char word = expression.charAt(i);
            
        }
    }

    public Vector<String> splitAndBalance(String expr) {  
        Vector<String> result = new Vector<>();
        boolean i = true;
        StringBuilder new_word = new StringBuilder();
        
        for (char c : expr.toCharArray()) {  
            if (c!='(' && i == true){
                StringBuilder new_s_word = new StringBuilder(c);
                result.add(new_s_word.toString());
            }
            else if (c=='('){
                i = false;
            }
            else if (c == ')'){
                i = true;
                result.add(new_word.toString());
                new_word = new StringBuilder();
            }
            else{
                new_word.append(c);
            }
        }  
        return result;
    }

    public Arbre<String> ProcessNoP(String expression){
        Vector<Arbre<String>> list = new Vector<>(expression.length());
        Arbre<String> racine = new Arbre<String>("");
        int i = 0;

        //查找^
        i = expression.indexOf("^",i);
        while(i!=-1){
            Arbre<String> power = new Arbre<String>("^");
            Arbre<String> left_number = new Arbre<String>(expression.substring(i-1,i));
            Arbre<String> righr_number = new Arbre<String>(expression.substring(i+1,i+2));
            power.affecterFilsDroit(righr_number);
            power.affecterFilsGauche(left_number);
            list.set(i,power);
            list.set(i-1,power);
            list.set(i+1,power);
            i = expression.indexOf("^",i);
        }

        //查找乘除*/
        i = 0;
        i = findBiIndexMin(expression, "*", "/", i);
        while(i != -1){
            Arbre<String> fd = new Arbre<String>(expression.substring(i,i+1));
            if (list.get(i+1)!=null){
                fd.affecterFilsDroit(list.get(i+1));
            }
            else{
                Arbre<String> righr_number = new Arbre<String>(expression.substring(i+1,i+2));
                fd.affecterFilsDroit(righr_number);
            }
            if (list.get(i-1)!=null){
                fd.affecterFilsGauche(list.get(i-1));
            }
            else{
                Arbre<String> left_number = new Arbre<String>(expression.substring(i-1,i));
                fd.affecterFilsDroit(left_number);
            }
            list.set(i,fd);
            list.set(i-1,fd);
            list.set(i+1,fd);
            i = findBiIndexMin(expression, "*", "/", i);
        }

        //查找加减*/
        i = 0;
        i = findBiIndexMin(expression, "+", "-", i);
        while(i != -1){
            Arbre<String> fd = new Arbre<String>(expression.substring(i,i+1));
            if (list.get(i+1)!=null){
                fd.affecterFilsDroit(list.get(i+1));
            }
            else{
                Arbre<String> righr_number = new Arbre<String>(expression.substring(i+1,i+2));
                fd.affecterFilsDroit(righr_number);
            }
            if (list.get(i-1)!=null){
                fd.affecterFilsGauche(list.get(i-1));
            }
            else{
                Arbre<String> left_number = new Arbre<String>(expression.substring(i-1,i));
                fd.affecterFilsDroit(left_number);
            }
            list.set(i,fd);
            list.set(i-1,fd);
            list.set(i+1,fd);
            i = findBiIndexMin(expression, "+", "-", i);
        }
        racine = list.get(0);

        return racine;
    }

    public int findBiIndexMin(String expression, String a,String b,int index_begin){
        int index_min;
        int index_foi = expression.indexOf("*",index_begin);
        int index_divise = expression.indexOf("/", index_begin);
        if (index_divise == -1){
            index_min = index_foi;
        }
        else if (index_foi == -1){
            index_min = index_divise;
        }
        else if (index_divise<index_foi){
            index_min = index_divise;
        }
        else{
            index_min = index_foi;
        }
        return index_min;
    }

}
