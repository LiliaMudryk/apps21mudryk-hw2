package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {

    @Test
    public void add() {
        ImmutableLinkedList a = new ImmutableLinkedList(new Object[]{1,3,5,8});
        assertArrayEquals(a.add(3).toArray(), new Object[]{1,3,5,8,3});
        ImmutableLinkedList b = new ImmutableLinkedList();
        assertArrayEquals(b.add(3).toArray(), new Object[]{3});
    }

    @Test
    public void testAdd() {
        ImmutableLinkedList a = new ImmutableLinkedList(new Object[]{1,3,5,8});
        assertArrayEquals(a.add(3,2).toArray(), new Object[]{1,3,5,2,8});

    }
    @Test(expected = IllegalArgumentException.class)
    public void testAdd2() {
        ImmutableLinkedList a = new ImmutableLinkedList();
        assertArrayEquals(a.add(3,2).toArray(), new Object[]{1,3,5,2,8});

    }

    @Test
    public void addAll() {
        ImmutableLinkedList a = new ImmutableLinkedList(new Object[]{1,3,5,8});
        assertArrayEquals(a.addAll( new Object[]{9,10}).toArray(), new Object[]{1,3,5,8,9,10});
        ImmutableLinkedList b = new ImmutableLinkedList();
        assertArrayEquals(b.addAll(new Object[]{2,3}).toArray(), new Object[]{2,3});

    }

    @Test
    public void testAddAll() {
        ImmutableLinkedList a = new ImmutableLinkedList(new Object[]{1,3,5,8});
        assertArrayEquals(a.addAll( 2,new Object[]{9,10}).toArray(), new Object[]{1,3,9,10,5,8});
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddAll2() {
        ImmutableLinkedList a = new ImmutableLinkedList(new Object[]{1,3,5,8});
        assertArrayEquals(a.addAll( 10,new Object[]{9,10}).toArray(), new Object[]{1,3,9,10,5,8});
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddAll3() {
        ImmutableLinkedList a = new ImmutableLinkedList();
        assertArrayEquals(a.addAll( 0,new Object[]{9,10}).toArray(), new Object[]{1,3,9,10,5,8});
    }

    @Test
    public void get() {
        ImmutableLinkedList a = new ImmutableLinkedList(new Object[]{1,3,5,8});
        assertEquals(a.get(3),8);
    }
    @Test(expected = IllegalArgumentException.class)
    public void get2() {
        ImmutableLinkedList a = new ImmutableLinkedList();
        a.get(0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void get3() {
        ImmutableLinkedList a = new ImmutableLinkedList(new Object[]{1,3,5,8});
        a.get(10);
    }

    @Test
    public void remove() {
        ImmutableLinkedList a = new ImmutableLinkedList(new Object[]{1,3,5,8});
        assertArrayEquals(a.remove(3).toArray(), new Object[]{1,3,5});
        assertArrayEquals(a.remove(2).toArray(), new Object[]{1,3,8});
    }
    @Test(expected = IllegalArgumentException.class)
    public void remove2() {
        ImmutableLinkedList a = new ImmutableLinkedList();
        a.remove(0);
    }

    @Test
    public void set() {
        ImmutableLinkedList a = new ImmutableLinkedList(new Object[]{1,3,5,8});
        assertArrayEquals(a.set(0,2).toArray(), new Object[]{2,3,5,8});
    }
    @Test(expected = IllegalArgumentException.class)
    public void set2() {
        ImmutableLinkedList a = new ImmutableLinkedList();
        a.set(0,2);
    }
    @Test
    public void indexOf() {
        ImmutableLinkedList a = new ImmutableLinkedList(new Object[]{1,3,5,8});
        assertEquals(a.indexOf(8),3);
    }
    @Test(expected = IllegalArgumentException.class)
    public void indexOf2() {
        ImmutableLinkedList a = new ImmutableLinkedList();
        a.indexOf(0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void indexOf3() {
        ImmutableLinkedList a = new ImmutableLinkedList(new Object[]{1,3,5,8});
        a.indexOf(10);
    }


    @Test
    public void size() {
        ImmutableLinkedList a = new ImmutableLinkedList(new Object[]{1,3,5,8,2});
        assertEquals(a.size(),5);
        ImmutableLinkedList b = new ImmutableLinkedList();
        assertEquals(b.size(),0);
    }

    @Test
    public void clear() {
        ImmutableLinkedList a = new ImmutableLinkedList(new Object[]{1,3,5,8});
        assertArrayEquals(a.clear().toArray(), new Object[]{});
        ImmutableLinkedList b = new ImmutableLinkedList();
        assertArrayEquals(b.clear().toArray(),new Object[]{});
    }

    @Test
    public void isEmpty() {
        ImmutableLinkedList a = new ImmutableLinkedList(new Object[]{1,3,5,8});
        assertFalse(a.isEmpty());
        ImmutableLinkedList b = new ImmutableLinkedList();
        assertTrue(b.isEmpty());
    }

    @Test
    public void toArray() {
        ImmutableLinkedList a = new ImmutableLinkedList(new Object[]{1,3,5,8});
        assertArrayEquals(a.toArray(),new Object[]{1,3,5,8});
        ImmutableLinkedList b = new ImmutableLinkedList();
        assertArrayEquals(b.toArray(),new Object[]{});
    }

    @Test
    public void addFirst() {
        ImmutableLinkedList a = new ImmutableLinkedList(new Object[]{1,3,5,8});
        assertArrayEquals(a.addFirst(0).toArray(),new Object[]{0,1,3,5,8});
        ImmutableLinkedList b = new ImmutableLinkedList();
        assertArrayEquals(b.addFirst(0).toArray(),new Object[]{0});

    }

    @Test
    public void addLast() {
        ImmutableLinkedList a = new ImmutableLinkedList(new Object[]{1,3,5,8});
        assertArrayEquals(a.addLast(0).toArray(),new Object[]{1,3,5,8,0});
        ImmutableLinkedList b = new ImmutableLinkedList();
        assertArrayEquals(b.addLast(0).toArray(),new Object[]{0});
    }

    @Test
    public void getHead() {
        ImmutableLinkedList a = new ImmutableLinkedList(new Object[]{1,3,5,8});
        assertEquals(a.getHead().getValue(),1);
        ImmutableLinkedList b = new ImmutableLinkedList();
        assertEquals(b.getHead(),null);
    }

    @Test
    public void getTail() {
        ImmutableLinkedList a = new ImmutableLinkedList(new Object[]{1,3,5,8});
        assertEquals(a.getTail().getValue(),8);
        ImmutableLinkedList b = new ImmutableLinkedList();
        assertEquals(b.getTail(),null);
    }

    @Test
    public void getFirst() {
        ImmutableLinkedList a = new ImmutableLinkedList(new Object[]{1,3,5,8});
        assertEquals(a.getFirst(),1);
        ImmutableLinkedList b = new ImmutableLinkedList();
        assertEquals(b.getFirst(),null);
    }

    @Test
    public void getLast() {
        ImmutableLinkedList a = new ImmutableLinkedList(new Object[]{1,3,5,8});
        assertEquals(a.getLast(),8);
        ImmutableLinkedList b = new ImmutableLinkedList();
        assertEquals(b.getLast(),null);
    }

    @Test
    public void removeFirst() {
        ImmutableLinkedList a = new ImmutableLinkedList(new Object[]{1,3,5,8});
        assertArrayEquals(a.removeFirst().toArray(),new Object[]{3,5,8});
    }
    @Test(expected = IllegalArgumentException.class)
    public void removeFirst1() {
        ImmutableLinkedList a = new ImmutableLinkedList();
        a.removeFirst();
    }
    @Test
    public void removeLast() {
        ImmutableLinkedList a = new ImmutableLinkedList(new Object[]{1,3,5,8});
        assertArrayEquals(a.removeLast().toArray(),new Object[]{1,3,5});
    }
    @Test(expected = IllegalArgumentException.class)
    public void removeLast1() {
        ImmutableLinkedList a = new ImmutableLinkedList();
        a.removeLast();
    }
}