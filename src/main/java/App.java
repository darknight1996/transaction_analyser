import config.AppConfig;
import factory.BeanFactory;
import model.Transaction;
import service.TransactionService;
import java.util.List;

public class App {

    public static void main(String[] args) {
        TransactionService transactionService = BeanFactory.getInstance().getTransactionService();
        AppConfig appConfig = AppConfig.getInstance();

        List<Transaction> transactions = transactionService.
                getTransactionsForReport(appConfig.getFromDate(), appConfig.getToDate(), appConfig.getMerchant());

        final int numberOfTransactions = transactions.size();
        final double averageTransactionValue = transactions.stream().mapToDouble(Transaction::getAmount).sum() / numberOfTransactions;

        System.out.println("------------ APP RESULT ------------");
        System.out.println("  Number of transactions = " + numberOfTransactions);
        System.out.println("  Average transaction value = " + averageTransactionValue);
        System.out.println("------------------------------------");
    }

}
