package service.impl;

import lombok.RequiredArgsConstructor;
import model.Transaction;
import model.TransactionType;
import repository.TransactionRepository;
import service.TransactionService;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public List<Transaction> getTransactionsForReport(Date dateFrom, Date dateTo, String merchant) {

        List<Transaction> transactions = transactionRepository.getAllInDateIntervalByMerchant(dateFrom, dateTo, merchant);
        List<Transaction> reversals = transactionRepository.getAllByType(TransactionType.REVERSAL);

        // remove transactions that marked as reversal
        return transactions.stream().
                filter(transaction -> reversals.stream()
                        .noneMatch(reversal -> transaction.getId().equals(reversal.getRelatedTransaction()))).
                collect(Collectors.toList());
    }

}
