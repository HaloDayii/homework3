public class Cacao implements IUncountable {
    private int amount;
    private int volume;

    public Cacao(){
        this(0);
    }
    public Cacao(int number){
        setAmount(number);
    }

    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        if(amount>=0) {
            this.amount = amount;
            this.volume = amount;
        }
    }
    public int getVolume() {
        return volume;
    }
    public void setVolume(int volume) {
        if(amount>=0) {
            this.volume = volume;
            this.amount = volume;
        }
    }

    public String toString(){
        return volume+"L Cacao.";
    }
}
