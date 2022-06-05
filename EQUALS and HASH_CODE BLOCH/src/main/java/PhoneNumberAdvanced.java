import java.util.Objects;

public class PhoneNumberAdvanced extends PhoneNumber {
    private final PhoneType phoneType;
    private final double callingRate;

    PhoneNumberAdvanced(int areaCode, int prefix, int lineNumber, PhoneType phoneType, double callingRate) {
        super(areaCode, prefix, lineNumber);
        this.phoneType = phoneType;
        this.callingRate = callingRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneNumberAdvanced pna)) return false;
        return super.equals(o) &&
                this.phoneType.equals(pna.phoneType) &&
                // Оптимальный стат. метод сравнения 2-x double без автобоксинга при вызове Doubles.equals()
                Double.compare(this.callingRate, pna.callingRate) == 0;
    }
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * Objects.hashCode(phoneType) + result;
        System.out.println("Hash code: " + result);
        return result;
    }
}
