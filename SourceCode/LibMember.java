public class LibMember {
    private String firstName;
    private String lastName;
    private char gender;
    private long cprNum;
    private String teleNum;
    private Book [] booksIssued =new Book[10];
    private int numBooksIssued;

    /**
     * constructor without parameter
     */
    public LibMember(){
        firstName=null;
        lastName=null;
        gender=' ';
        cprNum=0;
        teleNum=null;
        numBooksIssued=0;
    }

    /**
     * constructor with parameter
     * @param firstName
     * @param lastName
     * @param gender
     * @param cprNum
     * @param teleNum
     */
    public LibMember(String firstName,String lastName,char gender,long cprNum,String teleNum){
        this.firstName=firstName;
        this.lastName=lastName;
        this.gender=gender;
        this.cprNum=cprNum;
        this.teleNum=teleNum;
        numBooksIssued=0;
    }

    /**
     * get firstName method
     * @return String - firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * get lastName method
     * @return String - lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * get gender method
     * @return char - gender
     */
    public char getGender() {
        return gender;
    }

    /**
     * get cprNum method
     * @return long - cprNum
     */
    public long getCprNum() {
        return cprNum;
    }

    /**
     * get teleNum method
     * @return String - teleNum
     */
    public String getTeleNum() {
        return teleNum;
    }

    /**
     * get numBooksIssued method
     * @return int - numBooksIssued
     */
    public int getNumBooksIssued() {
        return numBooksIssued;
    }

    /**
     * get booksIssued method
     * @return booksIssued
     */
    public Book[] getBooksIssued() {
        return booksIssued;
    }

    /**
     * set firstName method
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * set lastName method
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * set gender method
     * @param gender
     */
    public void setGender(char gender) {
        this.gender = gender;
    }

    /**
     * set cprNum method
     * @param cprNum
     */
    public void setCprNum(long cprNum) {
        this.cprNum = cprNum;
    }

    /**
     * set teleNum method
     * @param teleNum
     */
    public void setTeleNum(String teleNum) {
        this.teleNum = teleNum;
    }

    /**
     * set booksIssued method
     * @param booksIssued
     */
    public void setBooksIssued(Book[] booksIssued) {
        this.booksIssued = booksIssued;
    }

    /**
     * set numBooksIssued method
     * @param numBooksIssued
     */
    public void setNumBooksIssued(int numBooksIssued) {
        this.numBooksIssued = numBooksIssued;
    }

    /**
     * return all data member with their values as String
     * @return String
     */
    public String toString(){
        return "Fist Name: "+firstName+"\nLast Name: "+lastName+"\nGender: "+gender+"\nCPR Number: "+cprNum+
                "\nTelephone Number: "+teleNum+"\nNumber of Books Issued: "+numBooksIssued;
    }

    /**
     * compare an obj and its data with another object if equals return true, else return false
     * @param b1
     * @return true, ot false
     */
    public boolean equals(LibMember b1) {
        if (b1==null) return false;
        return this.cprNum== b1.cprNum;
    }
}
