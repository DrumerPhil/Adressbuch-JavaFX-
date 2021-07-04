package sample;

public class Contact {

    public Contact(String vorname, String nachname, String email1, String email2, String email3, String tel1, String tel2, String tel3) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.email1 = email1;
        this.email1 = email2;
        this.email1 = email3;
        this.tel1 = tel1;
        this.tel1 = tel2;
        this.tel1 = tel3;
    }

    String vorname;
    String nachname;
    String name = vorname + " " + nachname;
    String email1;
    String email2;
    String email3;
    String tel1;
    String tel2;
    String tel3;

}
