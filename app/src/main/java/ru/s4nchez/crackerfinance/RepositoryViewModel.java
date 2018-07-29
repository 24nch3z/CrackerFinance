package ru.s4nchez.crackerfinance;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import ru.s4nchez.crackerfinance.model.Operation;
import ru.s4nchez.crackerfinance.model.Repository;

public class RepositoryViewModel extends ViewModel {

    private MutableLiveData<Repository> data = new MutableLiveData<>();

    public RepositoryViewModel() {
        Repository repository = new Repository();
        data.setValue(repository);
    }

    public void addOperation(Operation operation) {
        Repository repository = data.getValue();
        repository.addOperation(operation);
        data.setValue(repository);
    }

    public void removeOperation(int position) {
        Repository repository = data.getValue();
        repository.getOperations().remove(position);
        data.setValue(repository);
    }

    public List<Operation> getOperations() {
        return data.getValue().getOperations();
    }

    public MutableLiveData<Repository> getRepository() {
        return data;
    }

//    public Repository getRepository() {
//        return data.getValue();
//    }
}
