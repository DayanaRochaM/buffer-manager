package sgbd.objects;

public class Frame {
    
    private int pinCount;
    private String line;
    
    public Frame(String line){
        this.line = line;
    }
    
    public int getPintCount(){   
        return pinCount;
    }

    public void setPinCount(int pinCount) {
        this.pinCount = pinCount;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

} 
