package com.lyl.learn.designPattern.iterator;

/**
 * Created by lyl
 * Date 2018/12/16 19:57
 */
public class NameRepository implements Container {
    String[] names = {"aa","bb","cc"};

    int index;

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }


    private class NameIterator implements Iterator{

        @Override
        public boolean hasNext() {
            if(index<names.length)
                return true;
            else
                return  false;
        }

        @Override
        public Object next() {
            if (this.hasNext())
                return names[index++];
            else
                return null;
        }
    }
}
