public class ProductManager {
    private Repository repo;

    public ProductManager(Repository repo) {
        this.repo = repo;
    }

    public void add(Product item) {
        repo.save(item);
    }


    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repo.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }

        return result;
    }


}
