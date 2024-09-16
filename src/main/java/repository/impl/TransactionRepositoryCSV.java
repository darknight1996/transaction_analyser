package repository.impl;

import config.AppConfig;
import config.Constants;
import util.converter.TransactionConverter;
import model.Transaction;
import model.TransactionType;
import util.reader.ReaderCSV;
import repository.TransactionRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionRepositoryCSV implements TransactionRepository {

    private final List<Transaction> transactions = new ArrayList<>();

    public TransactionRepositoryCSV() {
        init();
    }

    private void init() {
        List<List<String>> content = ReaderCSV.getCSVContent(Constants.RESOURCES_PATH + AppConfig.getInstance().getInputFileName());
        content.forEach(contentLine -> {
            try {
                transactions.add(TransactionConverter.convert(contentLine));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public List<Transaction> getAllPaymentsInDateIntervalByMerchant(Date fromDate, Date toDate, String merchant) {
        return transactions.stream().
                filter(transaction -> transaction.getMerchant().equals(merchant)).
                filter(transaction -> transaction.getDate().getTime() >= fromDate.getTime() &&
                        transaction.getDate().getTime() <= toDate.getTime()).
                filter(transaction -> transaction.getType() == TransactionType.PAYMENT).
                collect(Collectors.toList());
    }

    @Override
    public List<Transaction> getAllByType(TransactionType type) {
        return transactions.stream().
                filter(transaction -> transaction.getType() == type)
                .collect(Collectors.toList());
    }

}
