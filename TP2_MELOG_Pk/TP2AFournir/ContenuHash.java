import java.io.*;
import java.util.*;


public class ContenuHash extends LinkedHashMap<String, Integer> {
    protected String nom;
    final String delimiteurs = "/0123456789%$*-_=+#'.,;:?!() {}[]`<>\"\t\\<>��";
    protected LinkedList<String> newWord;
    protected LinkedHashMap<String,Vector<Integer>> wordPosition;

    public ContenuHash(String texte) throws IOException{
        wordPosition = new LinkedHashMap<String,Vector<Integer>>();
        this.addNewText(texte);
    }

    public void addNewText(String texte) throws IOException{
        nom = texte;//文件名

        newWord = new LinkedList<String>();
        
        
        //读取文件
        Reader reader = new FileReader(texte+".txt");
        //读取流
        BufferedReader in  = new BufferedReader(reader);
        //读取第一句
        String ligne = in.readLine();
        Integer i = 1;
        //开始循环
        while (ligne != null){
            StringTokenizer st = new StringTokenizer(ligne,delimiteurs);
            while (st.hasMoreTokens()){
                String mot = st.nextToken();
                mot=mot.toLowerCase();
                if (this.get(mot) == null){
                    this.put(mot, 1);
                    newWord.add(mot);
                    wordPosition.put(mot,new Vector<Integer>());
                    wordPosition.get(mot).add(i);
                }
                else{
                    this.put(mot, 1+this.get(mot));
                    wordPosition.get(mot).add(i);
                }
            }
            //读取下一句
            ligne = in.readLine();
            i++;
        }
    }

    public void ecri() throws IOException{
        Writer writer = new FileWriter(this.nom+"_modifieHash.txt");
        writer.write("############\n#\n# Contenu de "+this.nom+".txt :\n#\n#\t"+this.size()+" mots.\n#\n############\n\n");
		// Tous les mots de la liste constituee
		for(Map.Entry<String,Integer> k : this.entrySet())	{  // this est une LinkedList<String>
			writer.write(k.getKey()+":"+k.getValue()+'\n');
			writer.flush();
		}
		writer.close();
    }

    public void getWordNumber(){
        System.out.printf("总不同单词数量：%d\n",this.size());
    }

    public LinkedList<String> getNewWordList(){
        return newWord;
    }

    public Vector<Integer> getPosition(String mot){
        return wordPosition.get(mot);
    }

    public void printNewWord(){
        System.out.printf("以下是新的单词, 共计%d个：",newWord.size());
        for (String word :newWord){
            System.out.printf("    "+word+";");
        }
    }

    public void printPosition(String mot){
        Vector<Integer> vs = wordPosition.get(mot);
        System.out.printf("%s在这些行出现：",mot);
        for (Integer v : vs){
            System.out.printf("%d  ",v);
        }
        System.out.println();
    }

    public Integer testWord(String word){
        return this.get(word);
    }

    public void deleteWord(String word){
        this.remove(word);
    }

    private void sort(Comparator<Map.Entry<String,Integer>> lambda){
        List<Map.Entry<String,Integer>> list = new LinkedList<>(this.entrySet());
        Collections.sort(list,lambda);
        this.clear();
        for (Map.Entry<String,Integer> entry : list){
            this.put(entry.getKey(),entry.getValue());
        }
    }

    public void sortByValue(int mode){
        this.sort((o1,o2)->o2.getValue().compareTo(o1.getValue()));
    }

    public void sortByValue(){
        this.sort(Map.Entry.comparingByValue());
    }

    public void sortByKey(){
        this.sort(Map.Entry.comparingByKey());
    }

    public Vector<String> getWordPlusFrequence(){
        Vector<String> wordPlusFrequence = new Vector<String> ();
        this.sortByValue(1);
        int i = 0;
        for (String key : this.keySet()){
            if (key.length()>=3){
                wordPlusFrequence.add(key);
                i++;
            }
            if (i>15){
                break;
            }
        }
        return wordPlusFrequence;
    }

    public void printWordPlusFrequence(){
        Vector<String> wordPlusFrequence = this.getWordPlusFrequence();
        for (Object word : wordPlusFrequence){
            System.out.println("   "+word+':'+this.get(word));
        }
    }
}
