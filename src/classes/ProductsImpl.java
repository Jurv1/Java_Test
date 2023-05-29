package src.classes;

import java.util.ArrayList;

public class ProductsImpl {
    private ArrayList<Product> localDB = new ArrayList<Product>();

    private Product findProduct(String id) {
        for (int i = 0; i < localDB.toArray().length; i++) {
            if (localDB.get(i).getId().equals(id)) {
                return localDB.get(i);
            }
        }
        return null;
    }

    private boolean findProductAndDelete(String id) {
        for (int i = 0; i < localDB.toArray().length; i++) {
            if (localDB.get(i).getId().equals(id)) {
                return localDB.remove(localDB.get(i));
            }
        }

        return false;
    }

    private ArrayList<String> getArrayListOfIdsByName(String name) {
        ArrayList<String> foundedIds = new ArrayList<String>();

        for (int i = 0; i < localDB.toArray().length; i++) {
            Product el = localDB.get(i);
            if (el.getName().equals(name))
                foundedIds.add(el.getId());
        }

        return foundedIds;
    }

    public boolean addProduct(String id, String name) {
        final Product product = this.findProduct(id);
        if (product != null)
            return false;
        Product productToAdd = new Product();
        productToAdd.setId(id);
        productToAdd.setName(name);
        localDB.add(productToAdd);
        return true;
    }

    public boolean deleteProduct(String id) {
        return this.findProductAndDelete(id);
    }

    public String getName(String id) {
        final Product product = this.findProduct(id);
        if (product == null)
            return "";
        return product.getName();
    }

    public ArrayList<String> findByName(String name) {
        return this.getArrayListOfIdsByName(name);
    }
}

