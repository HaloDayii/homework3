public class Factory {
    private StorageTank<Milk> storageTankMilk;
    private StorageTank<Cream> storageTankCream;
    private StorageTank<Cacao> storageTankCacao;
    private StorageTank<Yeast> storageTankYeast;
    private StorageArea<Chocolate> storageAreaChocolate;
    private StorageArea<BoxedMilk> storageAreaBoxedMilk;
    private StorageArea<Yogurt> storageAreaYogurt;

    public Factory(){
        storageTankMilk = new StorageTank();
        storageTankYeast = new StorageTank();
        storageTankCacao = new StorageTank();
        storageTankCream = new StorageTank();
        storageAreaBoxedMilk = new StorageArea();
        storageAreaChocolate = new StorageArea();
        storageAreaYogurt = new StorageArea();
        storageTankCream.store(new Cream(10000));
        storageTankCacao.store(new Cacao(10000));
        storageTankYeast.store(new Yeast(10000));
        storageTankMilk.store(new Milk(10000));

    }

    public void produceBoxedMilk(){
        if(storageTankMilk.getCurrentVolumeOfTank()>=1000){
            for(int i=0;i<1000;i++){
                storageAreaBoxedMilk.store(new BoxedMilk());
            }
            storageTankMilk.drainStorage(1000);
        }
    }

    public void produceChocolate(){
        if((storageTankMilk.getCurrentVolumeOfTank()>=500) && (storageTankCacao.getCurrentVolumeOfTank()>=300) && (storageTankCream.getCurrentVolumeOfTank()>=200)){
            for (int i=0;i<1600;i++){
                storageAreaChocolate.store(new Chocolate());
            }
            storageTankCream.drainStorage(200);
            storageTankCacao.drainStorage(300);
            storageTankMilk.drainStorage(500);
        }
    }
    public void produceYogurt(){
        if((storageTankYeast.getCurrentVolumeOfTank()>=100) && storageTankMilk.getCurrentVolumeOfTank()>=1500){
            for(int i=0;i<700;i++){
                storageAreaYogurt.store(new Yogurt());
            }
            storageTankMilk.drainStorage(1500);
            storageTankYeast.drainStorage(100);
        }else{
            System.err.println("There is no enough ingredients! Buy ingredients.");
        }
    }

    public void loadContainer(IContainer container,int operation){//1-milk 2-cream 3-cacao 4-yeast 5-chocolate 6-boxed milk 7-yogurt

    }

    public void printFactory(){
        storageTankMilk.printStorage();
        storageTankYeast.printStorage();
        storageTankCacao.printStorage();
        storageTankCream.printStorage();
        storageAreaBoxedMilk.printStorage();
        storageAreaChocolate.printStorage();
        storageAreaYogurt.printStorage();

    }
}
