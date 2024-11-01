import java.util.Scanner;
public class LibraryMain {
    public static void main(String[] args) {
        Scanner kbd=new Scanner(System.in);

        Book book;
        LibrarySystem list = new LibrarySystem();

        boolean finish=false;
        /**
         * loop to repeat the operation until the user enter 15
         */
        while (!finish) {

            /**
             * Print the available services in the Library.
             */
            System.out.println("Enter the number of wanted service");
            System.out.println("(1)Add new Book");
            System.out.println("(2)Add new Member");
            System.out.println("(3)Delete Book");
            System.out.println("(4)Delete Member");
            System.out.println("(5)Search Book");
            System.out.println("(6)Search Member");
            System.out.println("(7)Issue Book");
            System.out.println("(8)Return Book");
            System.out.println("(9)Print Issued Book");
            System.out.println("(10)Is the book issued?");
            System.out.println("(11)Check the book list if it is empty.");
            System.out.println("(12)Check the member list if it is empty.");
            System.out.println("(13)Check the book list size.");
            System.out.println("(14)Check the member list size.");
            System.out.println("(15)Finish");

            /**
             * to enter the number of the wanted service
             */
            int menu = kbd.nextInt();
            boolean v;


            switch (menu) {
                /**
                * add book
                */
                case 1:
                    System.out.println("Enter the title of the book: ");
                    kbd.nextLine();
                    String title = kbd.nextLine();

                    System.out.println("Enter author1: ");
                    String author1 = kbd.nextLine();

                    System.out.println("Enter author2: ");
                    String author2 = kbd.nextLine();

                    System.out.println("Enter the publisher: ");
                    String publisher = kbd.nextLine();

                    System.out.println("Enter a year publication: ");
                    int yearPublication = kbd.nextInt();

                    System.out.println("Enter isbn: ");
                    String isbn = kbd.next();

                    System.out.println("Enter the accession number: ");
                    long accessionNum = kbd.nextLong();

                    book = new Book(title, author1, author2, publisher, yearPublication, isbn, accessionNum);
                    v=list.addBook(book);
                    if (v)
                        System.out.println("Book is added successfully");
                    break;
                /**
                 * add member
                 */
                case 2:
                    System.out.println("Enter the first name: ");
                    String firstName = kbd.next();

                    System.out.println("Enter the last name: ");
                    String lastName = kbd.next();

                    System.out.println("Enter the gender: ");
                    char gender = kbd.next().charAt(0);

                    System.out.println("Enter the CPR number: ");
                    long cprNum = kbd.nextLong();

                    System.out.println("Enter the telephone number: ");
                    String teleNum = kbd.next();

                    LibMember member = new LibMember(firstName, lastName, gender, cprNum, teleNum);
                    v=list.addMember(member);
                    if (v)
                        System.out.println("Member is added successfully");
                    break;
                /**
                 * Delete Book
                 */
                case 3:
                    System.out.println("Enter the accession number of the book: ");
                    long accessNum1 = kbd.nextLong();
                    v=list.deleteBook(accessNum1);
                    if (v)
                        System.out.println("The book is deleted");
                    else System.out.println("The book can not be deleted");

                    break;
                /**
                 * Delete mamber
                 */
                case 4:
                    System.out.println("Enter the CPR number of the member: ");
                    long cpr = kbd.nextLong();
                    list.deleteMember(cpr);
                    break;
                /**
                 * Search Book
                 */
                case 5:
                    System.out.println("Enter Accession number: ");
                    accessionNum = kbd.nextLong();
                    int i=list.searchBook(accessionNum);
                    if(i==-1)
                        System.out.println("the book is not found");
                    else System.out.println("The book is at index "+i);
                    break;
                /**
                 * Search member
                 */
                case 6:
                    System.out.println("Enter CPR number: ");
                    cprNum = kbd.nextLong();
                    int m=list.searchMember(cprNum);
                    if(m==-1)
                        System.out.println("the member is not found");
                    else System.out.println("The member is at index "+m);
                    break;
                /**
                 * Issue Book
                 */
                case 7:
                    System.out.println("Enter the accession number of the book: ");
                    long accessNum2 = kbd.nextLong();

                    System.out.println("Enter the CPR number: ");
                    long cprNum2 = kbd.nextLong();

                    v=list.issueBook(accessNum2,cprNum2);
                    if(v)
                        System.out.println("book is issued successfully ");
                    break;
                /**
                 * return Book
                 */
                case 8:
                    System.out.println("Enter the accession number of the book: ");
                    long accessNum3 = kbd.nextLong();
                    v=list.returnBook(accessNum3);
                    if (v)
                        System.out.println("the book is returned successfully");
                    break;
                /**
                 * print Issued Books
                 */
                case 9:
                    System.out.println("Enter the CPR number: ");
                    long cprNum3 = kbd.nextLong();
                    list.printBooksIssued(cprNum3);
                    break;
                /**
                 * check if the book is issued
                 */
                case 10:
                    System.out.println("Enter the accession number of the book: ");
                    long accessNum4 = kbd.nextLong();
                    v=list.isBookIssued(accessNum4);
                    if (v)
                        System.out.println("The book is issued");
                    else System.out.println("The book is not issued");
                    break;
                /**
                 * check if the bookList empty
                 */
                case 11:
                    v=list.isEmptyBooksList();
                    if (v)
                        System.out.println("The book list is empty");
                    else System.out.println("The book list is not empty");
                    break;
                /**
                 * check if the memberList empty
                 */
                case 12:
                     v=list.isEmptyMembersList();
                     if (v)
                         System.out.println("The member list is empty");
                     else System.out.println("The member list is not empty");
                    break;
                /**
                 * print the size of bookList
                 */
                case 13:
                    System.out.println("The book list size is: " + list.sizeBooksList());
                    break;
                /**
                 * print the size of memberList
                 */
                case 14:
                    System.out.println("The member list size is: " + list.sizeMembersList());
                    break;
                /**
                 * To finish the while loop
                 */

                case 15:
                    finish = true;
                    break;
                /**
                 * if the user type other number
                 */

                default:
                    System.out.println("Please enter another number there is no service with this number.");


            }
            /**
             * start the while loop from begining
             */
            if (!finish) {
                System.out.println();
                System.out.println("-------------FM Library------------");
            }

        }
    }

}
