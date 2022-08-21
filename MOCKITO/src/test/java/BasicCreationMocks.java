import org.junit.Test;
import org.mockito.Mockito;


public class BasicCreationMocks {

    @Test
    public void test() {
        DataService dataService = Mockito.mock(DataService.class);
        System.out.println(dataService.getClass() + " " +
                (dataService instanceof DataService) + " " +
                Mockito.mockingDetails(dataService).isMock());
        System.out.println(dataService.getById(777));
        System.out.println(dataService.getAll());

        FinalClass finalClass = Mockito.mock(FinalClass.class);
        System.out.println(finalClass.getClass());

        DataService realDataService = new DataServiceImpl();
        DataService dataServiceSpy = Mockito.spy(realDataService);
        System.out.println(dataServiceSpy.getAll());

        System.out.println(Mockito.anySet());
    }
}
