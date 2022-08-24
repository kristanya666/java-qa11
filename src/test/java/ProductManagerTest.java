import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    Repository repo = new Repository();
    ProductManager productManager = new ProductManager(repo);

    Book book1 = new Book(1, "First Book", 200, "First");
    Book book2 = new Book(2, "Second Book", 350, "Second");
    Book book3 = new Book(3, "Third Book", 600, "Third");
    Book book4 = new Book(4, "Fourth Book", 650, "Fourth");
    Smartphone phone1 = new Smartphone(5, "Samsung", 750, "South Korea");
    Smartphone phone2 = new Smartphone(6, "Nokia", 750, "Finland");

    @Test
    public void shouldAddBooks() {

        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(book4);

        Product[] expected = {book1, book2, book3, book4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddPhones() {

        productManager.add(phone1);
        productManager.add(phone2);


        Product[] expected = {phone1, phone2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddAll() {

        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(book4);
        productManager.add(phone1);
        productManager.add(phone2);


        Product[] expected = {book1, book2, book3, book4, phone1, phone2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindOneProductFromAll() {
        shouldAddAll();

        Product[] expected = { phone1 };
        Product[] actual = productManager.searchBy("Samsung");

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldFindProductsFromAll() {
        shouldAddAll();

        Product[] expected = { book1, book2, book3, book4 };
        Product[] actual = productManager.searchBy("Book");

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldRemoveById() {
        shouldAddAll();
        repo.removeById(5);

        Product[] expected = {book1, book2, book3, book4, phone2};
        Product[] actual = repo.findAll();


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllProducts() {
        shouldAddAll();

        Product[] expected = {book1, book2, book3, book4, phone1, phone2};
        Product[] actual = repo.findAll();


        Assertions.assertArrayEquals(expected, actual);
    }
}
