package kg.megacom.students1.models.enums;

public enum Day {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;
    public int getDayValue(){return ordinal()+1;}

}
