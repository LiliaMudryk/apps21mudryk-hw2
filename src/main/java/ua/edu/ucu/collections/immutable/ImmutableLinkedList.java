package ua.edu.ucu.collections.immutable;

import java.util.Arrays;


public final class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private Node tail;
    public ImmutableLinkedList(Object[] elements) {
        if (elements.length == 0) {
            head = null;
        }
        else {
            Node previous = null;
            for (Object e : elements) {
                Node node = new Node();
                node.setValue(e);
                node.setPrevious(previous);
                if (previous == null) {
                    head = node;
                } else {
                    previous.setNext(node);
                }
                previous = node;
            }
            if (previous == null) {
                head = new Node();
                head.setValue(elements[0]);
            }
            previous.setNext(null);
            tail = previous;
        }
    }

    public ImmutableLinkedList() {
        head = null;
    }


    @Override
    public ImmutableList add(Object e) {
        if (getHead() == null) {
            return new ImmutableLinkedList(new Object[]{e});
        }
        return addAll(new Object[]{e});
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index,new Object[]{e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        Object[] oldArray = toArray();
        Object[] newArray = new Object[c.length + oldArray.length];
        System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
        System.arraycopy(c, 0, newArray, oldArray.length, c.length);
        return new ImmutableLinkedList(newArray);

    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index >= size() || index < 0) {
            throw new IllegalArgumentException();
        }
        Object[] oldArray = toArray();
        Object[] newArray = new Object[c.length + oldArray.length];
        for (int i = 0; i < index; i++) {
            newArray[i] = oldArray[i];
        }
        for (int i = index; i < c.length + index; i++) {
            newArray[i] = c[i - index];
        }
        int counter = 0;
        for (int i = index + c.length; i < c.length + oldArray.length; i++) {
            newArray[i] = oldArray[index + counter];
            counter++;
        }
        return new ImmutableLinkedList(newArray);
    }

    @Override
    public Object get(int index) {
        if (index >= size() || size() == 0) {
            throw new IllegalArgumentException();
        }
        Object[] arr = toArray();
        return arr[index];
    }

    @Override
    public ImmutableList remove(int index) {
        if (getHead() == null) {
            throw new IllegalArgumentException();
        }
        Object[] newArray = new Object[size() - 1];
        Object[] oldArray = toArray();
        for (int i = 0; i < index; i++) {
            newArray[i] = oldArray[i];
        }
        int counter = index + 1;
        for (int i = index; i < size() - 1; i++) {
            newArray[i] = oldArray[counter];
            counter++;
        }
        return new ImmutableLinkedList(newArray);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index >= size() || index < 0) {
            throw new IllegalArgumentException();
        }
        Object[] oldArray = toArray();
        Object[] newArray = new Object[size()];
        System.arraycopy(oldArray, 0, newArray, 0, size());
        newArray[index] = e;
        return new ImmutableLinkedList(newArray);

    }

    @Override
    public int indexOf(Object e) {
        if (getHead() == null) {
            throw new IllegalArgumentException();
        }
        Node node = getHead();
        Object value = node.getValue();
        int i = 0;
        while (node.getNext() != null) {
            if (value == e) {
                return i;
            }
            node = node.getNext();
            value = node.getValue();
            i++;
        }
        if (value == e) {
            return i;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int size() {
        int size = 0;
        Node node = getHead();
        if (node == null) {
            return size;
        }
        while (node.getNext() != null) {
            size++;
            node = node.getNext();
        }
        size++;
        return size;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[size()];
        Node node = getHead();
        if (node == null) {
            return newArray;
        }
        newArray[0] = node.getValue();
        int i=1;
        while (node.getNext() != null) {
            node=node.getNext();
            newArray[i] = node.getValue();
            i++;
        }
        return newArray;
    }

    public ImmutableLinkedList addFirst(Object e) {
        if (getHead() == null) {
            return new ImmutableLinkedList(new Object[]{e});
        }
        return (ImmutableLinkedList) add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        if (getHead() == null) {
            return new ImmutableLinkedList(new Object[]{e});
        }
        return (ImmutableLinkedList) addAll(new Object[]{e});
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        if (isEmpty()) {
            return null;
        }
        return tail;
    }

    public Object getFirst() {
        if (isEmpty()) {
            return null;
        }
        return getHead().getValue();
    }

    public Object getLast() {
        if (isEmpty()) {
            return null;
        }
        return getTail().getValue();
    }

    public ImmutableLinkedList removeFirst() {
        if (size() == 0) {
            throw new IllegalArgumentException();
        }
        Object[] newArray = Arrays.copyOfRange(toArray(), 1, size());
        return new ImmutableLinkedList(newArray);
    }

    public ImmutableLinkedList removeLast() {
        if (!isEmpty()) {
            Object[] newArray = Arrays.copyOf(toArray(), size() - 1);
            return new ImmutableLinkedList(newArray);
        }
        throw new IllegalArgumentException();
    }
}
