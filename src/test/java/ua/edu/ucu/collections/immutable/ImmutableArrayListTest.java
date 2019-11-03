package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    private ImmutableArrayList list1;
    private ImmutableArrayList list2;
    private ImmutableArrayList list3;

    @Before
    public void setUp() {
        list1 = new ImmutableArrayList();
        Object[] elements = new Object[] {1, 2, 3, 4, 5, 6};
        list2 = new ImmutableArrayList(elements);
        Object[] elements2 = new Object[] {15, 44, 2};
        list3 = new ImmutableArrayList(elements2);
    }

    @Test
    public void testAdd1() {
        ImmutableList newList1 = list1.add('a');
        ImmutableList newList2 = list2.add(7);
        assertArrayEquals(newList1.toArray(), new Object[] {'a'});
        assertArrayEquals(newList2.toArray(), new Object[] {1, 2, 3, 4, 5, 6, 7});
    }

    @Test
    public void testAdd2() {
        ImmutableList newList2 = list2.add(3,7);
        ImmutableList newList3 = list3.add(1, 6);
        assertArrayEquals(newList2.toArray(), new Object[] {1, 2, 3, 7, 4, 5, 6});
        assertArrayEquals(newList3.toArray(), new Object[] {15, 6, 44, 2});
    }

    @Test
    public void testAddAll1() {
        ImmutableList newList2 = list2.addAll(new Object[] {22, 33});
        ImmutableList newList3 = list3.addAll(new Object[] {'a', 'b', 'c'});
        assertArrayEquals(newList2.toArray(), new Object[] {1, 2, 3, 4, 5, 6, 22, 33});
        assertArrayEquals(newList3.toArray(), new Object[] {15, 44, 2, 'a', 'b', 'c'});
    }

    @Test
    public void testAddAll2() {
        ImmutableList newList2 = list2.addAll(4, new Object[] {22, 33});
        ImmutableList newList3 = list3.addAll(2, new Object[] {'a', 'b', 'c'});
        assertArrayEquals(newList2.toArray(), new Object[] {1, 2, 3, 4, 22, 33, 5, 6});
        assertArrayEquals(newList3.toArray(), new Object[] {15, 44,  'a', 'b', 'c', 2});
    }

    @Test
    public void testGet() {
        Object one = list2.get(3);
        Object two = list3.get(2);
        assertEquals(one, 4);
        assertEquals(two, 2);
    }

    @Test
    public void testRemove() {
        ImmutableList newList2 = list2.remove(4);
        ImmutableList newList3 = list3.remove(1);
        assertArrayEquals(newList2.toArray(), new Object[] {1, 2, 3, 4, 6});
        assertArrayEquals(newList3.toArray(), new Object[] {15, 2});
    }

    @Test
    public void testSet() {
        ImmutableList newList2 = list2.set(3, 7);
        ImmutableList newList3 = list3.set(1, 6);
        assertArrayEquals(newList2.toArray(), new Object[] {1, 2, 3, 7, 5, 6});
        assertArrayEquals(newList3.toArray(), new Object[] {15, 6, 2});
    }

    @Test
    public void testIndexOf() {
        int ind1 = list2.indexOf(6);
        int ind2 = list3.indexOf(44);
        assertEquals(ind1, 5);
        assertEquals(ind2, 1);
    }

    @Test
    public void testSize() {
        int ind1 = list2.size();
        int ind2 = list1.size();
        assertEquals(ind1, 6);
        assertEquals(ind2, 0);
    }

    @Test
    public void testClear() {
        ImmutableList newList2 = list2.clear();
        ImmutableList newList3 = list3.clear();
        assertArrayEquals(newList2.toArray(), new Object[] {});
        assertArrayEquals(newList3.toArray(), new Object[] {});
    }

    @Test
    public void testIsEmpty() {
        boolean one = list2.isEmpty();
        boolean two = list1.isEmpty();
        assertFalse(one);
        assertTrue(two);
    }

    @Test
    public void testToArray() {
        assertArrayEquals(list2.toArray(), new Object[] {1, 2, 3, 4, 5, 6});
        assertArrayEquals(list3.toArray(), new Object[] {15, 44, 2});
        assertArrayEquals(list1.toArray(), new Object[] {});
    }

    @Test
    public void testToString() {
        assertEquals(list2.toString(), "1, 2, 3, 4, 5, 6");
        assertEquals(list3.toString(), "15, 44, 2");
        assertEquals(list1.toString(), "");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testExceptions() {
        list1.set(10, 'a');
        list1.remove(10);
        list1.get(6);
        list1.addAll(5, new Object[] {1, 2});
        list1.add(4, 1);
    }
}
