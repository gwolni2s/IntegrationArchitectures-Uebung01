import org.bson.Document;

public class SalesMan {

    private int sid;
    private String firstname;
    private String lastname;

    public SalesMan(int sid, String firstname, String lastname) {
        super();
        this.sid = sid;
        this.firstname = firstname;
        this.lastname = lastname;
    }
    public int getSid() {
        return sid;
    }
    public void setSid(int sid) {
        this.sid = sid;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    /**
     * Implementation of the Object-to-Document Mapping by Prof. Dr. Alda from lectures
     */
    public Document toDocument() {
        return new Document()
                .append("sid", this.sid)
                .append("firstname", this.firstname)
                .append("lastname", this.lastname);
    }
    public String toString() {
        return "sid: " + this.sid + "\nfirstname: " + this.firstname + "\nlastname: " + this.lastname;
    }
}
