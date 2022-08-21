import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

public class MockitoWhen {

    @Test
    public void testWhen() {
        DataService dataService = Mockito.mock(DataService.class);

        List<String> referenceData = List.of("BARSIK", "SNEJOK", "PUSHOK");
        Mockito.when(dataService.getAll()).thenReturn(referenceData);
    }
}
