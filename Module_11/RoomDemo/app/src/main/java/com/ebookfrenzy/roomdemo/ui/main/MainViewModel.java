package com.ebookfrenzy.roomdemo.ui.main;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ebookfrenzy.roomdemo.Product;
import com.ebookfrenzy.roomdemo.ProductRepository;

import java.util.List;

// The ViewModel (actually extends AndroidViewModel) is responsible for creating an instance of the Repository
// and for providing methods and LiveData Objects that can be utilized by
// the UI controller to keep the User Interface synchronized with the
// underlying database.

public class MainViewModel extends AndroidViewModel {

    private ProductRepository repository;
    private LiveData<List<Product>> allProducts;
    private MutableLiveData<List<Product>> searchResults;

    // The constructor below creates a repository instance and then uses it to get references to
    // the results and live data objects, so that they can be observed by the UI controller.
    public MainViewModel (Application application) {
        super(application);

        repository = new ProductRepository(application);

        allProducts = repository.getAllProducts(); // Gets references to results
        searchResults = repository.getSearchResults(); // from the repository.
    }

    MutableLiveData<List<Product>> getSearchResults() {
        return searchResults;
    }

    LiveData<List<Product>> getAllProducts() {
        return allProducts;
    }

    public void insertProduct(Product product) {
        repository.insertProduct(product);
    }

    public void findProduct(String name) {
        repository.findProduct(name);
    }

    public void deleteProduct(String name) {
        repository.deleteProduct(name);
    }

} // class MainViewModel
