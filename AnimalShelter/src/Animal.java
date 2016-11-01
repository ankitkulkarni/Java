import java.util.LinkedList;

/**
 * Created by Ankit on 28-Oct-16.
 */
abstract class Animal {
    private int order;
    protected String name;
    public Animal(String n){
        name = n;
    }
    public void setOrder(int ord){
        order = ord;
    }
    public int getOrder(){
        return order;
    }
    public boolean isOldestAmongTwo(Animal a){
        return this.order < a.getOrder();
    }
}

class AnimalQueue{
    LinkedList<Dogs> dogList = new LinkedList<>();
    LinkedList<Cats> catList = new LinkedList<>();
    private int order;
    public void enqueue(Animal a){
        if(a instanceof Dogs){
            dogList.addLast((Dogs) a);
        }
        else if(a instanceof Cats){
            catList.addLast((Cats) a);
        }
    }
    public Dogs dequeueDogs(){
        return dogList.poll();
    }
    public Cats dequeueCats(){
        return catList.poll();
    }
    public Animal dequeueAny(){
        if(dogList.size() == 0) {
            return dequeueCats();
        }
        else if(catList.size() == 0){
            return dequeueDogs();
        }
        Dogs oldestDog = dogList.peek();
        Cats oldestCat = catList.peek();
        if(oldestDog.isOldestAmongTwo(oldestCat)){
            return dequeueDogs();
        }
        else{
            return dequeueCats();
        }
    }
}