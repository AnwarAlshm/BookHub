import java.util.LinkedList;
public class LibrarySystem {
    /**
     * LinkedList object each element is of type Book
     */
    private LinkedList<Book> booksList;
    /**
     * LinkedList object each element is of type LibMember
     */
    private LinkedList<LibMember> membersList;
    /**
     * number of objects of type Books in booksList
     */
    private int booksListSize;
    /**
     * number of objects of type LibMembers in membersList
     */
    private int membersListSize;

    /**
     * constructor without parameter
     */
    public LibrarySystem(){
        booksList=new LinkedList<>();
        membersList=new LinkedList<>();
        booksListSize=0;
        membersListSize=0;
    }

    /**
     * inserts a new Book object at the end of the booksList, if the obj is already in the list do not add it + return false.
     * return true if added the obj successfully, and increase the size by 1
     * @param book
     * @return true, or false
     */

    public boolean addBook(Book book){
        if (book==null || booksList.contains(book))
            return false;

        for (int i=0;i<booksListSize;i++){
            if (booksList.get(i).equals(book)){
                System.out.println("Accession number already exists");
                return false;
            }
        }

        booksList.add(book);
        booksListSize++;

        return true;
    }

    /**
     * to delete a book obj, if the book is issued by member  or obj is not exist return false.
     *  return true if deleting the obj successfully, and decrease the size by 1
     * @param accessionNum
     * @return true, or false
     */
    public boolean deleteBook(long accessionNum){
        int index=-1;
        for (int i=0;i<booksListSize;i++){
            if (booksList.get(i).getAccessionNum()==accessionNum) {
                index = i;
                break;
            }
        }
        if (index==-1 ||booksList.get(index).getIssuedTo()!=null){
            return false;
        }
        booksList.remove(index);
        booksListSize--;
        return true;
    }

    /**
     * /inserts a new LibMember object at the end of the membersList, if the obj is exists do not add it and return false
     *  return true if added the obj successfully, and increase the  membersListSize by 1
     * @param member
     * @return true, or false
     */
    public boolean addMember(LibMember member){
        if (membersList.contains(member)) {
            System.out.println("The member is already exists");
            return false;
        }
        for (int i=0;i<membersListSize;i++){
            if(membersList.get(i).equals(member)){
                System.out.println("The member is already exists");
                return false;
            }
        }

        membersList.add(member);
        membersListSize++;
        return true;
    }

    /**
     * to delete a LibMember obj, if the book is issued to member or the obj is not exist return false.
     * return true if deleting the obj successfully, and decrease the size by 1
     * @param CPR
     * @return true, or false
     */
    public boolean deleteMember(long CPR){

        for(int i=0;i<membersListSize;i++){
            if (membersList.get(i).getCprNum() == CPR && membersList.get(i).getNumBooksIssued() == 0) {
                membersList.remove(i);
                System.out.println("the member had been deleted");
                membersListSize--;
                return true;
            }
        }
        System.out.println("The member can not be deleted");
        return false;
    }

    /**
     * search for the booksList by accessionNum, if found its location as int, else return -1
     * @param accessionNum
     * @return location as int= i , or -1
     */
    public int searchBook (long accessionNum){
        for(int i=0;i<booksListSize;i++){
            if(booksList.get(i).getAccessionNum()==accessionNum)
                return i;
        }
        return -1;
    }

    /**
     * search for the membersList by cprNum, if found its location as int, else return -1
     * @param CPR
     * @return location as int= i , or -1
     */
    public int searchMember(long CPR){
        for(int i=0;i<membersListSize;i++){
            if(membersList.get(i).getCprNum()==CPR){
                return i;
            }
        }
        return -1;
    }

    /**
     * check if the BooksList is empty return true, else return false
     * @return true, or false
     */
    public boolean isEmptyBooksList(){
        return booksListSize==0;
    }

    /**
     * check if the MembersList is empty return true, else return false
     * @return true, or false
     */
    public boolean isEmptyMembersList(){
        return membersListSize==0;
    }

    /**
     * size of the BooksList
     * @return int - size
     */
    public int sizeBooksList(){
        return booksListSize;
    }

    /**
     * size of the MembersList
     * @return int - size
     */
    public int 	sizeMembersList(){
        return membersListSize;
    }

    /**
     *if (a) The Book exists in the booksList. (b) The member exists in the membersList. (c) The Book is not issued to any member.
     * (d)	The member has less than 10 books issued to him/her. Then it can be issued to a member:
     * add the Book object in the booksIssued array for the member, increase numBooksIssued by 1, make issuedTo instance variable of the Book object reference to the member
     * , and return true. else (cannot be issued) return false
     * @param accessionNum
     * @param cpr
     * @return true, or false
     */
    public boolean issueBook(long accessionNum, long cpr){
        int bindex=-1, mindex=-1;
        for (int i=0;i<booksListSize;i++){
            if(booksList.get(i).getAccessionNum()==accessionNum){
                bindex=i;
                break;
            }
        }
        for (int i=0;i<membersListSize;i++){
            if (membersList.get(i).getCprNum()==cpr){
                mindex=i;
                break;
            }
        }

        if (mindex==-1 || bindex==-1 || membersList.get(mindex).getNumBooksIssued()==10 || booksList.get(bindex).getIssuedTo()!=null) {
            System.out.println("book can not be issued to that member");
            return false;
        }

        Book[] list=membersList.get(mindex).getBooksIssued();
        list[membersList.get(mindex).getNumBooksIssued()]=booksList.get(bindex);
        membersList.get(mindex).setNumBooksIssued(membersList.get(mindex).getNumBooksIssued()+1);
        booksList.get(bindex).setIssuedTo(membersList.get(mindex));
        return true;
    }

    /**
     * if (a) The Book exists in the Books list. (b) The Book is issued to a member. it can be returned and Then:
     * delete it from booksIssued array for the member, decrease numBooksIssued by 1, make issuedTo instance variable of the Book object to null
     * ,and return true. else (cannot be returned) return false
     * @param accessionNum
     * @return true, or false
     */
    public boolean returnBook(long accessionNum){
        int indexb=-1;
        for(int i=0;i<booksListSize;i++){
            if(booksList.get(i).getAccessionNum()==accessionNum){;
                if (booksList.get(i).getIssuedTo()==null) {
                    System.out.println("The book is not issued to any member");
                    return false;
                }
                indexb=i;
                break;
            }
        }

        if (indexb==-1){
            System.out.println("Book is not found");
            return false;
        }

        LibMember mem=booksList.get(indexb).getIssuedTo();
        Book[] list=mem.getBooksIssued();
        int num=mem.getNumBooksIssued();
        for(int i=0; i<num;i++){
            if(list[i].getAccessionNum()==accessionNum) {
                for (int j = i; j < num-1; j++) {
                    list[j] = list[j + 1];
                }
                break;
            }
        }
        list[num-1]=null;
        mem.setNumBooksIssued(num-1);
        booksList.get(indexb).setIssuedTo(null);
        return true;
    }

    /**
     * prints details of all the books issued to the member by cprNum
     * @param cpr
     */
    public void printBooksIssued(long cpr){
        boolean found=false;
        LibMember mem=null;
        for(int i=0;i<membersListSize;i++){
            if (membersList.get(i).getCprNum()==cpr){
                mem=membersList.get(i);
                found=true;
                break;
            }
        }
        if (found){
            int num=mem.getNumBooksIssued();
            Book[] list=mem.getBooksIssued();
            for (int i=0;i<num;i++){
                System.out.println("The book "+(i+1));
                System.out.println(list[i]);
            }
        }
    }

    /**
     * checks for the object if exists in the bookList and is issued to a member return true, else return false
     * @param accession
     * @return true, or false
     */
    public boolean isBookIssued(long accession){
        for (int i=0;i<booksListSize;i++){
            if (booksList.get(i).getAccessionNum()==accession){
                if (booksList.get(i).getIssuedTo()==null)
                    return false;
                else return true;
            }
        }
        return false;
    }

}
