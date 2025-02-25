package com.ebookfrenzy.roomdemo;

import android.os.AsyncTask;
import androidx.lifecycle.MutableLiveData;
import java.util.List;
import android.app.Application;
import androidx.lifecycle.LiveData;

public class ContactRepository {

    private MutableLiveData<List<Contact>> searchResults = new MutableLiveData<>();

    private LiveData<List<Contact>> allContacts;
    private ContactDao contactDao;

    public ContactRepository(Application application) {  // Constructor

        ContactRoomDatabase db;
        db = ContactRoomDatabase.getDatabase(application);
        contactDao = db.contactDao();
        allContacts = contactDao.getAllContacts();
    }

    public LiveData<List<Contact>> getAllContacts() {
        return allContacts;
    }

    public MutableLiveData<List<Contact>> getSearchResults() {
        return searchResults;
    }

    public void insertContact(Contact newContact) {
        InsertAsyncTask task = new InsertAsyncTask(contactDao);
        task.execute(newContact);
    }

    public void deleteContact(String name) {
        DeleteAsyncTask task = new DeleteAsyncTask(contactDao);
        task.execute(name);
    }

    public void findContact(String name) {  // Not used
        QueryAsyncTask task = new QueryAsyncTask(contactDao);
        task.delegate = this;
        task.execute(name);
    }
    public void searchContact(String name) {  // Used this instead
        SearchAsyncTask task = new SearchAsyncTask(contactDao);
        task.delegate = this;
        task.execute(name);
    }
    private static class SearchAsyncTask extends  // used
            AsyncTask<String, Void, List<Contact>> {

        private ContactDao asyncTaskDao;
        private ContactRepository delegate = null;

        SearchAsyncTask(ContactDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected List<Contact> doInBackground(final String... params) {
            return asyncTaskDao.searchContact(params[0]);
        }

        @Override
        protected void onPostExecute(List<Contact> result) {
            delegate.asyncFinished(result);
        }
    }

    private void asyncFinished(List<Contact> results) {
        searchResults.setValue(results);
    }

    private static class QueryAsyncTask extends   // not used
            android.os.AsyncTask<String, Void, List<Contact>> {

        private ContactDao asyncTaskDao;
        private ContactRepository delegate = null;

        QueryAsyncTask(ContactDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected List<Contact> doInBackground(final String... params) {
            return asyncTaskDao.findContact(params[0]);
        }

        @Override
        protected void onPostExecute(List<Contact> result) {
            delegate.asyncFinished(result);
        }
    }

    //***************************
    private static class InsertAsyncTask extends android.os.AsyncTask<Contact, Void, Void> {

        private ContactDao asyncTaskDao;

        InsertAsyncTask(ContactDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Contact... params) {
            asyncTaskDao.insertContact(params[0]);
            return null;
        }
    }

    private static class DeleteAsyncTask extends android.os.AsyncTask<String, Void, Void> {

        private ContactDao asyncTaskDao;

        DeleteAsyncTask(ContactDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final String... params) {
            asyncTaskDao.deleteContact(params[0]);
            return null;
        }
    }

} // class ContactRepository
