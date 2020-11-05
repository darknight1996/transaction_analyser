package factory;

import lombok.Getter;
import repository.TransactionRepository;
import repository.impl.TransactionRepositoryCSV;
import service.TransactionService;
import service.impl.TransactionServiceImpl;

@Getter
public class BeanFactory {

    private static BeanFactory instance;

    private TransactionRepository transactionRepository;

    private TransactionService transactionService;

    private BeanFactory() {
        init();
    }

    private void init() {
        transactionRepository = new TransactionRepositoryCSV();
        transactionService = new TransactionServiceImpl(transactionRepository);
    }

    public static BeanFactory getInstance() {
        if (instance == null) {
            instance = new BeanFactory();
        }
        return instance;
    }

}
