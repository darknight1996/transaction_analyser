package service;

import model.Transaction;
import java.util.Date;
import java.util.List;

public interface TransactionService {

    List<Transaction> getTransactionsForReport(Date dateFrom, Date dateTo, String merchant);

}
