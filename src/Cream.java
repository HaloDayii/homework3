public class Cream implements IUncountable {
    private int volume;

    public Cream(){
        this(0);
    }
    public Cream(int number){
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
        return volume+"L Cream.";
    }
}
