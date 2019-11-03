package ua.edu.ucu.collections.immutable;


import java.util.Arrays;


public final class ImmutableArrayList implements ImmutableList {

    private Object[] myList;
    private int elNum;
    private int lstCapacity;

    public ImmutableArrayList() {
        myList = new Object[0];
        elNum = 0;
        lstCapacity = myList.length;
    }

    public ImmutableArrayList(Object[] objs) {
        myList = objs.clone();
        int counter = 0;
        for (Object el : objs) {
            if (el == null) { break; }
            counter++;
        }
        elNum = counter;
        lstCapacity = myList.length;
    }

    private Object[] resize(Object[] currList) {
        Object[] newList;
        if (currList.length == 0) { newList = Arrays.copyOf(currList, 1); }
        else { newList = Arrays.copyOf(currList, currList.length * 2); }
        return newList;
    }

    private ImmutableArrayList makeNew() {
        Object[] copyList = new Object[myList.length];
        System.arraycopy(myList, 0, copyList, 0, myList.length);
        return new ImmutableArrayList(copyList);
    }

    @Override
    public ImmutableList add(Object e) {
        ImmutableArrayList newList = makeNew();
        if (newList.lstCapacity == 0 || newList.lstCapacity
                - newList.elNum <= 0) {
            newList.myList = resize(newList.myList);
            newList.lstCapacity = newList.lstCapacity * 2;
        }
        newList.myList[elNum] = e;
        newList.elNum++;
        return newList;
    }

    @Override
    public ImmutableList add(int index, Object e) {
        if (index >= lstCapacity || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            Object[] workList = new Object[lstCapacity + 1];
            System.arraycopy(myList, 0, workList, 0, index);
            workList[index] = e;
            if (lstCapacity - index >= 0) {
                System.arraycopy(myList, index,
                        workList, index + 1, lstCapacity - index);
            }
            return new ImmutableArrayList(workList);
        }
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        ImmutableArrayList newList = makeNew();
        if (newList.lstCapacity < newList.elNum + c.length) {
            newList.myList = resize(newList.myList);
            newList.lstCapacity = newList.lstCapacity * 2;
        }
        return newList.addAll(elNum, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index >= lstCapacity || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            Object[] workList = new Object[lstCapacity + 1];
            System.arraycopy(myList, 0, workList, 0, index);
            ImmutableArrayList newList = new ImmutableArrayList(workList);
            int lengthC = c.length;
            int i = 0;
            while (i != c.length) {
                if (newList.lstCapacity - lengthC >= newList.elNum) {
                    int it = newList.elNum;
                    newList.myList[it] = c[i];
                    newList.elNum++;
                    i++;
                    lengthC--;
                } else {
                    newList.myList = resize(newList.myList);
                    newList.lstCapacity = newList.lstCapacity * 2;
                }
            }
            if (newList.lstCapacity < lstCapacity + c.length) {
                newList.myList = resize(newList.myList);
                newList.lstCapacity = newList.lstCapacity * 2;
            }
            for (int e = index; e < elNum; e++) {
                newList.myList[e + c.length] = myList[e];
                newList.elNum++;
            }
            return newList;
        }
    }

    @Override
    public Object get(int index) {
        if (index >= lstCapacity || index < 0) {
            throw new IndexOutOfBoundsException();
        } else { return myList[index]; }
    }

    @Override
    public ImmutableList remove(int index) {
        if (index >= lstCapacity || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            ImmutableArrayList newList = makeNew();
            for (int i = index + 1; i < newList.elNum; i++) {
                newList.myList[i - 1] = newList.myList[i];
            }
            newList.myList[elNum - 1] = null;
            newList.elNum--;
            return newList;
        }
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index >= lstCapacity || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            ImmutableArrayList newList = makeNew();
            newList.myList[index] = e;
            return newList;
        }
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < elNum; i++) {
            if (myList[i] == e) { return i; }
        }
        return -1;
    }

    @Override
    public int size() {
        return lstCapacity;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() { return elNum == 0; }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(myList, elNum);
    }

    @Override
    public String toString() {
        StringBuilder strList = new StringBuilder();
        for (int i = 0; i < elNum; i++) {
            strList.append(myList[i]);
            if (i != elNum - 1) { strList.append(", "); }
        }
        return strList.toString();
    }

}
