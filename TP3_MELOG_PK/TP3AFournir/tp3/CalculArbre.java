
import java.util.*;

public class CalculArbre {
    //根节点
    Arbre<String> racine;

    //运算符（遗留问题）
    final Arbre<String> plus;
    final Arbre<String> moins;
    final Arbre<String> fois;
    final Arbre<String> divise;
    final Arbre<String> puissance;
    final Arbre<String> left_bracket;
    final Arbre<String> right_bracket;

    //运算符最大优先级
    final int max_priority = 3;

    //变量x的值
    Double x = null;

    //构造函数
    public CalculArbre(){
        plus = new Arbre<String>("+");
        moins = new Arbre<String>("-");
        fois = new Arbre<String>("*");
        divise = new Arbre<String>("/");
        puissance = new Arbre<String>("^");
        left_bracket = new Arbre<String>("(");
        right_bracket = new Arbre<String>(")");
    }

    //获取表达式
    public void getExpression(String expression){
        Vector<Arbre<String>> expressionVec = toVector(expression);
        racine = ProcessNoP(expressionVec);
        check();
    }

    //生成运算树
    public Arbre<String> ProcessNoP(Vector<Arbre<String>> expression){
        ArrayList<Integer> priority = getPriority(expression);
        int index;
        Arbre<String> noyau;

        removeBracket(expression,priority);

        while (expression.size()!=1){
            index = getMaxIndex(priority);

            noyau = expression.get(index);
            expression.set(index,getSousArbreRacine(expression, noyau, index));

            expression.remove(index+1);
            priority.remove(index+1);
            priority.set(index,0);
            expression.remove(index-1);
            priority.remove(index-1);        
        }
        return expression.get(0);
    }

    //计算运算树
    public Double calculArbre(){
        Stack<Arbre<String>> stack = getStackBreadth();
        Arbre<String> noyau;
        while(stack.size()!=0){
            noyau = stack.pop();
            if (noyau.feuille()){
                continue;
            }
            else{
                noyau = calculSousFeuillArbre(noyau);
                if(noyau == null){
                    return null;
                }
            }
        }
        if (racine.valeur().equals("x")){
            return x;
        }
        return Double.parseDouble(racine.valeur());
    }

    //设置x
    public void setX(Double x){
        this.x = x;
    }

    //对多项式求导
    public void derivePolynome(){
        Arbre<String> noyau,left,right;
        Stack<Arbre<String>> stack = getStackBreadth();

        //检查常数项
        setConstantNull(racine);

        while(!stack.empty()){
            noyau = stack.pop();
            left = noyau.filsGauche();
            right = noyau.filsDroit();
            if (left == null || right == null){
                continue;
            }
            if (left.valeur().equals("x")){
                if (noyau.valeur().equals("^")){
                    //新增一个(n-1)x的节点，这里为了减少节点数量会直接计算n-1,这里没有抛弃节点所以没有数据丢失
                    Arbre<String> newnoyau = new Arbre<String>("^");

                    newnoyau.affecterFilsGauche(left);

                    Double newvaleur = Double.parseDouble(right.valeur());
                    Double newpuissance = Double.parseDouble(right.valeur())-1;

                    newnoyau.affecterFilsDroit(new Arbre<String>(newpuissance.toString()));
                    right.affecterValeur(newvaleur.toString());

                    noyau.affecterFilsGauche(newnoyau);
                    noyau.affecterValeur("*");
                }
                else if (noyau.valeur().equals("*") || noyau.valeur().equals("+")){
                    //对于一次方的量，设为1
                    left.affecterValeur("1");
                }
            }
            else if (right.valeur().equals("x")){
                if (noyau.valeur().equals("*") || noyau.valeur().equals("+")){
                    //对于一次方的量，设为1
                    right.affecterValeur("1");
                }
            }
        }

        check();
    }

    //重载，对多项式求导
    public Arbre<String> derivePolynome(Arbre<String> sousRacine){
        Arbre<String> noyau,left,right;
        Stack<Arbre<String>> stack = getStackBreadth(sousRacine);

        //检查常数项
        setConstantNull(sousRacine);

        while(!stack.empty()){
            noyau = stack.pop();
            left = noyau.filsGauche();
            right = noyau.filsDroit();
            if (left == null || right == null){
                continue;
            }
            if (left.valeur().equals("x")){
                if (noyau.valeur().equals("^")){
                    //新增一个(n-1)x的节点，这里为了减少节点数量会直接计算n-1,这里没有抛弃节点所以没有数据丢失
                    Arbre<String> newnoyau = new Arbre<String>("^");

                    newnoyau.affecterFilsGauche(left);

                    Double newvaleur = Double.parseDouble(right.valeur());
                    Double newpuissance = Double.parseDouble(right.valeur())-1;

                    newnoyau.affecterFilsDroit(new Arbre<String>(newpuissance.toString()));
                    right.affecterValeur(newvaleur.toString());

                    noyau.affecterFilsGauche(newnoyau);
                    noyau.affecterValeur("*");
                }
                else if (noyau.valeur().equals("*") || noyau.valeur().equals("+")){
                    //对于一次方的量，设为1
                    left.affecterValeur("1");
                }
            }
            else if (right.valeur().equals("x")){
                if (noyau.valeur().equals("*") || noyau.valeur().equals("+")){
                    //对于一次方的量，设为1
                    right.affecterValeur("1");
                }
            }
        }

        check();
        return sousRacine;
    }

    //对分式求导
    public void deriveRationnelle(){
        if (!racine.valeur().equals("/")){
            System.err.println("这不是分式");
            System.exit(0);
        }

        Arbre<String> left,right,leftCopy,rightCopy,leftDerived,rightDerived,plus,fois;
        left = racine.filsGauche();
        right = racine.filsDroit();

        leftCopy = copySousArbre(left);
        rightCopy = copySousArbre(right);

        leftDerived = derivePolynome(copySousArbre(leftCopy));
        rightDerived = derivePolynome(copySousArbre(rightCopy));

        plus = new Arbre<String>("+");
        plus.affecterFilsGauche(new Arbre<String>("*"));
        plus.affecterFilsDroit(new Arbre<String>("*"));

        plus.filsGauche().affecterFilsGauche(copySousArbre(leftDerived));
        plus.filsGauche().affecterFilsDroit(copySousArbre(rightCopy));
        plus.filsDroit().affecterFilsGauche(copySousArbre(leftCopy));
        plus.filsDroit().affecterFilsDroit(copySousArbre(rightDerived));

        fois = new Arbre<String>("^");
        fois.affecterFilsDroit(new Arbre<String>("2"));
        fois.affecterFilsGauche(copySousArbre(rightCopy));

        racine.affecterFilsDroit(fois);
        racine.affecterFilsGauche(plus);

        check();
    }

    //打印树
    public void printArbre(){
        printArbre(racine,1);
    }
    
    //重载打印树
    public void printArbre(Arbre<String> noayu,int n){
        System.out.printf("            ");
        System.out.printf("%s",noayu.valeur());
        if (noayu.filsGauche()!=null){
            printArbre(noayu.filsGauche(),n+1);
        }
        else{
            System.out.printf("\n");
            for (int i  = 0;i<n-1;i++){System.out.printf("            ");}
        }
        if (noayu.filsDroit()!=null){
            printArbre(noayu.filsDroit(),n+1);
        }
        else{
            System.out.printf("\n");
            for (int i  = 0;i<n-1;i++){System.out.printf("            ");}
        }
    }

    //将表达式从字符串转化为Vector，如果需要增加三角函数，可以修改这一部分来改变转换方式，将sin视为一个整体
    private Vector<Arbre<String>> toVector(String expression){
        Vector<Arbre<String>> expressionVec = new Vector<>();
        Arbre<String> noyau;
        for (int i = 0;i<expression.length();i++){
            expressionVec.add(new Arbre<String>(expression.substring(i, i+1)));
        }
        return expressionVec;
    }

    //获得运算优先级数组
    private ArrayList<Integer> getPriority(Vector<Arbre<String>> expression){
        ArrayList<Integer> priority = new ArrayList<>(expression.size());
        int priorityPlus = 0;


        for (Arbre<String> e : expression){
            if (e.compare(plus)||e.compare(moins)){
                priority.add(1+priorityPlus);
            }
            else if (e.compare(fois)||e.compare(divise)){
                priority.add(2+priorityPlus);
            }
            else if (e.compare(puissance)){
                priority.add(3+priorityPlus);
            }
            else if (e.compare(left_bracket)){
                priorityPlus+=max_priority;
                priority.add(-1);
            }
            else if (e.compare(right_bracket)){
                priorityPlus-=max_priority;
                priority.add(-1);
            }
            else{
                priority.add(0);
            }
        }

        return priority;
    }

    //删除括号
    private void removeBracket(Vector<Arbre<String>> expression,ArrayList<Integer> priority){
        int index = priority.indexOf(-1);;
        while(index!=-1){
            expression.remove(index);
            priority.remove(index);
            index = priority.indexOf(-1);
        }
    }

    //获得最大优先级索引
    private int getMaxIndex(ArrayList<Integer> list){
        int indexOfMaxElement = list.indexOf(Collections.max(list));
        return indexOfMaxElement;
    }
    
    //获得运算栈，实际上几乎所有的运算都是基于运算栈实现的而不是基于树实现的
    private Stack<Arbre<String>> getStackBreadth(){
        Queue<Arbre<String>> queue  = new LinkedList<>();
        Stack<Arbre<String>> stack = new Stack<>();
        queue.offer(racine);
        Arbre<String> noyau;
        while(queue.size()!=0){
            noyau = queue.poll();
            stack.push(noyau);
            if (noyau.filsDroit()!=null){queue.offer(noyau.filsGauche());}
            if (noyau.filsGauche()!=null){queue.offer(noyau.filsDroit());}
        }
        return stack;
    }

    //获得运算栈，实际上几乎所有的运算都是基于运算栈实现的而不是基于树实现的
    private Stack<Arbre<String>> getStackBreadth(Arbre<String> sousRacine){
        Queue<Arbre<String>> queue  = new LinkedList<>();
        Stack<Arbre<String>> stack = new Stack<>();
        queue.offer(sousRacine);
        Arbre<String> noyau;
        while(queue.size()!=0){
            noyau = queue.poll();
            stack.push(noyau);
            if (noyau.filsDroit()!=null){queue.offer(noyau.filsGauche());}
            if (noyau.filsGauche()!=null){queue.offer(noyau.filsDroit());}
        }
        return stack;
    }

    //下沉表达式，获得根节点
    private Arbre<String> getSousArbreRacine(Vector<Arbre<String>> expression,Arbre<String> noyau,int index){
        //检查
        Arbre<String> right = expression.get(index+1);
        Arbre<String> left = expression.get(index-1);
        noyau.affecterFilsDroit(right);
        noyau.affecterFilsGauche(left);
        return noyau;
    }

    //计算叶节点
    private Arbre<String> calculSousFeuillArbre(Arbre<String> sousFeuille){
        Arbre<String> noyau = sousFeuille;
        Arbre<String> right = checkX(sousFeuille.filsDroit());
        Arbre<String> left = checkX(sousFeuille.filsGauche());

        if (noyau.valeur().equals("+")){
            Double valeur;
            valeur = Double.parseDouble(left.valeur())+Double.parseDouble(right.valeur());
            noyau.affecterValeur(valeur.toString());
        }
        if (noyau.valeur().equals("-")){
            Double valeur;
            valeur = Double.parseDouble(left.valeur())-Double.parseDouble(right.valeur());
            noyau.affecterValeur(valeur.toString());
        }
        if (noyau.valeur().equals("*")){
            Double valeur;
            valeur = Double.parseDouble(left.valeur())*Double.parseDouble(right.valeur());
            noyau.affecterValeur(valeur.toString());
        }
        if (noyau.valeur().equals("/")){
            Double valeur;
            valeur = Double.parseDouble(left.valeur())/Double.parseDouble(right.valeur());
            noyau.affecterValeur(valeur.toString());
        }
        if (noyau.valeur().equals("^")){
            Double valeur;
            valeur = Math.pow(Double.parseDouble(left.valeur()),Double.parseDouble(right.valeur()));
            noyau.affecterValeur(valeur.toString());
        }

        noyau.affecterFilsDroit(null);
        noyau.affecterFilsGauche(null);
        return noyau;
    }

    //检查子节点是否为x
    private Arbre<String> checkX(Arbre<String> sousnoyau){
        if (sousnoyau.valeur().equals("x")){
            if (x == null){
                System.out.println("错误:未提供x的值");
                System.exit(0);
            }
            else{
                sousnoyau.affecterValeur(x.toString());
            }
        }
        return sousnoyau;
    }

    //检查表达式中的无效分支
    private void check(){
        Arbre<String> noyau,left,right;

        Stack<Arbre<String>> stack = getStackBreadth();

        while (!stack.empty()){
            noyau = stack.pop();
            //检查
            right = noyau.filsDroit();
            left = noyau.filsGauche();
             if (noyau.valeur().equals("+")){
                if (right.valeur().equals("0")||right.valeur().equals("0.0")){
                    noyau.copyArbre(left);
                    continue ;
                }
                if (left.valeur().equals("0")||left.valeur().equals("0.0")){
                    noyau.copyArbre(right);
                    continue ;
                }
            }
            if (noyau.valeur().equals("-")){
                if (right.valeur().equals("0")||right.valeur().equals("0.0")){
                    noyau.copyArbre(left);
                    continue ;
                }            
            }
            if (noyau.valeur().equals("*")){
                if (right.valeur().equals("0")||right.valeur().equals("0.0")){
                    noyau.copyArbre(right);
                    continue ;
                }
                if (left.valeur().equals("0")||left.valeur().equals("0.0")){
                    noyau.copyArbre(left);
                    continue ;
                }
                if (right.valeur().equals("1")||right.valeur().equals("1.0")){
                    noyau.copyArbre(left);
                    continue ;
                }
                if (left.valeur().equals("1")||left.valeur().equals("1.0")){
                    noyau.copyArbre(right);
                    continue ;
                }
            }
            if (noyau.valeur().equals("/")){
                if (right.valeur().equals("1")||right.valeur().equals("1.0")){
                    noyau.copyArbre(left);
                    continue ;
                }
                if (left.valeur().equals("0")||left.valeur().equals("0.0")){
                    noyau.copyArbre(left);
                    continue ;
                }
            }
            if (noyau.valeur().equals("^")){
                if (right.valeur().equals("1")||right.valeur().equals("1.0")){
                    noyau.copyArbre(left);
                    continue ;
                }
                if (left.valeur().equals("0")||left.valeur().equals("0.0")){
                    noyau.copyArbre(new Arbre<String>("1"));
                    continue ;
                }            
            }
        }


    }

    //将所有常量设置为0
    private boolean setConstantNull(Arbre<String> noyau){
        Arbre<String> n;
        if (noyau.valeur().equals("x")){
            return false;
        }
        boolean out = true;
        if (noyau.valeur().equals("+")||noyau.valeur().equals("-")){
            if (noyau.filsGauche()!=null){
                if (!setConstantNull(noyau.filsGauche())){
                    out = false;
                }
                else{
                    noyau.affecterFilsGauche(new Arbre<String>("0"));
                }
            }
            if (noyau.filsDroit()!=null){
                if (!setConstantNull(noyau.filsDroit())){
                    out = false;
                }
                else{
                    noyau.affecterFilsDroit(new Arbre<String>("0"));
                }
            }
            return out;
        }
        else{
            return !searchSousArbre(noyau, "x");
        }
    }

    //在子树中搜索object
    private boolean searchSousArbre(Arbre<String> noyau,String objet){
        if (noyau.valeur().equals(objet)){
            return true;
        }

        if (noyau.filsGauche()!=null){
            if (searchSousArbre(noyau.filsGauche(), objet)){
                return true;
            }
        }

        if (noyau.filsDroit()!=null){
            if (searchSousArbre(noyau.filsDroit(), objet)){
                return true;
            }
        }
        return false;
    }

    //复制子树
    private Arbre<String> copySousArbre(Arbre<String> sousArbre){
        Arbre<String> newRacine = new Arbre<String>(sousArbre.valeur());
        if (sousArbre.filsGauche()!=null){
            newRacine.affecterFilsGauche(copySousArbre(sousArbre.filsGauche()));
        }
        if (sousArbre.filsDroit()!=null){
            newRacine.affecterFilsDroit(copySousArbre(sousArbre.filsDroit()));
        }
        return newRacine;
    }
}
