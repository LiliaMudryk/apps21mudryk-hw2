package ua.edu.ucu.collections.immutable;


public final class ImmutableArrayList implements ImmutableList {
    private final Object[] oldArray;
    public ImmutableArrayList(Object[] elements) {
        this.oldArray = elements.clone();
    }

    public ImmutableArrayList() {
        this.oldArray = new Object[0];
    }

    @Override
    public ImmutableList add(Object e) {
        return addAll(new Object[] {e});
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[] {e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        int newArrayLength = oldArray.length + c.length;
        Object[] newArray = new Object[newArrayLength];
        for (int i = 0; i < oldArray.length; i ++) {
            newArray[i] = oldArray[i];
        }
        for (int i = oldArray.length; i < newArrayLength; i++) {
            newArray[i] = c[i - oldArray.length];
        }
        return new ImmutableArrayList(newArray);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index >= size() || index < 0) {
            throw new IllegalArgumentException();
        }
        int newArrayLength = oldArray.length + c.length;
        Object[] newArray = new Object[newArrayLength];
        for (int i = 0; i < index; i++) {
            newArray[i] = oldArray[i];
        }
        for (int i = index; i < c.length + index; i++) {
            newArray[i] = c[i - index];
        }
        int counter = 0;
        for (int i = index + c.length; i < newArrayLength; i++) {
            newArray[i] = oldArray[index + counter];
            counter ++;
        }
        return new ImmutableArrayList(newArray);
    }

    @Override
    public Object get(int index) {
        if (index >= size() || index < 0) {
            throw new IllegalArgumentException();
        }
       return oldArray[index];

    }

    @Override
    public ImmutableList remove(int index) {
        if (index >= size() || index < 0) {
            throw new IllegalArgumentException();
        }
        Object[] newArray = new Object[size() - 1];
        for (int i = 0; i < index; i++) {
            newArray[i] = oldArray[i];
        }
        int counter = index + 1;
        for (int i = index; i < size() - 1; i++) {
            newArray[i] = oldArray[counter];
            counter ++;
        }
        return new ImmutableArrayList(newArray);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index >= size() || index < 0) {
            throw new IllegalArgumentException();
        }
        Object[] newArray = new Object[size()];
        System.arraycopy(oldArray, 0, newArray, 0, size());
        newArray[index] = e;
        return new ImmutableArrayList(newArray);

    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size(); i++) {
            if (oldArray[i].equals(e)) {
                return i;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int size() {
        return oldArray.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return oldArray.length == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[size()];
        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }
        return newArray;
    }
}
