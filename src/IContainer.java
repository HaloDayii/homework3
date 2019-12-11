public interface IContainer {

    public double getEmptySpace();
    public boolean isContainerEmpty();
    public boolean isContainerFull();
    public void fillContainer(Object object);
    //public void moveContainer(Location location);
    public int getCapacity();
    public Location getLocation();
    public void setLocation(Location location);
}
