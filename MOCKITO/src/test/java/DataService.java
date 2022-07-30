import java.util.List;
import java.util.function.Supplier;

public interface DataService {
    List<String> getAll();

    String getById(int id);

    String getById(int id, Supplier<String> calculateIfAbsent);
}

class DataServiceImpl implements DataService {
    private List<String> names = List.of("BARSIK", "SNEJOK", "PUSHOK");

    @Override
    public List<String> getAll() {
        return names;
    }

    @Override
    public String getById(int id) {
        return names.get(id);
    }

    @Override
    public String getById(int id, Supplier<String> calculateIfAbsent) {
        if (id > 0 && id < names.size())
            return getById(id);
        return calculateIfAbsent.get();
    }
}


