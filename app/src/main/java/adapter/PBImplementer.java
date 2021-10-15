package adapter;


import java.util.StringTokenizer;

public class PBImplementer implements PushbackTokenizer {
    private String rawString;
    public StringTokenizer arryLStr;
    private String[] arryToks;
    private int index;

    public PBImplementer(String str){
        this.rawString = str;
        this.arryLStr = new StringTokenizer(str);
        this.arryToks = str.split("\\s");
        this.index = 0;
    }
    // Returns the next token
    public String nextToken(){
        try{
            String outStr = arryToks[index];
            incrementIndex();
            return outStr;
        }catch(IndexOutOfBoundsException e){
            System.out.println("index out of bounds for array string");
        }
        return null;
    };

    // Returns true if and only if there are more tokens
    public boolean hasMoreTokens(){
        return index <= (arryToks.length -1);
    };

    // The token read is pushed back, so it can be read again using nextToken.
    public void pushback(){index--;};

    public void incrementIndex(){index++;}
}
