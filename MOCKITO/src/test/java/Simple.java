import org.junit.Assert;
import org.junit.Test;

import org.mockito.Mockito;

import java.util.AbstractList;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class Simple {

    @Test
    public void test1() {
        MyList listMock = Mockito.mock(MyList.class);
        when(listMock.add(anyString())).thenReturn(true);

        boolean added = listMock.add("hgggj");
        Assert.assertTrue(added);
    }

    @Test(expected = IllegalStateException.class)
    public void givenMethodIsConfiguredToThrowException_whenCallingMethod_thenExceptionIsThrown() {
        MyList listMock = Mockito.mock(MyList.class);
        when(listMock.add(anyString())).thenThrow(IllegalStateException.class);

        assertTrue(listMock.add("hghghgh"));
    }

}

class MyList extends AbstractList<String> {

    @Override
    public String get(final int index) {
        return null;
    }
    @Override
    public int size() {
        return 1;
    }
    @Override
    public boolean add(String s) {
        return false;
    }
}


