import java.util.EmptyStackException;
import java.util.Stack;

public class TankContainer implements IContainer {
    private final int CAPACITY = 1000;
    private Stack<IUncountable> stack;
    private Location location;
    public TankContainer(){
        stack = new Stack<>();
        location = Location.FACTORY;
    }

    @Override
    public double getEmptySpace() {
        double sum=0;
        for(IUncountable e : stack) {
            sum += e.getVolume();
        }
        return CAPACITY-sum;
    }

    @Override
    public boolean isContainerEmpty() {
        return stack.isEmpty();
    }

    @Override
    public boolean isContainerFull() {
        return (getEmptySpace() == 0);
    }

    @Override
    public void fillContainer(Object object) {
        IUncountable splitObject;
        try {
            if(object instanceof IUncountable){
                if(object.getClass().equals(Milk.class))
                   splitObject = new Milk(1);
                else if(object.getClass().equals(Cream.class)){
                   splitObject = new Cream(1);
                }
                else{ throw new DifferentUncountableItemsException(); } //object is not cream or milk

                if(isContainerEmpty()){
                    if(getEmptySpace() < ((IUncountable) object).getVolume()){
                        splitObject.setVolume((int)getEmptySpace());
                        ((IUncountable) object).setVolume(((IUncountable) object).getVolume()-(int)getEmptySpace());
                        stack.push(splitObject);
                    }
                    else{ stack.push((IUncountable) object);}


                }
                else{
                    if(stack.peek().getClass().equals(object.getClass())){
                        if(getEmptySpace()>=((IUncountable) object).getVolume()){
                        stack.peek().setVolume(stack.peek().getVolume()+((IUncountable) object).getVolume());
                        }
                        else{
                            splitObject.setVolume((int)getEmptySpace());
                            ((IUncountable) object).setVolume(((IUncountable) object).getVolume() - (int)getEmptySpace());
                            stack.peek().setVolume(CAPACITY);
                        }

                    }
                    else{
                        throw new DifferentUncountableItemsException();
                    }
                }
            }


            else{ throw new ItemNotIUncountableException();}



        }catch (DifferentUncountableItemsException | ItemNotIUncountableException e){
            System.out.println(e.getMessage());
        }
    }

    public IUncountable drainContainer(){
        try {
            return stack.pop();
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
        return null;// burayı bi sor!!!!!
    }
    public void displayContainer(){
        try {
            System.out.println(stack.peek().toString());
        }catch (EmptyStackException e){
            System.out.println("stack is empty");
        }

    }
    @Override
    public int getCapacity() {
        return CAPACITY;
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public void setLocation(Location location) {
        this.location = location;
    }
}