import com.arife.library.Book;
import com.arife.library.Bookservice;
import com.arife.library.bookTypes.BookType;
import com.arife.people.Author;
import com.arife.people.Reader;
import com.arife.utils.IdGenerate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Bookservice bookService = new Bookservice();
    private static Scanner scanner = new Scanner(System.in);
   private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    public static void main(String[] args) throws ParseException {

        while (true) {
            System.out.println("1. Yeni Kitap Ekle");
            System.out.println("2. Kitap Ara (ID/İsim/Yazar/Kategori)");
            System.out.println("3. Kitap Güncelle");
            System.out.println("4. Kitap Sil");
            System.out.println("5. Kullanıcılar için Seçenekler");
            System.out.println("6. Çıkış");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addNewBook();
                    break;
                case 2:
                    searchBook();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    userOptions();
                    break;
                case 6:
                    System.out.println("Sistemden çıkılıyor...");
                    return;
                default:
                    System.out.println("Geçersiz seçim, lütfen tekrar deneyin.");
            }
        }
    }

    private static void addNewBook() throws ParseException {
        System.out.println("Kitap Adı: ");
        String bookname = scanner.nextLine();

        System.out.println("Yazar İsmi: ");
        String authorName = scanner.nextLine();
        int authorId = IdGenerate.generateId();
        Author author = new Author(authorName, authorId);

        System.out.println("Kitap Sürümü: ");
        int edition = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Oluşturma  Tarihi: ");
        String dateOfCreateStr = scanner.nextLine();

        Date dateOfCreate = dateFormat.parse(dateOfCreateStr);



        int bookId = IdGenerate.generateId();
        Book book = new Book(bookId, bookname, author,200,true, edition, dateOfCreate, BookType.BUSINESS);

        bookService.addBook(book);
        author.addBook(book);
       // System.out.println("Kitap eklendi: " + book);
    }

    private static void searchBook() {
        System.out.println("Kitap arama için: ");
        System.out.println("1. ID'ye göre");
        System.out.println("2. İsme göre");
        System.out.println("3. Yazara göre");
        System.out.println("4. Kategoriye göre");

        int searchChoice = scanner.nextInt();
        scanner.nextLine();

        switch (searchChoice) {
            case 1:
                System.out.println("Kitap ID: ");
                String id = scanner.nextLine();
                Book bookById = bookService.findBookById(Long.parseLong(id));
                System.out.println("Bulunan Kitap: " + bookById);
                break;
            case 2:
                System.out.println("Kitap İsmi: ");
                String name = scanner.nextLine();
                List<Book> booksByName = bookService.findBooksByName(name);
                booksByName.forEach(System.out::println);
                break;
            case 3:
                System.out.println("Yazar Adı: ");
                String authorName = scanner.nextLine();
                List<Book> booksByAuthor = bookService.findBooksByAuthor(authorName);
                booksByAuthor.forEach(System.out::println);
                break;
            case 4:
                System.out.println("Kategori İsmi: ");
                String categoryName = scanner.nextLine();
                List<Book> booksByCategory = bookService.findBooksByCategory(categoryName);
                booksByCategory.forEach(item -> System.out.println(item));
                break;
            default:
                System.out.println("Geçersiz seçim.");
        }
    }

    private static void updateBook() {
        System.out.println("Güncellemek istediğiniz kitabın ID'sini girin: ");
        String id = scanner.nextLine();

        Book book = bookService.findBookById(Long.parseLong(id));
        if (book != null) {
            System.out.println("Yeni İsim: ");
            String newName = scanner.nextLine();
            book.setBookName(newName);

            System.out.println("Yeni Sürüm: ");
            String newEdition = scanner.nextLine();
            book.setEdition(Integer.parseInt(newEdition));
            System.out.println("Kitap Türü:");
            String newType = scanner.nextLine();
            book.setBookType(BookType.valueOf(newType.toUpperCase()));
            bookService.updateBook(book);
            System.out.println("Kitap güncellendi: " + book);
        } else {
            System.out.println("Kitap bulunamadı.");
        }
    }

    private static void deleteBook() {
        System.out.println("Silmek istediğiniz kitabın ID'sini girin: ");
        String id = scanner.nextLine();

        bookService.deleteBook(Long.parseLong(id));
        System.out.println("Kitap silindi."+ bookService.findBookById(Long.parseLong(id)));
    }

    private static void userOptions() {
        System.out.println("1. Kitap Ödünç Al");
        System.out.println("2. Kitap İade Et");
        System.out.println("3. Kullanıcıya Fatura Kes");
        System.out.println("4. Kullanıcının Kitaplarını Listele");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Hata vermemesi için nextIntten sonra nextLine gerekir

        switch (choice) {
            case 1:
                borrowBook();
                break;
            case 2:
                returnBook();
                break;
            case 3:
                generateInvoice();
                break;
            case 4:
                listUserBooks();
                break;
            default:
                System.out.println("Geçersiz seçim, lütfen tekrar deneyin.");
        }
    }

    private static void borrowBook() {
        System.out.println("Kullanıcı İsmi: ");
        String userName = scanner.nextLine();
        Reader reader = new Reader(userName);

        System.out.println("Kitap ID: ");
        String bookId = scanner.nextLine();
        Book book = bookService.findBookById(Long.parseLong(bookId));

        if (book != null && book.isAvailable()) {
            reader.borrowBook(book);
            bookService.getBorrowedBooks().put(bookId, reader);
            System.out.println(userName + " kullanıcı için " + book.getBookName() + " ödünç alındı.");
        } else {
            System.out.println("Kitap mevcut değil.");
        }
    }

    private static void returnBook() {
        System.out.println("Kullanıcı İsmi: ");
        String userName = scanner.nextLine();
        Reader reader = new Reader(userName);

        System.out.println("Kitap ID: ");
        String bookId = scanner.nextLine();
        Book book = bookService.findBookById(Long.parseLong(bookId));

        if (book != null && !book.isAvailable() && book.getOwner().equals(reader)) {
            reader.returnBook(book);
            bookService.getBorrowedBooks().remove(bookId);
            System.out.println(userName + " kullanıcı " + book.getBookName() + " kitabını iade etti.");
        } else {
            System.out.println("Kitap iade edilemedi.");
        }
    }

    private static void generateInvoice() {
        System.out.println("Kullanıcı İsmi: ");
        String userName = scanner.nextLine();
        Reader reader = new Reader(userName);

        System.out.println("Kitap ID: ");
        String bookId = scanner.nextLine();
        Book book = bookService.findBookById(Long.parseLong(bookId));

        if (book != null && !book.isAvailable() && book.getOwner().equals(reader)) {
            System.out.println("Ödenecek Tutar: ");
            double amount = scanner.nextDouble();

            reader.purchaseBook(book, amount);
            System.out.println("Fatura kesildi: " + book.getBookName());
        } else {
            System.out.println("Fatura kesilemedi.");
        }
    }

    private static void listUserBooks() {
        System.out.println("Kullanıcı İsmi: ");
        String userName = scanner.nextLine();
        Reader reader = new Reader(userName);

        List<Book> userBooks = bookService.findBooksByOwner(reader);
        userBooks.forEach(System.out::println);
    }
}