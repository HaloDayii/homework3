public class Milk implements IUncountable {
    private int volume;

    public Milk(){
        this(0);
    }
    public Milk(int number){
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
        return volume+"L Milk.";
    }
}
