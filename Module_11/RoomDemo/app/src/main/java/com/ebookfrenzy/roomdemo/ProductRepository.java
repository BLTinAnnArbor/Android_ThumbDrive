package com.ebookfrenzy.roomdemo;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class ProductRepository {

    private ProductDao productDao;  // Is an interface.
    private LiveData<List<Product>> allProducts;

    private MutableLiveData<List<Product>> searchResults =
            new MutableLiveData<>();

    public ProductRepository(Application application) {  // Constructor
        ProductRoomDatabase db;

        db = ProductRoomDatabase.getDatabase(application);
        productDao = db.productDao();
        allProducts = productDao.getAllProducts();
    }

    public LiveData<List<Product>> getAllProducts() {  // ViewModel calls this.
        return allProducts;
    }
                                // ViewModel also calls this.
    public MutableLiveData<List<Product>> getSearchResults() {
        return searchResults;
    }

    // The code below sets up the Async calls to the DAO methods.
    // Remember, they are not on a separate thread, book p 518??

    public void insertProduct(Product newproduct) {
                             // Remember, productDao is an Interface
        InsertAsyncTask task = new InsertAsyncTask(productDao);
        task.execute(newproduct);
    }

    public void deleteProduct(String name) {
        DeleteAsyncTask task = new DeleteAsyncTask(productDao);
        task.execute(name);
    }

    public void findProduct(String name) {
        QueryAsyncTask task = new QueryAsyncTask(productDao);
        task.delegate = this;
        task.execute(name);
    }



    private void asyncFinished(List<Product> results) {
        searchResults.setValue(results);
    }

    private static class QueryAsyncTask extends
            AsyncTask<String, Void, List<Product>> {

        private ProductDao asyncTaskDao; // An interface
        private ProductRepository delegate = null;

        QueryAsyncTask(ProductDao dao) {  // Constructor
            asyncTaskDao = dao;
        } // Constructor

        @Override
        protected List<Product> doInBackground(final String... params) {
            return asyncTaskDao.findProduct(params[0]); // asyncTaskDao is an interface
        }

        @Override  // delegate is a private instance of ProductRepository (this) class.
        protected void onPostExecute(List<Product> result) {
            delegate.asyncFinished(result);
        }
    } // inner static class QueryAsyncTask

    private static class InsertAsyncTask extends AsyncTask<Product, Void, Void> {

        private ProductDao asyncTaskDao; // an Interface

        InsertAsyncTask(ProductDao dao) {  // Constructor
            asyncTaskDao = dao;
        } // Constructor

        @Override
        protected Void doInBackground(final Product... params) {
            asyncTaskDao.insertProduct(params[0]);
            return null;
        }

    } // inner static class InsertAsyncTask

    private static class DeleteAsyncTask extends AsyncTask<String, Void, Void> {
        private ProductDao asyncTaskDao;

        DeleteAsyncTask(ProductDao dao) {  // Constructor
            asyncTaskDao = dao;
        } // Constructor

        @Override
        protected Void doInBackground(final String... params) {
            asyncTaskDao.deleteProduct(params[0]);
            return null;
        }
    } // inner static class DeleteAsyncTask



} // class ProductRepository
