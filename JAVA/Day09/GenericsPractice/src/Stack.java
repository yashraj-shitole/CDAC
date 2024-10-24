import java.util.ArrayList;

public class Stack<T> {

    private static int top=0;

    private ArrayList<T> arrayList;

    public void add(T element) {
        arrayList.add(element);
        top++;
    }

    public void delete(int index){
        if(index<top && index>0){
            arrayList.remove(index);
            top--;
        }
    }

    public void count(){
        System.out.println(top);
    }

    public void print(){
        
        for(int i=0;i<top;i++){
            System.out.println(arrayList.get(i));
        }
    }

}
