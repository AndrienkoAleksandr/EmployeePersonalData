package com.codenvy.employee.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by logarifm on 04.09.14.
 */
@RunWith(MockitoJUnitRunner.class)
public class TesMockito {

    @Test
    public void testList() {
        List mockedList = mock(List.class);
        mockedList.add("one");
        mockedList.clear();

        verify(mockedList).add("one");
//        verify(mockedList).add("two");
        verify(mockedList).clear();
    }

    @Test
    public void testLinkedList() {
        LinkedList mockedList = mock(LinkedList.class);
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(5)).thenReturn("second");

        assertEquals(mockedList.get(0), "first");
        assertEquals(mockedList.get(5), "second");
        assertEquals(mockedList.get(999), null);
    }

}
