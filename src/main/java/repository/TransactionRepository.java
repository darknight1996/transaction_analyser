package repository;

import model.Transaction;
import model.TransactionType;
import java.util.Date;
import java.util.List;

public interface TransactionRepository {

    List<Transaction> getAllInDateIntervalByMerchant(Date fromDate, Date toDate, String merchant);

    List<Transaction> getAllByType(TransactionType type);

}
