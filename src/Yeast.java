public class Yeast implements IUncountable{
    private int volume;

    public Yeast(){
        this(0);
    }
    public Yeast(int number){
        setVolume(number);
    }

    public int getVolume() {
        return volume;
    }
    public void setVolume(int volume) {
        if(volume>=0) {
            this.volume = volume;
        }
    }
    public String toString(){
        return volume+"L Yeast.";
    }
}
