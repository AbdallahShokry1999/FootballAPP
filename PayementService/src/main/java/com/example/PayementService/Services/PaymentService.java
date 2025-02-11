package com.example.PayementService.Services;
import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PaymentService {

    private final APIContext apiContext;

    public PaymentService(APIContext apiContext) {
        this.apiContext = apiContext;
    }

    public Payment createPayment(Double total, String currency, String method,
                                 String intent, String description, String cancelUrl, String successUrl)
            throws PayPalRESTException {

        // Amount object to hold currency and total
        Amount amount = new Amount();
        amount.setCurrency(currency);
        amount.setTotal(String.format("%.2f", total));

        // Transaction details
        Transaction transaction = new Transaction();
        transaction.setDescription(description);
        transaction.setAmount(amount);

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);

        // Payer details
        Payer payer = new Payer();
        payer.setPaymentMethod(method);

        // Create payment object and set intent using setIntent
        Payment payment = new Payment();
        payment.setIntent(intent); // Set intent here
        payment.setPayer(payer);
        payment.setTransactions(transactions);
        payment.setRedirectUrls(new RedirectUrls().setCancelUrl(cancelUrl).setReturnUrl(successUrl));

        // Create the payment and return the result
        return payment.create(apiContext); // Send request to PayPal
    }
}
