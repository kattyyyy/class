public class TheDogTest1{
    public static void main(String[] args){
        Dog pochi = new Dog();

        pochi.print();
        pochi.roudou();
        pochi.print();
        pochi.roudou();
    }
}
class Dog{
    private DogState myState;
    
    public Dog(){
        myState = NeteruState.getInstance();
    }
    public void roudou(){
        myState.tukareta(this);
    }
    public void shokuji(){
        myState.tabeta(this);
    }
    public void changeState(DogState d){
        myState = d;
    }
    public void print(){
        System.out.print("現在、わたしは「");
        System.out.print(myState.toString());
        System.out.println("」です。");
    }
}

abstract class DogState{
    public abstract void tukareta(Dog yobidashimoto);
    public abstract void tabeta(Dog yobidashimoto);
}

class NeteruState extends DogState{
    private static NeteruState s = new NeteruState();

    private NeteruState(){}

    public static DogState getInstance(){
        return s;
    }
    public void tukareta(Dog moto){
        moto.changeState(FutsuuState.getInstance());
    }
    public void tabeta(Dog moto){
        
    }
    public String toString(){
        return "寝てる状態";
    }
}

    
class FutsuuState extends DogState{
    private static FutsuuState s = new FutsuuState();
    private FutsuuState(){}

    public static DogState getInstance(){
        return s;
    }
    public void tukareta(Dog moto){
        moto.changeState(IrairaState.getInstance());
    }
    public void tabeta(Dog moto){
        moto.changeState(NeteruState.getInstance());
    }
    public String toString(){
        return "普通状態";
    }
}
class IrairaState extends DogState{
    private static IrairaState s = new IrairaState();
    private IrairaState(){}

    public static DogState getInstance(){
        return s;
    }
    public void tukareta(Dog moto){

    }
    public void tabeta(Dog moto){
        moto.changeState(NeteruState.getInstance());
    }
    public String toString(){
        return "イライラ状態";
    }

}
