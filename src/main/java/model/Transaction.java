package model;

import lombok.Data;
import java.util.Date;

@Data
public class Transaction {

    private String id;

    private Date date;

    private double amount;

    private String merchant;

    private TransactionType type;

    private String relatedTransaction;

}
