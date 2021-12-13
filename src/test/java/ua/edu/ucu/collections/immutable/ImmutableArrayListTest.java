package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    @Test
    public void testAdd() {
        ImmutableArrayList a =new ImmutableArrayList(new Object[]{1,5,3,8});
        ImmutableList b = a.add(9);
        assertArrayEquals(b.toArray(), new Object[]{1,5,3,8,9});

    }
    @Test
    public void testAdd1() {
        ImmutableArrayList a =new ImmutableArrayList();
        ImmutableList b = a.add(9);
        assertArrayEquals(b.toArray(), new Object[]{9});

    }
    @Test
    public void testTestAdd() {
        ImmutableArrayList a =new ImmutableArrayList(new Object[]{1,5,3,8});
        ImmutableList b = a.add(0,9);
        assertArrayEquals(b.toArray(), new Object[]{9,1,5,3,8});
        ImmutableList c = a.add(3,9);
        assertArrayEquals(c.toArray(), new Object[]{1,5,3,9,8});
    }
    @Test(expected = IllegalArgumentException.class)
    public void testTestAdd1() {
        ImmutableArrayList a =new ImmutableArrayList();
        ImmutableList b = a.add(0,9);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testTestAdd2() {
        ImmutableArrayList a =new ImmutableArrayList(new Object[]{1,5,3,8});
        ImmutableList b = a.add(4,9);
    }
    @Test
    public void testAddAll() {
        ImmutableArrayList a =new ImmutableArrayList(new Object[]{1,5,3,8});
        ImmutableList b=a.addAll(new Object[]{9,10});
        assertArrayEquals(b.toArray(), new Object[]{1,5,3,8,9,10});
    }
    @Test
    public void testAddAll2() {
        ImmutableArrayList a =new ImmutableArrayList();
        ImmutableList b = a.addAll(new Object[]{9,10});
        assertArrayEquals(b.toArray(), new Object[]{9,10});
    }
    @Test
    public void testTestAddAll() {
        ImmutableArrayList a =new ImmutableArrayList(new Object[]{1,5,3,8});
        ImmutableList b=a.addAll(2,new Object[]{9,10});
        assertArrayEquals(b.toArray(), new Object[]{1,5,9,10,3,8});
    }
    @Test(expected = IllegalArgumentException.class)
    public void testTestAddAll1() {
        ImmutableArrayList a =new ImmutableArrayList();
        ImmutableList b=a.addAll(2,new Object[]{9,10});
    }
    @Test(expected = IllegalArgumentException.class)
    public void testTestAddAll2() {
        ImmutableArrayList a =new ImmutableArrayList(new Object[]{1,5,3,8});
        ImmutableList b=a.addAll(20,new Object[]{9,10});
    }
    @Test
    public void testGet() {
        ImmutableArrayList a =new ImmutableArrayList(new Object[]{1,5,3,8});
        Object b = a.get(2);
        assertArrayEquals(new Object[]{b}, new Object[]{3});

    }
    @Test(expected = IllegalArgumentException.class)
    public void testGet1() {
        ImmutableArrayList a =new ImmutableArrayList(new Object[]{1,5,3,8});
        Object b = a.get(4);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testGet2() {
        ImmutableArrayList a =new ImmutableArrayList();
        Object b = a.get(0);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemove() {
        ImmutableArrayList a =new ImmutableArrayList(new Object[]{1,5,3,8});
        ImmutableList b = a.remove(5);
    }
    @Test
    public void testRemove1() {
        ImmutableArrayList a =new ImmutableArrayList(new Object[]{1,5,3,8});
        ImmutableList b = a.remove(2);
        assertArrayEquals(b.toArray(), new Object[]{1,5,8});
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemove2() {
        ImmutableArrayList a =new ImmutableArrayList();
        ImmutableList b = a.remove(0);
    }
    @Test
    public void testSet() {
        ImmutableArrayList a =new ImmutableArrayList(new Object[]{1,3,8});
        ImmutableList b = a.set(1,5);
        assertArrayEquals(b.toArray(), new Object[]{1,5,8});

    }
    @Test(expected = IllegalArgumentException.class)
    public void testSet1() {
        ImmutableArrayList a =new ImmutableArrayList();
        ImmutableList b = a.set(0,5);
        assertArrayEquals(b.toArray(), new Object[]{1,5,8});

    }
    @Test
    public void testIndexOf() {
        ImmutableArrayList a =new ImmutableArrayList(new Object[]{1,5,8});
        assertEquals(a.indexOf(5),1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testIndexOf1() {
        ImmutableArrayList a =new ImmutableArrayList(new Object[]{1,5,8});
        a.indexOf(10);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testIndexOf3() {
        ImmutableArrayList a =new ImmutableArrayList();
        a.indexOf(0);

    }
    @Test
    public void testSize() {
        ImmutableArrayList a =new ImmutableArrayList(new Object[]{1,5,8});
        assertEquals(a.size(), 3);
        ImmutableArrayList b =new ImmutableArrayList();
        assertEquals(b.size(), 0);
    }
    @Test
    public void testClear() {
        ImmutableArrayList a =new ImmutableArrayList(new Object[]{1,5,8});
        ImmutableList a_c = a.clear();
        assertTrue(a_c.isEmpty());
        ImmutableArrayList b =new ImmutableArrayList();
        ImmutableList b_c =b.clear();
        assertTrue(b_c.isEmpty());
    }
    @Test
    public void testIsEmpty() {
        ImmutableArrayList a =new ImmutableArrayList(new Object[]{1,5,8});
        assertFalse(a.isEmpty());
        ImmutableArrayList b =new ImmutableArrayList();
        assertTrue(b.isEmpty());
    }
    @Test
    public void testToArray() {
        ImmutableArrayList a =new ImmutableArrayList(new Object[]{1,5,8});
        assertArrayEquals(a.toArray(), new Object[]{1,5,8});
        ImmutableArrayList b =new ImmutableArrayList();
        assertArrayEquals(b.toArray(), new Object[0]);
    }
}