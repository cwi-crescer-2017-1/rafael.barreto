/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.email;

import com.sendgrid.SendGrid;
import com.sendgrid.SendGridException;

/**
 *
 * @author rafael.barreto
 */
public class Email {

    public static void main(String[] args) {

        SendGrid sendgrid = new SendGrid("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");
        SendGrid.Email welcomeMail = new SendGrid.Email();
        welcomeMail.addTo("rafael.barreto@cwi.com.br");
        welcomeMail.addToName("Rafael");
        welcomeMail.setFrom("carloshenrique@cwi.com.br");
        welcomeMail.setSubject("Welcome to Example!");
        welcomeMail.setText("Thank you for your interest in Example.com! It is still in Beta at the moment but there are a number of exciting features planned. Tell us what you'd like to see.");

        try {
            SendGrid.Response response = sendgrid.send(welcomeMail);
            System.out.println(response.getMessage());
        } catch (SendGridException sge) {
            sge.printStackTrace();
        }
    }
}
