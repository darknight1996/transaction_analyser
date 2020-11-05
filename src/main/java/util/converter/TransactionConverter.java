package util.converter;

import config.Constants;
import model.Transaction;
import model.TransactionType;
import java.text.SimpleDateFormat;
import java.util.List;

public class TransactionConverter {

    private static final int FIELDS_COUNT = 6;
    private static final String INVALID_FIELDS_COUNT_EXCEPTION = "invalid fields count, expected " + FIELDS_COUNT;
    private static final int ID_INDEX = 0;
    private static final int DATE_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final int MERCHANT_INDEX = 3;
    private static final int TYPE_INDEX = 4;
    private static final int RELATED_INDEX = 5;

    public static Transaction convert(List<String> fields) throws Exception {

        if (fields.size() != 6) {
            throw new Exception(INVALID_FIELDS_COUNT_EXCEPTION);
        }

        Transaction transaction = new Transaction();
        transaction.setId(fields.get(ID_INDEX));
        transaction.setDate(new SimpleDateFormat(Constants.DATE_FORMAT).parse(fields.get(DATE_INDEX)));
        transaction.setAmount(Double.parseDouble(fields.get(AMOUNT_INDEX)));
        transaction.setMerchant(fields.get(MERCHANT_INDEX));
        transaction.setType(TransactionType.valueOf(fields.get(TYPE_INDEX)));
        transaction.setRelatedTransaction(fields.get(RELATED_INDEX));

        return transaction;

    }

}
