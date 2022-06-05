public class PhoneType {
    public String phoneType, comment;

    public PhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public PhoneType(String phoneType, String comment) {
        this.phoneType = phoneType;
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneType pt)) return false;
        return phoneType.equals(pt.phoneType);
    }
    // Хэш-код, вычисляемый только для значимого поля обеспечивает соответствие контракту equals!
    @Override
    public int hashCode() {
        return phoneType.hashCode();
    }

}
