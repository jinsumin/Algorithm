package section5;

import java.util.Arrays;

public class MyArrayList<T> {

    private static final int INIT_CAPACITY = 10;
    private T[] theData;
    private int size;
    private int capacity;

    public MyArrayList(){
        theData = (T[]) new Object[INIT_CAPACITY];
        size = 0;
        capacity = INIT_CAPACITY;
    }

    public void add(int index, T anEntry){
        if(index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if(size >= capacity){
            reallocate();
        }
        for(int i = size; i > index; i --){
            theData[i] = theData[i-1];
        }
        theData[index] = anEntry;
        size++;
    }

    public void add(T anEntry){
        add(size, anEntry);
    }

    private void reallocate(){
        capacity *= 2;
        theData = Arrays.copyOf(theData, capacity);
    }

    public String toString(){
        for(int i = 0; i < size; i ++){
            System.out.print(theData[i] + " ");
        }
        return null;
    }

    public int size(){
        return size;
    }

    public int indexOf(T anEntry){
        for(int i = 0; i < size; i ++){
            if(theData[i].equals(anEntry))
                return i;
        }
        return -1;
    }

    public T get(int index){
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return theData[index];
    }

    public T set(int index, T newValue){
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        T oldValue = theData[index];
        theData[index] = newValue;
        return oldValue;
    }

    public T remove(int index){
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        T returnValue = theData[index];
        for(int i = index + 1; i < size; i ++){
            theData[i-1] = theData[i];
        }
        size--;
        return returnValue;
    }

    public static void main(String[] args){
        MyArrayList<String> test = new MyArrayList<>();
        try{
            test.add(1, "Hello");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("out of index");
        }

        test.add("hi");
        test.add("hello");
        test.add("java");
        test.add(0, "first");

        test.toString();
        System.out.println();
        System.out.println(test.get(1));
        System.out.println();
        test.toString();

        test.set(1, "hello2");
        System.out.println();
        test.toString();
    }
}
