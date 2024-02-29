public class Couple {
    private Person partner1;
    private Person partner2;

    public Couple(Person partner1, Person partner2) {
        this.partner1 = partner1;
        this.partner2 = partner2;
    }

    public Person getPartner1() {
        return partner1;
    }

    public Person getPartner2() {
        return partner2;
    }
}
