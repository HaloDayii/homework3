import java.util.Stack;

public class DryStorageContainer implements IContainer {
    private final int CAPACITY = 1000;
    private Stack<ICountable> stack;
    private Location location;

    public DryStorageContainer(){
        stack = new Stack<>();
        location = Location.FACTORY;

    }

    @Override
    public double getEmptySpace() {
        double sum=0;
        for(ICountable ic : stack){
            sum+=ic.getVolume();
        }
        return CAPACITY-sum;
    }

    @Override
    public boolean isContainerEmpty() {
        return stack.isEmpty();
    }

    @Override
    public boolean isContainerFull() {
        return (getEmptySpace()==0);
    }

    @Override
    public void fillContainer(Object object) {
        try {
            if (object instanceof ICountable){
                if (!isContainerFull()) {
                    stack.push((ICountable) object);
                    return;
                }
                System.out.println("DryStorageContainer is full");
            }
            else{
                throw new ItemNotCountableException();
            }
        }catch (ItemNotCountableException e){
            System.out.println(e.getMessage());
        }

    }

   public ICountable removeOneCountableItemFromStack() {
        if(isContainerEmpty()){
            System.err.println("Container is empty!");
            return null;
        }
        return stack.pop();
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
